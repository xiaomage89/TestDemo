<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equlv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理页面</title>
<link rel="stylesheet" href="./css/index.css" type="text/css">

    <script type="text/javascript">
        function mouseoveMessage(e){
        	clearTimeout(time);
            var ulDNoneGoods=document.getElementById(e);
            ulDNoneGoods.style.display='block'


        };
        function mouseleaveMessage(e){
        	time = setTimeout(function(){//这个区域放置1-2秒，而不是 只要划过就行
                var ulDNoneGoods=document.getElementById(e);
                ulDNoneGoods.style.display='none'
        	},1000)
        }
        function mouseoveTypes(e){
        	clearTimeout(time);
            var ulDNoneGoods=document.getElementById(e);
            ulDNoneGoods.style.display='block'


        };
        function mouseleaveTypes(e){
        	time = setTimeout(function(){//这个区域放置1-2秒，而不是 只要划过就行
                var ulDNoneGoods=document.getElementById(e);
                ulDNoneGoods.style.display='none'
        	},1000)
        }
/*        function mouseoverDispayBox(){
            var boxcont1=document.getElementById('boxcont1');
            boxcont1.style.display='none'
        }
        function mouseleaveDispayBox(){
            
        }*/
    </script>
</head>
<body>
	<div id="header" class="layer clearfix">
		<h1>欢迎您进入后台管理页面</h1>
	</div>
	<div id="nav"  class="layer clearfix">
		<ul class="ulD" >
			<li class="liD">
				<a href="" class="navCM" onmouseover="mouseoveMessage('ulDNoneGoods')" onmouseleave="mouseleaveMessage('ulDNoneGoods')">商品管理</a>
				<ul id = "ulDNoneGoods" class="ulDNone">
					<li><a href="selGoodsServlet?act=sel" class="navM">查询商品</a></li>
					<li><a href="admin/addGoods.jsp" class="navM">添加商品</a></li>
					<li><a href="admin/selGoods.jsp?act=del" class="navM">删除商品</a></li>
					<li><a href="admin/selGoods.jsp?act=upd" class="navM">修改商品</a></li>
				</ul>
			</li>
			<li class="liD">
				<a href="" class="navCM" onmouseover="mouseoveTypes('ulDNoneTypes')" onmouseleave="mouseleaveTypes('ulDNoneTypes')">类型管理</a>
				<ul id = "ulDNoneTypes"  class="ulDNone">
					<li><a href="admin/addTypes.jsp" class="navM">添加类型</a></li>
					<li><a href="admin/delTypes.jsp" class="navM">删除类型</a></li>
					<li><a href="admin/updTypes.jsp" class="navM">修改类型</a></li>
					<li><a href="admin/selTypes.jsp" class="navM">查询类型</a></li>
				</ul>
			</li>
			<li class="liD">
				<a href="" class="navCM" onmouseover="mouseoveMessage('ulDNoneUsers')" onmouseleave="mouseleaveMessage('ulDNoneUsers')">用户管理</a>
				<ul id = "ulDNoneUsers"  class="ulDNone">
					<li><a href="admin/addUsers.jsp" class="navM">添加用户</a></li>
					<li><a href="admin/delUsers.jsp" class="navM">删除用户</a></li>
					<li><a href="admin/updUsers.jsp" class="navM">修改用户</a></li>
					<li><a href="admin/selUsers.jsp" class="navM">查询用户</a></li>
				</ul>
			</li>
			<li class="liD">
				<a href="" class="navCM" onmouseover="mouseoveMessage('ulDNoneOrderMs')" onmouseleave="mouseleaveMessage('ulDNoneOrderMs')">订单管理</a>
				<ul id = "ulDNoneOrderMs"  class="ulDNone">
					<li><a href="admin/addOrderMs.jsp" class="navM">添加订单</a></li>
					<li><a href="admin/delOrderMs.jsp" class="navM">删除订单</a></li>
					<li><a href="admin/updOrderMs.jsp" class="navM">修改订单</a></li>
					<li><a href="admin/selOrderMs.jsp" class="navM">查询订单</a></li>
				</ul>
			</li>
			<li class="liD">
				<a href="" class="navCM" onmouseover="mouseoveMessage('ulDNoneNoticeM')" onmouseleave="mouseleaveMessage('ulDNoneNoticeM')">公告管理</a>
				<ul id = "ulDNoneNoticeM"  class="ulDNone">
					<li><a href="admin/addNoticeM.jsp" class="navM">添加公告</a></li>
				</ul>
			</li>
		</ul>
	</div>
 	<div id="content" class="layer clearfix">
		<iframe src="selGoodsServlet?act=main" name="content" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>
	</div>
	<div id="footer" class="layer clearfix">Copyright @XXXXXXXXXXX</div>
</body>
</html>