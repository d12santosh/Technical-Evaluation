<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MGS Automation Framework</title>
	<link rel="stylesheet" href="resources/mgsautomation/css/MGSAutomationLayout.css" type="text/css"></link>
<style>
body{ margin-top:20px; margin-bottom:20px; }
</style>
</head>
<body>
<div id="framework-wrapper">
	<div id="framework-wrapper-body">
		<div>
			<div style="width: 200px; margin: 0 auto;">
				<tiles:insertAttribute name="header" />
			</div>
		</div>
		<div style="height: 70%;">
			<div style="width: 400px; height:220px; background-color:#632891; color:#FFFFFF; margin: 0 auto;">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</div>
<!-- <table cellspacing="0" cellpadding ="0" width="100%" style="height: 100%; margin: 0;">
			<tr>
				<td colspan="2" id="header">
					
					
				</td>
			</tr>
			<tr>
				<td style="width:25%; height: 100%;" aligh="left">
					
				</td>
				<td style="width:75%; height:100%; background-color:#F1F1F1; padding-left: 10px;" aligh="left">
					
				</td>
			</tr>
			<tr>
				<td colspan="2" id="footer-1">
					
					
				</td>
			</tr>
		</table>	 -->
</body>
</html>