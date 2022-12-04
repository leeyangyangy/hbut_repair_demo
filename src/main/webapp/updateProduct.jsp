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
    
    <title>供应商信息更新</title>
    
   	<link href="<%=request.getContextPath() %>/css/add.css" type="text/css" rel="stylesheet">
	
  </head>
  
  <body>
  	<div id="up">
	   <ul>
	    	<li><span><a href="javascript:history.go(-1);">物料管理 </a>&gt; 物料信息修改 &gt;</span></li>
	   </ul>
	</div>
	<div id="down">
	    <form method="post" action="/product/updateProductById" enctype="multipart/form-data">
	   		<table width="500px">
	   			<tr>
					<input type="hidden" name="id" value="${result.id}"/>
					<input type="hidden" name="productOperator" value="${result.productOperator}"/>
	   				<td>物料名称：</td>
	   				<td><input type="text" name="productName" value="${result.productName}" class="in"/></td>
	   			</tr>
	   			<tr>
	   				<td>物料简介：</td>
	   				<td><input type="text" name="productProfile" value="${result.productProfile}" class="in"/></td>
	   			</tr>
	   			<tr>
	   				<td>物料图url：</td>
					<td><input type="text" name="url" value="${result.productPicture}" class="in"/></td>
	   			</tr>
				<tr>
					<td>物料图上传：</td>
					<td><input type="file" name="multipartFile" value="" class="in"/></td>
				</tr>
				<tr>
					<td>物料价格：</td>
					<td><input type="text" name="productPrice" value="${result.productPrice}" class="in"/></td>
				</tr>
				<tr>
					<td>物料预警值：</td>
					<td><input type="text" name="productPrice" value="${result.productWarn}" class="in"/></td>
				</tr>
				<tr>
					<td>物料类别</td>
					<td>
						<select name="productType" class="in">
							<c:forEach items="${allType}" var="t">
								<option value="${t.typeName}"
										<c:if test="${result.productType==t.typeName}">
											selected="selected"
										</c:if>
								>${t.typeName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

	   			<tr>
	   				<td>物料分类</td>
	   				<td>
	   					<select name="productClassify" class="in">
							<c:forEach items="${allClassify}" var="c">

								<option value="${c.classifyName}"
										<c:if test="${result.productClassify==c.classifyName}">
											selected="selected"
										</c:if>
								>${c.classifyName}</option>
							</c:forEach>
	   					</select>
	   				</td>
	   			</tr>
				<tr>
					<td>物料单位：</td>
					<td><input type="text" name="productUnits" value="${result.productUnits}" class="in"/></td>
				</tr>
<%--				<tr>--%>
<%--					<td>物料单位：</td>--%>
<%--					<td><input type="text" name="productWarn" value="${result.productUnits}" class="in"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>物料供应商：</td>--%>
<%--					<td><input type="text" name="productSupplier" value="${result.productUnits}" class="in"/></td>--%>
<%--				</tr>--%>
				<tr>
					<td>物料供应商</td>
					<td>
						<select name="productSupplier" class="in">
							<c:forEach items="${allSupplier}" var="s">

								<option value="${s.supplierName}"
										<c:if test="${result.productSupplier==s.supplierName}">
											selected="selected"
										</c:if>
								>${s.supplierName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>

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
