<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

	
	        <a  href="<c:url value="/admin/user"/>">
	            <button class="tablink">Users </button>
	        </a>
	        <a  href="<c:url value="/admin/class"/>">  
	            <button class="tablink">Classes</button>
	        </a>


	</ul>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0" style="position: absolute;right: 20px;color: white;">

        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               Account
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" >
                <a class="dropdown-item" href="/logout" >Logout</a>
            </div>
        </li>
    </ul>
</nav>

<style>
img {
	width: 30px;
	height: 30px;
	margin: 4px;
	margin-right: 40px;
}

.tablink {
  background-color: #343a40!important;
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 17px;
  font-size: 17px;
  width: 100% !important;
}

.tablink:hover {
  background-color: pink;
}

.navbar {
	padding: 0px !important;
    height: 60px;
}
}


</style>