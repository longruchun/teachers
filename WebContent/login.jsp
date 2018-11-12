<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en" class="fullscreen-bg">

<head>
	<title>登录</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="Public/css/bootstrap.min.css">
	<link rel="stylesheet" href="Public/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="Public/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="Public/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="Public/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="Public/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="Public/img/favicon.png">
	<script type="text/javascript">
	   if (!navigator.cookieEnabled){//如果cookie被禁用,终止应用
		   location="cookieEnable.jsp";
	   } 
	   if(window.top!==window.self){window.top.location=window.location};
	</script>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box "  style="height:auto;">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center"><img style="width:60px;height:60px;" src="Public/images/logo.jpg" alt="Klorofil Logo"></div>
								<p class="lead">登录到你的帐户</p>
							</div>
							<form class="form-auth-small" action="${pageContext.request.contextPath }/adminServlet?method=login" method="post">
								<div class="form-group text-left">
									身份
									<select id="identify" name="identify" style="width:230px;">
								      
								       <option value="0">后台管理员</option>
								       <option value="1">宠物主人</option>
								       <option value="2">宠物专卖店</option>
								    </select>
								</div>
								<div class="form-group">
									<label for="name" class="control-label sr-only">Name</label>
									<input type="text" class="form-control" id="name" name="name" value="" placeholder="姓名">
								</div>
								<div class="form-group">
									<label for="password" class="control-label sr-only">Password</label>
									<input type="password" class="form-control" id="password" name="password" value="" placeholder="密码">
								</div>
								<div class="form-group clearfix">
									<label class="fancy-checkbox element-left">
										<input type="checkbox" name="rememberme" value="1"/>
										<span>记住我</span>
									</label>
								</div>
								<button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
								<div class="bottom">
									<span class="helper-text"><i class="fa fa-lock"></i> <a href="#">忘了密码?</a></span>
								</div>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading">宠物交易网欢迎你光临</h1>
							<p>开发世纪</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>
