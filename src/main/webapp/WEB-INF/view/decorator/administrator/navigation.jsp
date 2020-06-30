<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/user"/>">
            <i class="menu-icon mdi mdi-television"></i>
            <span class="menu-title">Users</span>
        </a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/class"/>">
            <i class="menu-icon mdi mdi-television"></i>
            <span class="menu-title">Classes</span>
        </a>
    </li>
</ul>