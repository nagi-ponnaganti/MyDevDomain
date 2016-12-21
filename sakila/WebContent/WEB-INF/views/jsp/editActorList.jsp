<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sakila Store</title>
</head>
<body>

	<h2>Actors Management System</h2>

	<form:form method="post" action="addActor" commandName="actor">

		<table>
			<tr>
				<td><form:label path="actorId">
						<spring:message code="label.actorid" />
					</form:label></td>
				<td><form:input path="actorId" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">
						<spring:message code="label.firstname" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message code="label.lastname" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastUpdateTS">
						<spring:message code="label.lastupdatets" />
					</form:label></td>
				<td><form:input path="lastUpdateTS" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.add"/>" /></td>
			</tr>
		</table>
	</form:form>

	<h3>Actors</h3>
	<c:if test="${!empty actorList}">
		<table class="data">
			<tr>
				<th>ActorId</th>
				<th>Name</th>
				<th>LastUpdateTime</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${actorList}" var="act">
				<tr>
					<td>${act.actorId}</td>
					<td>${act.lastName},${act.firstName}</td>
					<td>${act.lastUpdateTS}</td>
					<td>delete</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>