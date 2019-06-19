<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 13.06.2019
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Добавление чипов</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/addChip.css"/>
    <script type ="text/javascript" src = "js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
<%@ include file="/pattern/header.jsp" %>

<div class="mainANDaside">
  <div id="content">
  	<form id="form"  method="get" action="/PeshkaFinish/addChip">
  		<h2>Добавить метки</h2>
  		Количесво добаляемыех меток: <input type="text" name="sumChip">
  		<button tipe="submit">Добавить метки</button>
  	</form>

  	<form id="form"  method="get" action="/PeshkaFinish/chip">
  		<h2>Метки</h2>
  		<table>
  			<tr>
  				<th>№<br>п/п</th>
  				<th>ID метики</th>
  				<th>Статус метки</th>
  				<th>Удалить метку</th>
  			</tr>
  			<%! int i=0;%>
  			 <c:forEach items="${chipList}" var="chip">
  			 <tr>
  			 	<td><%=++i%></td>
  			 	<td>${chip.id}</td>
  			 	<c:set var="status" value="${chip.status}"/>
  			 	<c:set var="green" value="FREE"/>
  			 	<c:set var="red" value="NOT_FREE"/>
  			 	<c:if test="${status eq green}">
  			 		<td id="free">${chip.status}</td>
  			 	</c:if>
  			 	<c:if test="${status eq red}">
  			 		<td id="notFree">${chip.status}</td>
  			 	</c:if>

  			 	<td><input type="checkbox" name="del" value="del"></td>
  			 </tr>
  			</c:forEach>
  			<% i=0; %> 
  		</table>
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
