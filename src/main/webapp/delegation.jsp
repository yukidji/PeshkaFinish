<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 13.03.2019
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление делегации</title>
</head>
<body>
<h2>Данные делегации</h2>
<form id="addDelegtion" method="post" action = "http://localhost:8080/PeshkaFinish/delegation/add">
    <div>
        <div>
            <div class="">
                <label>Фамилия</label>
            </div>
            <div class="">
                <input type="text" name="lastName">
            </div>
        </div>
    </div>
</form>
</body>
</html>
