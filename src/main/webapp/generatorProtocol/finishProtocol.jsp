<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 11.04.2019
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/finishProtocol.css"/>
    <title>Протокол финиша</title>
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
		<h3>Протокол соревнований<br> в дисциплине: "дистанция-пешеходная<c:set var = "type" scope = "session" value = "${type}"/>
			        				<c:set var = "ONE" scope = "session" value = "ONE"/>
			        				<c:set var = "TWO" scope = "session" value = "TWO"/>
			        				<c:set var = "FOUR" scope = "session" value = "FOUR"/>
			        				<c:if test = "${type==ONE}">"</c:if>
			        				<c:if test = "${type==TWO}">-связка"</c:if>
			        				<c:if test = "${type==FOUR}">-группа"</c:if> ${classD} класса, код ВРВС <br></h3>
			        				<!--зачет-->
			        				<!--gender-->
	</div>
	<p id="rank">Квалификационный ранг дистанции:</p>
	
	<table>
<c:if test = "${type==ONE}">
	<c:set var= "column"  value ="${9}"/>
		<tr>
		     <th rowspan="2">№ п/п</th>
		     <th rowspan="2">Номер участника</th>
		     <th rowspan="2">Участник</th>
		     <th rowspan="2">Разряд</th>
		     <th rowspan="2">Делегация</th>
		     <th rowspan="2">Территория</th>
		     <th colspan="5">Прохождение дистанции (штрафные балы и снятия с этапов)</th>
		     <c:forEach items="${stages}" var="stage">
		     	<th>${stage.name}</th>
		 	 </c:forEach>
		     <th colspan="8">Результат</th>
		     <th>Время на дитсанции</th>
		     <th>Количество снятий</th>
		     <th>Сумма отсечек</th>
		     <th>Время на дистанции с учетом отсечек</th>
		     <th>Результат</th>
		     <th>Место</th>
		     <th>% от результата победителя</th>
		     <th>Выполненный норматив</th>
		     <th rowspan="2">Очки</th>
	    </tr>
	</c:if>

	<c:if test = "${type==TWO}">
	<c:set var= "column"  value ="${7}"/>
		<tr>
		     <th>№ п/п</th>
		     <th>Связка</th><!--номер связки-->
		     <th>Состав связки</th>
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
    	</tr>
	</c:forEach>
	<% i = 0;%>
</table>

<p>Главный судья:_________________________/${nameJudge}</p>
<p>Главная секретарь______________________/${nameSecretary}</p>

	
</div>
<br><br>
<p><a href="/PeshkaFinish/index.jsp">Вернуться на главную</a></p>
</body>
</html>
