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
	    <form method="post" action="/user/updateUserByUserId">
	   		<table width="500px">
	   			<tr>
					<input type="hidden" name="id" value="${userInfo.id}"/>
					<input type="hidden" name="userId" value="${userInfo.userId}"/>
	   				<td>用户姓名：</td>
	   				<td><input type="text" placeholder="密码为空，则不修改，如需修改，请填写密码!" name="username" value="${userInfo.username}" class="in"/></td>
	   			</tr>
	   			<tr>
	   				<td>用户密码：</td>
	   				<td><input type="password"  name="password" value="${userInfo.password}" class="in"/></td>
	   			</tr>
				<tr>
					<td>用户状态</td>
					<td>
						<select name="status" class="in">
							<option value="异常">异常</option>
							<option value="冻结">冻结</option>
							<option value="离职">离职</option>
							<option value="正常" selected="selected">正常</option>
						</select>
					</td>
				</tr>

	   			<tr>
	   				<td>用户组别</td>
	   				<td>
	   					<select name="permissionId" class="in">
							<c:forEach items="${permissionList}" var="p">

								<option value="${p.id}"
										<c:if test="${userInfo.permissionId==p.id}">
											selected="selected"
										</c:if>
								>${p.permissionName}</option>
							</c:forEach>
	   					</select>
	   				</td>
	   			</tr>
	   			
	   			<tr>
	   				<td></td>
	   				<td>
	   					<input type="submit" value="提&nbsp;&nbsp;&nbsp;交" class="su">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   					<input type="reset" value="清&nbsp;&nbsp;&nbsp;空" class="su">
	   				</td>
	   			</tr>
	   		</table>
	    </form>
    </div>
  </body>
</html>
