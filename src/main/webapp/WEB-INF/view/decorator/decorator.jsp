<!DOCTYPE html>
<html  lang="en">
<head>
    <%@ include file="/WEB-INF/view/decorator/header.jsp" %>
</head>
<body>
        <main id="page-wrapper5">
                <div class="container-fluid">
                       <sitemesh:write property='body'/>
                </div>
        </main>
     <%@ include file="/WEB-INF/view/decorator/footer.jsp" %>
</body>
</html>