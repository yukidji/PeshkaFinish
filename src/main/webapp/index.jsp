<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 13.03.2019
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Пеший туризм</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script type ="text/javascript" src = "js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
  <c:set var = "login" scope = "session" value = "${login}"/>
  <c:set var = "status" scope = "session" value = "${status}"/>
<%@ include file="/pattern/header.jsp" %>

<div class="mainANDaside">
  <div id="content">
    <ul id="ulIndex">
        <li><a href="/PeshkaFinish/competition">Посмотреть информацию о соревнованиях</a></li>
        <li><a href="pageAdd/addCompetition.jsp">Добавить информацию о соревнованиях</a></li>
        <li><a href="pageAdd/addDistance.jsp">Добавить информацию о дистанциях</a></li>
        <li><a href="/PeshkaFinish/stage">Посмотреть информацию о дистанциях</a></li>
        <li><a href="pageAdd/addDelegation.jsp">Добавить делегацию с участниками соревнований</a></li>
        <li><a href="/PeshkaFinish/chip">Добавить чипы</a></li>
        <li><a href="/PeshkaFinish/table">Сформировать протоколы</a></li>
        <li><a href="">Сформировать судейские бланки</a></li>
      </ul>
  </div>   
  <%@ include file="/pattern/aside.jsp"%>
</div>

<%@ include file="/pattern/footer.jsp"%>
</body>
</html>