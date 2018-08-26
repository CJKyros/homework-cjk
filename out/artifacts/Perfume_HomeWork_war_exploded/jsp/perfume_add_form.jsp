<%--
  Created by IntelliJ IDEA.
  User: Kyros_CJ
  Date: 2018/8/26 0026
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>香水增加表单</title>
</head>
<body>

<div style="text-align: center">
<form action="/add" method="post" >
    <div><input type="number" name="id" placeholder="id"></div>
    <div><input type="text" name="name" placeholder="书名"></div>
    <div><input type="number" name="price" placeholder="价格"></div>
    <div><input type="text" name="capacity" placeholder="容量"></div>
    <div><input type="text" name="other" placeholder="其他"></div>
    <div><input type="submit"></div>
</form>

</div>
</body>
</html>
