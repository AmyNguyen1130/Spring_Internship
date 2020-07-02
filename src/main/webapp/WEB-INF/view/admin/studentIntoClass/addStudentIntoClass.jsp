<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student in class</title>

</head>
<body>
	<div style="margin: 5%">
		<h1>Assign students into class</h1>
		<br>
		<br>
		<form class="form-group"
			action="<%=request.getContextPath()%>/admin/saveStudentsToClass?classid=<c:out value='${classid}'/>"
			method="POST" style="width: 50%;">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>UserID</th>
						<th scope="col">User Name</th>
						<th scope="col">RoleId</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${userPage.getContent()}" var="user">

						<tr>
							<td>
								<input type="checkbox" name="checkSelected"
									id="checkbox_${user.getUserid() }"
									value="${user.getUserid()}"
									${studentChecked.contains(user.getUserid()) ? 'checked' : ''}>
							</td>
							<td>${user.getUserid()}</td>
							<td>${user.getUsername()}</td>
							<td>${user.getRoleid()}</td>

						</tr>

					</c:forEach>
				</tbody>
			</table>
			<util:pagination
			count="${userPage.getTotalElements()}"
			totalPages="${userPage.getTotalPages()}" 
			url="${pageContext.request.contextPath}/admin/getTeacherAddToClass"
			curpage="${userPage.getNumber()}" />
			
			<button type="submit" id="assign_buton" class="btn btn-success">Save</button>

			<a href="/admin/class"><button type="button" class="btn btn-warning">Cancel</button></a>
		</form>
		<script type="text/javascript">
		$(document).ready(function(){
			
			$("#assign_buton").click(function(){
			    if(confirm("Are you sure you want to assign students?")){
			    	 return true;
			    }
			    else{
			        return false;
			    }
			});
		});
		</script>
	</div>
</body>
</html>
