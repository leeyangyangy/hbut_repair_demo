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
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
	    	<li><span><a href="javascript:history.go(-1);">平台首页 </a>&gt; 出入库记录 &gt; 入库记录</span></li>
	   </ul>
	</div>
	<div id="down">
		<table width="1000px" cellpadding="0" cellspacing="0">
			<thead>
			<tr class="head">
				<td>序号</td>
				<td>入库物料名称</td>
				<td>入库数量</td>
<%--				<td>单价</td>--%>
<%--				<td>总价</td>--%>
				<td>操作人</td>
				<td>入库时间</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allStorage}" var="storage" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${storage.productName}</td>
					<td>${storage.storageNumber}</td>
<%--					<td></td>--%>
<%--					<td></td>--%>
					<td>${storage.storageUser}</td>
					<td>${storage.storageTime}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
    </div>
  </body>
</html>
