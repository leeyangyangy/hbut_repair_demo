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
            $("#classifyName").blur(function () {
                // 测试是否获取成功，成功即弹窗
                // alert("aaaa")
                // 获取输入的用户名
                var value = $("#classifyName").val();
                // 测试是否正常获取值，成功即弹窗
                // alert(value)
                // 发出ajax请求，验证用户名是否存在
                $.ajax({
                    url: "/classify/checkClassifyName",
                    data: {
                        // 请求值
                        "classifyName": value.trim()
                    },
                    // 请求方法
                    type: "post",
                    // 返回值方式 json
                    dataType: "json",
                    success: function (data) {
                        // alert("data:"+data)
                        if (data) {
                            // alert("真值"+data)
                            // 用户存在  data=false
                            $("#warn").html("❌ 名称已存在，请更换!")
                            $("form").submit(function(e){
                                // return true
                                // alert("Submit prevented");
                                // e.preventDefault()
                            });
                        } else {
                            // 用户不存在  data=false
                            $("#warn").html("✔")
                            $("form").submit(function(e){
                                // e.
                                // return false
                            });
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
        <li><span><a href="javascript:history.go(-1);">用户管理 </a>&gt; 添加用户 &gt;</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/classify/add">
        <table width="500px">
            <tr>
                <input type="hidden" name="operator" value="${login.username}">
                <td>小类名称：</td>
                <td><input type="text" name="classifyName" id="classifyName" class="in"/></td>
                <td><span id="warn" class="warn"></span></td>
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
