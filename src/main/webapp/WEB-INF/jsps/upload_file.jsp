<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
			<meta name="description" content="">
				<meta name="author" content="">

					<title>资料管理平台</title> <!-- Bootstrap Core CSS -->
					<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

						<!-- MetisMenu CSS -->
						<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

							<!-- DataTables CSS -->
							<link href="<%=basePath%>css/dataTables.bootstrap.css"
								rel="stylesheet">

								<!-- Custom CSS -->
								<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

									<!-- Custom Fonts -->
									<link href="<%=basePath%>css/font-awesome.min.css"
										rel="stylesheet" type="text/css">
										<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
											type="text/css">
</head>

<body>
<script type="text/javascript" src="/DocumentsManage/js/register.js"></script>
<script type="text/javascript" src="/DocumentsManage/js/jquery.js"></script>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">资料管理平台</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
		欢迎你：${user.userName }
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user "></i>
					<i class="fa fa-caret-down"></i>
			</a>

				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> 用户设置</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> 系统设置</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/user/loginout.do"><i class="fa fa-sign-out fa-fw"></i>
							退出登录</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
						
					</li>
					<li><a
						href="${pageContext.request.contextPath}/user/toindex.do"
						class="active"><i class="fa fa-home fa-fw"></i> 主页</a></li>
					<li><a
						href="${pageContext.request.contextPath}/file/manage_file.do"
						class="active"><i class="fa fa-edit fa-fw"></i> 资料管理</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/upload_file.do"
						class="active"><i class="fa fa-dashboard fa-fw"></i> 资料上传</a></li>
				</ul>
			</div>
			
		</div>
</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">资料上传</h1>
				</div>
					<form action="${pageContext.request.contextPath}/file/uploadFile.do"  method="post" onsubmit="return CheckAll()"enctype="multipart/form-data" >
				 <div>
                    <div class="form-group">
                        <label class="control-label">资料名称</label>
                        <input class="form-control"  type="text" id="fileName" name="fileName" placeholder="请输入资料名称" onblur="checkfileName()"  />
                        <span id="fileNameSpan" style="color: red; font-style:italic;"></span>	
                    </div>
                    <div class="form-group">
                        <label class="control-label">上传人</label>
                        <input class="form-control" readonly="readonly" type="text" value="${user.userName }" placeholder="" />
                    </div>
                    <div class="form-group">
                      
							<label class="control-label">小组名称</label>
                        <input class="form-control" readonly="readonly" type="text" value="${user.groupName }" placeholder="" />
                    </div>
                     <div class="form-group">
                        <label class="control-label">资料简介</label>
                     	<textarea placeholder="请输入资料简介"  rows="3" cols="80" id="fileDescription" name="fileDescription" onblur="checkfileDescription()" ></textarea>
                     	 <span id="fileDescriptionSpan" style="color: red; font-style:italic"></span>	
                    </div>
                    <div class="form-group">
                        <label class="control-label">上传附件</label><span >(文件最大不超过10m)</span>
                     	<input  type="file" id="file"  onblur="checkfile()" name="file" value="附件名"/>
                     	 <span id="fileSpan" style="color: red;"></span>	
                    </div>
                    
                    <div class="form-group">
                        <button type="submit" class="btn btn-default" ">提交</button>
                    </div>
                </div>
			</form>
			</div>
		
		</div>
		
		<!-- /#page-wrapper -->

	</div>

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="<%=basePath%>js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=basePath%>js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=basePath%>js/sb-admin-2.js"></script>
	<script type="text/javascript">
	function checkfileName() {
		var fileName = $("#fileName").val();
		var spanNode = document.getElementById("fileNameSpan");
		if (fileName.replace(/^ +| +$/g, '') == '') {
			document.getElementById('fileNameSpan').innerHTML = "资料名不能为空！"
			return false;
		}else {
			spanNode.innerHTML = "";
			return true;
		}

	}
	function doSubmit(){
		var file =  document.getElementById('file'); 
		if(file.value == ""){
			alert("请选择您需要上传的文件！"); 
			
		}else {
			return true;
		}
		
	}
	
	function checkfileDescription() {
		var fileDescription = $("#fileDescription").val();
		var spanNode = document.getElementById("fileDescriptionSpan");
		if (fileDescription.replace(/^ +| +$/g, '') == '') {
			document.getElementById('fileDescriptionSpan').innerHTML = "资料描述不能为空！"
			return false;
		}else {
			spanNode.innerHTML = "";
			return true;
		}

	}
	
	
	
	 function CheckAll() {
		
		 var fileName =  checkfileName();
		 var Submit = doSubmit();
		 var fileDescription = checkfileDescription();
		if(fileName&&Submit&&fileDescription){
			return true;
		}else {
			return false;
		}
	} 
	
	
	</script>
	

</body>

</html>
