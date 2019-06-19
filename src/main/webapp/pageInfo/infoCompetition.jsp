<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.04.2019
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Информация о соревнованиях</title>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/infoCompetition.css"/>
    <script type ="text/javascript" src = "js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
<!--<jsp:useBean id="competition" scope="request" class="ru.ufa.peshka.entity.Competition"/>-->
<%@ include file="/pattern/header.jsp"%>

<div class="mainANDaside">
    <div id="content">
        <form id = "form" method="get" action="/PeshkaFinish/competition">
            <p><b>Название соревнований:</b> ${competition.name}</p>
            <p><b>Место проведения:</b> ${competition.place}</p>
            <p><b>Дата начала соревнований:</b> ${competition.startDay}</p>
            <p><b>Дата окончания соревнований:</b> ${competition.stopDay}</p>
            <p><b>Главный судья:</b> ${competition.nameJudge}</p>
            <p><b>Главный секретарь:</b> ${competition.nameSecretary}</p>
        </form>
        <div id="menu">
            <a href="/PeshkaFinish/competition?action=update"><img src="/PeshkaFinish/img/menu.png" width="20px">Изменить информацию о соревнованиях</a>
            <a href="/PeshkaFinish/stage"><img src="/PeshkaFinish/img/menu.png" width="20px">Посмотреть информацию о дистанциях</a>
            <a href="/PeshkaFinish/index.jsp"><img src="/PeshkaFinish/img/menu.png" width="20px">Вернуться на главную</a>
        </div>
    </div>
    <%@ include file="/pattern/aside.jsp" %>
</div>

<%@ include file="/pattern/footer.jsp"%>

</body>
</html>
