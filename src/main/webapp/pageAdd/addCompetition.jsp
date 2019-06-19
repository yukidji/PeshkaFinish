<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.04.2019
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Добивить информацию о соревнованиях</title>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/addCompetition.css"/>
    <script type ="text/javascript" src = "/PeshkaFinish/js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
<!--<jsp:useBean id="competition" scope="request" class="ru.ufa.peshka.entity.Competition"/>-->
<%@ include file="/pattern/header.jsp"%>

<div class="mainANDaside">

    <div id="content">
        <form id="form" method="post" action="/PeshkaFinish/competition">
                <p id="nameComp">Название соревнований: <input type = "text" name="name" value="${competition.name}"></p>
                <p>Место проведения: <input type="text" name="place" value="${competition.place}"></p>
                <!--календарь-->
                <p>Дата начала соревнований: <input type="text" name="startDay" value="${competition.startDay}"></p>
                <!--календарь-->
                <p>Дата окончания соревнований: <input type="text" name="stopDay" value="${competition.stopDay}"></p>
                <p>Главный судья: <input type="text" name="nameJudge" value="${competition.nameJudge}"></p>
                <p>Главный секретарь: <input type="text" name="nameSecretary" value="${competition.nameSecretary}"></p>
            <div class ="but">
                <button tipe="submit">Сохранить данные</button>
            </div>
        </form>
        <div id="menu">
            <a href="/PeshkaFinish/competition"><img src="/PeshkaFinish/img/menu.png" width="20px">Посмотреть информацию о соревнованиях</a>
            <a href="/PeshkaFinish/stage"><img src="/PeshkaFinish/img/menu.png" width="20px">Посмотреть информацию о дистанциях</a>
            <a href="/PeshkaFinish/index.jsp"><img src="/PeshkaFinish/img/menu.png" width="20px">Вернуться на главную</a><br>
        </div>
    </div>

    <%@ include file="/pattern/aside.jsp"%>

</div>

<%@ include file="/pattern/footer.jsp"%>

</body>
</html>
