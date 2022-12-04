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
		  // $(function () {
			//   // jQuery选中id
			//   $("#pid").blur(function () {
			// 	  // 测试是否获取成功，成功即弹窗
			// 	  alert("aaaa")
			// 	  // 获取输入的用户名
			// 	  var value = $("#pid").textContent;
			// 	  // 测试是否正常获取值，成功即弹窗
			// 	  alert(value)
			// 	  // 发出ajax请求，验证用户名是否存在
			// 	  $.ajax({
			// 		  url: "/product/checkProductValue",
			// 		  data: {
			// 			  // 请求值
			// 			  "pid": value
			// 		  },
			// 		  // 请求方法
			// 		  type: "post",
			// 		  // 返回值方式 json
			// 		  dataType: "json",
			// 		  success: function (data) {
			// 			  // alert("data:"+data)
			// 			  if (data) {
			// 				  // alert("真值"+data)
			// 				  // 用户存在  data=false
			// 				  $("#warn").html("❌")
			// 			  } else {
			// 				  // 用户不存在  data=false
			// 				  $("#warn").html("✔")
			// 			  }
			// 		  }
			// 	  })
			//   });
		  // })
	  </script>
  </head>
  
  <body>
  	<div id="up">
	   <ul>
	    	<li><span><a href="javascript:history.go(-1);">平台首页 </a>&gt; 物料管理 &gt; 物料列表</span></li>
	   </ul>
	</div>
	<div id="down">
	    <table width="1000px" cellpadding="0" cellspacing="0">
	    	<thead>
		    	<tr class="head">
		    		<td>序号</td>
					<td>主键</td>
					<td>物料名</td>
					<td>物料大类</td>
					<td>物料小类</td>
					<td>物料图片</td>
					<td>物料数量</td>
					<td>物料单价</td>
					<td>物料单位</td>
					<td>物料预警值</td>
					<td>物料状态</td>
					<td>添加人</td>
					<td>添加时间</td>
<%--					<td>更新时间</td>--%>
<%--					<td>最后入库时间</td>--%>
<%--					<td>最后出库时间</td>--%>
		    		<td>操作</td>
		    	</tr>
	    	</thead>
	    	<tbody>
				<c:forEach items="${allProduct}" var="product" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td id="pid">${product.id}</td>
						<td>${product.productName}</td>
						<td>${product.productType}</td>
						<td>${product.productClassify}</td>
						<td><img src="${product.productPicture}" alt="" width="50px"></td>
						<c:if test="${product.productValue<=product.productWarn}">
							<td style="background-color: red">${product.productValue}</td>
						</c:if>
						<c:if test="${product.productValue>product.productWarn}">
							<td>${product.productValue}</td>
						</c:if>
						<td>${product.productPrice}</td>
						<td>${product.productUnits}</td>
						<td>${product.productWarn}</td>
						<c:if test="${product.productValue<=product.productWarn}">
							<td style="background-color: red">低于库存</td>
						</c:if>
						<c:if test="${product.productValue>product.productWarn}">
							<td>正常</td>
						</c:if>
						<td>${product.productOperator}</td>
						<td>${product.createTime}</td>
<%--						<td>${product.updateTime}</td>--%>
<%--						<td>${product.deliverTime}</td>--%>
			    		<td>
							<c:if test="${login.permissionId==1}">
								<a href="/product/findProductById?id=${product.id}" class="del">修改</a>&nbsp;
							</c:if>
							<c:if test="${login.permissionId==1}">
								<a href="/product/deleteProductById?id=${product.id}" class="del">删除</a>&nbsp;
							</c:if>
							<c:if test="${login.permissionId==1 || login.permissionId==2 || login.permissionId==3}">
								<a href="/product/subProductValueById?id=${product.id}" class="del">出库</a>&nbsp;
							</c:if>
							<c:if test="${login.permissionId==1 || login.permissionId==2 || login.permissionId==3}">
								<a href="/product/addProductValueById?id=${product.id}" class="del">入库</a>&nbsp;
							</c:if>
			    		</td>
			    	</tr>
				</c:forEach>
			</tbody>
	    </table>
    </div>
  </body>
</html>
