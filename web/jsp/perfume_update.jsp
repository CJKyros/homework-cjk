<%@ page import="entity.Perfume" %><%--
  Created by IntelliJ IDEA.
  User: Kyros_CJ
  Date: 2018/8/26 0026
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>香水修改表单</title>
</head>
<body>
<div  style="text-align: center">
<% Perfume perfume = (Perfume) request.getAttribute("perfume"); %>

<form action="/update" method="post" >
    <div><input type="text" name="name" placeholder="name" value="<%= perfume.getName()%>"></div>
    <div><input type="number" step="0.01" name="price" placeholder="price" value="<%= perfume.getPrice()%>"></div>
    <div><input type="text" name="capacity" placeholder="capacity" value="<%= perfume.getCapacity()%>"></div>
    <div><input type="text" name="other" placeholder="other" value="<%= perfume.getOther()%>"></div>
    <div><input type="hidden" name="id" value="<%= perfume.getId()%>"></div>

    <div><input type="submit" value="提交更新"></div>
</form>
</div>
</body>
</html>
