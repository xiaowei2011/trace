<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>提示信息</title>
<link href="css/status.css" rel="stylesheet">
<link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<div id="error_tips">
			<h2>${status}</h2>
			<div class="error_cont">
				<ul>
					<li>${message}</li>
				</ul>
				<div class="error_return">
					<a href="${not empty url ? url : 'javascript:window.history.go(-1);'}"
						class="btn">返回</a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		setTimeout(function() {
					location.href = "${not empty url ? url : 'javascript:window.history.go(-1);'}";
				}, 3000);
	</script>
</body>
</html>