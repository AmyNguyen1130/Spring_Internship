<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<sitemesh:write property="head" />
<%@ include file="/WEB-INF/view/decorator/student/header.jsp"%>
</head>
<bodyop">
	<div class="container-fluid">
		<%@ include file="/WEB-INF/view/decorator/student/top_title.jsp"%>
		<div id="wrapper">
			<div id="content-wrapper" class="col-8">
				<div class="row">
					<div class="col-sm-12">
						<c:if test="${messageSuccess != null}">
							<div class="alert success" style="display:none">
								<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
								<strong id="message">${messageSuccess}</strong> 
							</div>
						</c:if>
					</div>
				</div>
		        <div class="container-fluid">
		            <sitemesh:write property="body"/>
		        </div>
			</div>

			<%@ include file="/WEB-INF/view/decorator/student/footer.jsp"%>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value="/js/global.js"/>"></script>

	<!-- TODO: Why student decorator don't have script popup, same as teacher and student ? -->
</body>
</html>