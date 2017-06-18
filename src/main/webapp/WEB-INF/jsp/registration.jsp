<%@include file="/WEB-INF/jspf/page.jspf"%>
<%@include file="/WEB-INF/jspf/taglib.jspf"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n">
<html>
<head>
	<c:set var="pageTitle" value="reg_page.title" scope="page"/>
	<%@include file="/WEB-INF/jspf/header.jspf"%>
</head>
<body>
	<my:navbar/>
	<div class="container">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h4 class="text-center"><fmt:message key="reg_page.registration"/></h4>
				</div>
				<div class="panel-body">
					<my:registrationForm/>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>
</fmt:bundle>
