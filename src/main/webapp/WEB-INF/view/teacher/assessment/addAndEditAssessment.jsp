<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid center">

	<div class="col-sm-3"></div>
	<form action="<%=request.getContextPath()%>${url}" method="post" class="col-sm-6 form-general">
		<h1 class="form-title"><spring:message code="assessment-form"/></h1>
		<input class="form-control" value="${assessmentEdit.assessmentid}" type="hidden" name="assessmentid">

		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="AssessmentName" class="col-sm-2 col-form-label"><spring:message code="assessment-name"/></label>
			<div class="col-sm-8">
				<input class="form-control" value="${assessmentEdit.assessmentname}" type="text" name="assessmentname" placeholder="Please enter assessment's name here">
				<p class="error">${error.errAssessmentName}</p>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="className" class="col-sm-2 col-form-label"><spring:message code="class-name"/></label>
			<div class="col-sm-8">
				<select class="form-control" name="classForeign.classid">
					<c:forEach items="${listClass}" var="class">
						<c:if test="${class.status}">
							<option value="${class.classid}" ${class.classid == assessmentEdit.getClassForeign().getClassid() ? 'selected' : ''}>${class.getClassname()}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="startdate" class="col-sm-2 col-form-label"><spring:message code="start-date"/></label>
			<div class="col-sm-8">
				<input class="form-control" value="${assessmentEdit.startdate}" type="date" id="startdate" name="startdate" placeholder="Please choose a date here">
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="expireddate" class="col-sm-2 col-form-label"><spring:message code="expired-date"/></label>
			<div class="col-sm-8">
				<input class="form-control" value="${assessmentEdit.expireddate}" type="date" id="expireddate" name="expireddate" placeholder="Please choose a date here">
				<p class="error">${error.errExpiredDate}</p>
			</div>
		</div>

		<div class="form-group row">
			<input type="hidden" value="${url == '/teacher/assessment/saveAddAssessment' ? 'true' : assessmentEdit.status}"  name="status" />
		</div>

		<input class="btn btn-pink" type="submit" value="Save">
		<a href="/teacher/assessment"><input class="btn btn-warning" type="button" value="Cancel"></a>
	</form>

	<div class="col-sm-3"></div>

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
