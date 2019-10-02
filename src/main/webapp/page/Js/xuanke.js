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

            ,{field: 'caozuo', title: '操作' ,templet:'<div id="barDemo">               {{d.tbXuanke.xuanZhuangtai=="null"? "选课": d.tbXuanke.xuanZhuangtai=="1" ?"已选","已满"}}</div>'}
        ]]
    });
//搜索
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
        }
    };
    table.on('tool(coursexuan)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'xuanke'){
          $.ajax({
           async:false,
           cache:false,
           type:'post',   
              data:"cId="+data.cId,
              url:"",
              success:function (res) {
                  
              }
          });
            layer.confirm('确定选课吗', function(index){
              $("#xuan"+data.cId).text("sss").attr('herf',"#");
                layer.close(index);
            });

        }
    });


    $('.selectt .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});