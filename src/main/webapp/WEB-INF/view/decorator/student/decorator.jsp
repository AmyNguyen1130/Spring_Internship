<!DOCTYPE html>
<html lang="en">
<head>
<sitemesh:write property="head" />
<%@ include file="/WEB-INF/view/decorator/student/header.jsp"%>
</head>
<body id="page-top">
	<div class="container-fluid">
		<%@ include file="/WEB-INF/view/decorator/student/top_title.jsp"%>
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="row">
					<div class="col-sm-7">
						<div class="alert success" style="display:none">
							<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
							<strong id="message">${messageSuccess}</strong> 
						</div>
					</div>
				</div>
		        <div class="container-fluid">
		            <sitemesh:write property="body" />
		        </div>

				<%@ include file="/WEB-INF/view/decorator/student/footer.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>