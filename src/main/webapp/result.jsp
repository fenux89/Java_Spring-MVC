<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link href="styles.css" rel="stylesheet">--%>
    <title>Домашняя работа №3</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>
<div id="content">
<c:if test="${all != null}">
    <ul>
    <table>
        <p >
            <tr> <td name="td_width"> Индекс </td>
            <td>Имя </td>
            <td>Пароль </td>
            </tr>
        </p >
        <c:forEach items = "${userList}" var = "user" varStatus = "status" >
            <p>
                <tr><td name="td_width"> ${ status.index }</td> <td>${ user.name }</td>   <td>${ user.password }</td>  </tr>
            </p>
        </tr>

    </c:forEach >
        </table>
    </ul>

    </c:if>

<c:if test="${all == null}">
    <div id="info">
        <p> Количество записей за все время : ${koll}</p>

        <p class="norm"> Последняя запись</p>
<p class="norm"> Имя : ${user.name}</p>
<p class="norm">Пароль : ${user.password}</p>
    </div>
    <form action="/all" method="get" >
    <input type="submit" value="Все записи" >
    </form>
</c:if>
    <p id="p"> <a href="/user "> Войти </a> </p>


</div>
</body>
</html>