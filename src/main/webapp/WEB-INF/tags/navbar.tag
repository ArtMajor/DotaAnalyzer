<%@ tag body-content="empty" language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<c:set scope="request" var="qwerty">${requestScope['javax.servlet.forward.request_uri']}</c:set>
<div class="navbar navbar-inverse navbar-sticky-top no-border-radius">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse"
                    data-target="#navbar-body">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/DotaAnalyzer">DotaAnalyzer</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-body">
            <c:if test="${not empty sessionUser}">
                <ul class="nav navbar-nav">


                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown">Courses</a>
                        <ul class="dropdown-menu">
                            <li><a href="courses.do"><fmt:message
                                    key="navbar.courses.view_all" /></a></li>
                            <c:choose>
                                <c:when test="${sessionUser.role.name == 'administrator'}">
                                    <li><a href="createCourse.do"><fmt:message
                                            key="navbar.courses.create_new" /></a></li>
                                </c:when>
                            </c:choose>
                        </ul>
                    </li>
                </ul>
            </c:if>


            <div class="nav navbar-right">
                <ul class="nav navbar-nav">
                        <li><a href="signIn.do"> <span
                                class="glyphicon glyphicon-log-in"></span> Sign in
                        </a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown">Language
                        <span class="caret"></span>
                    </a>
                        <ul class="dropdown-menu">
                            <li><a
                                    href="${requestScope['javax.servlet.forward.request_uri']}?lang=en">English</a></li>
                            <li><a
                                    href="${requestScope['javax.servlet.forward.request_uri']}?lang=ru">Russian</a></li>
                            <li><a
                                    href="${requestScope['javax.servlet.forward.request_uri']}?lang=uk">Ukrainian</a></li>
                        </ul></li>
                </ul>
            </div>
        </div>
    </div>
</div>
