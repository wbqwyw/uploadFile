<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/16
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件页面</title>
    <link rel="shortcut icon" href="/icon/favicon.ico">
</head>
<body>
<form action="${pageContext.request.contextPath}uploadFile" enctype="multipart/form-data" method="post">
    <input type="file" name="file1"><br>
    <input type="file" name="file2"><br>
    <input type="submit" value="上传附件">
</form>
</body>
</html>
