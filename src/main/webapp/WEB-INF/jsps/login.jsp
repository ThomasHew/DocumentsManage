<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资料管理平台登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />
<link href="/DocumentsManage/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" media="all">
<link href="/DocumentsManage/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link
	href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900"
	rel="stylesheet">
</head>
<body>
	<div class="signupform">
		<h1>资料管理平台</h1>
		<div class="container">

			<div class="agile_info">
				<div class="w3l_form">
					<div class="left_grid_info">
						<h3>Welcome !</h3>
						<h4>Lorem ipsum dolor sit amet, nulla consectetur adipiscing
							elit Sed.</h4>
						<p>Nam eleifend velit eget dolor vestibulum ornare. Vestibulum
							est nulla, fermentum eget euismod et, tincidunt at dui. Nulla
							tellus nisl, semper id justo vel, rutrum finibus risus. Cras vel
							auctor odio.</p>
						<ul class="social_section_1info">
							<li><a href="#" class="w3_facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="w3_twitter"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="w3_instagram"><i
									class="fa fa-instagram"></i></a></li>
							<li><a href="#" class="w3_google"><i
									class="fa fa-google-plus"></i></a></li>
							<li><a href="#" class="w3_pinterest"><i
									class="fa fa-pinterest"></i></a></li>
							<li><a href="#" class="w3_vimeo"><i class="fa fa-vimeo"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="w3_info">
					<h2>登录</h2>
					<p><%
				String msg = (String)request.getAttribute("msg");
					if(msg!=null){
				out.print(msg);
					}
	
					%>	</p>
					<form action="${pageContext.request.contextPath }/user/login.do" method="post">
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span> <input
								type="text" placeholder="用户名" name="userName" required="">
						</div>
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span> <input
								type="password" name="password" placeholder="密码" required="">
						</div>
						
						
							
						<label for="remember-me"> 
						<input name="autologin" type="checkbox" onclick="remember();"> <h4>自动登录(公共计算机请不要勾选)</h4>
						</label>
						 
						<button class="btn btn-danger btn-block" type="submit">Login</button>
						<h4>
							没有账户？<a href="${pageContext.request.contextPath }/user/toregister.do">注册</a>
						</h4>
					</form>
				</div>
				<div class="clear"></div>
			</div>

		</div>
		<div class="footer">

			<p>Copyright &copy; 2018.Company name All rights reserved.Thomas</p>
		</div>
	</div>
</body>
</html>