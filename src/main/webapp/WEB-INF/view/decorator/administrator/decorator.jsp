<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
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