<%--
  Created by IntelliJ IDEA.
  User: Dmitry Kartashov
  Date: 31.05.2021
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% //TODO: table design%></>
<html>
<head>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>MyFilms</title>
</head>
<body>
<h2 style="text-align: center">Films</h2>
<p style="text-align: center">
    <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
        <c:url value="/" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
    <a href="${url}">${i.index}</a>
    </c:forEach>
</p>
<table>
    <tr>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
        <th>action</th>
    </tr>
    <c:forEach var="film" items="${filmList}">
        <tr>
            <th>${film.title}</th>
            <th>${film.year}</th>
            <th>${film.genre}</th>
            <th>${film.watched}</th>
            <th>
                <a href="/${film.id}/edit">edit</a>
                <a href="/${film.id}/delete">delete</a>
            </th>
        </tr>
    </c:forEach>
</table>
<h2 style="text-align: center">Add</h2>
<c:url value="/add" var="add"/>
<p style="text-align: center"><a href="${add}">Add film</a></p>
</body>
</html>
