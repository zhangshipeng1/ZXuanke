layui.use(['table','jquery','form','element'], function(){
    var element = layui.element;
    var table = layui.table,
        $= layui.jquery,
        form = layui.form;
    //…

        getdabang();
        // 监听tab切换 操作：文档 - 内置模块 - 常用元素操作 element - 监听tab切换
        element.on('tab(tab-all)', function (data) {
            // console.log(this);        // 当前Tab标题所在的原始DOM元素
            // console.log(data.index);  // 得到当前Tab的所在下标
            // console.log(data.elem);   // 得到当前的Tab大容器
            var status = $(this).attr('data-status');

            switch (status) {
                case '1':getgerenScore(); break;

                default:getdabang();
            }

        });
        function getgerenScore(){
            //个人信息
            $.ajax({
                    async:false,
                    cache:false,
                    url:"../../Score/getMessage.action",
                    type:'post',
                    success:function (res) {

                        if(res!=null){
                            $(".l1").html(res.tbStudent.sname);
                            $(".l2").html(res.college.collegeName);
                            $(".l3").html(res.tbMajor.majorName);
                        }
                    }
                }

            );
            //个人成绩
            $.ajax({
                    async:false,
                    cache:false,
                    url:"../../Score/getgerenScore.action",
                    type:'post',
                    success:function (res) {
                        for (var i=0;i<res.length;i++) {

                            var htmladd="<tr align='center'><td>"+res[i].tbStudent.snumber+"</td><td>"+res[i].tbCourse.cCname+"</td><td>"+res[i].sscore+"</td><td>"+res[i].sxuefen+"</td></tr>";
                            $(".d3").append(htmladd);
                        }
                    }
                }

            );
            //数据汇总
            $.ajax({
                    async:false,
                    cache:false,
                    url:"../../Score/dohuizong.action",
                    type:'post',
                    success:function (res) {

                        if(res!=null){
                            $(".l4").html(res.sum);
                            $(".l5").html(res.gpa);
                            $(".l6").html(res.avg);
                        }
                    }
                }

            );
        }
        function getdabang(){

            $.ajax({
                async:false,
                cache:false,
                url:"../../student/selectcolage.action",
                success:function (data) {
                    var proHtml = '',that = this;

                    var colage=JSON.stringify(data);

                    for (var i = 0; i < data.length; i++) {

                        proHtml += '<option value="' + data[i].collegeId + '">' + data[i].collegeName + '</option>';

                    }
                    $("select[name=cXueyuan]").append(proHtml);
                    form.render();
                    form.on('select(cXueyuan)', function (colData) {

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
                                    $("select[name=cZhuanye]").html(cityHtml).removeAttr("disabled");
                                    form.render();

                                }
                            });
                        } else {
                            $("select[name=cZhuanye ]").attr("disabled", "disabled");
                        }
                    });

                }
            });
            $.ajax({
                async: false,
                cache: false,
                url: "../../course/selectYiXuan.action",
                success: function (data) {

                    for (var i=0;i<data.length;i++) {

                        var  htmltext="<button type=\"button\" style=\"font-size:5px;\" id=\"zs"+data[i].xuanId+"\" onclick=\"shanchu('"+data[i].xuanId+"')\" lay-filter=\"yixuan\" name=\"xuanId\"  value=\""+data[i].xuanId+"\" class=\"layui-btn layui-btn-xs layui-icon layui-btn-radius layui-bg-gray layui-icon-close\">"+data[i].tbCourse.cCname+"</button>";

                        $("#yiXuan").append(htmltext);

                    }
                }
            });

            //第一个实例
            table.render({

                elem: '#demo'
                ,height: 400
                ,toolbar:"#score"
                ,defaultToolbar: ['filter', 'print', 'exports']
                ,cellMinWidth:100
                ,limit:1
                ,autoSort:true
                ,limits : [5,10,25,50,100,1000]
                ,url: '../../Score/selectAllscore.action' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头

                    {field:'sNumber',  title: '学号', sort: true,align: 'center',width:70,sort: true,sort: true,templet:'<div>{{d.tbStudent.sNumber}}</div>'}

                    ,{field: 'sName', title: '姓名',sort: true,align: 'center',sort: true,templet:'<div>{{d.tbStudent.sName}}</div>'}
                    ,{field: 'cCname', title: '科目', align: 'center',sort: true,templet:'<div>{{d.tbCourse.cCname}}</div>'}
                    ,{field: 'collegeName', title: '所属学院',align: 'center', sort: true,  templet:'<div>{{d.college? d.college.collegeName: ""}}</div>'}
                    ,{field: 'majorName', title: '所属专业', align: 'center',sort: true,  templet:'<div>{{d.tbMajor? d.tbMajor.majorName: ""}}</div>'}
                    ,{field: 'sScore', title: '分数', align: 'center',sort: true,  templet:'<div>{{d.sScore}}</div>'}

                ]]

                ,id: 'scoreReload'


            });
//搜索

             $ = layui.$, active = {

                reload: function(){

                    var cXueyuan = $('#cXueyuan');
                    var cZhuanye = $('#cZhuanye');
                    var selectName = $('#selectName');
                    //执行重载
                    table.reload('scoreReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                            key: selectName.val(),
                            cXueyuan: cXueyuan.val(),
                            cZhuanye: cZhuanye.val()

                        }
                    }, 'data');
                }

            };

            $('.selectTable  .layui-btn').on('click', function(){

                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
            $('.xuanTable .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
        }

    });
