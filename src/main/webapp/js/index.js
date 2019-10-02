var $,tab,dataStr,layer;
layui.config({
	base : "../../js/"
}).extend({
	"bodyTab" : "bodyTab"
})
function chingeimg(){
	$(".loginImg").attr("src","../../student/getuserimg.action?data="+ new Date() + Math.floor(Math.random()*24));

}
layui.use(['bodyTab','form','element','layer','jquery'],function(){
	var form = layui.form,
		element = layui.element;
		$ = layui.$;
		var role=localStorage.getItem("rId")
    	layer = parent.layer === undefined ? layui.layer : top.layer;
		tab = layui.bodyTab({
			openTabNum : "50",  //最大可打开窗口数量
			url : "../../student/getTree.action?rId="+role //获取菜单json地址
		});
		//加载头像
	$(function () {

		$.ajax({
			cache:false,
			async:true,
			type: 'POST',
			xhrFields: {
				withCredentials: true
			},
			// 允许跨域
			crossDomain: true,
			url: '../../student/getuser.action?data=' + new Date() + Math.floor(Math.random()*24),


			success: function (data) {
				/*if(data.slNicheng!=null){*/
				$(".userName1").text(data.slNicheng);
			/*	}*/
				$(".loginImg").attr("src","../../student/getuserimg.action?data="+ new Date() + Math.floor(Math.random()*24));
			}

		});

	});

	//通过顶部菜单获取左侧二三级菜单
	// 注：此处只做演示之用，实际开发中通过接口传参的方式获取导航数据
	function getData(){
		$.get(tab.tabConfig.url,function(data){

				dataStr = data;
				//重新渲染左侧菜单
				tab.render();

		})
	}
	//页面加载时判断左侧菜单是否显示
	//通过顶部菜单获取左侧菜单
	$(".topLevelMenus li,.mobileTopLevelMenus dd").click(function(){
		if($(this).parents(".mobileTopLevelMenus").length != "0"){
			$(".topLevelMenus li").eq($(this).index()).addClass("layui-this").siblings().removeClass("layui-this");
		}else{
			$(".mobileTopLevelMenus dd").eq($(this).index()).addClass("layui-this").siblings().removeClass("layui-this");
		}
		$(".layui-layout-admin").removeClass("showMenu");
		$("body").addClass("site-mobile");

		//渲染顶部窗口
		tab.tabMove();
	})

	//隐藏左侧导航
	$(".hideMenu").click(function(){
		if($(".topLevelMenus li.layui-this a").data("url")){
			layer.msg("此栏目状态下左侧菜单不可展开");  //主要为了避免左侧显示的内容与顶部菜单不匹配
			return false;
		}
		$(".layui-layout-admin").toggleClass("showMenu");
		//渲染顶部窗口
		tab.tabMove();
	})

	//通过顶部菜单获取左侧二三级菜单   注：此处只做演示之用，实际开发中通过接口传参的方式获取导航数据
	getData("");

	//手机设备的简单适配
    $('.site-tree-mobile').on('click', function(){
		$('body').addClass('site-mobile');
	});
    $('.site-mobile-shade').on('click', function(){
		$('body').removeClass('site-mobile');
	});

	// 添加新窗口
	$("body").on("click",".layui-nav .layui-nav-item a:not('.mobileTopLevelMenus .layui-nav-item a')",function(){
		//如果不存在子级
		if($(this).siblings().length == 0){
			addTab($(this));
			$('body').removeClass('site-mobile');  //移动端点击菜单关闭菜单层
		}
		$(this).parent("li").siblings().removeClass("layui-nav-itemed");
	})

	//清除缓存
	$(".clearCache").click(function(){
		window.sessionStorage.clear();
        window.localStorage.clear();
        var index = layer.msg('清除缓存中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
            layer.msg("缓存清除成功！");
        },1000);
    })

	//刷新后还原打开的窗口

})

//打开新窗口
function addTab(_this){
	tab.tabAdd(_this);
}



/*
//图片管理弹窗
function showImg(){
    $.getJSON('json/images.json', function(json){
        var res = json;
        layer.photos({
            photos: res,
            anim: 5
        });
    });
}*/
