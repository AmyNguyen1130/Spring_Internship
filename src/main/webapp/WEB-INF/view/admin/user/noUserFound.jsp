<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/fontawesome.min.css">
</head>
<div class="container-fluid center pd-10 mg-top-nodata">
	<div class="">
		<img src="<c:url value="../../../images/no-data.jpg"/>" class="welcomeImg"/>
		<h1><strong><spring:message code="there-are-no-data.-Please-creating-the-first-user-here"/> </strong></h1>
		<div class="table-mg-top-8 form-group row ">
		<div class="col-sm-2"></div>
		<div class="col-sm-8 flex-around">
			<a href="/admin/user/addUser?role=3">
				<button class="btn btn-pink large-btn"><spring:message code="add-new-student"/></button>
			</a>
			<a href="/admin/user/addUser?role=2">
				<button class="btn btn-warning large-btn"><spring:message code="add-new-teacher"/></button>
			</a>
		</div>
		<div class="col-sm-2"></div>
		</div>
	</div>
</div>
