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

		<c:if test="${login.permissionId==1}">
			<h3 class="h1"><span>用户管理</span></h3>
			<ul>
				<c:if test="${login.permissionId==1}">
					<li><a href="addUser.jsp" target="con">--用户添加</a></li>
				</c:if>
				<li><a href="/user/findAllUser" target="con">--用户列表</a></li>
			</ul>
		</c:if>

		<c:if test="${login.permissionId==1 || login.permissionId==2}">
			<h3 class="h2"><span>供应商管理</span></h3>
			<ul>
				<c:if test="${login.permissionId==1}">
					<li><a href="addSupplier.jsp" target="con">--供应商添加</a></li>
				</c:if>
				<li><a href="supplierList.jsp" target="con">--供应商列表</a></li>
			</ul>
		</c:if>
    	<h3 class="h2"><span>物料管理</span></h3>
    	<ul>
			<li><a href="productList.jsp" target="con">--物料列表</a></li>
<%--			物料==产品--%>
<%--			<li><a href="jsp/product/add.jsp" target="con">--物料添加</a></li>--%>
<%--			<li><a href="jsp/product/add.jsp" target="con">--物料删除</a></li>--%>
<%--			查询所有物料的类别，增删改查--%>
			<li><a href="typeList.jsp" target="con">--物料种类标签</a></li>
				<c:if test="${login.permissionId==1 || login.permissionId==3}">
					<li><a href="addProduct.jsp" target="con">--添加物料</a></li>
				</c:if>
		</ul>
		<h3 class="h2"><span>出入库记录</span></h3>
		<ul>
			<li><a href="storage.jsp" target="con">--入库记录</a></li>
			<li><a href="delivery.jsp" target="con">--出库记录</a></li>
<%--			<li><a href="inventory.jsp" target="con">--所有记录</a></li>--%>
		</ul>
<%--    	<h3 class="h4"><span>订单管理</span></h3>--%>
<%--    	<ul>--%>
<%--    		<li><a href="/getAllOrders" target="con">--订单列表</a></li>--%>
<%--		</ul>--%>
    	<h3 class="h2"><span>其他操作</span></h3>
    	<ul>
    		<li><a href="/aboutTeam" target="con">--关于我们</a></li>
    	</ul>
    </div>
  </body>
</html>
