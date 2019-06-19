<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 11.04.2019
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Добивить информацию о участниках</title>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/addParticipant.css"/>
    <script type ="text/javascript" src = "/PeshkaFinish/js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>

  <%@ include file="/pattern/header.jsp"%>

<div class="mainANDaside">
    <div id="content">
        <form id="form" method="post" action="/PeshkaFinish/participant">
          	<table>
          		<tr>
          			<th>№<br>п/п</th>
          			<th>Делегация</th>
          			<th>Территория</th>
          			<th>Представитель</th>
          			<th>Фамилия<br>участника</th>
          			<th>Имя<br>участника</th>
          			<th>Дата<br>рождения</th>
          			<th>Разряд</th>
          			<th>Пол</th>
          			<th>Номер чипа</th>
          			<th>Участние в личном забеге</th>
          			<th>Номер <br>связки</th>
          			<th>Номер <br>группы</th>
          		</tr>
          		<%! int a = 0;%>
                <c:forEach var="i" begin="1" end="${sumParticipant}">
                	<tr>
                		<td><input type="text" name="number<%=++a%>" class="number" value="<%=a%>"></td>
                		<td><input type="text" name="nameDelegation" value="${delegation.name}" id="nameDelegation"></td>
                		<td><input type="text" name="placeDelegation" value="${delegation.place}" id="placeDelegation"></td>
                		<td><input type="text" name="nameCaptain" value="${delegation.lastName} ${delegation.firstName}"></td>
                		<td><input type="text" name="firstName<%=a%>" id="firstName"></td>
                		<td><input type="text" name="lastName<%=a%>" id="lastName"></td>
                		<td><input type="text" name="age<%=a%>" placeholder="2001" id="date"></td>
                		<td>
                			<select name="rank<%=a%>">
                				<option value="NOT_RANK">б/р</option>
                				<option value="FIRST_JUNIOR">1ю</option>
                				<option value="SECOND_JUNIOR">2ю</option>
                				<option value="THIRD_JUNIOR">3ю</option>
                				<option value="FIRST">1</option>
                				<option value="SECOND">2</option>
                				<option value="THIRD">3</option>
                				<option value="KMS">КМС</option>
                				<option value="MS">МС</option>
                			</select>
                		</td>
                		<td>
                			<select name="gender<%=a%>">
                				<option value="MAN">м</option>
                				<option value="WOMAN">ж</option>
                			</select>
                		</td>
                		<td><input type="text" name="idChip<%=a%>" id="idChip"></td>
                		<td><input type="checkbox" name="raceOne<%=a%>" value="1" id="checkbox"></td>
                		<td><input type="text" name="raceTwainId<%=a%>" id="raceTwainId"></td>
                		<td><input type="text" name="raceGroupId<%=a%>"id="raceGroupId"></td>
                	</tr>
            	</c:forEach>
            	<% a = 0;%>
          	</table><br>
            <div class ="but">
                <button tipe="submit">Сохранить</button>
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
