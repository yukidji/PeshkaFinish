<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.04.2019
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <img src="/PeshkaFinish/img/ikar.png" width="15%"/>
    <div class="nav">
      <ul>
		<li><a href="index2.jsp">Походы</a></li>
		<li><a href="index2.jsp">О туризме</a></li>
		<li><a href="index2.jsp">Новости</a></li>
		<li><a href="index2.jsp">О Икаре</a></li>
 		<c:set var = "status2" scope = "session" value = "SECRETARY"/>
		<c:if test = "${status eq status2}">
			<li><a href="/PeshkaFinish/index.jsp">Спортивный туризм</a></li>
		</c:if>
	  </ul>
	</div>
	<div id="entry">
		<c:if test = "${not empty status}">
			<p>${login} ${status}</p>
			<span><a href="/PeshkaFinish/out">Выйти</a></span>
		</c:if>
		<c:if test = "${empty status}">
			<span><a href="./entry.jsp">Войти</a></span>
			<span><a href="">Регистрация</a></span>
		</c:if>
	</div>
</header>