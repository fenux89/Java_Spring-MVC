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
<form id="from1" action="/user" method="post" modelAttribute="${user}">
    <p>&nbsp; &nbsp; &nbsp;
        Имя : <input type="text" name="name"></p>
    <p>Пароль : <input type="text" name="password"></p>

    <p></p>

    <input type="submit" value="Отправить данные">
</form>

    <p id="p"> <a href="/user "> Войти </a> </p>

    <p id="p"><a href="/all "> Список всех </a> </p>
</div>
</body>
</html>
