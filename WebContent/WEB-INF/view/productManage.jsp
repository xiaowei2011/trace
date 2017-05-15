<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>产品列表</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="import" href="navigation.htm">
<link href="css/productManage.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
<script type="text/javascript">
	$(function(){
		//引入导航栏和尾部
		var doc = $("link[rel = 'import']")[0].import;
		var header = $(doc).find("div.container-fluid.header");
		var foot= $(doc).find("div.user_copyright");
		$("body").prepend(header.clone()).append(foot.clone());
		var flag=true;
		$("#dropdownMenu1").click(function(){
			if(flag){
				$(".dropdown-menu").show();
			}else{
				$(".dropdown-menu").hide();
			}
			flag=!flag;
		});
		
		$(".qrcode").each(function(){
			var url ="http://"+location.host+"${pageContext.request.contextPath}/";
			url+=$(this).attr("data-url");
			console.log(url);
			$(this).qrcode({width:100,height:100,text:url})
		});
	});
	function productDelete(id){
		if(confirm("确定删除该产品！")){
			location.href="productDelete.htm?id="+id;
		}
	}
</script>
</head>
<body>
	<div class="visible-xs" style="background: white; margin-top: 5px;">
		<div class="part">
			<a href="toProductAdd.htm"
				class="btn btn-success" style="color: white;"> 新增产品 </a>
			<c:forEach var="product" items="${products}">
			<div class="media">
				<a class="media-left" href="toProductDetail.htm?id=${product.id}"
					target="_blank"> <span class="qrcode"
					data-url="toProductDetail.htm?id=${product.id}"
					style="width: 100px; height: 100px;"
					title="toProductDetail.htm?id=${product.id}"></span>
				</a>
				<div class="media-body">
					<h3 class="media-heading">${not empty product.name ? product.name : "不详"}</h3>
					<p class="shangshi">种植时间：${empty product.plantDate ? "不详" : ""}
					<fmt:formatDate pattern="yyyy/MM/dd" value="${product.plantDate}"/></p>
					<p class="shangshi">上市时间：${empty product.pickDate ? "不详" : ""}
					<fmt:formatDate pattern="yyyy/MM/dd" value="${product.pickDate}"/></p>
					<p class="pinzhong">产地：${product.origin}</p>
					<p>
						<a class="btn btn-primary btn-sm text-white"
							href="toProductAlter.htm?id=${product.id}">
							<span class="glyphicon glyphicon-edit"></span> 编辑
						</a> <a class="btn btn-danger btn-sm text-white"
						href="javascript:void(0)" onclick="productDelete(${product.id})"> <span
							class="glyphicon glyphicon-remove"></span> 删除
						</a>
					</p>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>

	<div class="user hidden-xs">
		<div class="user_center_body" style="padding: 8px;">
			<a href="toProductAdd.htm"
				class="btn btn-success" style="color: white">新增产品</a>
			<section style="margin: 8px;">
				<table class="table table-bordered table-hover">
					<caption>产品列表</caption>
					<thead>
						<tr class="success">
							<th>ID</th>
							<th>二维码</th>
							<th>名称</th>
							<th>种植时间</th>
							<th>上市时间</th>
							<th>产地</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${products}">
						<tr>
							<th scope="row">${product.id}</th>
							<td>
								<div style="width: 100px; height: 100px;"
									title="toProductDetail.htm?id=${product.id}">
									<a href="toProductDetail.htm?id=${product.id}" class="qrcode" 
									 data-url="toProductDetail.htm?id=${product.id}" target="_blank"></a>
								</div>
							</td>
							<td>${not empty product.name ? product.name : "不详"}</td>
							<td>${empty product.plantDate ? "不详" : ""} <fmt:formatDate 
								pattern="yyyy/MM/dd" value="${product.plantDate}"/></td>
							<td>${empty product.pickDate ? "不详" : ""}<fmt:formatDate 
								pattern="yyyy/MM/dd" value="${product.pickDate}"/></td>
							<td>${product.origin}</td>
							<td><a class="btn btn-primary btn-sm text-white"
								href="toProductAlter.htm?id=${product.id}">
									<span class="glyphicon glyphicon-edit"></span> 编辑
							</a> <a class="btn btn-danger btn-sm text-white"
								href="javascript:void(0)" onclick="productDelete(${product.id})"> <span
									class="glyphicon glyphicon-remove"></span> 删除
							</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</div>
	</div>
</body>
</html>