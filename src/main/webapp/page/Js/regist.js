function recode() {

    $("#img").attr("src","../../student/code.action?data=" + new Date() + Math.floor(Math.random()*24));

}
function  isHasUser(){
    var username=$("#Useranme").val();
    var temp;
    $.ajax({
        async:false,
        cache:false,
        data:"username="+username,
        url:"../../regist/getisHasUserName.action",
        success:function (res) {
            //true证明存在不可注册

            if(res){
                $("#focus").html("账号存在！！")
               temp= false;
            }else{

                temp=true;
            }
        }
    });
    return temp;
}
//查询是否有该学号或工号。
function victornumber(){
    var data=$("#ID").val();
    var temp;
    $.ajax({
        async:false,
        cache:false,
        data:"rNumber="+data,
        url:"../../regist/selectId.action",
        success:function (res) {
            //true证明存在

            if(res){
                $("#lab").html("存在可以注册！");
                temp= true;
            }else{
                $("#lab").html("您不在该系统内请联系管理员！！");
               temp= false;
            }
        },
        erro:function (res) {
            alert("未知错误！")
            temp= false;
        }

    });
    return temp;

}
layui.use(['form','layer','upload','laydate',"address"],function(){
    form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        upload = layui.upload,
        laydate = layui.laydate,
        address = layui.address;

    $(function(){
        //第一页的确定按钮
        $("#btn_part1").click(function(){
            var s=isHasUser();
            //alert(s)
            if( isHasUser()&& victornumber()){
            var code=$("#randCode").val();
            $.ajax({
                async:false,
                cache:false,
                data:"code="+code,
                url:"../../regist/selectCode.action",
                success:function (res) {
                    if(res){
                        if(!verifyCheck._click()) return;
                        $(".part1").hide();
                        $(".part2").show();
                        $(".step li").eq(1).addClass("on");}
                    else {
                        alert("验证码有误！");
                    }
                }
            });
            }
        });



        $.ajax({
            async:false,
            cache:false,
            url:"../../student/selectcolage.action",
            success:function (data) {
                var proHtml = '',that = this;

                var colage=JSON.stringify(data);
               // alert(colage);
                for (var i = 0; i < data.length; i++) {

                    proHtml += '<option value="' + data[i].collegeId + '">' + data[i].collegeName + '</option>';

                }
                $("select[name=slXueyuan]").append(proHtml);
                form.render();
                form.on('select(slXueyuan)', function (colData) {
                    $("select[name=slClass]").html('<option value="">请选择你的班级</option>');
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
                                $("select[name=slZhuanye]").html(cityHtml).removeAttr("disabled");
                                form.render();
                                form.on('select(slZhuanye)', function (majorData) {
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
                                                $("select[name=slClass]").html(areaHtml).removeAttr("disabled");
                                                form.render();
                                            }
                                        });
                                    } else {
                                        $("select[name=slClass]").attr("disabled", "disabled");
                                    }
                                });
                            }
                        });
                    } else {
                        $("select[name=slZhuanye ]").attr("disabled", "disabled");
                    }
                });

            }
        });
        $("#btn_part3").click(function(){
           var username= $("#Useranme").val();
           var phone= $("#phone").val();
           var password= $("#password").val();
           var ID= $("#ID").val();//学号/工号
           var email= $("#email").val();
           var slXueyuan= $("#slXueyuan").val();//学院
           var slZhuanye= $("#slZhuanye").val();
           var slClass= $("#slClass").val();
            var formData = new FormData();
            formData.append("username",username );
            formData.append("phoneNumber",phone );
            formData.append("password",password);
            formData.append("number",ID);
            formData.append("email",email);
            formData.append("xueyuan",slXueyuan);
            formData.append("zhuanye",slZhuanye);
            formData.append("banji",slClass);
            $.ajax({
                type: "post",
                url: "../../regist/registuser.action",
                data: formData,
                contentType: false,
                processData: false,
                async: false,
                success: function (res) {
                    if (res){
                        alert("注册成功!")
                        $(".part3").hide();
                        $(".part4").show();
                        $(".step li").eq(2).addClass("on");
                      //  alert("ss")
                        countdown({
                            maxTime:10,
                            ing:function(c){
                                $("#times").text(c);
                            },
                            after:function(){
                                window.location.href="../login/login.html";
                            }
                        });
                    }
                    else{
                        alert("注册失败请检查账户是否存在或未知错误请联系管理员!");
                        var data=$("#Useranme").val();
                        //alert(data)
                        $.ajax({
                            type: "post",
                            url: "../../regist/delregistuserface.action",
                            data:"faceid="+data,


                            async: false,
                            success: function (test) {

                            }
                        })
                    }
                }
            });

        });
    });
});
//第三页的确定按钮

function showoutc(){/*$(".m-sPopBg,.m-sPopCon").show();*/
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;
        layer.open({
            type: 1
            ,title:"服务条款" //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,resize: false
            ,btn: ['已阅读并同意此条款']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">内容<br>内容</div>'

        });

    });

}
//ren脸信息注册
function getMedia() {
    $("#mainDiv").empty();
    let videoComp = " <video id='video' width='200px' height='200px' autoplay='autoplay' style='border-radius: 30px;'></video><canvas id='canvas' width='500px' height='500px' style='display: none'></canvas>";
    $("#mainDiv").append(videoComp);

    let constraints = {
        video: {width: 200, height: 200}

    };
    //获得video摄像头区域
    let video = document.getElementById("video");
    //这里介绍新的方法，返回一个 Promise对象
    // 这个Promise对象返回成功后的回调函数带一个 MediaStream 对象作为其参数
    // then()是Promise对象里的方法
    // then()方法是异步执行，当then()前的方法执行完后再执行then()内部的程序
    // 避免数据没有获取到
    let promise = navigator.mediaDevices.getUserMedia(constraints);
    promise.then(function (MediaStream) {
        video.srcObject = MediaStream;
        video.play();
    });

    // var t1 = window.setTimeout(function() {
    //     takePhoto();
    // },2000)
}
//拍照事件
function turn(){
    if(!verifyCheck._click()) return;
    $(".part2").hide();
    $(".part3").show();

}
function takePhoto() {
    let mainComp = $("#mainDiv");
    if(mainComp.has('video').length)
    {
        let userNameInput = $("#Useranme").val();
        let email=$("#email").val();
        let phone=$("#phone").val();
        //获得Canvas对象
        let video = document.getElementById("video");
        let canvas = document.getElementById("canvas");
        let ctx = canvas.getContext('2d');
        ctx.drawImage(video, 0, 0, 200, 200);
        var formData = new FormData();
        var base64File = canvas.toDataURL();
        var userName = $("#Useranme").val();
        formData.append("file", base64File);
        formData.append("name", userName);
        formData.append("groupId", "101");
        formData.append("email", email);
        formData.append("phone", phone);

        $.ajax({
            type: "post",
            url: "../../faceAdd.action",
            data: formData,
            contentType: false,
            processData: false,
            async: false,
            success: function (text) {
                var res = JSON.stringify(text)
                if (text.code == 0) {
                    alert("注册成功")
                    //第二页的确定按钮
                     turn();
                } else {
                    alert(text.message)
                }

            },
            error: function (error) {
                alert(JSON.stringify(error));

            }
        });
    }
    else{
        var formData = new FormData();
        let userName = $("#userName").val();
        formData.append("groupId", "101");
        var file = $("#file0")[0].files[0];
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            var base64 = reader.result;
            formData.append("file", base64);
            formData.append("name",userName);
            $.ajax({
                type: "post",
                url: "../../faceAdd.action",
                data: formData,
                contentType: false,
                processData: false,
                async: false,
                success: function (text) {
                    var res = JSON.stringify(text)
                    if (text.code == 0) {
                        alert("注册成功")
                        //第二页的确定按钮
                 turn();
                    } else {
                        alert(text.message)
                    }

                },
                error: function (error) {
                   // alert(JSON.stringify(error));

                }
            });
            location.reload();
        }
    }

}

function imageRecog() {
    let imageInput = " <h2>点击图片区域上传文件</h2><input style='display: none' type='file'  name='file0' id='file0' multiple='multiple' /><br><img src='images/shibie.jpg' id='img0' onclick='toChooseFile()' style='width: 30rem;height: 25rem;'>";
    $("#mainDiv").empty();
    $("#mainDiv").append(imageInput);
}

function toChooseFile()
{
    $("#file0").trigger('click');
}
$(document).on("change","#file0",function(){
    var objUrl = getObjectURL(this.files[0]) ;//获取文件信息
    console.log("objUrl = "+objUrl);
    if (objUrl) {
        $("#img0").attr("src", objUrl);
    }
});

function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL!=undefined) {
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}

function closeClause(){
    $(".m-sPopBg,.m-sPopCon").hide();
}