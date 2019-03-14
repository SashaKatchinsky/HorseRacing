<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-03
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="openModalForShowBets" class="modalDialogForShowBet">
    <div>
        <a href="#close" title="Close" class="close">X</a>
        <c:choose>
            <c:when test="${empty comingBets}">
                <h2 align="center"><fmt:message key="thereisnocomingbets" bundle="${ mainRB }" /></h2>
                <h3 align="center"><a href="#openModalForDoBet"><fmt:message key="youcandobetjustnow" bundle="${ mainRB }" /></a></h3>
            </c:when>
            <c:otherwise>
                <h2 align="center"><fmt:message key="comingbets" bundle="${ mainRB }" /></h2>
                <table border="1" cellpadding="5" cellspacing="0" align="center">
                    <thead>
                    <tr>
                        <th><fmt:message key="event" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="date" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="time" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="bettype" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="coefficient" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="money" bundle="${ mainRB }" /></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${comingBets}" var="bet">
                        <tr>
                            <th>${bet.event.name}  ${bet.event.date}  ${bet.event.time}</th>
                            <th>${bet.date}</th>
                            <th>${bet.time}</th>
                            <th>
                                <c:forEach items="${bet.typeList}" var="type">
                                    <p>
                                            ${type}
                                    </p>
                                </c:forEach>
                            </th>
                            <th>${bet.coefficient}</th>
                            <th>${bet.money}</th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <h3 align="center"><fmt:message key="deletebet" bundle="${ mainRB }" /></h3>
                <form action="/main" method="post">
                    <input type="hidden" name="command" value="deleteBet">
                    <fmt:message key="what" bundle="${ mainRB }" /> :  <select name="id">
                    <c:forEach items="${comingBets}" var="bet">
                        <option value="${bet.id}">
                                ${bet.event.name} ${bet.event.date} ${bet.event.time} | ${bet.time} ${bet.coefficient} ${bet.money}
                        </option>
                    </c:forEach>
                </select>
                    <input type="submit" value="Delete">
                </form>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${empty playedBets}">
                <h2 align="center"><fmt:message key="nobetshavebeenplayedyet" bundle="${ mainRB }" /></h2>
            </c:when>
            <c:otherwise>
                <h2 align="center"><fmt:message key="playedbets" bundle="${ mainRB }" /></h2>
                <table border="1" cellpadding="5" cellspacing="0" align="center">
                    <thead>
                    <tr>
                        <th><fmt:message key="event" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="date" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="time" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="bettype" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="coefficient" bundle="${ mainRB }" /></th>
                        <th><fmt:message key="money" bundle="${ mainRB }" /></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th colspan="6"><fmt:message key="win" bundle="${ mainRB }" /></th>
                    </tr>
                    <c:forEach items="${playedBets}" var="bet">
                        <c:choose>
                            <c:when test="${bet.status == 'WIN'}">
                                <tr>
                                    <th>${bet.event.name}  ${bet.event.date}  ${bet.event.time}</th>
                                    <th>${bet.date}</th>
                                    <th>${bet.time}</th>
                                    <th>
                                        <c:forEach items="${bet.typeList}" var="type">
                                            <p>
                                                    ${type}
                                            </p>
                                        </c:forEach>
                                    </th>
                                    <th>${bet.coefficient}</th>
                                    <th>${bet.money}</th>
                                </tr>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                    <tr>
                        <th colspan="6"><fmt:message key="loss" bundle="${ mainRB }" /></th>
                    </tr>
                    <c:forEach items="${playedBets}" var="bet">
                        <c:choose>
                            <c:when test="${bet.status == 'LOSS'}">
                                <tr>
                                    <th>${bet.event.name}  ${bet.event.date}  ${bet.event.time}</th>
                                    <th>${bet.date}</th>
                                    <th>${bet.time}</th>
                                    <th>
                                        <c:forEach items="${bet.typeList}" var="type">
                                            <p>
                                                    ${type}
                                            </p>
                                        </c:forEach>
                                    </th>
                                    <th>${bet.coefficient}</th>
                                    <th>${bet.money}</th>
                                </tr>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>