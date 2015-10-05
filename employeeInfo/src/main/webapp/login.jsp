<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<p>
<c:if test="${error == true}">
	<b class="error">Invalid login or password.</b>
</c:if>
</p>
<form method="post" action="<c:url value='j_spring_security_check'/>" >
	<table cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td align="center" style="height:50px; line-height: 50px; font-weight: bold; border-bottom-color: #FFFFFF; border-bottom-style: solid; border-bottom-width: 2px; color: #FFFFFF;">
				Login page
			</td>
		</tr>
		<tr><td style="height: 10px;"></td></tr>
		<tr>
			<td style="padding-left: 10%; color: #FFFFFF;" align="left">
				<span class="textHeaderWhite">Username</span><br/>
				<input type="text" name="j_username" id="j_username"size="30" maxlength="40" style="width: 85%;" class="textbox" />
			</td>
		</tr>
		<tr><td style="height: 10px;"></td></tr>
		<tr>
			<td style="padding-left: 10%; color: #FFFFFF;" align="left">
				<span class="textHeaderWhite">Password</span><br/>
				<input type="password" name="j_password" id="j_password" size="30" maxlength="32" style="width: 85%;" class="textbox" />
			</td>
		</tr>
		<tr><td style="height: 10px;"></td></tr>
		<tr>
			<td align="right" style="padding-right: 13%">
				<input type="submit" value="Login" class="button" />
			</td>
		</tr>
	</table>
</form>	

</body>
</html>