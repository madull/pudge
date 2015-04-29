<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- jsp文件头和头部 -->
	<%@ include file="../system/admin/top.jsp"%> 
	</head> 
<body>
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
						
  <div class="row-fluid">


	
			<!-- 检索  -->
			<table id="bikeAreaTable"></table> 
            <div id="bikeAreaPage"></div>
			<br />
    <a href="javascript:void(0)" id="m1">Get Selected id's</a>
    <br />
    <a href="javascript:void(0)" id="m1s">Select(Unselect) row 13</a>
			
 
 
 
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		
		
		<script type="text/javascript" src="static/js/jquery.tips.js"></script><!--提示框-->
		
		<script type="text/javascript" src="plugins/jqGrid/jquery.jqGrid.js"></script><!--提示框-->
		
		
		
		<script type="text/javascript">
		
		$(function(){
  pageInit();
});
function pageInit(){
  jQuery("#bikeAreaTable").jqGrid(
      {
        url : 'bikeArea_manage/getBikeAreaLog',
        datatype : "json",
        colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax','Total', 'Notes' ],
        colModel : [ 
                     {name : 'bikeAreaUid',index : 'bikeAreaUid',width : 55}, 
                     {name : 'bikeAreaNo',index : 'bikeAreaNo',width : 90}, 
                     {name : 'bikeAreaName',index : 'bikeAreaName',width : 100}, 
                     {name : 'areaRentNum',index : 'areaRentNum',width : 80,align : "right"}, 
                     {name : 'areaReturnNum',index : 'areaReturnNum',width : 80,align : "right"}, 
                     {name : 'updateTime',index : 'updateTime',width : 80,align : "right"}, 
                     {name : 'areaLocation',index : 'areaLocation',width : 150,sortable : false} 
                   ],
        rowNum : 10,
        rowList : [ 10, 20, 30 ],
        pager : '#bikeAreaPage',
        sortname : 'bikeAreaUid',
        mtype : "post",
        viewrecords : true,
        sortorder : "desc",
        caption : "JSON 实例",
        autowidth:true,
        recordpos : 'left',
        multiselect : true
      });
  jQuery("#bikeAreaTable").jqGrid('navGrid', '#bikeAreaPage', {edit : false,add : false,del : false});
  jQuery("#m1").click(function() {
    var s;
    s = jQuery("#bikeAreaTable").jqGrid('getGridParam', 'selarrrow');
    alert(s);
  });
  jQuery("#m1s").click(function() {
    jQuery("#bikeAreaTable").jqGrid('setSelection', "13");
  });
}
		
		
		
		</script>
		


		
		
		
	</body>
</html>

