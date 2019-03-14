<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="openModalForCoefficients" class="modalDialogForCoefficients">
    <div>
        <a href="#close" title="Close" class="close">X</a>
        <h3 align="center"><fmt:message key="eventscoefficients" bundle="${ mainRB }"/></h3>
        <table border="1" cellpadding="3" cellspacing="0" align="center">
            <thead>
            <tr>
                <th><fmt:message key="id" bundle="${ mainRB }"/></th>
                <th><fmt:message key="name" bundle="${ mainRB }"/></th>
                <th><fmt:message key="date" bundle="${ mainRB }"/></th>
                <th><fmt:message key="time" bundle="${ mainRB }"/></th>
                <th>1-1</th>
                <th>1-2</th>
                <th>1-3</th>
                <th>1-4</th>
                <th>2-1</th>
                <th>2-2</th>
                <th>2-3</th>
                <th>2-4</th>
                <th>3-1</th>
                <th>3-2</th>
                <th>3-3</th>
                <th>3-4</th>
                <th>4-1</th>
                <th>4-2</th>
                <th>4-3</th>
                <th>4-4</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th colspan="20"><fmt:message key="comingevents" bundle="${ mainRB }"/></th>
            </tr>
            <c:forEach items="${comingEvents}" var="event">
                <tr>
                    <th>${event.id}</th>
                    <th>${event.name}</th>
                    <th>${event.date}</th>
                    <th>${event.time}</th>
                    <th>${event.rider1Position1Coefficient}</th>
                    <th>${event.rider1Position2Coefficient}</th>
                    <th>${event.rider1Position3Coefficient}</th>
                    <th>${event.rider1Position4Coefficient}</th>
                    <th>${event.rider2Position1Coefficient}</th>
                    <th>${event.rider2Position2Coefficient}</th>
                    <th>${event.rider2Position3Coefficient}</th>
                    <th>${event.rider2Position4Coefficient}</th>
                    <th>${event.rider3Position1Coefficient}</th>
                    <th>${event.rider3Position2Coefficient}</th>
                    <th>${event.rider3Position3Coefficient}</th>
                    <th>${event.rider3Position4Coefficient}</th>
                    <th>${event.rider4Position1Coefficient}</th>
                    <th>${event.rider4Position2Coefficient}</th>
                    <th>${event.rider4Position3Coefficient}</th>
                    <th>${event.rider4Position4Coefficient}</th>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="20"><fmt:message key="playedevents" bundle="${ mainRB }"/></th>
            </tr>
            <c:forEach items="${playedEvents}" var="event">
                <tr>
                    <th>${event.id}</th>
                    <th>${event.name}</th>
                    <th>${event.date}</th>
                    <th>${event.time}</th>
                    <th>${event.rider1Position1Coefficient}</th>
                    <th>${event.rider1Position2Coefficient}</th>
                    <th>${event.rider1Position3Coefficient}</th>
                    <th>${event.rider1Position4Coefficient}</th>
                    <th>${event.rider2Position1Coefficient}</th>
                    <th>${event.rider2Position2Coefficient}</th>
                    <th>${event.rider2Position3Coefficient}</th>
                    <th>${event.rider2Position4Coefficient}</th>
                    <th>${event.rider3Position1Coefficient}</th>
                    <th>${event.rider3Position2Coefficient}</th>
                    <th>${event.rider3Position3Coefficient}</th>
                    <th>${event.rider3Position4Coefficient}</th>
                    <th>${event.rider4Position1Coefficient}</th>
                    <th>${event.rider4Position2Coefficient}</th>
                    <th>${event.rider4Position3Coefficient}</th>
                    <th>${event.rider4Position4Coefficient}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
