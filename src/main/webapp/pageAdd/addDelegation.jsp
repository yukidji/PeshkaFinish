<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 13.03.2019
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Добивить информацию о делегации</title>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/addDelegatiоn.css"/>
    <script type ="text/javascript" src = "/PeshkaFinish/js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>

  <%@ include file="/pattern/header.jsp"%>

<div class="mainANDaside">
    <div id="content">
        <form id="form" method="post" action="/PeshkaFinish/delegation">
          <h2>Делегация</h2>
                <p>Название делегации: <input type = "text" name="name" value="${delegation.name}"></p>
                <p>Территория: <input type="text" name="place" value="${delegation.place}"></p>
                <p>Имя представителя команды: <input type="text" name="firstName" value="${delegation.ferstName}"></p>
                <p>Фамилия представителя команды: <input type="text" name="lastName" value="${delegation.lastName}"></p>
                <p>Номер телефона представителя команды: <input type="text" name="phoneCaptain" value="${delegation.phoneCaptain}"></p>
                <p>Количесво участников в команде: <input type="text" name="sumParticipant" value="${delegation.sumParticipant}"></p>
                <p>Дата прибытия делегации: <input type="text" name="arriveDate" value="${delegation.arriveDate}"></p>
            <div class ="but">
                <button tipe="submit">Добавить участников</button>
            </div>
        </form>
        <div id="menu">
            <a href="/PeshkaFinish/competition"><img src="/PeshkaFinish/img/menu.png" width="20px">Посмотреть информацию о соревнованиях</a>
            <a href="/PeshkaFinish/stage"><img src="/PeshkaFinish/img/menu.png" width="20px">Посмотреть информацию о дистанциях</a>
            <a href="/PeshkaFinish/index.jsp"><img src="/PeshkaFinish/img/menu.png" width="20px">Вернуться на главную</a>
        </div>
    </div>

    <%@ include file="/pattern/aside.jsp"%>
</div>

<%@ include file="/pattern/footer.jsp"%>
</body>
</html>
