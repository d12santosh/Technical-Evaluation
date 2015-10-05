<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/mgsautomation/css/MGSAutomationPages.css" type="text/css"></link>
</head>
<body>
<div class="menu-item-regular">
<spring:url value="/welcome" var="homeUrl" htmlEscape="true" />
        <a href=<c:url value="/welcome"/>>Home</a>
</div>
<div class="menu-item-regular">
<spring:url value="/createTestCaseGroup" var="createTestCaseGroupUrl" htmlEscape="true" />
        <a href=<c:url value="/createTestCaseGroup"/>>Create Group</a>
</div>
<div class="menu-item-regular">
<spring:url value=<c:url value="/testRunPageSelection"/> var="logoutUrl" htmlEscape="true" />
        <a href=<c:url value="/testRunPageSelection"/>>Run Test Cases</a>
</div>
<div class="menu-item-regular">
<spring:url value=<c:url value="/logout"/> var="logoutUrl" htmlEscape="true" />
        <a href=<c:url value="/logout"/>>Logout</a>
</div>
</body>
</html>