<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 08.04.2019
  Time: 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Стартовые протоколы</title>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/generator.css"/>
    <script type ="text/javascript" src = "js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
<!--<jsp:useBean id="competition" scope="request" class="ru.ufa.peshka.entity.Competition"/>-->
<%@ include file="/pattern/header.jsp"%>

<div class="mainANDaside">
    <div id="content">
        		<table>
        			<tr>
        				<th>№</th>
        				<th>Дистанция</th>
        				<th>Время старта (чч:мм)</th>
        				<th>Стартовые протоколы</th>
        				<th>Финишные протоколы</th>
        			</tr>
        			<%! int a = 0;%>
        			<c:forEach items="${distances}" var="distance">
		        		<tr>
		        			<form method="get" action="">
			        			<td class="centerColumn"><%=++a%></td>
			        			<td class="no_senter">Класс дистанции: ${distance.classDist}<br>
			        				Дата проведения:  ${distance.data}<br>
			        				Тип дистанции: 
			        				<c:set var = "type" scope = "session" value = "${distance.typeDistance}"/>
			        				<c:set var = "ONE" scope = "session" value = "ONE"/>
			        				<c:set var = "TWO" scope = "session" value = "TWO"/>
			        				<c:set var = "FOUR" scope = "session" value = "FOUR"/>
			        				<c:if test = "${type==ONE}">
			        				Личка
			        				</c:if>
			        				<c:if test = "${type==TWO}">
			        				Cвязка
			        				</c:if>
			        				<c:if test = "${type==FOUR}">
			        				Группа
			        				</c:if>
			        			</td><!--:${timeMinute}&timeM=${timeMinute}-->
			        			<td class="centerColumn"><input id = "time" type="type" name="time" value="${timeHour}"></td>
			        			<td class="centerColumn"><a href="/PeshkaFinish/startP?IdDist=${distance.id}">Сформировать</a></td>
			        			<td class="centerColumn"><a href="/PeshkaFinish/startF?IdDist=${distance.id}">Сформировать</a></td>
		        			</form>
		        		</tr>
        			</c:forEach>
        			<% a = 0;%>
        		</table>
        <a href="/PeshkaFinish/index.jsp">Вернуться на главную</a><br>
    </div>

    <%@ include file="/pattern/aside.jsp" %>
</div>

<%@ include file="/pattern/footer.jsp"%>
</body>
</html>
