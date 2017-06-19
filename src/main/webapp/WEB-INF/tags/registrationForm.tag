
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<%@ tag body-content="empty" language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" src="bootstrap/js/validator.js"></script>

<form action="registration.do" method="post" class="form-horizontal">

	<!-- Email field -->
	<div class="form-group">
		<label for="mail" class="col-sm-3 control-label"><fmt:message
				key="db.user.mail" />:</label>
		<div class="col-sm-7">
			<input type="email" class="form-control" id="mail" name="mail"
				value="${userDto.mail}">
				<c:if test="${not empty regErrors.mail}">
					<p class="text-danger"><fmt:message key="messages.${regErrors.mail}"/></p>
				</c:if>
		</div>
	</div>

	<!-- Password field -->
	<div class="form-group">
		<label for="password" class="col-sm-3 control-label"><fmt:message
				key="db.user.password" />:</label>
		<div class="col-sm-7">
			<input type="password" class="form-control" id="password"
				name="password" maxlength="18"> 
				<c:if test="${not empty regErrors.password}">
				<p class="text-danger"><fmt:message key="messages.${regErrors.password}"/></p>
				</c:if>
		</div>
	</div>

	<!-- Confirm password field -->
	<div class="form-group">
		<label for="confirm_password" class="col-sm-3 control-label"><fmt:message
				key="reg_page.repeat_pass" />:</label>
		<div class="col-sm-7">
			<input type="password" class="form-control" id="confirm_password"
				name="confirm_password">
			<c:if test="${not empty regErrors.confirm_password}">
				<p class="text-danger"><fmt:message key="messages.${regErrors.confirm_password}"/></p>
			</c:if>
			<div class="help-block">
				<fmt:message key="reg_page.password_help" />
			</div>
			
		</div>

	</div>

	<!-- First name field -->
	<div class="form-group">
		<label for="firstName" class="col-sm-3 control-label"><fmt:message
				key="db.user.firstName" />:</label>
		<div class="col-sm-7">
			<input type="text"  class="form-control" id="firstName"
				name="firstName" required="required" value="${userDto.firstName}">
			<c:if test="${not empty regErrors.firstName}">
				<p class="text-danger"><fmt:message key="messages.${regErrors.firstName}"/></p>
			</c:if>
		</div>
	</div>

	<!-- Second name field -->
	<div class="form-group">
		<label for="lastName" class="col-sm-3 control-label"><fmt:message
				key="db.user.lastName" />:</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="lastName" name="lastName"
				required="required" value="${userDto.lastName}"> 
			<c:if test="${not empty regErrors.lastName}">
				<p class="text-danger"><fmt:message key="messages.${regErrors.lastName}"/></p>
			</c:if>
		</div>
	</div>

	<!-- Submit button -->
	<div class="form-group">
		<div class="col-sm-4 col-sm-offset-3">
			<button class="btn btn-primary form-control" type="submit">
				<fmt:message key="navbar.sign_up" />
			</button>
		</div>
	</div>
</form>