<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MGS Automation Framework</title>
	<link rel="stylesheet" href="resources/mgsautomation/css/MGSAutomationLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="<c:url value="/resources/css/pageloader.css"/>">
</head>
<body>
	<div id="framework-wrapper">
		<div id="framework-wrapper-body">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td aligh="left" id="header">
						<tiles:insertAttribute name="header" />
					</td>
				</tr>
				<tr>
					<td aligh="left">
						<table cellspacing="0" cellpadding="0" width="100%" style="height: 100%;">
							<tr>
								<td style="width:25%; background-color: #efdaff; padding-bottom: 15px;" aligh="left" valign="top">
									<tiles:insertAttribute name="menu" />
								</td>
								<td style="width:75%; padding-left: 10px; padding-bottom: 15px;" aligh="left" valign="top">
									<tiles:insertAttribute name="body" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td aligh="left" id="footer">
						<tiles:insertAttribute name="footer" />
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="fade" style="display:none"></div>
        <div id="modal">
            <img id="loader" src="<c:url value="/resources/images/ajax-loader.gif" />" />
        </div>
    </div>
	
</body>
<script type="text/javascript">
function openModal() {
    $('#modal').show();
    $('#fade').show();
}

function closeModal() {
	$('#modal').hide();
    $('#fade').hide();
}

</script>
</html>