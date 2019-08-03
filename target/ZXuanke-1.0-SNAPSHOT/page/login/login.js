layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;




    //登录按钮
    form.on("submit(login)",function(data){
        $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        setTimeout(function(){
            var data1=data.field;

            $.ajax({
                type: 'POST',
                xhrFields: {
                    withCredentials: true
                },
                // 允许跨域
                crossDomain: true,
                url: '../../student/dologin.action?data=' + new Date() + Math.floor(Math.random()*24),
                async: false,
                data:data1,
                success: function (data) {


                    layer.load();
                    if(data=='true'){
                        layer.msg('hello');
                        window.location.href = "role.html";

                    }else{
                        setTimeout(function(){
                        layer.msg(data, {icon: 2});
                        },2000);
                    }
                }
            });



        },1000);
        return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })


     $("#userName").blur(function () {
         var flage =false;
         var username=$("#userName").val();
         var zhengze=/^[a-zA-Z0-9_-]{1,16}$/;
         $(".userAvatar").attr("src","../../student/getuserimg.action?data="+ new Date() + Math.floor(Math.random()*24)+"&slUsername="+$("#userName").val());

         if(username==""){
            $("#userlab").css({color:"red"}).html("用户名不能为空");
            $(".loginBody form.layui-form").css({height:"370px"});
            if($("#passlab").text()!=''){
                $(".loginBody form.layui-form").css({height:"385px"});
                if($("#codelab").text()!=''){
                    $(".loginBody form.layui-form").css({height:"400px"});
                }
            }else if($("#codelab").text()!=''){
                $(".loginBody form.layui-form").css({height:"365px"});
            }

        }else
        {

            if(username.length>=1&&username.length<=16){
                if(zhengze.test(username)){
                    $("#userlab").html("");
                    if($("#userlab").text()==''&&$("#passlab").text()==''&&$("#codelab").text()==''){

                        $(".loginBody form.layui-form").css({height:"340px"});
                    } else
                         if($("#userlab").text()==''&&$("#passlab").text()=='' ||$("#passlab").text()==''&&$("#codelab").text()=='' ||$("#userlab").text()==''&&$("#codelab").text()=='')
                    {
                        $(".loginBody form.layui-form").css({height:"370px"});
                    } else if($("#userlab").text()==''||$("#passlab").text()==''||$("#codelab").text()==''){
                        $(".loginBody form.layui-form").css({height:"385px"});
                    }else {
                             $(".loginBody form.layui-form").css({height:"410px"});
                         }
                    flage =true;
                }else {
                    $("#userlab").css({color:"red"}).html("用户名应为数字,字母,下滑线组成");
                    $(".loginBody form.layui-form").css({height:"370px"});
                    if($("#passlab").text()!=''){
                        $(".loginBody form.layui-form").css({height:"385px"});
                        if($("#codelab").text()!=''){
                            $(".loginBody form.layui-form").css({height:"400px"});
                        }
                    }else if($("#codelab").text()!=''){
                        $(".loginBody form.layui-form").css({height:"365px"});
                    }
                }

            }


        }
        return flage;
    });
    $("#password").blur(function () {
        var flage =false;
        var password=$("#password").val();
        var zhengze= /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;

        if(password==""){
            $("#passlab").css({color:"red"}).html("密码不能为空");
            //记得加上判断控制页面增长
            $(".loginBody form.layui-form").css({height:"370px"});
            if($("#userlab").text()!=''){
                $(".loginBody form.layui-form").css({height:"385px"});
                if($("#codelab").text()!=''){
                    $(".loginBody form.layui-form").css({height:"400px"});
                }
            }else if($("#codelab").text()!=''){
                $(".loginBody form.layui-form").css({height:"365px"});
            }


        }else
        {

            if(password.length>=1&&password.length<=16){
                if(zhengze.test(password)){
                    $("#passlab").html("");
                    if($("#userlab").text()==''&&$("#passlab").text()==''&&$("#codelab").text()==''){

                        $(".loginBody form.layui-form").css({height:"340px"});
                    } else
                    if($("#userlab").text()==''&&$("#passlab").text()=='' ||$("#passlab").text()==''&&$("#codelab").text()=='' ||$("#userlab").text()==''&&$("#codelab").text()=='')
                    {
                        $(".loginBody form.layui-form").css({height:"370px"});
                    } else if($("#userlab").text()==''||$("#passlab").text()==''||$("#codelab").text()==''){
                        $(".loginBody form.layui-form").css({height:"385px"});
                    }else {
                        $(".loginBody form.layui-form").css({height:"410px"});
                    }
                    flage =true;
                }else {
                    $("#passlab").css({color:"red"}).html("最少6位,至少1个大写字母，1个小写字母，1个数字，1个特殊字符");
                    if($("#userlab").text()==''&&$("#passlab").text()==''&&$("#codelab").text()==''){

                        $(".loginBody form.layui-form").css({height:"340px"});
                    } else
                    if($("#userlab").text()==''&&$("#passlab").text()=='' ||$("#passlab").text()==''&&$("#codelab").text()=='' ||$("#userlab").text()==''&&$("#codelab").text()=='')
                    {
                        $(".loginBody form.layui-form").css({height:"370px"});
                    } else if($("#userlab").text()==''||$("#passlab").text()==''||$("#codelab").text()==''){
                        $(".loginBody form.layui-form").css({height:"385px"});
                    }else {
                        $(".loginBody form.layui-form").css({height:"410px"});
                    }
                }

            }


        }
        return flage;
    });
    //验证码校验
    $("#code").blur(function () {
        var flage =false;
        var code1=$("#code").val();


        if(code==""){
            $("#codelab").css({color:"red"}).html("验证码不能为空");
            //记得加上判断控制页面增长
            if($("#userlab").text()==''&&$("#passlab").text()==''&&$("#codelab").text()==''){

                $(".loginBody form.layui-form").css({height:"340px"});
            } else
            if($("#userlab").text()==''&&$("#passlab").text()=='' ||$("#passlab").text()==''&&$("#codelab").text()=='' ||$("#userlab").text()==''&&$("#codelab").text()=='')
            {
                $(".loginBody form.layui-form").css({height:"370px"});
            } else if($("#userlab").text()==''||$("#passlab").text()==''||$("#codelab").text()==''){
                $(".loginBody form.layui-form").css({height:"385px"});
            }else {
                $(".loginBody form.layui-form").css({height:"410px"});
            }

        }

            if(code1.length!=4){

                $("#codelab").css({color:"red"}).html("验证码长度不正确！");
                    if($("#userlab").text()==''&&$("#passlab").text()==''&&$("#codelab").text()==''){

                        $(".loginBody form.layui-form").css({height:"340px"});
                    } else
                    if($("#userlab").text()==''&&$("#passlab").text()=='' ||$("#passlab").text()==''&&$("#codelab").text()=='' ||$("#userlab").text()==''&&$("#codelab").text()=='')
                    {
                        $(".loginBody form.layui-form").css({height:"370px"});
                    } else if($("#userlab").text()==''||$("#passlab").text()==''||$("#codelab").text()==''){
                        $(".loginBody form.layui-form").css({height:"385px"});

                }else {
                        $(".loginBody form.layui-form").css({height:"410px"});
                    }


            }else{
                $("#codelab").html("");
                if($("#userlab").text()==''&&$("#passlab").text()==''&&$("#codelab").text()==''){

                    $(".loginBody form.layui-form").css({height:"340px"});
                } else
                if($("#userlab").text()==''&&$("#passlab").text()=='' ||$("#passlab").text()==''&&$("#codelab").text()=='' ||$("#userlab").text()==''&&$("#codelab").text()=='')
                {
                    $(".loginBody form.layui-form").css({height:"370px"});
                } else if($("#userlab").text()==''||$("#passlab").text()==''||$("#codelab").text()==''){
                    $(".loginBody form.layui-form").css({height:"385px"});

                }else {
                    $(".loginBody form.layui-form").css({height:"410px"});
                }

            }



        return flage;
    });
   /* $("#userName").focus(function () {

            $("#userlab").html("用户名");
            $("#passlab").html("密码");
            $("#codelab").html("验证码");


    });
    $("#password").focus(function () {

        $("#userlab").html("用户名");
        $("#passlab").html("密码");
        $("#codelab").html("验证码");


    });
    $("#code").focus(function () {

        $("#userlab").html("用户名");
        $("#passlab").html("密码");
        $("#codelab").html("验证码");


    });*/


})
