
layui.use(['form','layer','upload','laydate'],function() {
    form = layui.form;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    function getRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    $(function () {

        var data = getRequest();
        var scId = data.scId;
        $("#scId").val(scId);
    });
    form.on("submit(changeScore)",function(data){



        var data1=data.field;

        $.ajax({
            type: 'POST',
            xhrFields: {
                withCredentials: true
            },
            // 允许跨域
            crossDomain: true,
            url: '../../Score/upscore.action',
            async: false,
            data:data1,
            success: function (res) {


                if(res){
                    layer.msg("修改成功");
                    parent.reloadData();

                }else{

                    layer.msg("失败可能不存在！");

                }
            }
        });




        return false;
    })
});