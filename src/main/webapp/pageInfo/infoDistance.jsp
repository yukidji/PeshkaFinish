<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.04.2019
  Time: 16:44
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
            <div class = "dist">
                <form id = "form" method="get" action="/PeshkaFinish/stage">
                	<div id="one">
                		<p><b>Личка</b></p>
                        <%! int i=0;%>
                        <c:forEach items="${distanceONE}" var="distance">
                            <div>
                                Дистанция <%=++i%>:<br>
                                Дата проведения: ${distance.data}<br>
                                Класс дистанции: ${distance.classDist}<br>
                                Этапы:<br>
                                <c:forEach items="${stageList}" var="stage">
                                    <c:set var = "idDist" scope = "session" value = "${distance.id}"/>
                                    <c:set var = "idStage" scope = "session" value = "${stage.idDistance}"/>
                                    <c:if test= "${idDist==idStage}">
                                        ${stage.number}. ${stage.name} КВ: ${stage.controlTime} мин.<br>
                                    </c:if>
                                </c:forEach>
                             </div><br> 
                             <a href="/PeshkaFinish/deleteDistance?idDist=${distance.id}">Удалить дистанцию</a>  
                        </c:forEach>
                          <% i=0; %> 
                        ${infoONE}
                	</div>
                </form>
                
                <form id = "form" method="get" action="/PeshkaFinish/stage">
                	<div id="two">
                		<p><b>Связка</b></p>
                        <%! int a=0;%>
                        <c:forEach items="${distanceTWO}" var="distance">
                            <div>
                            Дистанция <%=++a%>:<br>
                            Дата проведения: ${distance.data}<br>
                            Класс дистанции: ${distance.classDist}<br>
                            Этапы:<br>
                            <c:forEach items="${stageList}" var="stage">
                            <c:set var = "idDist" scope = "session" value = "${distance.id}"/>
                            <c:set var = "idStage" scope = "session" value = "${stage.idDistance}"/>
                                <c:if test= "${idDist==idStage}">
                                    ${stage.number}. ${stage.name} КВ: ${stage.controlTime} мин.<br>
                                </c:if>
                            </c:forEach>
                         </div><br>
                         <a href="/PeshkaFinish/deleteDistance?idDist=${distance.id}">Удалить дистанцию</a>     
                        </c:forEach>
                        <% a=0; %> 
                        ${infoTWO}
                	</div>
                </form>
                <form id = "form" method="get" action="/PeshkaFinish/stage">
                	<div id="four">
                		<p><b>Группа</b></p>
                         <%! int b=0;%>
                        <c:forEach items="${distanceFOUR}" var="distance">
                            <div>
                                Дистанция <%=++b%>:<br>
                                Дата проведения: ${distance.data}<br>
                                Класс дистанции: ${distance.classDist}<br>
                                Этапы:<br>
                                <c:forEach items="${stageList}" var="stage">
                                <c:set var = "idDist" scope = "session" value = "${distance.id}"/>
                                <c:set var = "idStage" scope = "session" value = "${stage.idDistance}"/>
                                    <c:if test= "${idDist==idStage}">
                                        ${stage.number}. ${stage.name} КВ: ${stage.controlTime} мин.<br>
                                    </c:if>
                                </c:forEach>
                            </div><br>
                            <a href="/PeshkaFinish/deleteDistance?idDist=${distance.id}">Удалить дистанцию</a>     
                        </c:forEach>
                        <% b=0; %> 
                        ${infoFOUR}
                	</div>
                    <div class= "but">
                            <button type="submit" formaction="/PeshkaFinish/stage">Загрузить данные</button>  
                        </div>
                </form>
                        
            </div>
        <a href="/PeshkaFinish/pageAdd/addDistance.jsp">Добавить дистанции</a>
        <a href="/PeshkaFinish/index.jsp">Вернуться на главную</a><br>
    </div>

    <%@ include file="/pattern/aside.jsp" %>
</div>

<%@ include file="/pattern/footer.jsp"%>
	
</body>
</html>
