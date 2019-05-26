<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.04.2019
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Добавить дистанцию</title>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/addDistance.css"/>
    <script type ="text/javascript" src = "/PeshkaFinish/js/script.js"/></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
<!--<jsp:useBean id="competition" scope="request" class="ru.ufa.peshka.entity.Competition"/>-->
<%@ include file="/pattern/header.jsp"%>

<div class="mainANDaside">
    <div id="content">
        <div class = "dist">
            <div>
                <form id="formDist" action="/PeshkaFinish/distance?typeD=one" method="post">
                    <p><b>Личка</b></p>
                    <p>Дата: <input type="text" name="data" class="poleDist"></p>
                    <p>Класс дистанции: <input type="text" name="classDist" class="poleDist"></p>
                    <p>Количестов этапов: <input type="text" name="numberStage" class="poleDist"></p>
                    <button type="submit" name="one">Добавить этапы</button>
                </form>
            </div>

            <div>
                <form id="formDist" method="post" action="/PeshkaFinish/distance?typeD=two">
                    <p><b>Связка</b></p>
                    <p>Дата: <input type="text" name="data" class="poleDist"></p>
                    <p>Класс дистанции: <input type="text" name="classDist" class="poleDist"></p>
                    <p>Количестов этапов: <input type="text" name="numberStage" class="poleDist"></p>
                    <button type="submit" name="two">Добавить этапы</button>
                </form>
            </div>

            <div>
                <form id="formDist" method="post" action="/PeshkaFinish/distance?typeD=four">
                    <p><b>Группа</b></p>
                    <p>Дата: <input type="text" name="data" class="poleDist"></p>
                    <p>Класс дистанции: <input type="text" name="classDist" class="poleDist"></p>
                    <p>Количестов этапов: <input type="text" name="numberStage" class="poleDist"></p>
                    <button type="submit" name="four">Добавить этапы</button>
                </form>
            </div>
        </div>
        <a href="/PeshkaFinish/index.jsp">Вернуться на главную</a><br>
        <!--должна быть ссылка на сервлет для обработки вывода данных-->
        <!--<a href="/PeshkaFinish/pageInfo/infoDistance.jsp">Посмотреть информацию о дистанциях</a><br>-->
        <a href="/PeshkaFinish/stage">Посмотреть информацию о дистанциях</a><br>
    </div>
      <%@ include file="/pattern/aside.jsp" %>
</div>

<%@ include file="/pattern/footer.jsp"%>

</body>
</html>
