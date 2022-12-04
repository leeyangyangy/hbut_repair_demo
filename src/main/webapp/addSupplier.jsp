<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'add.jsp' starting page</title>

    <link href="<%=request.getContextPath() %>/css/add.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // jQuery选中id
            $("#supplierName").blur(function () {
                var value = $("#supplierName").val();
                $.ajax({
                    url: "/supplier/checkSupplier",
                    data: {
                        // 请求值
                        "supplierName": value
                    },
                    // 请求方法
                    type: "post",
                    // 返回值方式 json
                    dataType: "json",
                    success: function (data) {
                        if (data) {
                            $("#warn").html("✔").style.color="green"

                        } else {
                            $("#warn").html("❌")
                        }
                    }
                })
            });
        })
    </script>
</head>

<body>
<div id="up">
    <ul>
        <li><span><a href="javascript:history.go(-1);">供应商管理 </a>&gt; 添加供应商 &gt;</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/supplier/addSupplier">
        <table width="500px">
            <tr>
                <td>供应商名称：</td>
                <td><input type="text" id="supplierName" name="supplierName" class="in"/></td>
                <td><span id="warn" class="warn"></span></td>
            </tr>
            <tr>
                <td>供应商简介：</td>
                <td><input type="text" name="supplierProfile" class="in"/></td>
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
