<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<link  href="<%=request.getContextPath() %>/css/content.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		#down table {
			position: relative;
			left: 50%;
			margin-left: -500px;
			top: 50px;
			border-top: 1px #999 solid;
			border-right: 1px #999 solid;
		}
		#down tr {
			height: 60px;
		}
		
		#down tr td {
			text-align: center;
			border-left: 1px #999 solid;
			border-bottom: 1px #999 solid;
		}
		
		#up a:VISITED,#up a:LINK {
			color: #4C8FBD;
			text-decoration: none;
		}
		#up a:HOVER {
			color: #4C8FBD;
			text-decoration: none;
		}
		.head {
			background: #438EB9;
			color: #fff;
		}
		tbody tr:nth-child(odd) {
			background: #e5e5e5;
		}
		
		tbody tr:nth-child(even) {
			background: #d5d5d5;
		}
	</style>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		
	</script>
  </head>
  
  <body>
  	<div id="up">
	   <ul>
	    	<li><span><a href="javascript:history.go(-1);">平台首页 </a>&gt; 用户管理 &gt; 用户列表</span></li>
	   </ul>
	</div>
	<div id="down">
	    <table width="1000px" cellpadding="0" cellspacing="0">
	    	<thead>
		    	<tr class="head">
		    		<td>序号</td>
					<td>主键</td>
					<td>姓名</td>
					<td>用户账号</td>
					<td>用户状态</td>
<%--					<td>关联字段</td>--%>
<%--					<td>角色主键</td>--%>
					<td>用户角色</td>
		    		<td>操作</td>
		    	</tr>
	    	</thead>
	    	<tbody>
				<c:forEach items="${allUser}" var="user" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.userId}</td>
						<td>${user.status}</td>
<%--						<td>${user.permissionId}</td>--%>
<%--						<td>${user.permission.id}</td>--%>
						<td>${user.permission.permissionName}</td>
			    		<td>
<%--			    			<a href="/getCustomerById?id=${user.userId}">用户详情</a>&nbsp;--%>
							<a href="/user/toUpdateUser?userId=${user.userId}">修改</a>&nbsp;

							<c:if test="${user.permissionId>1}">
								<a href="/user/deleteUserByUserId?userId=${user.userId}" class="del">删除</a>&nbsp;
							</c:if>
			    		</td>
			    	</tr>
				</c:forEach>
			</tbody>
	    </table>
    </div>
  </body>
</html>
