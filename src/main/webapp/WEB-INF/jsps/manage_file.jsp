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

<title>资料管理平台</title>

<!-- Bootstrap Core CSS -->
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
	type="text/css">



</head>

<body>

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
					<li><a
						href="${pageContext.request.contextPath}/user/loginout.do"><i
							class="fa fa-sign-out fa-fw"></i> 退出登录</a></li>
				</ul> <!-- /.dropdown-user --></li>

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
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">资料管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline"
						action="${pageContext.request.contextPath }/file/manage_file.do"
						method="post">

						<div class="form-group">
							<label for="customerFrom">文件名称</label>
							<input type="text" class="form-control" placeholder="请输入需要查找的文件名"  name="fileName" />
						</div>
						<div class="form-group">
							<label for="custIndustry">小组名称</label> <select
								class="form-control"  name="groupName">
								<option value="">--请选择--</option>
								<c:forEach items="${groupName}" var="item">
									<option value="${item}"  >${item}</option>
								</c:forEach>
							</select>
						</div>

						<button type="submit" class="btn btn-primary" >查询</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">文件信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>小组名称</th>
									<th>资料名称</th>
									<th>上传ip</th>
									<th>上传人</th>
									<th>创建时间</th>
									<th>更新时间</th>
									<th>浏览数</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pb.fileInfors}" var="files">
									<tr>
										<td>${files.groupName}</td>
										<td>${files.fileName}</td>
										<td>${files.uploadIp}</td>
										<td>${files.uploadUserName}</td>
										<td>${files.uploadTime}</td>
										<td>${files.updateTime}</td>
										
										<td>${files.pageView}</td>
										
										<td><a href="${pageContext.request.contextPath }/file/updatepageview.do?id=${files.id}" class="btn btn-primary btn-xs"
											data-toggle="modal" data-target="#customerEditDialog"
											onclick="editCustomer(${files.id})">查看/修改</a>
											 
											<a href="${pageContext.request.contextPath }/file/download.do?fileName=${files.fileName}" class="btn btn-primary btn-xs"
											>下载</a>
											<a href="#"
											class="btn btn-danger btn-xs"
											onclick="deleteCustomer('${files.id}','${user.userName }','${files.uploadUserName}')">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-12 text-right">
							<ul class="pagination">
								<li><a href="#">&laquo;</a></li>
							
								<li >	<a href="${pageContext.request.contextPath  }/file/manage_file.do?currentPage=${pb.currentPage==1?1:pb.currentPage-1}">上一页</a></li>
								
								<li><a href="#">第${pb.currentPage}页</a></li>
								<li><a href="#">共${pb.totalPageCount} 页</a></li>
								
								<li><a href="${pageContext.request.contextPath  }/file/manage_file.do?currentPage=${pb.currentPage==pb.totalPageCount?pb.totalPageCount:pb.currentPage+1}">下一页</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- 客户编辑对话框 -->
	<div class="modal fade" id="customerEditDialog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改资料信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_file_form">
						<input type="hidden" id="id" name="id" />
						
						<div class="form-group">
								<label for="edit_linkMan" class="col-sm-2 control-label">小组名称</label>
							<div class="col-sm-10">
								<input type="text" readonly="readonly"  class="form-control" id="groupName"
									placeholder="小组名称" name="groupName">
							</div>
						</div>
						<div class="form-group">
								<label for="edit_linkMan" class="col-sm-2 control-label">资料名称</label>
							<div class="col-sm-10">
								<input type="text" readonly="readonly" class="form-control" id="fileName"
									placeholder="资料名称" name="fileName">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">上传ip</label>
							<div class="col-sm-10">
								<input type="text" readonly="readonly" class="form-control" id="uploadIp"
									placeholder="上传ip" name="uploadIp">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan"  class="col-sm-2 control-label">上传人</label>
							<div class="col-sm-10">
								<input type="text" readonly="readonly" class="form-control" id="uploadUserName"
									placeholder="上传人" name="uploadUserName">
							</div>
						</div>
							<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">资料简介</label>
							<div class="col-sm-10">
								<textarea id="fileDescription" rows="3" cols="60"  name="fileDescription" ></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="updateCustomer('${user.userName }')">保存修改</button>
				</div>
			</div>
		</div>
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
		function editCustomer(id) {
			$.ajax({
				type:"get",
				url:"<%=basePath%>file/edit.do",
				data:{"id":id},
				success:function(data) {
					$("#id").val(data.id);
					$("#groupName").val(data.groupName);
					$("#fileName").val(data.fileName);
					$("#uploadIp").val(data.uploadIp);
					$("#uploadUserName").val(data.uploadUserName);
					$("#fileDescription").val(data.fileDescription);
				}
			});
		}
		function updateCustomer(userName) {
			var uploadUserName = document.getElementById("uploadUserName").value;
			
			if(userName == uploadUserName){
				
			$.post("<%=basePath%>file/update.do",$("#edit_file_form").serialize(),function(data){
				alert("资料信息更新成功！");
				window.location.reload();
			});
			}else {
				alert("对不起,您没有权限！");
			}
		}
		
		function deleteCustomer(id,userName,uploadUserName) {
		
			if(userName == uploadUserName){
			if(confirm('确实要删除该资料吗?')) {
				$.post("<%=basePath%>file/delete.do",{"id":id},function(data){
					alert("资料删除更新成功！");
					window.location.reload();
				});
			}
			}else {
				alert("对不起,您没有权限！");
			}
		}
		
		
		
	</script>

</body>

</html>
