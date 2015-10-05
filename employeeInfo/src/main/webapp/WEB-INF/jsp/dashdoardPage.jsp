<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/ui.jqgrid.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/ui.jqgrid-bootstarp.css"/>">
<script src="<c:url value="/resources/js/jquery/jquery-2.1.0.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery.jqGrid.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/jquery/grid.locale-en.js" />"></script> --%>

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
<div id="errMessage" style="margin-top: 10px; margin-bottom: 10px; border: 1px solid #117215; background-color: #FF0000; color: #FFFFFF; font-weight: bold; font-size: 11px; width: 95%; padding: 10px;">
				
			</div>

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

<!-- dashboard -->

<%-- <c:forEach items="${response}" var="test">
<c:out value="${test.applicationName} "/>
</c:forEach> --%>
<c:if test="">,</c:if>
<!-- <script type="text/javascript">

var mydata = [
<c:forEach items="${response}" var="test" varStatus="loop">
{applicationName:"${test.applicationName}",
	id:"${test.id}",
	applicationVersion:"${test.applicationVersion}",
	testRunIn:"${test.testRunIn}",
	browser:"${test.browser}",
	totalTestCases:"${test.totalTestCases}",
	totalPassedTestCases:"${test.totalPassedTestCases}",
	totalFailedTestCases:"${test.totalFailedTestCases}",
	testRunStatus:"${test.testRunStatus}"
	}
<c:if test="${!loop.last}">,  
</c:if> 
</c:forEach>
];


console.log(mydata);
jQuery("#dataTableDashBoard").jqGrid({
    datatype: "local",
    data:mydata,
    
    colNames: ['ID','Application Name','Test Run Name','Test Run In Env','Browser', 'Total Test Case', 'Passed Test Case','Failed Test Cases','Status'],
    colModel: [{
        name: 'id',
        index: 'id',
        width: 10,hidden:true},
{
        name: 'applicationName',
        index: 'applicationName',
        width: 150
        },{
	        name: 'applicationVersion',
	        index: 'applicationVersion',
	        width: 50
        },{
        name: 'testRunIn',
        index: 'testRunIn',
        width: 100
        }, {
        name: 'browser',
        index: 'browser',
        width: 100
        }, {
        name: 'totalTestCases',
        index: 'totalTestCases',
        width: 100
    }, {
        name: 'totalPassedTestCases',
        index: 'totalPassedTestCases',
        width: 100
    }, {
        name: 'totalFailedTestCases',
        index: 'totalFailedTestCases',
        width: 100
    }
    ,{
        name: 'testRunStatus',
        index: 'testRunStatus',
        width: 100,formatter:statusFormatter
    }
    
        
        ],
//    multiselect: true,
    caption: 'Test Cases Results Summary ',
    subGrid: true,
    subGridOptions: {
        "plusicon": "ui-icon-triangle-1-e",
        "minusicon": "ui-icon-triangle-1-s",
        "openicon": "ui-icon-arrowreturn-1-e",
        "reloadOnExpand": false,
        "selectOnExpand": true
    },
    subGridRowExpanded: function(subgrid_id, row_id) {
    	var subgrid_table_id, pager_id;
		subgrid_table_id = subgrid_id+"_t";
		debugger;
		pager_id = "p_"+subgrid_table_id;
		$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
		 $.ajax({url:"${pageContext.request.contextPath}/dashBoardResult",data:'id=' + row_id ,success: function(result){
				//alert('result---'+result.logText);
				
				debugger;
				console.log(result);
			jQuery("#"+subgrid_table_id).jqGrid({
			datatype: "local",
			data:result.rows,
			colNames: ['Test Case ID','Test Case Description', 'Status'],
			colModel: [
				{		
				        name: 'testCaseId',
				        index: 'testCaseId',
				        width: 100
				        },{
				        name: 'testCaseDescription',
				        index: 'testCaseDescription',
				        width: 250
				        }, {
				        name: 'status',
				        index: 'status',
				        width: 50,formatter:statusFormatter
				        }
				/* {name:"num",index:"num",width:80,key:true},
				{name:"item",index:"item",width:130},
				{name:"qty",index:"qty",width:70,align:"right"},
				{name:"unit",index:"unit",width:70,align:"right"},
				{name:"total",index:"total",width:70,align:"right",sortable:false} */
			],
		   	rowNum:20,
		   	pager: pager_id,
		   	sortname: 'testCaseId',
		    sortorder: "asc",
		    height: '100%'
		}); 
		 }
		 ,error:function(ts){
				debugger;
				console.log(ts)
				//alert(ts.responseText)
				
				}});
    },
    subGridRowColapsed: function(subgrid_id, row_id) {
		// this function is called before removing the data
		//var subgrid_table_id;
		//subgrid_table_id = subgrid_id+"_t";
		//jQuery("#"+subgrid_table_id).remove();
	},
    /* grouping:true,
   	groupingView : {
   		groupField : ['applicationName'],
   		groupColumnShow : [false],
groupText : ['<b>{0} - {1} Test Run Result(s)</b>'],
	groupCollapse : true,
groupOrder: ['desc']  
   	}, */
   	height: '100%',
    pager: '#pgridDashBoard'
});


$(function() {
  $( "#datepicker1" ).datepicker();
});

 
  $(function() {
    $( "#datepicker2" ).datepicker();
  });
  
function statusFormatter(cellvalue, options, rowObject)
{
	
	console.log("options"+options)
	console.log("rowObject"+rowObject)
	//debugger;
	var cellHtml ='default';
    var color = 'yellow';
    if(cellvalue == "PASSED"){
    	color ='green';
    	 cellHtml = '<span class="cellWithoutBackground" style="background-color:' + color + ';">'+ cellvalue + "</span>";
    }
    if(cellvalue == "IN QUEUE"){
    	color ='yellow';
    	 cellHtml = '<span class="cellWithoutBackground" style="background-color:' + color + ';">'+ cellvalue + "</span>";
    }
    if(cellvalue == "STARTED"){
    	color ='orange';
    	 cellHtml = '<span class="cellWithoutBackground" style="background-color:' + color + ';">'+ cellvalue + "</span>";
    	 //cellHtml = '<span class="cellWithoutBackground" style="background-color:' + color + ';">'+ cellvalue + "</span> <input type='button' class='button' value='Run Failed TC' onClick='reRunFailedTestCases("+rowObject.id+ ")'/>";
    }
    if(cellvalue == "FAILED"){
    	color ='red';
    //	consile.log("<input type='button' value='Run Failed TC' onClick='reRunFailedTestCases("+options+","+rowObject+ ")'/>");
    	 cellHtml = '<span class="cellWithoutBackground" style="background-color:' + color + ';">'+ cellvalue + "</span> <input type='button' class='button' value='Run Failed TC' onClick='reRunFailedTestCases("+rowObject.id+")'/>";
    }
    	
    //var cellHtml = '<span class="cellWithoutBackground" style="background-color:' + color + ';">'+ cellvalue + "</span> <input type='button' value='Run Failed TC' onClick='reRunFailedTestCases("+options+","+rowObject ")'/>";

    return cellHtml;
 }
 
 function reRunFailedTestCases(id){
	 openModal();
	 debugger;
	 //alert("i am here");
	 var rowData = jQuery("#dataTableDashBoard").jqGrid('getRowData',id);
	 $.ajax({
  		 type: "post",
  		  url: "${pageContext.request.contextPath}/reRunFailedTC",
  		  cache: false,    
  		  data: 'allRowsInGrid='+ JSON.stringify(rowData)+'&id='+id, //'&groupDesc=' + groupdesc + '&groupType=' + grpType + '&application=' + application + '&testType=2&allRowsInGrid=' +JSON.stringify(ret),
  		  success: function(response){
  		//  debugger;
  		
		  
		  /*  $.each(response, function(key, value) {   
			     $('#module')
			          .append($('<option>', { value : value.moduleId })
			          .text(value.moduleName)); 
			});  */
  			  //alert('Successfully created tc group..');
  		closeModal();
  		  },
  		  error: function(){
  			closeModal();
  			   alert('Error while getting module names');
  			  }
  			 });
	 
 }
$('#errMessage').hide();
$("#reportButton").click(function(){
	openModal();
	$('#errMessage').hide();
	debugger;
	var fromDate = $("#datepicker1").val();
	var toDate = $("#datepicker2").val();
	var applicationId= $('#application  option:selected').val();
	if(applicationId ==='NONE'){
		$('#errMessage').show();
		$("#errMessage").html("please select Application"); 
		
		 closeModal();
		 return false;
	 }
	if(Boolean(fromDate) ){
		if(!Boolean(toDate)){
		$('#errMessage').show();
		$("#errMessage").html("To Date Cannot Be Empty "); 
		 closeModal();
		 return false;
		}
	 }
	if(Boolean(toDate) ){
		if(!Boolean(fromDate)){
		$('#errMessage').show();
		$("#errMessage").html("From Date Cannot Be Empty "); 
		 closeModal();
		 return false;
		}
	 }
	 $.ajax({
		  type: "post",
		  url: "${pageContext.request.contextPath}/welcome",
		  cache: false,    
		  data:'fromDate=' + fromDate + "&toDate=" +toDate+ "&applicationId=" +applicationId,// "&password=" +password+ "&browser=" +browser+ "&env=" +env+ "&runIn=" +runIn+"&category="+category +"&allRowsInGrid=" +JSON.stringify(allRowsInGrid),
		  success: function(response){
		console.log("response==="+response);
			  
				jQuery('#dataTableDashBoard').jqGrid('clearGridData');
				jQuery('#dataTableDashBoard').jqGrid('setGridParam', {data:response});
				jQuery('#dataTableDashBoard').trigger('reloadGrid');
			  
				$('#errMessage').hide();
				closeModal();
		  },
		  error: function(){      
			  $('#errMessage').show();
			  $("#errMessage").html("Error while processing request");
			  closeModal();		 
			   
			  }
	 });
	 
});
 
 
(function poll(){
	setTimeout(function() {
		var fromDate = $("#datepicker1").val();
		var toDate = $("#datepicker2").val();
		var applicationId= $('#application  option:selected').val();
		 $.ajax({
			  type: "post",
			  url: "${pageContext.request.contextPath}/welcome",
			  cache: false,    
			  data:'fromDate=' + fromDate + "&toDate=" +toDate+ "&applicationId=" +applicationId,// "&password=" +password+ "&browser=" +browser+ "&env=" +env+ "&runIn=" +runIn+"&category="+category +"&allRowsInGrid=" +JSON.stringify(allRowsInGrid),
			  success: function(response){
			console.log("response==="+response);
				  
					jQuery('#dataTableDashBoard').jqGrid('clearGridData');
					jQuery('#dataTableDashBoard').jqGrid('setGridParam', {data:response});
					jQuery('#dataTableDashBoard').trigger('reloadGrid');
				  
				  
			  }
    ,dataType: "json", complete: poll,error:function(ts){
	debugger;
	console.log(ts)
	//alert(ts.responseText)
	
	}});}, 30000);
})();

</script> -->

</body>
</html>