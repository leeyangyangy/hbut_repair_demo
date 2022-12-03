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
    
    <title>类别列表</title>
    
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
	    	<li><span><a href="javascript:history.go(-1);">平台首页 </a>&gt; 物料管理 &gt; 物料种类</span></li>
	   </ul>
	</div>
	<div id="down">
	    <table width="1000px" cellpadding="0" cellspacing="0">
	    	<thead>
		    	<tr class="head">
		    		<td>序号</td>
					<td>主键</td>
					<td>大类</td>
					<td>操作人</td>
					<td>创建时间</td>
					<td>修改时间</td>
		    		<td>操作</td>
		    	</tr>
	    	</thead>
	    	<tbody>
				<c:forEach items="${allType}" var="type" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${type.id}</td>
						<td>${type.typeName}</td>
						<td>${type.typeOperator}</td>
						<td>${type.createTime}</td>
						<td>${type.updateTime}</td>
			    		<td>
<%--			    			<a href="/getCustomerById?id=${user.userId}">用户详情</a>&nbsp;--%>
							<a href="/type/toFindType?id=${type.id}">修改</a>&nbsp;

							<c:if test="${login.permissionId==1}">
								<a href="/type/deleteTypeById?id=${type.id}" class="del">删除</a>&nbsp;
							</c:if>
			    		</td>
			    	</tr>
				</c:forEach>
			</tbody>
	    </table>
		<br>
		<table width="1000px" cellpadding="0" cellspacing="0">
			<thead>
			<tr class="head">
				<td>序号</td>
				<td>主键</td>
				<td>详细分类</td>
				<td>操作人</td>
				<td>创建时间</td>
				<td>修改时间</td>
				<td>操作</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allClassify}" var="classify" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${classify.id}</td>
					<td>${classify.classifyName}</td>
					<td>${classify.operator}</td>
					<td>${classify.createTime}</td>
					<td>${classify.updateTime}</td>
					<td>
							<%--			    			<a href="/getCustomerById?id=${user.userId}">用户详情</a>&nbsp;--%>
						<a href="/classify/toFindClassify?id=${classify.id}">修改</a>&nbsp;

						<c:if test="${login.permissionId==1}">
							<a href="/classify/deleteClassifyById?id=${classify.id}" class="del">删除</a>&nbsp;
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>


    </div>
  </body>
</html>
