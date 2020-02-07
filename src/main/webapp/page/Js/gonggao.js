var form, $,areaData;
layui.use(['table','jquery','form','element','rate'], function() {
    var element = layui.element;
    var rate = layui.rate;
    var table = layui.table,
        $ = layui.jquery,
        form = layui.form;

    function formatDate(now) {
        var year=now.getFullYear();  //取得4位数的年份
        var month=now.getMonth()+1;  //取得日期中的月份，其中0表示1月，11表示12月
        var date=now.getDate();      //返回日期月份中的天数（1到31）
        var hour=now.getHours();     //返回日期中的小时数（0到23）
        var minute=now.getMinutes(); //返回日期中的分钟数（0到59）
        var second=now.getSeconds(); //返回日期中的秒数（0到59）
        return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
    }

    $(function () {
        $.ajax({
            async:false,
            cache:false,
            url:"../../gonggao/getgonggao.action",
            success:function (res) {

                $("#timeline").html("");
                for (var i=0;i<res.length;i++) {
                    var time=res[i].gdate;
                    var  d=new Date(time);
                   var date=formatDate(d);
               var html="    <li class=\"layui-timeline-item\">\n" +
                   "        <i class=\"layui-icon layui-timeline-axis\">&#xe63f;</i>\n" +
                   "        <div class=\"layui-timeline-content layui-text\" style=\"width: 400px\">\n" +
                   "            <h3 class=\"layui-timeline-title\">"+date+"</h3>\n" +
                   "            <h3 class=\"layui-timeline-title\" align=\"center\">"+res[i].gtitle+"</h3>\n" +
                   "            <p>\n" +

                   res[i].gmessage
                   +
                   "            </p>\n" +
                   "        </div>\n" +
                   "    </li>" ;
               $("#timeline").append(html);
                }
            }
        });
    })
})