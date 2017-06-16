<%@include file="/WEB-INF/jspf/page.jspf" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<html>
<head>
    <title>Create confrontation | DotA Analyzer</title>
    <%@include file="/WEB-INF/jspf/header.jspf" %>
</head>
<body>
<my:navbar/>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Panel title</h3>
                </div>
                <div class="panel-body">
                    <form action="createConfrontation" method="post" class="form-horizontal">
                        <div class="form-group">
                            <select class="selectpicker" name="firstHero" id="firstHero">
                                <option selected disabled> Choose hero</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <select class="selectpicker" name="secondHero" id="secondHero">
                                <option selected disabled> Choose hero</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control" name="confrontation" min="0" max="100">
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-block" value="Send"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
<script src="js/loadDataAjax.js"></script>
</body>
</html>
