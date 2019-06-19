<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.06.2019
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Икар</title>
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
    
  </div>   
  <%@ include file="/pattern/aside.jsp"%>
</div>

<%@ include file="/pattern/footer.jsp"%>
</body>
</html>
