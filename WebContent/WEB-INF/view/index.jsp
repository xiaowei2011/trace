<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>农产品溯源系统</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet">
<link href="http://www.bootcdn.cn//assets/css/site.min.css" rel="stylesheet">
<link rel="apple-touch-icon-precomposed" sizes="144x144" 
	href="http://www.bootcdn.cn//assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="shortcut icon" href="http://www.bootcdn.cn//assets/ico/favicon.ico">
<style>
img {
	max-width: 100%;
}
</style>
</head>

<body class="home-template">
	<div class="site-notice hidden">
		<a href="javascript:void(0);" target="_blank"> <em>溯源系统，为您的产品再添一份信任！</em></a>
	</div>
	<header class="site-header jumbotron">
		<div class="site-nav">
		<c:choose>
			<c:when test="${admin != null}">
			<a href="toProductManage.htm" style="font-size:1.8rem;">${admin.account}</a>
			 &nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="logout.htm?url=toIndex.htm" style="font-size:1.8rem;">退出</a>
			</c:when>
			<c:otherwise>
			<a href="toLogin.htm" style="font-size: 1.8rem;">登录</a>
			</c:otherwise>
		</c:choose>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<h1 style="text-shadow: none;">溯源系统</h1>
					<p style="text-shadow: none;">农产品的户口本，塑造信誉品牌</p>
				</div>
			</div>
		</div>
	</header>

	<div class="container protocal-notice">
		<div class="row">
			<div class="col-xs-12">
				<p style="text-align: center;">
					<img src="http://suyuan.iacms.cn/statics/default/img/index1.png" alt="">
					<img src="http://suyuan.iacms.cn/statics/default/img/index2.png" alt="">
				</p>
			</div>
		</div>
	</div>

	<footer id="footer" class="footer hidden-print hidden-xs">
		<div class="container">
			<div class="row">
				<div class="footer-about col-md-5 col-sm-12" id="about">
					<h4>关于溯源</h4>
					<p>农业科技服务提供商</p>
				</div>
			</div>
		</div>
	</footer>
	<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>
</body>
</html>