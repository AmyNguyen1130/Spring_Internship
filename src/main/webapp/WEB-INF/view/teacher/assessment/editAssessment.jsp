<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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

	<div style="margin: 5%">
		<h1>Add Assessment Form</h1>

		<form class="form-group" action="<%=request.getContextPath()%>/teacher/assessment/saveEditAssessment"
			method="post" style="width: 50%;">
			<input class="form-control" value="${assessmentEdit.assessmentid}" type="hidden" name="assessmentid">
			Assessment Name: <input class="form-control" value="${assessmentEdit.assessmentname}" type="text" name="assessmentname">
			<p class="error">${error.errAssessmentName}</p>
			Class:
			<select class="form-control" id="classid" name="classid">
				<option value="" ${assessmentEdit.classid == null ? 'selected="selected"' : ''}>None</option>
				 <c:forEach items="${listClass}" var="class">
					<option value="${class.classid}" ${class.classid == assessmentEdit.classid ? 'selected="selected"' : ''}>${class.getClassname()}</option>
			     </c:forEach>
			</select>
			<br>
			Start Date: <input class="form-control" type="date" value="${assessmentEdit.startdate}" id="startdate" name="startdate">
			<p class="error">${error.errStartDate}</p>

			Expired Date: <input class="form-control" type="date" value="${assessmentEdit.expireddate}" id="expireddate" name="expireddate">
			<p class="error">${error.errExpiredDate}</p>
			<br>
			<input type="hidden" value="true" name="status" />

			<a href="/teacher/assessment"><input class="btn btn-warning" type="button" value="Cancel"></a>

			<input class="btn btn-success" id="bt-submit" type="submit" value="Save">

		</form>	
	</div>

</body>
</html>