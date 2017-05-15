<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>产品详情</title>
<link href="css/productDetail.css" rel="stylesheet" type="text/css"/>
<!-- 顶部资源   -->
</head>
<body>
	<!-- 内容 -->

	<div id="wrap">
		<header id="bar" class="f24">
			<span id="headTitle">产品详情</span>
		</header>
		<section id="cards">
			<div class="first-view ac">
				<span class="produce_photo"> <img src="${product.img}" 
				onerror="javascript:this.src='img/product_0.png'"
					class="img-responsive" width="480px">
				</span><span class="logo-bg"></span>
			</div>
			<div class="product-title clearfix">
				<p class="product-name">
					XX公司 <a href="http://admin.xasimple.com/weixinpl/common_shop/jiushop/index.php?customer_id=UmUFNgBnBDQ=&amp;fromuser=o-ym5uDGbuakCba_Wo7LHQrfaNVs&amp;wxref=mp.weixin.qq.com"
						class="company">
					</a>
				</p>
			</div>
			<div class="produce-info">
				<div class="statistics">
					<ul>
						<li>
							<p>名称</p>
							<p class="value cropname">${not empty product.name ? product.name : "不详"}</p>
						</li>
						<li>
							<p>上市时间</p>
							<p class="value date">${empty product.pickDate ? "不详" : "" }
							<fmt:formatDate pattern="yyyy/MM/dd" value="${product.pickDate }"/></p>
						</li>
						<li>
							<p>种植时间</p>
							<p class="value date">${empty product.plantDate ? "不详" : "" }
							<fmt:formatDate pattern="yyyy/MM/dd" value="${product.plantDate }"/></p>
						</li>
					</ul>
				</div>
			</div>
			<div class="card summary">
				<div class="company pd20 mt30">
					<ul>
						<li><label id="cplogo" class="label-like"> <i
								class="company-logo"></i>
						</label>
							<div>
								<a
									href="http://suyuan.iacms.cn/index.php?m=Product&amp;a=show_area&amp;area_id=1&amp;product_id=1">
								</a>
								<p class="c-name" id="companyname">XX公司</p>
							</div></li>
						<li><label class="label-like"> 负责人</label>
							<p>
								<span class="name mr20" id="headUser">XXX</span><span
									id="check_i"></span>
							</p></li>
						<li><label class="label-like"> 产地</label>
							<p class="company-address">${not empty product.origin ? product.origin : "不详"}</p></li>
					</ul>
				</div>
			</div>

			<div class="card Moudle" id="Moudle_9104">
				<div class="mod brief">
					<p class="sub-title f24 ac">产品简介</p>
					<div class="clearfix mt15 text" style="text-indent: 2em;">
						${not empty product.description ? product.description : "不详"}
					</div>
				</div>
			</div>
			
		</section>
	</div>
</body>
</html>