<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="confirm" class="modal">
	<form class="modal-content">
		<div class="container-model">
			<div class="title-popup">
				<span onclick="document.getElementById('confirm').style.display='none'" class="close" title="Close Modal">&times;</span>
				<h1 id="title" class="action-confirm"></h1>
			</div>
			
			<div class="">
				<p id="ask" class="ask"></p>
				<img alt="abc" src="https://pa1.narvii.com/7585/1bd73d72c130b1d2144a1c54cb4696f1343e7747r1-348-298_00.gif" class="image-popUp">
				
				<div class="clearfix flex-around">
					<div>
						<a id="cancelConfirm" href="#" onclick="document.getElementById('confirm').style.display='none'">
							<button type="button" class="btn-warning btn cancelbtn confirm-btn"><spring:message code="no"/></button>
						</a>
					</div>
					<div>
						<a id="acceptConfirm" href="#">
							<button type="button" class="btn-pink btn acceptbtn confirm-btn"><spring:message code="yes"/></button>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</form>
</div>