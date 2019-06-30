<%--
  Created by IntelliJ IDEA.
  User: 11485
  Date: 2019/6/28
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这里是添加评论的界面</h1>

<form action="/news/toComment/">


    <input type="hidden"  name="newsid" value="${id}">
    评论内容: <input type="text" name="content" > <br>
    评论人  <input type="text" name="author"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
