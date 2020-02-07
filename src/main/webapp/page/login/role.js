layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;
    var html="   <form class=\"layui-form\" action=\"\">  " +
        " <div class=\"layui-inline\">\n" +
        "                        <input class=\"layui-input\" name=\"cCnumber\" id=\"selectName\" autocomplete=\"off\">\n" +
        "                    </div> " +

        "</form>"
    $(function () {
        $.ajax({
            async:false,
            cache:false,
            type:"post",
            url:"../../student/selectroal.action",
            success:function (data) {

                var roHtml = '',that = this;

                for (var i = 0; i < data.length; i++) {

                    roHtml += '<option value="' + data[i].rId + '">' + data[i].rName + '</option>';

                }
                $("select[name=rName]").append(roHtml);
                form.render();
            }

        });
        form.on('select(formselect)', function(data){
            alert("aa")
            var data1=data.value;
            localStorage.setItem("rId",data1);
            alert(localStorage.getItem("rId"));

        });

        form.on("submit(tijiao)",function(data){
            window.location.href = "../main/index.html";

            return false;
        })

    });
 /*   var role;
    form.on("submit(formselect)",function(data){
        role= data.value;
        localStorage.setItem("rId",role);
    });*/
    //登录按钮




})
