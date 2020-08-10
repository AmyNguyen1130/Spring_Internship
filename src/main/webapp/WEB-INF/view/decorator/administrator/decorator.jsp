<!DOCTYPE html>
<html lang="en">
<head>
	<sitemesh:write property="head" />
	<%@ include file="/WEB-INF/view/decorator/administrator/header.jsp"%>
</head>
<body id="page-top">
	<div class="container-fluid">
		<%@ include file="/WEB-INF/view/decorator/administrator/top_title.jsp"%>
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
				<%@ include file="/WEB-INF/view/decorator/administrator/footer.jsp"%>
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
							<button type="button" class="btn cancelbtn">No</button>
						</a>
						<a id="acceptConfirm" href="#">
							<button type="button" class="btn-dark btn acceptbtn">Yes</button>
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
		});
		function confirmation(success, action) {
			
			$('#acceptConfirm').attr("href", success);
			$('#title').html(action + ' Item');
			$('#ask').html('Are you sure you want to ' + action + ' this Item ?');
			$('#confirm').show();
		}
	</script>

</body>
</html>