<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资料管理平台注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />

<link href="/DocumentsManage/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="/DocumentsManage/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="/DocumentsManage/js/register.js"></script>
<script type="text/javascript" src="/DocumentsManage/js/jquery.js"></script>
<div class="signupform">
<h1>资料管理平台</h1>
	<div class="container">
		
		<div class="agile_info">
			<div class="w3l_form">
				<div class="left_grid_info">
					<h3>Welcome !</h3>
					<h4>Lorem ipsum dolor sit amet, nulla consectetur adipiscing elit Sed.</h4>
					<p> Nam eleifend velit eget dolor vestibulum ornare. Vestibulum est nulla, fermentum eget euismod et, tincidunt at dui. Nulla tellus nisl, semper id justo vel, rutrum finibus risus. Cras vel auctor odio.</p>
					<ul class="social_section_1info">
						<li><a href="#" class="w3_facebook"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#" class="w3_twitter"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#" class="w3_instagram"><i class="fa fa-instagram"></i></a></li>
						<li><a href="#" class="w3_google"><i class="fa fa-google-plus"></i></a></li>
						<li><a href="#" class="w3_pinterest"><i class="fa fa-pinterest"></i></a></li>
						<li><a href="#" class="w3_vimeo"><i class="fa fa-vimeo"></i></a></li>
					</ul>
				</div>
			</div>
			<div class="w3_info">
				<h2>注册</h2>
						<form action="${pageContext.request.contextPath }/user/register.do"  onsubmit="return checkAll()" method="post">
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="text" name="userName"  id="userName" placeholder="用户名" onblur="checkUser()"> 
						
							<span id="userSpan" style="color: red;"></span>							
						</div>
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="Password" name="password" id="password" placeholder="密码" onblur="checkPassword()"  >
							<br>
							<span style="font-size:13px" id="passwordspan"></span>
						</div>
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="Password"  id="password2"   placeholder="确认密码" onblur="checkSame()">
							<br>
       						<span  style="font-size:13px" id="passwordspan2"></span>  
						</div>
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="text" placeholder="班级"name="majorClass" id="majorClass" onblur="checkmajorClass()"> 
							<br>
							 <span  style="font-size:13px" id="majorClassSpan"></span> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-envelope" aria-hidden="true"></i></span>
							<input type="email" name="telephone" id="telephone" placeholder="联系方式"  onblur="checkTelephone()"> 
							<br>
							<span  style="font-size:13px" id="TelephoneSpan"></span> <br> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="text" name="groupName" id="groupName"  placeholder="所在小组名称" onblur="checkGroupName()">
							<br>
							 <span  style="font-size:13px" id="groupNameSpan"></span> 
						</div>
					
						
						      
							<button class="btn btn-danger btn-block" type="submit" >Create Account</button >   
							 <h4>已有账号？<a href="${pageContext.request.contextPath }/user/toLogin.do">登录</a></h4>               
					</form>
			</div>
			<div class="clear"></div>
			</div>
			
		</div>
		<div class="footer">

 <p>Copyright &copy; 2018.Company name All rights reserved.Thomas</a></p>
 </div>
	</div>
	</body>
</html>