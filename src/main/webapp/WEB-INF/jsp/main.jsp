<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-02-15
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="dt" uri="http://dateTimeTag.com" %>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="mainPageContent" var="mainRB" scope="session"/>
<html>
<head>
<title><fmt:message key="main" bundle="${ mainRB }" /></title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
    <jsp:include page="/css/mainStyles.jsp"/>
</head>
<body>
    <div>
        <div style="float: left;">
            <form method="post" action="/main">
                <input type="hidden" name="command" value="setRussianLanguage">
                <input name="language" type="submit" value="Русский" ${sessionScope.language == 'ru' ? 'selected' : ''}>
            </form>
        </div>
        <div style="float: left;">
            <form method="post" action="/main">
                <input type="hidden" name="command" value="setEnglishLanguage">
                <input name="language" type="submit" value="English" ${sessionScope.language == 'en' ? 'selected' : ''}>
            </form>
        </div>
        <div style="float: right; color: WHITE;">
            <dt:DateTimeTag locale="${language}"/>
        </div>
    </div>
    <h1 align="center"><fmt:message key="welcome" bundle="${ mainRB }" /></h1>
    <jsp:include page="infoPanel.jsp" flush="true">
        <jsp:param name="user" value="${user}"/>
        <jsp:param name="users" value="${users}"/>
        <jsp:param name="riders" value="${riders}"/>
        <jsp:param name="horses" value="${horses}"/>
        <jsp:param name="allBets" value="${allBets}"/>
        <jsp:param name="events" value="${events}"/>
        <jsp:param name="riders" value="${riders}"/>
        <jsp:param name="comingEvents" value="${comingEvents}"/>
    </jsp:include>

    <img src="<c:url value="/images/StartHorse.jpg"/>" alt="Horse" class="horseimage">
    <hr/>
    <div class="events" align="center">
        <h2 align="center"><fmt:message key="availableevents" bundle="${ mainRB }" /></h2>
        <table border="1" cellpadding="5" cellspacing="0" align="center">
            <thead>
            <tr>
                <th rowspan="3"><fmt:message key="name" bundle="${ mainRB }" /></th>
                <th rowspan="3"><fmt:message key="date" bundle="${ mainRB }" /></th>
                <th rowspan="3"><fmt:message key="time" bundle="${ mainRB }" /></th>
                <th colspan="3"><fmt:message key="rider" bundle="${ mainRB }" /> 1</th>
                <th colspan="3"><fmt:message key="rider" bundle="${ mainRB }" /> 2</th>
                <th colspan="3"><fmt:message key="rider" bundle="${ mainRB }" /> 3</th>
                <th colspan="3"><fmt:message key="rider" bundle="${ mainRB }" /> 4</th>
            </tr>
            <tr>
                <c:forEach begin="0" end="3" step="+1">
                    <th rowspan="2"><fmt:message key="name" bundle="${ mainRB }" /></th>
                    <th colspan="2"><fmt:message key="horse" bundle="${ mainRB }" /></th>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach begin="0" end="3" step="+1">
                    <th><fmt:message key="name" bundle="${ mainRB }" /></th>
                    <th><fmt:message key="breed" bundle="${ mainRB }" /></th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <th colspan="15"><fmt:message key="comingevents" bundle="${ mainRB }" /></th>
            <c:forEach items="${comingEvents}" var="event">
                <tr>
                    <td>${event.name}</td>
                    <td>${event.date}</td>
                    <td>${event.time}</td>
                    <td>${event.rider1.name}</td>
                    <td>${event.rider1.horse.name}</td>
                    <td>${event.rider1.horse.breed}</td>
                    <td>${event.rider2.name}</td>
                    <td>${event.rider2.horse.name}</td>
                    <td>${event.rider2.horse.breed}</td>
                    <td>${event.rider3.name}</td>
                    <td>${event.rider3.horse.name}</td>
                    <td>${event.rider3.horse.breed}</td>
                    <td>${event.rider4.name}</td>
                    <td>${event.rider4.horse.name}</td>
                    <td>${event.rider4.horse.breed}</td>
                </tr>
            </c:forEach>
            </tbody>
            <th colspan="15"><fmt:message key="alreadyplayed" bundle="${ mainRB }" /></th>
            <c:forEach items="${playedEvents}" var="event">
                <tr>
                    <td>${event.name}</td>
                    <td>${event.date}</td>
                    <td>${event.time}</td>
                    <td>${event.rider1.name}</td>
                    <td>${event.rider1.horse.name}</td>
                    <td>${event.rider1.horse.breed}</td>
                    <td>${event.rider2.name}</td>
                    <td>${event.rider2.horse.name}</td>
                    <td>${event.rider2.horse.breed}</td>
                    <td>${event.rider3.name}</td>
                    <td>${event.rider3.horse.name}</td>
                    <td>${event.rider3.horse.breed}</td>
                    <td>${event.rider4.name}</td>
                    <td>${event.rider4.horse.name}</td>
                    <td>${event.rider4.horse.breed}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
