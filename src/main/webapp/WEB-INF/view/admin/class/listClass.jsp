<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<body>
	<div class"parents" style="margin: 5%">
	<h1>List Class</h1>
	<a href='/admin/class/addClass'><button class="btn btn-success" type="button">Add class</button></a>

	</br>
	</br>
	<table class="table table-bordered" id="table" style="width: 50%">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Class Name</th>
				<th scope="col">Teacher ID</th>
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
				       <td><a href="/admin/class/editClass?classid=<c:out value='${class.classid}' />">Edit</a> &emsp;
							<a href="/admin/class/deleteClass?classid=<c:out value='${class.classid}'/>" id="delete-button">Delete</a> &emsp;
							<a href="/admin/getTeacherAddToClass?classid=<c:out value='${class.classid}'/>"><button>Assign</button></a></td>

				   </tr>
				   <c:set var="i" value="${i+1}" />
		     	</c:forEach>

		</tbody>
	</table>
	
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