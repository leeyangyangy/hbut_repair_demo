<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息更新</title>
    
   	<link href="<%=request.getContextPath() %>/css/add.css" type="text/css" rel="stylesheet">
	
  </head>
  
  <body>
  	<div id="up">
	   <ul>
	    	<li><span><a href="javascript:history.go(-1);">用户管理 </a>&gt; 用户修改 &gt;</span></li>
	   </ul>
	</div>
	<div id="down">
	    <form method="post" action="/supplier/updateSupplierById">
			<table width="500px">
				<tr>
					<input type="hidden" name="id" value="${supplier.id}">
					<td>供应商名称：</td>
					<td><input type="text" id="supplierName" name="supplierName" value="${supplier.supplierName}" class="in"/></td>
					<td><span id="warn" class="warn"></span></td>
				</tr>
				<tr>
					<td>供应商简介：</td>
					<td><input type="text" name="supplierProfile" value="${supplier.supplierProfile}" class="in"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" id="inform" value="提&nbsp;&nbsp;&nbsp;交" class="su">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="清&nbsp;&nbsp;&nbsp;空" class="su">
					</td>
				</tr>
			</table>
	    </form>
    </div>
  </body>
</html>
