layui.use(['table','jquery','form','element'], function(){
    var element = layui.element;
    var table = layui.table,
        $= layui.jquery,
        form = layui.form;






            //第一个实例
            table.render({

                elem: '#tongxue'
                ,height: 400


                ,defaultToolbar: ['filter', 'print', 'exports']
                ,cellMinWidth:100
                ,limit:5
                ,autoSort:true
                ,limits : [5,10,25,50,100,1000]
                ,url: '../../Friend/frind.action' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field:'sNumber',  title: 'img', sort: true,align: 'center',sort: true,templet:'<div><img src="../../student/getuserimg.action?slUsername={{d.slUsername}}"></div>'},

                    {field:'sNumber',  title: '同学录',align: 'center',templet:'<div class="layui-form-item">\n' +
                            '    <div style="">\n' +
                            '    <div>\n' +
                            '        <label class="layui-form-label">姓名:</label>\n' +
                            '        <div class="layui-input-block" style="width: 200px">\n' +
                            '            <input type="text" style="border:none;"  name="title" disabled required  lay-verify="required"  autocomplete="off" class="layui-input"  value="{{d.sName}}">\n' +
                            '        </div>\n' +
                            '    </div>\n' +
                            '    <div>\n' +
                            '        <label class="layui-form-label">手机号:</label>\n' +
                            '        <div class="layui-input-block" style="width: 200px">\n' +
                            '            <input type="text" style="border:none;"  name="title" disabled required  lay-verify="required"  autocomplete="off" class="layui-input" value="{{d.sPhonenumber}}">\n' +
                            '        </div>\n' +
                            '    </div>\n' +
                            '    <div >\n' +
                            '        <label class="layui-form-label">邮箱：</label>\n' +
                            '        <div  class="layui-input-block" style="width: 400px;height: 100px">\n' +
                            '            <input type="text" style="border:none;"  name="title" disabled required  lay-verify="required"  autocomplete="off" class="layui-input" value="{{d.slEmail}}">\n' +
                            '\n' +
                            '        </div>\n' +
                            '\n' +
                            '    </div>\n' +
                            '\n' +
                            '    <div >\n' +
                            '        <label class="layui-form-label">兴趣爱好：</label>\n' +
                            '        <div  class="layui-input-block" style="width: 400px;height: 100px">\n' +
                            '            <textarea name="xingqu" style="border:none;" required lay-verify="required" disabled   class="layui-textarea" > {{d.slXingqu}}</textarea>\n' +
                            '\n' +
                            '        </div>\n' +
                            '\n' +
                            '    </div>\n' +
                            '    <div >\n' +
                            '        <label class="layui-form-label">自我评价：</label>\n' +
                            '        <div  class="layui-input-block" style="width: 400px;height: 100px">\n' +
                            '            <textarea name="xingqu" required lay-verify="required" style="border:none;" disabled   class="layui-textarea">{{d.slPingjia}}</textarea>\n' +
                            '\n' +
                            '        </div>\n' +
                            '\n' +
                            '    </div>\n' +
                            '    </div>\n' +
                            '</div>>'}


                ]]

                ,id: 'scoreReload'


            });
//搜索
    table.on('rowDouble(test)', function(obj){

        //obj 同上
        var shuangjidom=obj.tr;
        shuangjidom.attr({class:""});


        shuangjidom.removeClass("layuitablecell");

        shuangjidom.addClass("layuitablecell");

        /*     shuangjidom.css({ "height":"200px","line-height": "200px"});*/
    });
    table.on('row(test)', function(obj){
        var shuangjidom=obj.tr;
        shuangjidom.attr({class:""});

        shuangjidom.removeClass("layuitablecell");

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
