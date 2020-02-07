
var form, $,areaData;
layui.config({
    base : "../../js/"
}).extend({
    "address" : "address",
    "index":"index"
})
layui.use(['form','layer','upload','laydate',"address"],function(){
    form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        upload = layui.upload,
        laydate = layui.laydate,
        address = layui.address;
    $(function () {
        $.ajax({
            async:false,
            cache:false,
            url:"../../student/getloginmessage.action",
            success:function (res) {
                $("#username").val(res.slUsername);
                $("#role").val(res.roal.rName);
                $("#NiCheng").val(res.slNicheng);
                if(res.tbStudent.ssex=="男"){
                    $("#sexnan").attr("checked","checked" );
                }else {
                    $("#sexnv").attr("checked","checked" );
                }
                /*$("select[name=slClass]").html('<option value="">'+res.tbClass.className+'</option>');
                $("select[name=slXueyuan]").html('<option value="">'+res.college.collegeName+'</option>');
                $("select[name=slZhuanye]").html('<option value="">'+res.tbMajor.majorName+'</option>');
                */$(".userPhone").val(res.slPhone);
                $("#saddress").val(res.tbStudent.saddress);
                $("#email").val(res.slEmail);
                $("#hobby").val(res.slXingqu);
                $("#pingjia").val(res.slPingjia);

            }
        });
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

    })
        //上传头像
    upload.render({
        elem: '.userFaceBtn',
        url: '../../upuserimg.action'
        , accept: 'file'
        ,done: function(res, index, upload){
             //生成0-4的随机数，随机显示一个头像信息
            $("#imgp").text(res.msge)

            window.parent.chingeimg();
            $('#userFace').attr('src',"../../student/getuserimg.action?data="+ new Date() + Math.floor(Math.random()*24));
            window.sessionStorage.setItem('userFace',"../../student/getuserimg.action?data="+ new Date() + Math.floor(Math.random()*24));
        }


    });

    //添加验证规则
    form.verify({
        userBirthday : function(value){
            if(!/^(\d{4})[\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|1[0-2])([\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|[1-2][0-9]|3[0-1]))*$/.test(value)){
                return "出生日期格式不正确！";
            }
        }
    })
    //选择出生日期
    laydate.render({
        elem: '.userBirthday',
        format: 'yyyy年MM月dd日',
        trigger: 'click',
        max : 0,
        mark : {"0-12-15":"生日"},
        done: function(value, date){
            if(date.month === 12 && date.date === 15){ //点击每年12月15日，弹出提示语
               // layer.msg('今天是马哥的生日，也是layuicms2.0的发布日，快来送上祝福吧！');
            }
        }
    });

    //获取省信息
    address.provinces();

    //提交个人资料
    form.on("submit(changeUser)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //将填写的用户信息存到session以便下次调取

        var data1=data.field;
alert(JSON.stringify(data1));
        $.ajax({
            async:false,
            cache:false,
            type:"post",
            url:"../../student/updateuserlogMessage.action",
            data:data1,
            success:function (res) {
                if(res){
                    setTimeout(function(){
                        layer.close(index);
                        layer.msg("提交成功！");
                    },2000);
                }else {
                    setTimeout(function(){
                        layer.close(index);
                        layer.msg("提交失败！");
                    },2000);
                }
            }
        });


        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })

    //修改密码
    form.on("submit(changePwd)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});


        setTimeout(function(){
            layer.close(index);
            layer.msg("密码修改成功！");
            $(".pwd").val('');
        },2000);
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })
})