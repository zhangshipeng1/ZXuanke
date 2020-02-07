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
            alert(data.length+"sss");
            for (var i=0;i<data.length;i++) {
                alert(data[i].xuanId+"sss");
                var  htmltext="<button type=\"button\" style=\"font-size:5px;\" id=\"zs"+data[i].xuanId+"\" onclick=\"shanchu('"+data[i].xuanId+"')\" lay-filter=\"yixuan\" name=\"xuanId\"  value=\""+data[i].xuanId+"\" class=\"layui-btn layui-btn-xs layui-icon layui-btn-radius layui-bg-gray layui-icon-close\">"+data[i].tbCourse.cCname+"</button>";

                $("#yiXuan").append(htmltext);

            }
        }
    });
});


    //第一个实例
    table.render({
        
        elem: '#demo'
        ,height: 400
        ,toolbar:"#xuanke"
        ,defaultToolbar: ['filter', 'print', 'exports']
        ,cellMinWidth:100
        ,limit:1
        ,autoSort:true
        ,limits : [5,10,25,50,100,1000]
        ,url: '../../course/selectCourseMessage.action' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头

            {field:'cId',  title: 'ID', sort: true,align: 'center',width:70}

            ,{field: 'cCname', title: '课程名称',sort: true,align: 'center'}
            ,{field: 'cGrade', title: '所属年级', align: 'center',sort: true}
            ,{field: 'cXueyuan', title: '课程所属学院',align: 'center', sort: true,  templet:'<div>{{d.college? d.college.collegeName: ""}}</div>'}
            ,{field: 'cZhuanye', title: '课程所属专业', align: 'center',sort: true,  templet:'<div>{{d.tbMajor? d.tbMajor.majorName: ""}}</div>'}
           ,{field: 'cType', title: '课程级别', align: 'center',  templet:'<div>{{d.cType}}</div>'}
            ,{field: 'cMessage', title: '课程信息',align: 'center',width:300, templet:'<div>{{d.cMessage}}</div>'}
        ]]

        ,id: 'courseReload'


    });
//搜索
    table.on('checkbox(demo)', function(obj){
        console.log(obj)
    });
    table.on('rowDouble(coursexuan)', function(obj){

        //obj 同上
        var shuangjidom=obj.tr;
        shuangjidom.attr({class:""});


            shuangjidom.removeClass("layuitablecell");

            shuangjidom.addClass("layuitablecell");

        /*     shuangjidom.css({ "height":"200px","line-height": "200px"});*/
    });
    table.on('row(coursexuan)', function(obj){
        var shuangjidom=obj.tr;
        shuangjidom.attr({class:""});

           shuangjidom.removeClass("layuitablecell");

    });
    var $ = layui.$, active = {

        reload: function(){

            var cXueyuan = $('#cXueyuan');
            var cZhuanye = $('#cZhuanye');
            var selectName = $('#selectName');
            //执行重载
            table.reload('courseReload', {
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


});