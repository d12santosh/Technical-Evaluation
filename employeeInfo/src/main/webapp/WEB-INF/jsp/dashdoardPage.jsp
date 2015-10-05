<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
span.cellWithoutBackground
{
    display:block;
    background-image:none;
    margin-right:-2px;
    margin-left:-2px;
    height:14px;
    padding:4px;
}
</style>
</head>
<body>

<div class="subTitle" style="margin-top: 10px;">
	Dash Board
</div>
<div id="errMessage" style="margin-top: 10px; margin-bottom: 10px; border: 1px solid #117215; background-color: #FF0000; color: #FFFFFF; font-weight: bold; font-size: 11px; width: 95%; padding: 10px; display:none">
				
			</div>
<!-- 
<table cellpadding="0" cellspacing="0" style="width: 97%; margin-top: 10px;">
	<tr>
		<td align="left" style="width: 25%;"> 
			<span class="textHeader">Application</span>
			<select id="application" class="dropdown" style="width: 100%;">
			<option value="NONE">Select One</option>
			<c:forEach items="${masterApplicationsList}" var="test" varStatus="loop">
			<option value="${test.applicationMasterId}">${test.applicationMasterName}</option> 
		</c:forEach>
			</select>
		</td>
		<td align="left" style="width: 25%; padding-left: 10px;">
			<span class="textHeader">From Date</span>
			<input type="text" id="datepicker1" class="textbox" style="width: 100%;">
		</td>
		<td align="left" style="width: 25%;  padding-left: 10px;">
			<span class="textHeader">To Date</span>
			<input type="text" id="datepicker2" class="textbox" style="width: 100%;">
		</td>
		<td align="right" style="width: 25%;">
			<input type="button" id = "reportButton" value = "Get Report" class="button"/>
		</td>
	</tr>
	<tr><td colspan="4" style="height: 10px;"></td></tr>
	<tr>
		<td colspan="4" align="left">
			<div id = "dashBoardDataDiv" >
				<table id="dataTableDashBoard"></table>
				<div id="pgridDashBoard"></div>
			</div>
		</td>
	</tr>
</table>
 -->


</body>
</html>