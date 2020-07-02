<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Custom styles for this template-->
<link href="<c:url value="/css/top_title.css"/>" rel="stylesheet"
	type="text/css">

<nav class="navbar border-bottom navbar-expand">
	<div class="navbar-top-right col-sm-4">

		<div class="brand-top-right col-sm-6">
			<img class="logo-right"
				style="max-width: 32; vertical-align: middle;"
				src="https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg">
			<h6 class="brand-name grey">Intern App</h6>
		</div>

		<div class="col-sm-6 navbar-top-right">
			<a class="navbar-brand grey tab-link"
				href="<c:url value="/admin/user"/>"> Users </a> 
			<a class="navbar-brand grey tab-link"
				href="<c:url value="/admin/class"/>"> Classes </a>
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

<style>
.logo-right {
	border-radius: 50px;
	margin: 5% 10% 5% 5%;
}

.grey {
	color: #5d5d5d;
}

.brand-name {
	font-size: 20px;
	font-weight: bold;
	padding-top: 5%;
}

.navbar {
	padding-bottom: 0px;
	padding-top: 0px;
	height: 56px;
	margin-bottom: 2%;
}

.navbar-top-right {
	display: flex;
	flex-wrap: nowrap;
	cursor: pointer;
}

.brand-top-right {
	display: flex;
	flex-wrap: nowrap;
}

.tab-link {
	cursor: pointer;
	font-weight: bold;
	padding-top: 5%;
	width: 44%;
	margin: 0px;
	padding-left: 10%;
}

.tab-link:hover {
	transition: 1s;
	background-color: #e2e2e2de;
	color: #040404de;
	border-bottom: 4px solid black;
}
</style>