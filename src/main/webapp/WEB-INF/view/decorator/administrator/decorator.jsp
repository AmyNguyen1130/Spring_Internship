<!DOCTYPE html>
<html lang="en">
<head>
	<sitemesh:write property="head"/>
	<%@ include file="/WEB-INF/view/decorator/administrator/header.jsp"%>
</head>
<body id="page-top">
	<%@ include file="/WEB-INF/view/decorator/administrator/top_title.jsp" %>
	<div id="wrapper">

		<div id="content-wrapper">

	        <div class="container-fluid">
	            <sitemesh:write property="body" />
	        </div>

	        <%@ include file="/WEB-INF/view/decorator/administrator/footer.jsp"%>
	    </div>
	</div>

</body>
</html>