<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>物料管理系统</title>
    

  </head>
  <!-- 页面分帧技术 -->
  <frameset rows="47,*" border="0">
  	<frame src="/page/top.jsp" scrolling="no">
  	<frameset cols="190,*">
  		<frame src="/page/left.jsp" noresize="noresize">
  		<frame src="/page/welcome.jsp" name="con">
  	</frameset>
  </frameset>
</html>
