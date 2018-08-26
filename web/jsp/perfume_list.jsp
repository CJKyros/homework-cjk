<%@ page import="entity.Perfume" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>香水列表</title>

    <style>
        table {
            border-collapse: collapse;
        }

        table, th, td {
            padding: 3px 1em;
            border: 1px solid black;
            text-align: center;
        }
        form{
            margin: auto;
        }
    </style>
</head>
<body>


<form action="/q">
    <input type="text" placeholder="查询条件(名字)" name="condition">
    <input type="submit" value="搜索">
</form>

<form action="/del" method="post" >
    <table>
        <tr>
            <th><input type="checkbox" onclick="alls(this)"></th>
            <th>id</th>
            <th>香水名</th>
            <th>价格</th>
            <th>容量</th>
            <th>其他</th>
            <th>操作</th>
        </tr>
        <%
            List<Perfume> perfumes = (List<Perfume>) request.getAttribute("perfumes");

            for (Perfume perfume : perfumes) {
        %>
        <tr>
            <td><input name="id" value="<%= perfume.getId()%>" type="checkbox"></td>
            <td><%= perfume.getId() %>
            </td>
            <td><a href="/detail?id=<%= perfume.getId()%>"><%= perfume.getName() %>
            </a></td>
            <td><%= perfume.getPrice() %>
            </td>
            <td><%= perfume.getCapacity() %>
            </td>
            <td><%= perfume.getOther() %>
            </td>
            <td>
                <a href="/del?id=<%= perfume.getId() %>">删除</a>
                <a href="/update?id=<%= perfume.getId() %>">更新</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>


    <div style="margin-top: 2em;">
        <input type="submit" value="删除">
        <a href="/add">增加新的香水</a>
    </div>
</form>

<script>
    function alls(e) {
        var checkboxs=document.getElementsByName("id");
        for (var i = 0; i < checkboxs.length; i++) {
            checkboxs[i].checked=e.checked
        }
    }
</script>
</body>
</html>
