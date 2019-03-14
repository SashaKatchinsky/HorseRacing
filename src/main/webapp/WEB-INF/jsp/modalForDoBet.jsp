<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-03
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/js/modalForDoBetScript.jsp"/>
<div id="openModalForDoBet" class="modalDialogForDoBet">
    <div>
        <form action="/main" method="post">
            <a href="#close" title="Close" class="close">X</a>
            <h2 align="center"><fmt:message key="dobet" bundle="${ mainRB }"/></h2>
            <p><fmt:message key="onwhat" bundle="${ mainRB }"/>
                <select name="event">
                    <c:forEach items="${comingEvents}" var="event">
                        <option value="${event.id}">${event.name} ${event.date} ${event.time}</option>
                    </c:forEach>
                </select>
            </p>
            <c:forEach begin="0" end="3" varStatus="status0">
                <p>
                    <fmt:message key="rider" bundle="${ mainRB }"/> #${status0.count} <fmt:message key="willtake" bundle="${ mainRB }"/>
                    <select name="rider${status0.count}position" id="dobetselect${status0.count}">
                        <c:forEach begin="0" end="4" varStatus="status1">
                            <option>${status1.count - 1}</option>
                        </c:forEach>
                    </select>
                </p>
            </c:forEach>
            <p>
                <fmt:message key="entedamount" bundle="${ mainRB }"/>
                <input type="number" min="0" max="${user.balance}" step="0.2" name="betamount" value="5">
            </p>
            <p>
            <pre><fmt:message key="ifyouchoose0youwillnotdobetonthisrider" bundle="${ mainRB }"/></pre>
            </p>
            <input type="hidden" name="command" value="bet">
            <input id="submit" type="submit" value="Do bet" class="great_btn">
        </form>
    </div>
</div>
<script>
    function checkDoBetForm() {
        var button = document.getElementById('submit');
        var select0 = $("#select0").val();
        var select1 = $("#select1").val();
        var select2 = $("#select2").val();
        var select3 = $("#select3").val();

        let set = new Set();
        let countNoZero = 0;

        if (select0 != 0) {
            set.add(select0);
            countNoZero++;
        }
        if (select1 != 0) {
            set.add(select1);
            countNoZero++;
        }
        if (select2 != 0) {
            set.add(select2);
            countNoZero++;
        }
        if (select3 != 0) {
            set.add(select3);
            countNoZero++;
        }

        if (countNoZero === set.size) {
            button.disabled = false;
        } else {
            button.disabled = true;
        }
        button.disabled = false;
    }
    $(document).ready(function () {
        $("#dobetselect0 , #dobetselect1 , #dobetselect2 , #dobetselect3").onchange(checkDoBetForm());
        alert("AHAHAHAHHA");
    });

</script>
