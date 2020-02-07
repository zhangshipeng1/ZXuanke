layui.use(['table','jquery','form'], function(){
    var table = layui.table,
    $ = layui.jquery,
        form = layui.form;
$(function () {
    $.ajax({
        async:false,
        cache:false,
        url:"../../student/selectcolage.action",
        success:function (data) {
            var proHtml = '',that = this;

            var colage=JSON.stringify(data);
            alert(colage);
            for (var i = 0; i < data.length; i++) {

                proHtml += '<option value="' + data[i].collegeId + '">' + data[i].collegeName + '</option>';

            }
            $("select[name=slXueyuan]").append(proHtml);
            form.render();
            form.on('select(slXueyuan)', function (colData) {
                $("select[name=slClass]").html('<option value="">请选择你的班级</option>');
                var value = colData.value;
                if (value > 0) {
                    $.ajax({
                        async:false,
                        cache:false,
                        url:"../../student/selectmajorByid.action",
                        data:"collegeId="+value,
                        success:function (data1) {
                            var cityHtml = '<option value="">请选择专业</option>',that = this;
                            for (var i = 0; i < data1.length; i++) {
                                cityHtml += '<option value="' + data1[i].majorId + '">' + data1[i].majorName + '</option>';
                            }
                            $("select[name=slZhuanye]").html(cityHtml).removeAttr("disabled");
                            form.render();

                        }
                    });
                } else {
                    $("select[name=slZhuanye ]").attr("disabled", "disabled");
                }
            });

        }
    });

})

    //第一个实例
    table.render({
        
        elem: '#demo'
        ,height: 312
        ,toolbar:"#xuanke"
        ,defaultToolbar: ['filter', 'print', 'exports']
        ,cellMinWidth: 80

        ,limit:1
        ,autoSort:true
        ,limits : [1,5,10,25,50,100,1000]
        ,url: '../../course/getallCourse.action' //数据接口
        ,page: true //开启分页
        ,id: 'xuankeReload'

        ,cols: [[ //表头
            {type:'checkbox'}
            ,{field:'cId', width:80, title: 'ID', sort: true}

            ,{field: 'cCname', title: '课程名称',sort: true}
            ,{field: 'tbTeacher.tName', title: '任课教师', sort: true,  templet:'<div>{{d.tbTeacher ? d.tbTeacher .tName: ""}}</div>'}
            ,{field: 'time.timeCart', title: '上课时间',  templet:'<div>{{d.time ? d.time.timeCart: ""}}</div>'}
            ,{field: 'teacherCourse.tcZhuangtai', title: '课程状态',  templet:'<div>{{d.teacherCourse.tcZhuangtai=="1"? "正常上课": "休假"}}</div>'}
            ,{field: 'college.collegeName', title: '课程所属学院', sort: true,  templet:'<div>{{d.college? d.college.collegeName: ""}}</div>'}
            ,{field: 'tbMajor.majorName', title: '课程所属专业', sort: true, templet:'<div>{{d.tbMajor? d.tbMajor.majorName: ""}}</div>'}

            , {fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
        ]]
        ,done:function (res, curr, count) {

            //table_data = res.data;
            trNum = count;
            for(var i = 0;i<res.data.length;i++){
                var state = res.data[i].zhuangtai;
                var count1 =res.data[i].xuankeCount;
                alert(count1);
                if(state != '0' && count1>30){
                    var index = res.data[i]['LAY_TABLE_INDEX'];
                    $(".layui-table tr[data-index="+index+"] input[type='checkbox']").prop('disabled',true);
                    $(".layui-table tr[data-index="+index+"] input[type='checkbox']").next().addClass('layui-btn-disabled');
                    $('.layui-table tr[data-index=' + index + '] input[type="checkbox"]').prop('name', 'caib');
                }else{
                    table_data.push(res.data[i])
                }
            }

        }

    });
//搜索
    table.on('checkbox(demo)', function(obj){
        console.log(obj)
    });
    var $ = layui.$, active = {

        reload: function(){

            var slXueyuan = $('#slXueyuan');
            var slZhuanye = $('#slZhuanye');
            var selectName = $('#selectName');
            //执行重载
            table.reload('xuankeReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: selectName.val(),
                    slXueyuan: slXueyuan.val(),
                    slZhuanye: slZhuanye.val()

                }
            }, 'data');
        },
        getCheckData: function(){ //获取选中数据
            layer.alert("aa");
            var checkStatus = table.checkStatus('xuankeReload')
                ,data = checkStatus.data;
            //批量选课

            layer.confirm('确定选课吗', function(index){

                $.ajax({
                        async:false,
                        cache:false,
                        contentType:'application/json;charset=utf-8',
                        type:'post',
                        data:JSON.stringify(data),
                        url:"../../course/duoxuan.action",
                        success:function (res) {
                          layer.msg(res);

                            table.reload('xuankeReload', {
                                where: { //设定异步数据接口的额外参数，任意设
                                    aaaaaa: 'xxx'
                                }
                            });

                        }
                    }


                );


                layer.close(index);
            });
        }
    };

    table.on('tool(coursexuan)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'xuanke'){
            //单次选课

            layer.confirm('确定选课吗', function(index){

                $.ajax({
                    async:false,
                    cache:false,
                    contentType:'application/json;charset=utf-8',
                    type:'post',
                    data:JSON.stringify(data),
                    url:"../../course/xuanke.action",
                    success:function (res) {
                    if (res){
                        layer.msg('选课成功');

                        table.reload('xuankeReload', {
                            where: { //设定异步数据接口的额外参数，任意设
                                aaaaaa: 'xxx'
                            }
                        });
                        layer.close(index);
                    }else {
                        layer.msg('选课失败');
                    }

                    }
                }


                );


                layer.close(index);
                    });



        }

    });


    $('.selectTable  .layui-btn').on('click', function(){

        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    $('.xuanTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});