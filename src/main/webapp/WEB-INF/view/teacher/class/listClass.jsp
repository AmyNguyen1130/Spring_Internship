<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<body>

	<div class="container-fluid">
	  <div class="row = 12">
	  	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Class Name</th>
				<th scope="col">Teacher ID</th>
				<th scope="col">Status</th>
				<th scope="col">Total Student</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
				<c:set var="i" value="1" />
				<c:forEach items="${classPage.getContent()}" var="class">
			       <tr>
				       <td>${i}</td>
				       <td>${class.classname}</td>
				       <td>${class.teacherid}</td>
				       <td><a href="/admin/class/editClassStatus?classid=<c:out value='${class.classid}' />"
					        onclick="return confirm('Are you sure?')">
					        <button class="btn btn-default">${class.getStatus() == true ? 'Active' : 'Inactive'}</button></a></td>
				       <td>${totalStudent}</td>
				       <td><a href="/teacher/getTeacherAddToClass?classid=<c:out value='${class.classid}'/>"><button class="btn btn-default">View Students In Class</button></a></td>

				   </tr>
				   <c:set var="i" value="${i+1}" />
		     	</c:forEach>

		</tbody>
	</table>

		</div>
	</div>

	<util:pagination
			count="${classPage.getTotalElements()}"
			totalPages="${classPage.getTotalPages()}" 
			url="${pageContext.request.contextPath}/admin/class"
			curpage="${classPage.getNumber()}" />

	<script type="text/javascript">
		$(document).ready(function(){
			
			$("#delete-button").click(function(){
			    if(confirm("Are you sure you want to delete this class?")){
			    	 return true;
			    }
			    else{
			        return false;
			    }
			});
		});
	</script>
</body>
</html>