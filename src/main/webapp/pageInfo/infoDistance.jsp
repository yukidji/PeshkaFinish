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
    <link rel="stylesheet" type="text/css" href="/PeshkaFinish/css/infoDistance.css"/>
    <script type ="text/javascript" src = "js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
<%@ include file="/pattern/header.jsp"%>

<div class="mainANDaside">
    <div id="content">
        <div id="menu">
            <a href="#" onclick="toggleinformer(); return false;"> <img src="/PeshkaFinish/img/menu.png" width="20px"> Дистанция-пешеходная</a>
        </div>
        <form id = "informer" method="get" action="/PeshkaFinish/stage">
            <div id="info">
            <%! int i=0;%>
            <c:forEach items="${distanceONE}" var="distance">
                <div>
                    Дистанция <%=++i%>:<br>
                    Дата проведения: ${distance.data}<br>
                    Класс дистанции: ${distance.classDist}<br><br>
                    <b>ПЕРЕЧЕНЬ ЭТАПОВ:</b><br>
                    <c:forEach items="${stageList}" var="stage">
                        <c:set var = "idDist" scope = "session" value = "${distance.id}"/>
                        <c:set var = "idStage" scope = "session" value = "${stage.idDistance}"/>
                        <c:if test= "${idDist==idStage}">
                            <u>Этап ${stage.number}. ${stage.name} КВ: мужчины - ${stage.controlTimeMan} мин, КВ: женщины ${stage.controlTimeWoman}.</u><br>
                            Параметры этапа:
                            <table>
                                <tr>
                                    <th>Длина этапа</th>
                                    <th>
                                        <c:set var = "nameD" scope = "session" value = "${stage.name}"/>
                                        <c:set var = "name1" scope = "session" value = "Спуск по перилам"/>
                                        <c:set var = "name2" scope = "session" value = "Спуск по склону"/>
                                        <c:set var = "name3" scope = "session" value = "Подъем по перилам"/>
                                        <c:set var = "name4" scope = "session" value = "Подъем по склону"/>
                                        <c:set var = "name5" scope = "session" value = "Траверс склона"/>

                                        <c:set var = "name6" scope = "session" value = "Переправа в брод"/>

                                        <c:set var = "name7" scope = "session" value = "Переправа по бревну"/>
                                        <c:set var = "name8" scope = "session" value = "Переправа по бревну методом горизонтальный маятник"/>

                                        <c:set var = "name9" scope = "session" value = "Навесная переправа"/>
                                        <c:set var = "name10" scope = "session" value = "Переправа по параллельным перилам"/>
                                        <c:set var = "name11" scope = "session" value = "Спуск по наклонной навесной переправе"/>
                                        <c:set var = "name12" scope = "session" value = "Подъём по наклонной навесной переправе"/>

                                        <c:set var = "name13" scope = "session" value = "Переправа методом вертикальный маятник"/>


                                        <c:if test= "${(nameD eq name1) || (nameD eq name2) || (nameD eq name3) || (nameD eq name4) || (nameD eq name5)}">
                                            Крутизна склона, °
                                            <c:set var = "p" scope = "session" value = "${stage.angle}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name6)}">
                                            Глубина брода, м
                                            <c:set var = "p" scope = "session" value = "${stage.depth}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name7) || (nameD eq name8)}">
                                            Длина бревна, м
                                            <c:set var = "p" scope = "session" value = "${stage.longLogs}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name9) || (nameD eq name10) || (nameD eq name11) || (nameD eq name12)}">
                                            Угол наклона перил, °
                                            <c:set var = "p" scope = "session" value = "${stage.railAngle}"/>
                                        </c:if>
                                        <c:if test= "${nameD eq name13}">
                                            Высота крепления перил, м
                                            <c:set var = "p" scope = "session" value = "${stage.supportHeight}"/>
                                        </c:if>
                                    </th>
                                </tr>
                                <tr>
                                    <td>${stage.length} м</td>
                                    <td>${p}</td>
                                </tr>
                            </table><br>
                        </c:if>
                    </c:forEach>
                    <a href="/PeshkaFinish/deleteDistance?idDist=${distance.id}" id="del">Удалить дистанцию</a><br>
                </div>
            </c:forEach>
            <% i=0; %> 
            </div>
        </form>
        
        <div id="menu">
            <a href="#" onclick="toggleinformer2(); return false;"> <img src="/PeshkaFinish/img/menu.png" width="20px"> Дистанция-пешеходная-связка</a>
        </div>
        <form id = "informer2" method="get" action="/PeshkaFinish/stage">
            <div id="info">
            <%! int a=0;%>
            <c:forEach items="${distanceTWO}" var="distance">
                <div>
                    Дистанция <%=++a%>:<br>
                    Дата проведения: ${distance.data}<br>
                    Класс дистанции: ${distance.classDist}<br><br>
                    <b>ПЕРЕЧЕНЬ ЭТАПОВ:</b><br>
                    <c:forEach items="${stageList}" var="stage">
                        <c:set var = "idDist" scope = "session" value = "${distance.id}"/>
                        <c:set var = "idStage" scope = "session" value = "${stage.idDistance}"/>
                        <c:if test= "${idDist==idStage}">
                            <u>Этап ${stage.number}. ${stage.name} КВ: мужчины - ${stage.controlTimeMan} мин, КВ: женщины ${stage.controlTimeWoman}.</u><br>
                            Параметры этапа:
                            <table>
                                <tr>
                                    <th>Длина этапа</th>
                                    <th>
                                        <c:set var = "nameD" scope = "session" value = "${stage.name}"/>
                                        <c:set var = "name1" scope = "session" value = "Спуск по перилам"/>
                                        <c:set var = "name2" scope = "session" value = "Спуск по склону"/>
                                        <c:set var = "name3" scope = "session" value = "Подъем по перилам"/>
                                        <c:set var = "name4" scope = "session" value = "Подъем по склону"/>
                                        <c:set var = "name5" scope = "session" value = "Траверс склона"/>

                                        <c:set var = "name6" scope = "session" value = "Переправа в брод"/>

                                        <c:set var = "name7" scope = "session" value = "Переправа по бревну"/>
                                        <c:set var = "name8" scope = "session" value = "Переправа по бревну методом горизонтальный маятник"/>

                                        <c:set var = "name9" scope = "session" value = "Навесная переправа"/>
                                        <c:set var = "name10" scope = "session" value = "Переправа по параллельным перилам"/>
                                        <c:set var = "name11" scope = "session" value = "Спуск по наклонной навесной переправе"/>
                                        <c:set var = "name12" scope = "session" value = "Подъём по наклонной навесной переправе"/>

                                        <c:set var = "name13" scope = "session" value = "Переправа методом вертикальный маятник"/>


                                        <c:if test= "${(nameD eq name1) || (nameD eq name2) || (nameD eq name3) || (nameD eq name4) || (nameD eq name5)}">
                                            Крутизна склона, °
                                            <c:set var = "p" scope = "session" value = "${stage.angle}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name6)}">
                                            Глубина брода, м
                                            <c:set var = "p" scope = "session" value = "${stage.depth}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name7) || (nameD eq name8)}">
                                            Длина бревна, м
                                            <c:set var = "p" scope = "session" value = "${stage.longLogs}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name9) || (nameD eq name10) || (nameD eq name11) || (nameD eq name12)}">
                                            Угол наклона перил, °
                                            <c:set var = "p" scope = "session" value = "${stage.railAngle}"/>
                                        </c:if>
                                        <c:if test= "${nameD eq name13}">
                                            Высота крепления перил, м
                                            <c:set var = "p" scope = "session" value = "${stage.supportHeight}"/>
                                        </c:if>
                                    </th>
                                </tr>
                                <tr>
                                    <td>${stage.length} м</td>
                                    <td>${p}</td>
                                </tr>
                            </table><br>
                        </c:if>
                    </c:forEach>
                    <a href="/PeshkaFinish/deleteDistance?idDist=${distance.id}" id="del">Удалить дистанцию</a><br>
                </div>
            </c:forEach>
            <% a=0; %> 
            </div>
        </form>

        <div id="menu">
            <a href="#" onclick="toggleinformer3(); return false;"> <img src="/PeshkaFinish/img/menu.png" width="20px"> Дистанция-пешеходная-группа</a>
        </div>
        <form id = "informer3" method="get" action="/PeshkaFinish/stage">
            <div id="info">
            <%! int b=0;%>
            <c:forEach items="${distanceFOUR}" var="distance">
                <div>
                    Дистанция <%=++b%>:<br>
                    Дата проведения: ${distance.data}<br>
                    Класс дистанции: ${distance.classDist}<br><br>
                    <b>ПЕРЕЧЕНЬ ЭТАПОВ:</b><br>
                    <c:forEach items="${stageList}" var="stage">
                        <c:set var = "idDist" scope = "session" value = "${distance.id}"/>
                        <c:set var = "idStage" scope = "session" value = "${stage.idDistance}"/>
                        <c:if test= "${idDist==idStage}">
                            <u>Этап ${stage.number}. ${stage.name} КВ: мужчины - ${stage.controlTimeMan} мин, КВ: женщины ${stage.controlTimeWoman}.</u><br>
                            Параметры этапа:
                            <table>
                                <tr>
                                    <th>Длина этапа</th>
                                    <th>
                                        <c:set var = "nameD" scope = "session" value = "${stage.name}"/>
                                        <c:set var = "name1" scope = "session" value = "Спуск по перилам"/>
                                        <c:set var = "name2" scope = "session" value = "Спуск по склону"/>
                                        <c:set var = "name3" scope = "session" value = "Подъем по перилам"/>
                                        <c:set var = "name4" scope = "session" value = "Подъем по склону"/>
                                        <c:set var = "name5" scope = "session" value = "Траверс склона"/>

                                        <c:set var = "name6" scope = "session" value = "Переправа в брод"/>

                                        <c:set var = "name7" scope = "session" value = "Переправа по бревну"/>
                                        <c:set var = "name8" scope = "session" value = "Переправа по бревну методом горизонтальный маятник"/>

                                        <c:set var = "name9" scope = "session" value = "Навесная переправа"/>
                                        <c:set var = "name10" scope = "session" value = "Переправа по параллельным перилам"/>
                                        <c:set var = "name11" scope = "session" value = "Спуск по наклонной навесной переправе"/>
                                        <c:set var = "name12" scope = "session" value = "Подъём по наклонной навесной переправе"/>

                                        <c:set var = "name13" scope = "session" value = "Переправа методом вертикальный маятник"/>


                                        <c:if test= "${(nameD eq name1) || (nameD eq name2) || (nameD eq name3) || (nameD eq name4) || (nameD eq name5)}">
                                            Крутизна склона, °
                                            <c:set var = "p" scope = "session" value = "${stage.angle}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name6)}">
                                            Глубина брода, м
                                            <c:set var = "p" scope = "session" value = "${stage.depth}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name7) || (nameD eq name8)}">
                                            Длина бревна, м
                                            <c:set var = "p" scope = "session" value = "${stage.longLogs}"/>
                                        </c:if>
                                        <c:if test= "${(nameD eq name9) || (nameD eq name10) || (nameD eq name11) || (nameD eq name12)}">
                                            Угол наклона перил, °
                                            <c:set var = "p" scope = "session" value = "${stage.railAngle}"/>
                                        </c:if>
                                        <c:if test= "${nameD eq name13}">
                                            Высота крепления перил, м
                                            <c:set var = "p" scope = "session" value = "${stage.supportHeight}"/>
                                        </c:if>
                                    </th>
                                </tr>
                                <tr>
                                    <td>${stage.length} м</td>
                                    <td>${p}</td>
                                </tr>
                            </table><br>
                        </c:if>
                    </c:forEach>
                    <a href="/PeshkaFinish/deleteDistance?idDist=${distance.id}" id="del">Удалить дистанцию</a><br>
                </div>
            </c:forEach>
            <% b=0; %> 
            </div>
        </form>

        <div id="menu">
            <a href="/PeshkaFinish/pageAdd/addDistance.jsp"><img src="/PeshkaFinish/img/menu.png" width="20px"> Добавить дистанции</a>
            <a href="/PeshkaFinish/index.jsp"><img src="/PeshkaFinish/img/menu.png" width="20px">Вернуться на главную</a>
        </div>
    </div>

    <%@ include file="/pattern/aside.jsp" %>
</div>

<%@ include file="/pattern/footer.jsp"%>
	
</body>
</html>
