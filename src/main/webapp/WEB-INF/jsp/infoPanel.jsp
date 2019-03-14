<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-03
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="userinfo">
    <h3 align="center"><fmt:message key="yourinfo" bundle="${ mainRB }" /></h3>
    <p/>
    <fmt:message key="name" bundle="${ mainRB }" /> - <font class="fontFantasy">${user.name}</font>
    <p/>
    <fmt:message key="username" bundle="${ mainRB }" /> - <font class="fontFantasy">${user.login}</font>
    <p/>
    <fmt:message key="balance" bundle="${ mainRB }" /> - <font class="fontFantasy">${user.balance}</font>
    <p/>
    <fmt:message key="access" bundle="${ mainRB }" /> - <font class="fontFantasy"><c:out value="${user.access}"/></font>
    <p/>
    <fmt:message key="registrationdate" bundle="${ mainRB }" /> - <font class="fontFantasy">${user.registrationDate}</font>
    <form action="/main" method="post">
        <input type="hidden" name="command" value="logout">
        <input input type="submit" id="submit" value="<fmt:message key="exit" bundle="${ mainRB }" />" class="great_btn"/>
    </form>

    <form action="#openModalForDoBet">
        <input type="submit" value="<fmt:message key="dobet" bundle="${ mainRB }" />" class="great_btn" />
    </form>

    <form action="#openModalForShowBets">
        <input type="submit" value="<fmt:message key="showbets" bundle="${ mainRB }" />" class="great_btn">
    </form>

    <c:if test="${user.access == 'ADMIN'}">
        <form action="#openModalForAdminPanel">
            <input type="submit" value="<fmt:message key="adminpanel" bundle="${ mainRB }" />" class="great_btn"/>
        </form>
    </c:if>

    <c:if test ="${user.access == 'BOOKMAKER'}">
        <form action="#openModalForBookmakerPanel">
            <input type="submit" value="<fmt:message key="bookmakerpanel" bundle="${ mainRB }" />" class="great_btn">
        </form>
    </c:if>

    <form action="#openModalForCoefficients">
        <input type="submit" value="<fmt:message key="coefficients" bundle="${ mainRB }" />" class="great_btn">
    </form>

    <jsp:include page="modalForShowBets.jsp" flush="true">
        <jsp:param name="playedBets" value="${playedBets}"/>
        <jsp:param name="comingBets" value="${comingBets}"/>
    </jsp:include>

    <jsp:include page="modalForAdminPanel.jsp" flush="true">
        <jsp:param name="user" value="${user}"/>
        <jsp:param name="users" value="${users}"/>
        <jsp:param name="riders" value="${riders}"/>
        <jsp:param name="horses" value="${horses}"/>
        <jsp:param name="allBets" value="${allBets}"/>
    </jsp:include>

    <jsp:include page="modalForBookmakerPanel.jsp" flush="true">
        <jsp:param name="events" value="${events}"/>
        <jsp:param name="riders" value="${riders}"/>
        <jsp:param name="comingEvents" value="${comingEvents}"/>
    </jsp:include>

    <jsp:include page="modalForDoBet.jsp" flush="true">
        <jsp:param name="comingEvents" value="${comingEvents}"/>
        <jsp:param name="user" value="${user}"/>
    </jsp:include>

    <jsp:include page="modalForCoefficients.jsp" flush="true">
        <jsp:param name="comingEvents" value="${comingEvents}"/>
        <jsp:param name="playedEvents" value="${playedEvents}"/>
    </jsp:include>
</div>
