<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<h1>Assessment Form</h1>
	<br>

	<form action="<%=request.getContextPath()%>${url}" method="post">

		<input class="form-control" value="${assessmentEdit.assessmentid}" type="hidden" name="assessmentid">

		<div class="form-group row">
			<label for="AssessmentName" class="col-sm-1 col-form-label">Name</label>
			<div class="col-sm-4">
				<input class="form-control" value="${assessmentEdit.assessmentname}" type="text" name="assessmentname">
				<p class="error">${error.errAssessmentName}</p>
			</div>
		</div>

		<div class="form-group row">
			<label for="className" class="col-sm-1 col-form-label">Class Name</label>
			<div class="col-sm-4">
				<select class="form-control" name="classForeign.classid">
					<option value="" ${assessmentEdit.getClassForeign().getClassid() == null ? 'selected="selected"' : ''}>None</option>
					<c:forEach items="${listClass}" var="class">
						<option value="${class.classid}" ${class.classid == assessmentEdit.getClassForeign().getClassid() ? 'selected="selected"' : ''}>${class.getClassname()}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label for="startdate" class="col-sm-1 col-form-label">Start Date</label>
			<div class="col-sm-4">
				<input class="form-control" value="${assessmentEdit.startdate}" type="date" id="startdate" name="startdate">
			</div>
		</div>

		<div class="form-group row">
			<label for="expireddate" class="col-sm-1 col-form-label">Expired Date</label>
			<div class="col-sm-4">
				<input class="form-control" value="${assessmentEdit.expireddate}" type="date" id="expireddate" name="expireddate">
				<p class="error">${error.errExpiredDate}</p>
			</div>
		</div>

		<div class="form-group row">
			<input type="hidden" value="${url == '/teacher/assessment/saveAddAssessment' ? 'true' : assessmentEdit.status}"  name="status" />
		</div>

		<input class="btn btn-default" type="submit" value="Save">
		<a href="/teacher/assessment"><input class="btn btn-default" type="button" value="Cancel"></a>
	</form>
	
	</div>
	<script type="text/javascript">
		var url = window.location.href;
		if(url == "http://localhost:8080/teacher/assessment/addAssessment"){

			$("#startdate").val(getFormattedDate(today()));

			$("#expireddate").val(getFormattedDate(tomorrow()));

			function today() {
				return new Date();
			}

			function tomorrow() {
				return new Date(today().getTime() + 24 * 60 * 60 * 1000);
			}

			function getFormattedDate(date) {
				return date.getFullYear() + "-"
						+ ("0" + (date.getMonth() + 1)).slice(-2) + "-"
						+ ("0" + date.getDate()).slice(-2);
			}
		}

	</script>
</body>
</html>