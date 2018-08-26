<%@ page import="entity.Perfume" %><%--
  Created by IntelliJ IDEA.
  User: Kyros_CJ
  Date: 2018/8/26 0026
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>香水详情</title>
    <style>
        .msg {
            font-size: 2em;
            color: greenyellow;
        }
    </style>
</head>
<body>
<div  style="text-align: center">
<%
    Perfume perfume = (Perfume) request.getAttribute("perfume");
%>


<h1><%=perfume.getName()%></h1>
<ul>
    <li><%=perfume.getCapacity()%></li>
    <li><%=perfume.getPrice()%></li>
    <li><%=perfume.getOther()%></li>
</ul>
</div>
</body>
</html>
