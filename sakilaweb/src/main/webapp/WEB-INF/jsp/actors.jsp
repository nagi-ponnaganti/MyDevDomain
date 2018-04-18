<%--
  Created by IntelliJ IDEA.
  User: Nagi
  Date: 18/04/2018
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Actors</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>All Actors Listed</h2>

<table>
    <tr>
        <td>Actor Id</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Last Update</td>
    </tr>
    <c:forEach items="${actorList}" var="actor">
        <tr>
            <td>${actor.actorId}</td>
            <td>${actor.firstName}</td>
            <td>${actor.lastName}</td>
            <td>${actor.lastUpdate}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
