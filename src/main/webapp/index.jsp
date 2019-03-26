<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 13.03.2019
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Пеший туризм</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/print.css"/>
    <script type ="text/javascript" src = "js/script.js"></script>
    <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<header>
    <h1>Туристический тклуб Икар при Авиационном университете<br> Пеший туризм</h1>
</header>

<div class="firstCont">
    <form class="formCompetition">
        <div class ="but"><!--при нажатии на кнопку "Обновить данные" поля о соревнованиях должны стать активными и должна появиться конка СОХРАНИТЬ-->
            <button id="inputInfoBut" onclick="enable()">Внести данные о соревнованиях</button>
        </div>

        <div id = "competitionParam"><!--накачальный статус полей неактивен-->
            <p>Название соревнований: <input type="text" name="nameCompetition" class="inputInfo"></p>
            <p>Место проведения: <input type="text" name="placeCompetition" class="inputInfo"></p>
            <p>Дата начала соревнований: <input type="text" name="startTime" class="inputInfo"></p><!--календарь-->
            <p>Дата окончания соревнований: <input type="text" name="stopTime" class="inputInfo"></p><!--календарь-->
            <p>Главный судья: <input type="text" name="nameJudge" class="inputInfo"></p>
            <p>Главный секретарь: <input type="text" name="nameSecretary" class="inputInfo"></p>
        </div>
        <div class ="but">
            <button>Сохранить данные</button><!--изначально должна быть скрыта-->
        </div>
    </form>

    <aside>
        <b id="nameAside">Полезная инофрмация</b>
        <ul>
            <li> <a href="">Основные правила соревнований</a></li>
            <li><a href="">Положение</a></li>
            <li><a href="">Бланк предварительной заявки</a></li>
            <li><a href="">Бланк заявки</a></li>
            <li><a href="">Условия:</a></li>
            <!--подсписок-->
            <ul>
                <li><!--Список. должен сам формироваться после заполнения данных о дистанциях соревнований-->
                    <a href="">Личка. 2 класс</a>
                </li>
                <li><a href="">Связка. 2 класс</a></li>
            </ul>
            <li><a href="">Стартовые протоколы</a></li>
            <li><a href="">Протоколы соревнований</a></li>
        </ul>
    </aside>
</div>

<div>
    <h2 id="headerDistances">Дистанции <img src="img/drop-down-list.png" width="1.5%"></h2>
</div>

<div class="distance">
<form>
    <p>Личка <input type="label" name="date"> <img src="img/drop-down-list.png" class ="drop-down-list"></p>
    Дистаниця № <span>1</span> <!--сдлелать автоматический подсчет кол-ва дистанций-->
    <img src="img/drop-down-list.png" class ="drop-down-list"><br>
    <img src="img/plus.png" title="Добавить дистанцию" class ="plus">
    <div class="addDistance"><!--скрытая форма-->
        <p>Клсасс дистанции: <input type="text" name="classDistance"></p><!--всего 6 классов дистанций (в закрытых 5 классов но закрытые пока не рассматриваем)-->
        <p>Количество этапов: <input type="text" name="Stages"></p><!--посмотреть по регламенту сколько тапов может быть на дистанции-->
        <button>Посмотреть названия этапов</button>
        <div class="addStage">
            <table> <!--должна появляться при нажатии кнопки-->
                <tr>
                    <th>№ этапа</th>
                    <th>название этапа</th>
                    <th>КВ</th>
                </tr>
                <tr>
                    <td></td><!--вставка кода для создания столькоих строк, сколько указано в кол-ве этпов-->
                </tr>
            </table>
            <button>сохранить изменения</button>
        </div>
    </div>
</form>

<form>
    <p>Связка  <input type="label" name="date"> <img src="img/drop-down-list.png" class="drop-down-list"></p>
    Дистаниця № <span>1</span> <!--сдлелать автоматический подсчет кол-ва дистанций-->
    <img src="img/drop-down-list.png" class="drop-down-list"><br>
    <img src="img/plus.png" class="plus" title="Добавить дистанцию">
    <div class="addDistance"><!--скрытая форма-->
        <p>Клсасс дистанции: <input type="text" name="classDistance"></p><!--всего 6 классов дистанций (в закрытых 5 классов но закрытые пока не рассматриваем)-->
        <p>Количество этапов: <input type="text" name="Stages"></p><!--посмотреть по регламенту сколько тапов может быть на дистанции-->
        <button>Посмотреть названия этапов</button>
        <div class="addStage">
            <table> <!--должна появляться при нажатии кнопки-->
                <tr>
                    <th>№ этапа</th>
                    <th>название этапа</th>
                    <th>КВ</th>
                </tr>
                <tr>
                    <td></td><!--вставка кода для создания столькоих строк, сколько указано в кол-ве этпов-->
                </tr>
            </table>
            <button>сохранить изменения</button>
        </div>
    </div>
</form>

<form>
    <p>Группа  <input type="label" name="date"> <img src="img/drop-down-list.png" class="drop-down-list"></p><!--дата проведения-->
    <img src=""><!--+ при нажатии на каторый открывается окно/форма для добавления дистанции-->
    Дистаниця № <span>1</span> <!--сдлелать автоматический подсчет кол-ва дистанций-->
    <img src="img/drop-down-list.png" class="drop-down-list"><br>
    <img src="img/plus.png" class="plus" title="Добавить дистанцию">
    <div class="addDistance"><!--скрытая форма-->
        <p>Клсасс дистанции: <input type="text" name="classDistance"></p><!--всего 6 классов дистанций (в закрытых 5 классов но закрытые пока не рассматриваем)-->
        <p>Количество этапов: <input type="text" name="Stages"></p><!--посмотреть по регламенту сколько тапов может быть на дистанции-->
        <button>Посмотреть названия этапов</button>
        <div class="addStage">
            <table> <!--должна появляться при нажатии кнопки-->
                <tr>
                    <th>№ этапа</th>
                    <th>название этапа</th>
                    <th>КВ</th>
                </tr>
                <tr>
                    <td></td><!--вставка кода для создания столькоих строк, сколько указано в кол-ве этпов-->
                </tr>
            </table>
            <button>сохранить изменения</button>
        </div>
    </div>
</form>
</div>

<main>
    <h2>Что хотите сделать?</h2>
    <ul>
        <li><a href="">Добавить делегацию с участниками соревнований</a></li>
        <li><a href="">Добавить чипы</a></li>
        <li><a href="">Сформировать стартовые протоколы</a></li>
        <li><a href="">Сформировать судейские бланки</a></li>
        <li><a href="">Сформировать протоколы соревнований</a></li>
    </ul>
</main>

<footer></footer>
</body>
</html>