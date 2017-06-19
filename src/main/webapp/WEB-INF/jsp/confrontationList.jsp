<%@include file="/WEB-INF/jspf/page.jspf" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n">
<html>
<head>
    <title>Confrontations | DotA Analyzer</title>
    <%@include file="/WEB-INF/jspf/header.jspf" %>
</head>
<body>
<my:navbar/>
<div class="container">
    <div class="row">
        <div class="col-sm-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Choose opponent's heroes</h3>
                </div>
                <div class="panel-body panel-hero">
                    <div class="hero-container">

                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Chosen heroes</h3>
                </div>
                <div class="panel-body panel-hero">
                    <div class="chose-hero-container">

                    </div>
                    <div class="button-block">
                        <button id="analyze" class="btn btn-success btn-large btn-block">Analyze!</button>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary opponent-panel">
                <div class="panel-heading">
                    <h3 class="panel-title">Recommended heroes</h3>
                </div>
                <div class="panel-body panel-hero">
                    <div class="opponent-hero-container">

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
<script src="js/loadDataFromServlet.js"></script>
</body>
</html>
</fmt:bundle>