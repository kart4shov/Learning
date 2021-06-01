<%--
  Created by IntelliJ IDEA.
  User: Dmitry Kartashov
  Date: 31.05.2021
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AddPage</title>
</head>
<body>
<c:url value="/add" var="Add"/>
<form action="${Add}" method="post">>
    <label for="title">Title</label>
    <input type="text" name="title" value="${film.title}" id="title">
    <br>
    <label for="year">Year</label>
    <input type="text" name="year" value="${film.year}" id="year">
    <br>
    <label for="genre">Genre</label>
    <input type="text" name="genre" value="${film.genre}" id="genre">
    <br>
    <label for="watched">Status</label>
    <input type="text" name="watched" value="${film.watched}" id="watched">
    <br>
    <button type="submit">add film</button>
</form>
</body>
</html>
