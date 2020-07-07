<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Custom styles for this template-->

<nav class="navbar border-bottom navbar-expand">
	<div class="navbar-top-right col-sm-5">

		<div class="brand-top-right col-sm-6">
			<img class="logo-right"
				style="max-width: 32; vertical-align: middle;"
				src="https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg">
			<h6 class="brand-name grey">Intern App</h6>
		</div>

		<div class="col-sm-6 navbar-top-right">
			<a class="navbar-brand grey tab-link"
				href="<c:url value="/teacher/assessment"/>"> Assessments </a> 

		</div>
	</div>

	<ul class="navbar-nav ml-auto ml-md-0"
		style="position: absolute; right: 20px; color: white;">

		<li class="nav-item dropdown"><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> Account </a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="/logout">Logout</a>
			</div></li>
	</ul>
</nav>
