<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-03
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${user.access == 'ADMIN'}">
    <jsp:include page="/js/modalForAdminPanelScript.jsp"/>
    <div id="openModalForAdminPanel" class="modalDialogForAdminPanel">
        <div>
            <a href="#close" title="Close" class="close">X</a>
            <div class="tabs">
                <input id="tab1" type="radio" name="tabs" checked>
                <label for="tab1" title="Вкладка 1"><fmt:message key="users" bundle="${ mainRB }" /></label>

                <input id="tab2" type="radio" name="tabs">
                <label for="tab2" title="Вкладка 2"><fmt:message key="riders" bundle="${ mainRB }" /></label>

                <input id="tab3" type="radio" name="tabs">
                <label for="tab3" title="Вкладка 3"><fmt:message key="horses" bundle="${ mainRB }" /></label>

                <input id="tab4" type="radio" name="tabs">
                <label for="tab4" title="Вкладка 4"><fmt:message key="allbets" bundle="${ mainRB }" /></label>

                <section id="content-tab1">
                    <table border="1" cellpadding="3" cellspacing="0" align="center">
                        <thead>
                        <tr>
                            <th><fmt:message key="username" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="name" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="balance" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="registrationdate" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="access" bundle="${ mainRB }" /></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <th>${user.login}</th>
                                <th>${user.name}</th>
                                <th>${user.balance}</th>
                                <th>${user.registrationDate}</th>
                                <th>${user.access}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <h3 align="center"><fmt:message key="updateuser" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="updateUser">
                        <fmt:message key="who" bundle="${ mainRB }" /> :    <select name="user">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.login}">${user.login}</option>
                                    </c:forEach>
                                </select>
                        <fmt:message key="name" bundle="${ mainRB }" /> :   <input type="text" value="Name" name="name" id="modalForAdminPanelUpdateUserName" onchange="checkUpdateUser()">

                        <fmt:message key="balance" bundle="${ mainRB }" /> :<input type="number" value="10" name="balance" min="0">
                        </p>
                        <fmt:message key="access" bundle="${ mainRB }" /> : <select name="access">
                                    <option value="ADMIN"><fmt:message key="admin" bundle="${ mainRB }" /></option>
                                    <option value="BOOKMAKER"><fmt:message key="bookmaker" bundle="${ mainRB }" /></option>
                                    <option value="USER"><fmt:message key="user" bundle="${ mainRB }" /></option>
                                </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Update" id="modalForAdminPanelUpdateUserSubmit" class="great_btn" disabled>
                    </form>
                    <h3 align="center"><fmt:message key="deleteuser" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="deleteUser">
                        <fmt:message key="who" bundle="${ mainRB }" /> :   <select name="user">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.login}">${user.login}</option>
                                    </c:forEach>
                                </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Submit" align="center" class="great_btn">
                    </form>
                </section>
                <section id="content-tab2">
                    <table border="1" cellpadding="3" cellspacing="0" align="center">
                        <thead>
                        <tr>
                            <th rowspan="2"><fmt:message key="id" bundle="${ mainRB }" /></th>
                            <th rowspan="2"><fmt:message key="name" bundle="${ mainRB }" /></th>
                            <th colspan="3"><fmt:message key="horse" bundle="${ mainRB }" /></th>
                        </tr>
                        <tr>
                            <th><fmt:message key="id" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="name" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="breed" bundle="${ mainRB }" /></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${riders}" var="rider">
                            <tr>
                                <th>${rider.id}</th>
                                <th>${rider.name}</th>
                                <th>${rider.horse.id}</th>
                                <th>${rider.horse.name}</th>
                                <th>${rider.horse.breed}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <h3 align="center"><fmt:message key="addrider" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="addRider">
                        <fmt:message key="name" bundle="${ mainRB }" /> : <input type="text" value="Name" name="name" id="modalForAdminPanelAddRiderName" onchange="checkAddRider()">
                        <fmt:message key="horse" bundle="${ mainRB }" /> : <select name ="horseId">
                        <c:forEach items="${horses}" var="horse">
                            <option value="${horse.id}">${horse.id} ${horse.name} ${horse.breed}</option>
                        </c:forEach>
                    </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Add" id="modalForAdminPanelAddRiderSubmit" class="great_btn" disabled>
                    </form>
                    <h3 align="center"><fmt:message key="updaterider" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="updateRider">
                        <fmt:message key="who" bundle="${ mainRB }" /> :   <select name="updatedRiderId">
                        <c:forEach items="${riders}" var="rider">
                            <option value="${rider.id}">${rider.id} ${rider.name}</option>
                        </c:forEach>
                    </select>
                        <fmt:message key="name" bundle="${ mainRB }" />: <input type="text" name="updatedName" value="Name" id="modalForAdminPanelUpdateRiderName" onchange="checkUpdateRider()">
                        <fmt:message key="horse" bundle="${ mainRB }" />: <select name="horseId">
                        <c:forEach items="${horses}" var="horse">
                            <option value="${horse.id}">${horse.id} ${horse.name} ${horse.breed}</option>
                        </c:forEach>
                    </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Update" id="modalForAdminPanelUpdateRiderSubmit" class="great_btn" disabled>
                    </form>
                    <h3 align="center"><fmt:message key="deleterider" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="deleteRider">
                        <fmt:message key="who" bundle="${ mainRB }" /> :   <select name="deletedRiderId">
                                    <c:forEach items="${riders}" var="rider">
                                        <option value="${rider.id}">${rider.id} ${rider.name}</option>
                                    </c:forEach>
                                </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Delete" class="great_btn">
                    </form>
                </section>
                <section id="content-tab3">
                    <table border="1" cellpadding="3" cellspacing="0" align="center">
                        <thead>
                        <tr>
                            <th><fmt:message key="id" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="name" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="breed" bundle="${ mainRB }" /></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${horses}" var="horse">
                            <tr>
                                <th>${horse.id}</th>
                                <th>${horse.name}</th>
                                <th>${horse.breed}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <h3 align="center"><fmt:message key="addhorse" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="addHorse">
                        <fmt:message key="name" bundle="${ mainRB }" /> : <input type="text" name="name" value="Name" id="modalForAdminPanelAddHorseName" onchange="checkAddHorse()">
                        <fmt:message key="breed" bundle="${ mainRB }" /> : <select name ="breed">
                        <option value="ARABIAN">Arabian</option>
                        <option value="AKHAL_TEKE">Akhal-Teke</option>
                        <option value="SIGLAVI">Siglavi</option>
                        <option value="HADBAN">Hadban</option>
                    </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Add" id="modalForAdminPanelAddHorseSubmit" class="great_btn" disabled>
                    </form>
                    <h3 align="center"><fmt:message key="updatehorse" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="updateHorse">
                        <fmt:message key="who" bundle="${ mainRB }" /> : <select name="id" >
                        <c:forEach items="${horses}" var="horse">
                            <option value="${horse.id}">${horse.id} ${horse.name} ${horse.breed}</option>
                        </c:forEach>
                    </select>
                        <fmt:message key="name" bundle="${ mainRB }" /> : <input type="text" name="name" value="Name" id="modalForAdminPanelUpdateHorseName" onchange="checkUpdateHorse()">
                        <fmt:message key="breed" bundle="${ mainRB }" /> : <select name ="breed">
                        <option value="ARABIAN">Arabian</option>
                        <option value="AKHAL_TEKE">Akhal-Teke</option>
                        <option value="SIGLAVI">Siglavi</option>
                        <option value="HADBAN">Hadban</option>
                    </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Update" id="modalForAdminPanelUpdateHorseSubmit" class="great_btn" disabled>
                    </form>
                    <h3 align="center"><fmt:message key="deleterider" bundle="${ mainRB }" /></h3>
                    <form action="/main" method="post">
                        <input type="hidden" name="command" value="deleteHorse">
                        <fmt:message key="who" bundle="${ mainRB }" /> : <select name="id" >
                                    <c:forEach items="${horses}" var="horse">
                                        <option value="${horse.id}">${horse.id} ${horse.name} ${horse.breed}</option>
                                    </c:forEach>
                                </select>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Delete" class="great_btn">
                    </form>
                </section>
                <section id="content-tab4">
                    <table border="1" cellpadding="3" cellspacing="0" align="center">
                        <thead>
                        <tr>
                            <th><fmt:message key="userlogin" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="coefficient" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="money" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="date" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="time" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="bettype" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="event" bundle="${ mainRB }" /></th>
                            <th><fmt:message key="status" bundle="${ mainRB }" /></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${allBets}" var="bet">
                            <tr>
                                <th>${bet.user.login}</th>
                                <th>${bet.coefficient}</th>
                                <th>${bet.money}</th>
                                <th>${bet.date}</th>
                                <th>${bet.time}</th>
                                <th>
                                    <c:forEach items="${bet.typeList}" var="type">
                                        <p>
                                                ${type}
                                        </p>
                                    </c:forEach>
                                </th>
                                <th>${bet.event.name} ${bet.event.date} ${bet.event.time}</th>
                                <th>${bet.status}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </section>
            </div>
        </div>
    </div>
</c:if>