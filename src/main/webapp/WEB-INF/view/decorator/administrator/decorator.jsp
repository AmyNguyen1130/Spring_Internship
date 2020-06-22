<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/decorator/administrator/header.jsp"%>
</head>
<body>
	<main id="page-wrapper5">
		<div class="container-fluid">
			<sitemesh:write property='body' />
		</div>
	</main>
	<%@ include file="/WEB-INF/view/decorator/administrator/footer.jsp"%>
</body>
</html>