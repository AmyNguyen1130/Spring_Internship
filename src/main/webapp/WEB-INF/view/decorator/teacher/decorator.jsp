<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<sitemesh:write property="head"/>
<%@ include file="/WEB-INF/view/decorator/teacher/header.jsp"%>
</head>
<body id="page-top">
	<div class="container-fluid">
		<%@ include file="/WEB-INF/view/decorator/teacher/top_title.jsp"%>
		<div id="wrapper">
			<div id="content-wrapper" class="col-8">
				<div class="row">
					<div class="col-sm-12">
						<c:if test="${messageSuccess != null}">
							<c:choose>
								<c:when test="${messageSuccess.length() > 0}">
									<div class="alert success" style="display: none">
										<span class="closebtn"
											onclick="this.parentElement.style.display='none';">&times;</span>
										<strong id="message">${messageSuccess}</strong>
									</div>
								</c:when>
								<c:otherwise>
									<div class="alert danger" style="display: none">
										<span class="closebtn"
											onclick="this.parentElement.style.display='none';">&times;</span>
										<strong id="message">${messageDanger}</strong>
									</div>
								</c:otherwise>
							</c:choose>
						</c:if>
					</div>
				</div>
		        <div class="container-fluid">
		            <sitemesh:write property="body" />
		        </div>
		        <%@ include file="/WEB-INF/view/decorator/teacher/footer.jsp"%>
		    </div>
		</div>
	</div>

	<div id="confirm" class="modal">
			<form class="modal-content">
				<div class="container-model">
		 			<span onclick="document.getElementById('confirm').style.display='none'" class="close" title="Close Modal">&times;</span>
					<h1 id="title"></h1>
					<p id="ask"></p>

					<div class="clearfix">
						<a id="cancelConfirm" href="#" onclick="document.getElementById('confirm').style.display='none'">
							<button type="button" class="btn cancelbtn"><spring:message code="no"/></button>
						</a>
						<a id="acceptConfirm" href="#">
							<button type="button" class="btn-dark btn acceptbtn"><spring:message code="yes"/></button>
						</a>
					</div>
				</div>
			</form>
		</div>

	<script type="text/javascript">
		$(document).ready(function() {
	
			if($("#message").html() != ""){
				$(".alert").css("display", "block");
				setTimeout(function(){ $(".alert").css("display", "none"); }, 5000);
			}

			setMinHeightForWrapperContainer();
		});

		function setMinHeightForWrapperContainer() {
			var min_height = $(window).height();
			$("#wrapper").css("min-height", min_height + "px");
			$("#content-wrapper").css("min-height", min_height + "px");
		}

		function confirmation(success, action) {
			
			$('#acceptConfirm').attr("href", success);
			$('#title').html(action + ' Item');
			$('#ask').html('Are you sure you want to ' + action + ' this Item ?');
			$('#confirm').show();
		}
	</script>

</body>
</html>

		