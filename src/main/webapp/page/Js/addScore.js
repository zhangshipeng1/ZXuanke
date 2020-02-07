layui.use(['form','layer','upload','laydate'],function(){
    form = layui.form;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
    $ = layui.jquery;


  $("#sNumber").blur(function () {
      alert("asssssss");
      var sNumber=$("#sNumber").val();
      $.ajax({
          async:false,
          cache:false,
          url:"../../xuankeMessage/getcourse.action",
          data:"sNumber="+sNumber,
          success:function (res) {
              alert(res);
              var areaHtml = '<option value="">请选择</option>';
              for (var i = 0; i < res.length; i++) {
                  areaHtml += '<option value="' + res[i].cId + '">' + res[i].cCname + '</option>';
              }
              $("select[name=sCourse]").html(areaHtml);
              form.render();
          }
      });
  })
    form.on("submit(changeScore)",function(data){



            var data1=data.field;

            $.ajax({
                type: 'POST',
                xhrFields: {
                    withCredentials: true
                },
                // 允许跨域
                crossDomain: true,
                url: '../../Score/addscore.action',
                async: false,
                data:data1,
                success: function (res) {



                    if(res){
                        layer.msg("录入成功");
                        parent.reloadData();

                    }else{

                        layer.msg("失败可能已存在！");

                    }
                }
            });




        return false;
    })


    })
