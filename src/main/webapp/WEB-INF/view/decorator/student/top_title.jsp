<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.codeenginestudio.elearning.util.SecurityUtil" %>
<!-- Custom styles for this template-->

<nav class="navbar border-bottom navbar-expand">
	<div class="navbar-top-right col-sm-4">

		<div class="brand-top-right col-sm-4">
			<img class="logo-right"
				src="https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg">
			<h6 class="brand-name white">Intern App</h6>
		</div>

		<div class="col-sm-8 navbar-top-right">
			<a id="history" class="navbar-brand white tab-link" href="<c:url value="/student/assessment/history"/>">History</a>
			<a id="assessment" class="navbar-brand white tab-link" href="<c:url value="/student/assessment"/>"> Assessment</a>
		</div>
	</div>

	<ul class="navbar-nav ml-auto ml-md-0" style="position: absolute; right: 20px; color: white;">

		<li class="nav-item dropdown"><a
			class="nav-link dropdown-toggle white capitalize" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> ${SecurityUtil.getUserPrincipal().getUsername()} </a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="/logout">Logout</a>
			</div>
		</li>
	</ul>
</nav>
<script type="text/javascript">
	$(document).ready(function() {
		var url = window.location.href;
		if (url == "http://localhost:8080/student/assessment") {
			$("#assessment").css("border-bottom", "4px solid red");
		} else {
			$("#history").css("border-bottom", "4px solid red");
		}

	});
</script>
