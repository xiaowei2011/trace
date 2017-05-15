<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新增产品</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css" href="css/navigation.css" rel="stylesheet" media="all">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>	
</head>
<body>
	<div class="container-fluid header"
		style="background: #385; height: 70px; width: inherit;">
		<div class="h_main" style="width: inherit;">
			<ul class="menus">
				<li class="m_nav_a"><a class="sliding_menu" href="toIndex.htm">首页<b class="arrow"></b></a></li>
				<li class="m_nav_a hidden-xs"><a class="sliding_menu"
					href="toProductManage.htm">产品档案<b class="arrow"></b></a></li>
			</ul>
			<ul class="member_login hidden-xs" id="userLogin">
				<li style="padding: 12px; font-size: 16px;"><a class="set_menu"
					href="toProductManage.htm"
					title="个人设置" style="color: white;">${admin.account}</a></li>
				<li style="padding: 12px; font-size: 16px;"><a class="set_menu"
					href="logout.htm?url=toIndex.htm"
					title="退出登录" style="color: white;">退出登录</a></li>
			</ul>
			<div class="dropdown visible-xs pull-right"
				style="z-index: 99999; padding: 0 10px 0 50px;">
				<p class="text-white dropdown-toggle"
					id="dropdownMenu1" data-toggle="dropdown">
					<span class="glyphicon glyphicon-align-justify"
						style="font-size: 16px; line-height: 70px;"></span>
				</p>
				<ul class="dropdown-menu" role="menu"
					aria-labelledby="dropdownMenu1">
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="toProductManage.htm">产品档案</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="logout.htm?url=toIndex.htm">退出登录</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="user_copyright" style="width: 100%;background: #338855;padding-top: 23px;">
    	<p style="color: white;">© 2017 溯源系统</p>
	</div>
	
</body>
</html>