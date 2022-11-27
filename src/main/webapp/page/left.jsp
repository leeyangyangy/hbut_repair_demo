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
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="<%=request.getContextPath() %>/css/left.css" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("h3").click(topic,topic);
			function topic() {
				$(this).next("ul").slideToggle(200);
				$(this).next("ul").siblings("ul").slideUp(200);
			}
		});
	</script>
  </head>
  
  <body>
    <div>
    	<h3 id="con"></h3>
    	<h3 class="h1"><span>用户管理</span></h3>
    	<ul>
    		<c:if test="${sessionScope.customer.did==1}">
    			<li><a href="/toAddCustomer" target="con">--用户添加</a></li>
			</c:if>
    		<li><a href="/getAllCuttomer" target="con">--用户列表</a></li>
    	</ul>
    	<h3 class="h2"><span>商品管理</span></h3>
    	<ul>
    		<li><a href="jsp/product/add.jsp" target="con">--商品添加</a></li>
    		<li><a href="jsp/product/list.jsp" target="con">--商品列表</a></li>
    	</ul>

    	<h3 class="h4"><span>订单管理</span></h3>
    	<ul>
    		<li><a href="/getAllOrders" target="con">--订单列表</a></li>
		</ul>
    	<h3 class="h5"><span>其他操作</span></h3>
    	<ul>
    		<li><a href="" target="con">--其他操作</a></li>
    	</ul>
    </div>
  </body>
</html>
