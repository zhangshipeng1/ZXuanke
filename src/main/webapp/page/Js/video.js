layui.use(['table','jquery','form','element','laypage', 'layer'], function(){
    var element = layui.element;

    var table = layui.table,
        $= layui.jquery,
        form = layui.form;
    var laypage = layui.laypage
        ,layer = layui.layer;

    $(function () {
        //加载总页数
        var total ;
        $.ajax({
            async:false,
            cache:false,
            url:"../../video/getTotle.action",
            success:function (res) {
                total=res;
            }
        }
        );
//先初始化加载首页，十条数据
        showReocrd(1,10);

        layui.use(['laypage','jquery'], function() {

            var laypage = layui.laypage,$ = layui.$;
            $("#video").each(function(i,the){
                laypage.render({
                    elem: the //注意，这里的 test1 是 ID，不用加 # 号
                    ,count: total //数据总数，从服务端得到
                    , limit: 10           //每页显示条数
                    , limits: [10, 20, 30]
                    , curr: 1            //起始页
                    , groups: 5           //连续页码个数
                    , prev: '上一页'         //上一页文本
                    , netx: '下一页'         //下一页文本
                    , first: 1           //首页文本
                    , last: 100           //尾页文本
                    , layout: ['prev', 'page', 'next','limit','refresh','skip']
                    //跳转页码时调用
                    , jump: function (obj, first) { //obj为当前页的属性和方法，第一次加载first为true
                        //非首次加载 do something
                        if (!first) {
                            //清空以前加载的数据
                            $('#videoid').html("");
                            //调用加载函数加载数据
                            showReocrd(obj.curr,obj.limit);
                        }
                    }
                });
            })
        });
        function showReocrd(pageNo,pageSize){


            $.ajax({
                async:false,
                cache:false,

                data:"pageNo="+pageNo+"&pageSize="+pageSize,
                url:"../../video/getAllvideo.action",
                success:function (res) {



                    for(var i=0;i<res.length;i++){
                        var html1="    <a href=\"../../video/getvideo.action?vName="+res[i].vName+"\">\n" +
                            "\n" +
                            "            <div class=\"v1\">\n" +
                            "               <div align=\"center\"><img  class=\"img\" src=\"../../video/getimg.action?vId="+res[i].vId+"\" width=\"150\" height=\"200\" ></div>\n" +
                            "                <div><span class=\"s0\">"+res[i].vName+"</span></div>\n" +
                            "                <div class=\"v12\"><span class=\"s1\" >"+res[i].tName+"</span><span class=\"s2\">"+res[i].vTime+"</span> </div>\n" +
                            "            </div>\n" +
                            "        </a>";
                        $(".video1").append(html1);
                    }

                }
            })
        }

});

});