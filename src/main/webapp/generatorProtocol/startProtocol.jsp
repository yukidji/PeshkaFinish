<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 11.04.2019
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/startProtocol.css"/>
    <title>Протокол старта</title>
</head>
<body>

	<div id="content">
	<div id="headText"><h3>Министерство молодежной политики и спорта Республики Башкортостан<br>Федерация спортивного туризма Республики Башкортостан</h3>
	<h2>${name}</h2></div>
	<div>
		<hr/>
		<hr/>
		<div class="head" id="data">${data}</div> <div class="head" id="place">${place}</div>
	</div>
	<div id="headText">
			<h1>СТАРТОВЫЙ ПРОТОКОЛ</h1>
			<h3>Дистанция-пешеходная<c:set var = "type" scope = "session" value = "${type}"/>
			        				<c:set var = "ONE" scope = "session" value = "ONE"/>
			        				<c:set var = "TWO" scope = "session" value = "TWO"/>
			        				<c:set var = "FOUR" scope = "session" value = "FOUR"/>
			        				<c:if test = "${type==ONE}"></c:if>
			        				<c:if test = "${type==TWO}">-связка</c:if>
			        				<c:if test = "${type==FOUR}">-группа</c:if> ${classD} класс</h3>
	</div>

<table>
	<c:if test = "${type==ONE}">
	<c:set var= "column"  value ="${9}"/>
		<tr>
		     <th>№ п/п</th>
		     <th>Номер участника</th>
		     <th>Участник</th>
		     <th>Делегация</th>
		     <th>Территория</th>
		     <th>Разряд</th>
		     <th>Год</th>
		     <th>Пол</th>
		     <th>Зачет</th>
		     <th>Чип</th>
		     <th>Время старта</th>
	    </tr>
	</c:if>

	<c:if test = "${type==TWO}">
	<c:set var= "column"  value ="${7}"/>
		<tr>
		     <th>№ п/п</th>
		     <th>Связка</th>
		     <th>Состав</th>
		     <th>Делегация</th>
		     <th>Территория</th>
		     <th>Пол</th>
		     <th>Зачет</th>
		     <th>Чип</th>
		     <th>Время старта</th>
	    </tr>
	</c:if>
	<c:if test = "${type==FOUR}">
	<c:set var= "column"  value ="${7}"/>
		<tr>
		     <th>№ п/п</th>
		     <th>Группа</th>
		     <th>Состав</th>
		     <th>Делегация</th>
		     <th>Территория</th>
		     <th>Пол</th>
		     <th>Зачет</th>
		     <th>Чип</th>
		     <th>Время старта</th>
	    </tr>
	</c:if>
	<%! int i = 0;%>
    <c:forEach var="i" begin="1" end="12">
    	<tr>
    		<td class="pp"><%=++i%></td>
    		<c:forEach var="a" begin="1" end="${column}">
    			<td></td>
    		</c:forEach>
    		<c:if test = "${i mod 2 == 1}">
    			<td rowspan="2"></td>
    		</c:if>
    	</tr>
	</c:forEach>
	<% i = 0;%>
</table>

<p>Главная секретарь______________________/${nameSecretary}</p>
</div>
<br>
<a href="/PeshkaFinish/index.jsp">Вернуться на главную</a><br>
</body>
</html>
