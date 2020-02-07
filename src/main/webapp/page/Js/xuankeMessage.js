layui.use(['table','jquery','form'], function(){
    var table = layui.table,
    $ = layui.jquery,
        form = layui.form;
$(function () {
    $.ajax({
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
    })
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
        
        elem: '#demo'
        ,height: 400
        ,toolbar:"#xuanke"
        ,defaultToolbar: ['filter', 'print', 'exports']
        ,cellMinWidth:100
        ,limit:5
        ,autoSort:true
        ,limits : [5,10,25,50,100,1000]
        ,url: '../../xuankeMessage/getthxuankeData.action' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头

            {field:'sNumber',  title: 'ID', sort: true,align: 'center',width:70}

            ,{field: 'sName', title: '姓名',sort: true,align: 'center'}
            ,{field: 'className', title: '所属班级', align: 'center',sort: true}
            ,{field: 'collegeName', title: '所属学院',align: 'center', sort: true}
            ,{field: 'majorName', title: '所属专业', align: 'center',sort: true}
           ,{field: 'cCname', title: '所选课程', align: 'center'}

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
            var cClass=$('#cClass');
            var selectName = $('#selectName');
            //执行重载
            table.reload('courseReload', {
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