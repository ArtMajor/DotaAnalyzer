<%@include file="/WEB-INF/jspf/page.jspf"%>
<%@include file="/WEB-INF/jspf/taglib.jspf"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<html>
<c:set var="pageTitle" value="auth_page.title" scope="page" />
<head>
	<title>Authorization | DotA Analyzer</title>
	<%@include file="/WEB-INF/jspf/header.jspf"%>
</head>
<body>
	<my:navbar />
	<div class="container">
		<div class="col-sm-6 col-sm-offset-3">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h4 class="text-center">
						<fmt:message key="auth_page.authorization" />
					</h4>
				</div>
				<div class="panel-body">
				
				<!-- Registration message -->
				<c:if test="${not empty reqMessages.regSuccess}">
				<div class="alert alert-success alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<fmt:message key="messages.${reqMessages.regSuccess}"/>
				</div>
				</c:if>
					<form action="signIn.do" method="post" class="form-horizontal">
					
					<!-- Login field -->
						<div class="form-group">
							<label for="mail" class="col-sm-4 control-label"><fmt:message
									key="db.user.mail" />:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="mail" name="mail" placeholder="Email">
								<c:if test="${not empty requestScope.loginErrors.login}">
									<p class="text-danger">
										<fmt:message key="messages.${requestScope.signInErrors.mail}" />
									</p>
								</c:if>
							</div>
						</div>
						
					<!-- Password field -->
						<div class="form-group">
							<label for="password" class="col-sm-4 control-label"><fmt:message
									key="db.user.password" />:</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="password"
									name="password" maxlength="18" placeholder="Password">
								<c:if test="${not empty requestScope.signInErrors.password}">
									<p class="text-danger">
										<fmt:message
											key="messages.${requestScope.signInErrors.password}" />
									</p>
								</c:if>
								<c:if
									test="${not empty requestScope.signInErrors.authorizationError}">
									<p class="text-danger">
										<fmt:message
											key="messages.${requestScope.signInErrors.authorizationError}" />
									</p>
								</c:if>
							</div>
						</div>
						
					<!-- Submit button -->
						<div class="form-group">
							<div class="col-sm-7 col-sm-offset-4">
								<button class="btn btn-primary" type="submit">
									<fmt:message key="navbar.sign_in"/>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
	</html>
