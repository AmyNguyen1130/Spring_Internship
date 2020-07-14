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
		<div class="row = 12">
			<div class="col-sm-8">

			 	<h1>Add Class Form</h1>

				<form class="form-group"
					action="<%=request.getContextPath()%>${url}"
					method="post">
					<input class="form-control" value="${assessmentEdit.assessmentid}" type="hidden" name="assessmentid">
					Assessment Name: <input class="form-control" value="${assessmentEdit.assessmentname}" type="text" name="assessmentname">
					<p class="error">${error.errAssessmentName}</p>

					Class: <select class="form-control" name="classForeign.classid">
						<option value="" ${assessmentEdit.getClassForeign().getClassid() == null ? 'selected="selected"' : ''}>None</option>
						<c:forEach items="${listClass}" var="class">
							<option value="${class.classid}" ${class.classid == assessmentEdit.getClassForeign().getClassid() ? 'selected="selected"' : ''}>${class.getClassname()}</option>
						</c:forEach>
					</select>
					<br>
					Start Date: <input class="form-control" value="${assessmentEdit.startdate}" type="date" id="startdate" name="startdate">
					<br>
					Expired Date: <input class="form-control" value="${assessmentEdit.expireddate}" type="date" id="expireddate" name="expireddate">
					<p class="error">${error.errExpiredDate}</p> 
					<br>
					<input type="hidden" value="${url == '/teacher/assessment/saveAddAssessment' ? 'true' : assessmentEdit.status}"  name="status" />
					<br>
					<input class="btn btn-default" type="submit" value="Save">

					<a href="/teacher/assessment"><input class="btn btn-default" type="button" value="Cancel"></a>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		// Set values
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
	</script>
</body>
</html>