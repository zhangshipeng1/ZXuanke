layui.use(['table','jquery','form','element'], function(){
    var element = layui.element;
    var table = layui.table,
        $= layui.jquery,
        form = layui.form;
    //…


 $(function () {
     //第一个实例

     $.ajax({
         async:false,
         cache:false,

         url:"../video/getJivideo.action",
         success:function (res) {



             for(var i=0;i<res.length;i++){
                 var html1="    <tr align='center' style='height: 30px;background-color: #5bc0de'>\n" +

                     "        <td align='center' onclick='show(\""+res[i].vId+"\")'>"+res[i].vJiename+"</td>\n" +
                     "    </tr>";
                 $("#demo").append(html1);
             }

         }
     });

 });




    });
