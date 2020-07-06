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

		<form class="form-group" action="<%=request.getContextPath()%>/admin/assessment/saveAddAssessment"
			method="post" style="width: 50%;">
			Assessment Name: <input class="form-control" type="text" name="assessmentname">
			<p class="error">${error.errAssessmentName}</p>
			 <br>
			Class:
			<select class="form-control" id="classid" name="classid">
				<option value="0">None</option>
			 <c:forEach items="${listClass}" var="class">
				   <option value="${class.classid}">${class.classname}</option>
		     </c:forEach>
			</select>
			<br>
			Start Date: <input class="form-control" type="date" id="startdate" name="startdate">
			<p class="error">${error.errStartDate}</p>
			<br>
			Expired Date: <input class="form-control" type="date" id="expireddate" name="expireddate">
			<p class="error">${error.errExpiredDate}</p>
			<br>
			<input type="hidden" value="true" name="status" />

			<a href="/admin/assessment"><input class="btn btn-warning" type="button" value="Cancel"></a>

			<input class="btn btn-success" type="submit" value="Save">

		</form>	
	</div>
	<script type="text/javascript">
	// Set values
	$("#startdate").val(getFormattedDate(today()));

	$("#expireddate").val(getFormattedDate(tomorrow()));

	function today() {
	    return new Date();
	}

	function tomorrow(){
		return new Date(today().getTime() + 24 * 60 * 60 * 1000);
		}

	function getFormattedDate(date) {
	    return date.getFullYear()
	        + "-"
	        + ("0" + (date.getMonth() + 1)).slice(-2)
	        + "-"
	        + ("0" + date.getDate()).slice(-2);
	}
	</script>
</body>
</html>