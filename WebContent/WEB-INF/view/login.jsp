<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link href="css/login.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<title>系统登录</title>
</head>
<body>
	<div class="header">
		<div class="header_con">
			<div class="logo">溯源系统</div>
			<div class="right">
				<a class="home" href="/">返回主页</a>
			</div>
		</div>
		<div class="login_body">
			<div class="login_box">
				<div class="login_box_left">
					<form action="login.htm" method="post">
						<div class="center">
							<span id="errMessage"
							 ${empty message ? "style='display:none;'" :""}>${message}</span>
						</div>
						<div class="site">
							<div class="info_list">
								<div class="username">
								<input type="hidden" name="productId" value="${productId}"/>
									<input class="input" type="text" value="" name="account"
										id="loginName" placeholder="请输入管理员帐号" style="width: 100%;">
								</div>
							</div>
							<div class="info_list">
								<div class="password">
									<input class="input" type="password" value="" name="password"
										maxlength="128" id="password" placeholder="请输入密码">
								</div>
							</div>
							<!-- 
							<div class="info_list">
								<div id="loginName" class="input">
									<input id="vCode" class="input_normal" type="text"
										style="width: 81px;" name="vCode" maxlength="4" value="请输入验证码">
								</div>
								<div class="vcode">
									<div class="noleft">
										<img id="authCode" title="看不清？点击更换"
											src="http://suyuan.iacms.cn/index.php?g=Api&amp;m=Checkcode&amp;type=userlogin&amp;code_len=4&amp;font_size=14&amp;width=80&amp;height=24&amp;font_color=&amp;background=">
									</div>
								</div>
							</div>
							 -->
							<div class="style">
								<input class="home_btn" type="submit" value="登 陆">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="bottom">
			<div class="content"> © 2016 溯源系统</div>
		</div>
	</div>
</body>
</html>