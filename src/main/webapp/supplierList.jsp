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
<%--					<td>主键</td>--%>
					<td>供应商名称</td>
					<td>供应商简介</td>
					<c:if test="${login.permissionId==1 ||login.permissionId==3}">
						<td>操作</td>
					</c:if>
		    	</tr>
	    	</thead>
	    	<tbody>
				<c:forEach items="${allSupplier}" var="supplier" varStatus="status">
					<tr>
						<td>${status.count}</td>
<%--						<td>${supplier.id}</td>--%>
						<td>${supplier.supplierName}</td>
						<td>${supplier.supplierProfile}</td>
			    		<td>
<%--			    			<a href="/getCustomerById?id=${user.userId}">用户详情</a>&nbsp;--%>


							<c:if test="${login.permissionId==1 || login.permissionId==3}">
								<a href="/supplier/toUpdateSupplierById?id=${supplier.id}">修改</a>&nbsp;
								<a href="/supplier/deleteSupplierById?id=${supplier.id}" class="del">删除</a>&nbsp;
							</c:if>
			    		</td>
			    	</tr>
				</c:forEach>
			</tbody>
	    </table>
    </div>
  </body>
</html>
