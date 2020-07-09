<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student in class</title>

</head>
<body>
	<div class="container-fluid">
		<div class="row = 12">
		    <div class="col-sm-7">
			    <form action="/admin/class/search" method="get">
			    	<div class="row">
					    <div class="col-sm-6">
					    	<input class="form-control" type="text" name="inputSearch" placeholder="Search"
					    	aria-label="Search">
					    </div>
					    <div class="col-sm-6">
					    	<button type="submit" class="btn btn-default" >Search</button>
					    </div>
					  </div>
	
				</form>
			</div>
		    <div class="col-sm-5"> 
		    </div>
		</div>
	</div>
	<br><br>
	<div class="container-fluid">
			<form class="form-group"
				action="<%=request.getContextPath()%>/admin/saveStudentsToClass?classid=<c:out value='${classid}'/>"
				method="POST">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">UserID</th>
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
								<td>${user.getUsername()}</td>
								<td>${user.getEmail()}</td>
								<td>${user.isEnabled()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
				<button type="submit" id="assign_buton" class="btn btn-default">Save</button>
				<a href="/admin/class"><button type="button" class="btn btn-default">Cancel</button></a>
			</form>
		</div>
<util:pagination
	count="${userPage.getTotalElements()}"
	totalPages="${userPage.getTotalPages()}" 
	url="${pageContext.request.contextPath}/admin/getTeacherAddToClass"
	curpage="${userPage.getNumber()}" />
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
</body>
</html>
