
layui.use(['table','jquery','form'], function(){
    var table = layui.table,
    $ = layui.jquery,
        form = layui.form;

$(function () {
 /*   $.ajax({
        async:false,
        cache:false,
        url:"../../xuankeMessage/gettudata.action",
        success:function (res) {
             var land=[];
            var selected = {};
            for (var i=0;i<res.length;i++){
                land.push(res[i].name);
                selected[res[i].name] = i < 6;
            }
            var myChart = echarts.init(document.getElementById('main'));
            myChart.setOption({
                title: {
                    text: '全校选课百分比',
                    subtext: '各科人数占比',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    type: 'scroll',
                    orient: 'vertical',
                    right: 10,
                    top: 20,
                    bottom: 20,
                    data: land,

                    selected:selected
                },
                series : [
                    {
                        name: '全校选课状况',
                        type: 'pie',
                        radius: '45%',
                        center: ['40%', '50%'],
                        roseType: 'angle',
                        data: res,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            })
            myChart.setOption(option);
        }
    })*/
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
                $("select[name=cClass]").html('<option value="">请选择你的班级</option>');
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
                            form.on('select(cZhuanye)', function (majorData) {
                                var value = majorData.value;
                                if (value > 0) {
                                    $.ajax({
                                        async:false,
                                        cache:false,
                                        url:"../../student/selectclassesByid.action",
                                        data:"majorId="+value,
                                        success:function (data2) {
                                            var areaHtml = '<option value="">请选择班级</option>';
                                            for (var i = 0; i < data2.length; i++) {
                                                areaHtml += '<option value="' + data2[i].classId + '">' + data2[i].className + '</option>';
                                            }
                                            $("select[name=cClass]").html(areaHtml).removeAttr("disabled");
                                            form.render();
                                        }
                                    });
                                } else {
                                    $("select[name=cClass]").attr("disabled", "disabled");
                                }
                            });
                        }
                    });
                } else {
                    $("select[name=cZhuanye ]").attr("disabled", "disabled");
                }
            });

        }
    });


});


    //第一个实例
    table.render({

        elem: '#scorexuan'
        ,height: 400
        ,toolbar: 'default'

        ,cellMinWidth:100
        ,limit:5
        ,autoSort:true
        ,limits : [5,10,25,50,100,1000]
        ,url: '../../Score/selectAllscore.action' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'scId', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field:'sNumber',  title: '学号', sort: true,align: 'center',width:70,sort: true,sort: true,templet:'<div>{{d.tbStudent.sNumber}}</div>'}

            ,{field: 'sName', title: '姓名',sort: true,align: 'center',sort: true,templet:'<div>{{d.tbStudent.sName}}</div>'}
            ,{field: 'cCname', title: '科目', align: 'center',sort: true,templet:'<div>{{d.tbCourse.cCname}}</div>'}
            ,{field: 'collegeName', title: '所属学院',align: 'center', sort: true,  templet:'<div>{{d.college? d.college.collegeName: ""}}</div>'}
            ,{field: 'majorName', title: '所属专业', align: 'center',sort: true,  templet:'<div>{{d.tbMajor? d.tbMajor.majorName: ""}}</div>'}
            ,{field: 'sScore', title: '分数',  edit: 'text', align: 'center',sort: true,  templet:'<div>{{d.sScore}}</div>'}
            ,{field: 'sXuefen', title: '学分', edit: 'text', align: 'center',sort: true,  templet:'<div>{{d.sXuefen}}</div>'}
        ]]

        ,id: 'scoreReload'


    });
//搜索
    table.on('checkbox(scorexuan)', function(obj){
        console.log(obj)
    });
    //监听单元格编辑
    table.on('edit(scorexuan)', function(obj){
        var value = obj.value //得到修改后的值
            ,data = obj.data //得到所在行所有键值
            ,field = obj.field; //得到字段

        $.ajax({
            type: 'POST',
            xhrFields: {
                withCredentials: true
            },
            // 允许跨域
            crossDomain: true,
            url: '../../Score/upscore2.action',
            async: false,
            data:field+"="+value+"&scId="+data.scId,
            success: function (res) {


                if(res){
                    layer.msg("修改成功");
                    parent.reloadData();

                }else{

                    layer.msg("失败可能不存在！");

                }
            }
        });
    });


    table.on('toolbar(scorexuan)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':


                layer.open({
                    type: 2,
                    title: '录入成绩',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['400px', '100%'],

                    content: '../teacherpage/addScore.html' //iframe的url
                });
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {

                    layer.open({
                        type: 2,
                        title: '录入成绩',
                        shadeClose: true,
                        shade: 0.8,
                        area: ['300px', '60%'],

                        content: '../teacherpage/upScore.html?scId='+checkStatus.data[0].scId //iframe的url
                    });
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    var  sum=1;
                    var  boo=false;
                    alert(data.length)
                    for (var i=0;i<data.length;i++) {
                    $.ajax({
                        async:false,
                        cache:false,
                        url:"../../Score/delscore.action",
                        data:"scId="+checkStatus.data[i].scId,
                        success:function (res) {
                            if(res){
                                boo=true;
                                sum+=i;


                                table.reload('scoreReload', {
                                    page: {
                                        curr: 1 //重新从第 1 页开始
                                    }
                                    ,where: {
                                       aaa: "sa"

                                    }
                                }, 'data');
                            }else{
                               boo=false;


                            }
                            alert(boo)
                        }
                    })
                    }
                    if(boo){
                        layer.msg("删除成功"+sum+"条");
                    }else{
                        layer.msg("删除失败可能"+data.length-sum+"条不存在！");
                    }
                }
                break;
        };
    });


    var $ = layui.$, active = {

        reload: function(){

            var cXueyuan = $('#cXueyuan');
            var cZhuanye = $('#cZhuanye');
            var cClass=$('#cClass');
            var selectName = $('#selectName');
            //执行重载
            table.reload('scoreReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: selectName.val(),
                    cXueyuan: cXueyuan.val(),
                    cZhuanye: cZhuanye.val(),
                    cClass:cClass.val()
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
function reloadData(){
    //当前页的刷新

    $(".layui-laypage-btn")[0].click();

}