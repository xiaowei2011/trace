<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新增产品</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<!--    自定义 -->
<link rel="import" href="navigation.htm">
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>	
<script type="text/javascript">
	$(function(){
		var doc = $("link[rel = 'import']")[0].import;
		var header = $(doc).find("div.container-fluid.header");
		var foot= $(doc).find("div.user_copyright");
		$("body").prepend(header.clone()).append(foot.clone());
		var flag=false;
		$("#dropdownMenu1").click(function(){
			if(flag){
				$(".dropdown-menu").show();
			}else{
				$(".dropdown-menu").hide();
			}
			flag=!flag;
		});
		
		$(":file[name='img']").change(function(){
			var url=getObjectURL(this.files[0]);
			if(url==null){
				$("#preview-img")[0].src="";
				$("#preview-img").hide();
			}else{
				$("#preview-img")[0].src=url;
				$("#preview-img").show();
			}
		});
	})
	function getObjectURL(file) {
		var url = null ;
		if(file==undefined)
			return null;
		if (window.createObjectURL!=undefined) { // basic
			url = window.createObjectURL(file) ;
		} else if (window.URL!=undefined) { // mozilla(firefox)
			url = window.URL.createObjectURL(file) ;
		} else if (window.webkitURL!=undefined) { // webkit or chrome
			url = window.webkitURL.createObjectURL(file) ;
		}
		return url ;
	}
</script>
</head>

<body>
	<div class="user container"
		style="width: 100%; max-width: 960px; padding: 0;">
		<div class="user_center_body" style="padding: 8px; width: 100%;">

			<section style="margin-top: 16px; width: 100%;" class="container">

				<form class="form-horizontal" action="productAlter.htm" method="POST"
					enctype="multipart/form-data">
					<h3 style="text-align: center;">编辑产品</h3>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">产品名称</label>
						<div class="col-sm-10">
							<input type="hidden" name="id" value="${product.id}">
							<input type="text" class="form-control" name="name" value="${product.name}">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">上市时间</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" name="pickDateStr"
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${product.pickDate}'/>">
						</div>
					</div>
	
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">种植时间</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" name="plantDateStr" 
							value="<fmt:formatDate pattern='yyyy-MM-dd' value='${product.plantDate}'/>">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">产地</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="origin" value="${product.origin}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">产品简介</label>
						<div class="col-sm-10">
							<textarea class="form-control" name="description" rows="4">${product.description}</textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="upload-pic" class="col-sm-2 control-label">产品图片</label>
						<div class="col-sm-10">
							<input type="file" accept="image/*" class="form-control" name="img">
							<span style="color: red">图片文件建议不要超过2M</span><br> <img src="${product.img}"
								alt="尚未添加图片" id="preview-img"
								style="margin-top: 8px; max-width: 200px;">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">提交</button>
						</div>
					</div>
				</form>
			</section>
		</div>
	</div>
</body>
</html>