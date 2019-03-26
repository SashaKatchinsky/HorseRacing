<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-03
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test ="${user.access == 'BOOKMAKER'}">
    <div id="openModalForBookmakerPanel" class="modalDialogForBookmakerPanel">
        <div>
            <a href="#close" title="Close" class="close">X</a>
            <div class="tabs">
                <input id="tab5" type="radio" name="tabs" checked>
                <label for="tab5"><fmt:message key="showevents" bundle="${ mainRB }"/></label>

                <input id="tab6" type="radio" name="tabs">
                <label for="tab6"><fmt:message key="addevent" bundle="${ mainRB }"/></label>

                <input id="tab7" type="radio" name="tabs">
                <label for="tab7"><fmt:message key="updateevent" bundle="${ mainRB }"/></label>

                <input id="tab8" type="radio" name="tabs">
                <label for="tab8"><fmt:message key="deleteevent" bundle="${ mainRB }"/></label>

                <section id="content-tab5">
                    <h3 align="center"><fmt:message key="events" bundle="${ mainRB }"/></h3>
                    <table border="1" cellpadding="3" cellspacing="0" align="center">
                        <thead>
                        <tr>
                            <th rowspan="2"><fmt:message key="name" bundle="${ mainRB }"/></th>
                            <th rowspan="2"><fmt:message key="date" bundle="${ mainRB }"/></th>
                            <th rowspan="2"><fmt:message key="time" bundle="${ mainRB }"/></th>
                            <th colspan="2"><fmt:message key="rider" bundle="${ mainRB }"/> 1</th>
                            <th colspan="2"><fmt:message key="rider" bundle="${ mainRB }"/> 2</th>
                            <th colspan="2"><fmt:message key="rider" bundle="${ mainRB }"/> 3</th>
                            <th colspan="2"><fmt:message key="rider" bundle="${ mainRB }"/> 4</th>
                        </tr>
                        <tr>
                            <th><fmt:message key="id" bundle="${ mainRB }"/></th>
                            <th><fmt:message key="position" bundle="${ mainRB }"/></th>
                            <th><fmt:message key="id" bundle="${ mainRB }"/></th>
                            <th><fmt:message key="position" bundle="${ mainRB }"/></th>
                            <th><fmt:message key="id" bundle="${ mainRB }"/></th>
                            <th><fmt:message key="position" bundle="${ mainRB }"/></th>
                            <th><fmt:message key="id" bundle="${ mainRB }"/></th>
                            <th><fmt:message key="position" bundle="${ mainRB }"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${events}" var="event">
                            <tr>
                                <th>${event.name}</th>
                                <th>${event.date}</th>
                                <th>${event.time}</th>
                                <th>${event.rider1.id}</th>
                                <th>${event.rider1Position}</th>
                                <th>${event.rider2.id}</th>
                                <th>${event.rider2Position}</th>
                                <th>${event.rider3.id}</th>
                                <th>${event.rider3Position}</th>
                                <th>${event.rider4.id}</th>
                                <th>${event.rider4Position}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </section>

                <section id="content-tab6">
                    <h3 align="center"><fmt:message key="addevent" bundle="${ mainRB }"/></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="addIvent">
                        <fmt:message key="name" bundle="${ mainRB }"/> :  <input type="text" name="name" required>
                        <p/>
                        <fmt:message key="date" bundle="${ mainRB }"/> :  <input type="date" name="date" required>
                        <p/>
                        <fmt:message key="time" bundle="${ mainRB }"/> :  <input type="time" name="time" step="1" required>
                        <p/>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 1 :   <select name="rider1">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 2 :   <select name="rider2">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <p/>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 3 :   <select name="rider3">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 4 :   <select name="rider4">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <pre><fmt:message key="thereisonlydifferentriderscantakepartintheeventotherwiseeventwillnotbeadded" bundle="${ mainRB }"/></pre>
                        <h3 align="center"><fmt:message key="choosecoefficientsonpositioninformatrider_position" bundle="${ mainRB }"/></h3>
                        <c:forEach begin="1" end="4" varStatus="i">
                            <c:forEach begin="1" end="4" varStatus="j">
                                ${i.index} - ${j.index} <input type="number" min="0.01" max="10" step="0.01" name="${i.index}-${j.index}" value="coef${i.index}-${j.index}">
                            </c:forEach>
                            <p/>
                        </c:forEach>
                        <h4><fmt:message key="orsetrandomcoefficients" bundle="${ mainRB }"/>
                            <input type="checkbox" name="isRandomCoef" id="isRandomCoef">
                        </h4>
                        <input type="submit" value="<fmt:message key="add" bundle="${ mainRB }"/>" class="great_btn">
                    </form>
                </section>
                <section id="content-tab7">
                    <h3 align="center"><fmt:message key="updateevent" bundle="${ mainRB }"/></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="updateIvent">
                        <fmt:message key="what" bundle="${ mainRB }"/> :  <select name="id">
                                    <c:forEach items="${comingEvents}" var="event">
                                        <option value="${event.id}">${event.name} ${event.date} ${event.time}</option>
                                    </c:forEach>
                                </select>
                        </p>
                        <fmt:message key="name" bundle="${ mainRB }"/> :  <input type="text" name="name" required>
                        </p>
                        <fmt:message key="date" bundle="${ mainRB }"/> :  <input type="date" name="date">
                        <fmt:message key="time" bundle="${ mainRB }"/> :  <input type="time" name="time" step="1">
                        </p>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 1 :   <select name="rider1">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 2 :   <select name="rider2">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <p/>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 3 :   <select name="rider3">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <fmt:message key="rider" bundle="${ mainRB }"/> 4 :   <select name="rider4">
                                        <c:forEach items="${riders}" var="rider">
                                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                        </c:forEach>
                                    </select>
                        <h3 align="center"><fmt:message key="choosecoefficientsonpositioninformatrider_position" bundle="${ mainRB }"/></h3>
                        <c:forEach begin="1" end="4" varStatus="i">
                            <c:forEach begin="1" end="4" varStatus="j">
                                ${i.index} - ${j.index} <input type="number" min="0" max="10" step="0.01" name="${i.index}-${j.index}" value="0">
                            </c:forEach>
                            <p/>
                        </c:forEach>
                        <h4><fmt:message key="ifatleast1fieldwillbe0nothingwillchange" bundle="${ mainRB }"/></h4>
                        <input type="submit" value="<fmt:message key="update" bundle="${ mainRB }"/>" class="great_btn">
                    </form>
                </section>

                <section id="content-tab8">
                    <h3 align="center"><fmt:message key="deleteevent" bundle="${ mainRB }"/></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="deleteEvent">
                        <fmt:message key="what" bundle="${ mainRB }"/> :  <select name="eventId">
                                    <c:forEach items="${events}" var="event">
                                        <option value="${event.id}">${event.id} ${event.name} ${event.date} ${event.time}</option>
                                    </c:forEach>
                                </select>
                        </p>
                        <input type="submit" value="<fmt:message key="delete" bundle="${ mainRB }"/>"
                               class="great_btn"/>
                    </form>
                </section>

                <section id="content-tab9">

                </section>
            </div>
        </div>
    </div>
</c:if>