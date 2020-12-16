<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/16
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件下载列表</title>
    <link rel="shortcut icon" href="/icon/favicon (1).ico">
</head>
<body>
<table border="1px" cellspacing="0" bordercolor="#f00" border-style="dashed">
    <tr>
        <th>文件名称</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${mapList}" var="entry">
        <tr>
            <td>${entry.value}</td>
            <td><a href="${pageContext.request.contextPath}downLoad?filename=${entry.key}">下载</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
