var form, $,areaData;
layui.use(['table','jquery','form','element','rate'], function(){
    var element = layui.element;
    var rate = layui.rate;
    var table = layui.table,
        $= layui.jquery,
        form = layui.form;
    rate.render({
        elem: '#pingjia'
        ,choose: function(value){
            $("#xinghid").val(value);
        }
    });
      form.on('submit(Pingjiaform)', function(data){
        var data1=data.field;
          $.ajax({
              type: 'POST',
              xhrFields: {
                  withCredentials: true
              },
              // 允许跨域
              crossDomain: true,
              url: '../../pingjia/InPingjia.action?data=' + new Date() + Math.floor(Math.random()*24),
              async: false,
              data:data1,
              success: function (data) {
                  if(data){
                      layer.msg("感谢您的评价！")
                  }else{
                      layer.msg("评价该教师错误或输入有误！")
                  }
              }
          });
        return false;

    });

});