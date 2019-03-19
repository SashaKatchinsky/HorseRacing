<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://dateTimeTag.com" prefix="dt"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
<jsp:include page="/css/startStyles.jsp"/>
<jsp:include page="/js/startScript.jsp"/>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="startPageContent" var="startRB"/>
<html>
<head>
  <title><fmt:message key="start" bundle="${ startRB }" /></title>
</head>
<body>
<form method="post" action="/start">
    <input type="hidden" name="command" value="setRussianLanguage">
    <input type="submit" value="Russian" style="color: #757575">
</form>
<form method="post" action="/start">
    <input type="hidden" name="command" value="setEnglishLanguage">
    <input type="submit" value="English" style="color: #606061">
</form>
<div align="center">
    <div class="block1">
        <h2 align="center"><fmt:message key="login" bundle="${ startRB }" /></h2>
        <form name="loginForm" method="post" action="/start">
            <input type="hidden" name="command" value="login">
            <fmt:message key="username" bundle="${ startRB }" />:<br/>
            <input type="text" name="loginL" id="loginL" value="" required/>
            <br/><fmt:message key="password" bundle="${ startRB }" />:<br/>
            <input type="password" name="passwordL" id="passwordL" value="" required/>
            <br/><br/><br/><br/>
            <font class="errormessage">${errorLoginPassMessage}</font>
            <br/><br/><br/>
            <input type="submit" value="<fmt:message key="login" bundle="${ startRB }" />" id="submitL" class="great_btn">
        </form>
    </div>
    <div class="block2">
        <h2><fmt:message key="registration" bundle="${ startRB }" /></h2>
        <form name="registartionForm" method="post" action="/start">
            <input type="hidden" name="command" value="registration">
            <fmt:message key="username" bundle="${ startRB }" />:<br/>
            <input type="text" id="loginR" name="loginR" onchange="checkRegistrationForm()" value="">
            <br><fmt:message key="name" bundle="${ startRB }" />:<br/>
            <input type="text" name="name" id="name" onchange="checkRegistrationForm()" value="">
            <br/><fmt:message key="password" bundle="${ startRB }" />:<br/>
            <input type="password" name="passwordR" id="passwordR" onchange="checkRegistrationForm()" autocomplete="off">
            <br/><fmt:message key="confirmpassword" bundle="${ startRB }" />:<br/>
            <input type="password" name="passwordRS" id="passwordRS" onChange="checkRegistrationForm();" autocomplete="off">
            <br/>
            <font class="errormessage">${registrationError}</font>
            <br/>
            <font class="successmessage">${successRegistration}</font>
            <br/>
            <input type="submit" id="submitR" value="<fmt:message key="registration" bundle="${ startRB }" />" class="great_btn" disabled/>
            <div class="registrationFormAlert" id="divCheckPasswordMatch">
            </div>
        </form>
    </div>
</div>
<hr/>
<dt:DateTimeTag locale="${language}"/>
</body>
<script>
    function checkRegistrationForm() {
        var bt = document.getElementById('submitR');
        var login = $.trim($("#loginR").val());
        var name = $.trim($("#name").val());
        var password = $.trim($("#passwordR").val());
        var confirmPassword = $.trim($("#passwordRS").val());

        if (login.length > 2 && name.length > 1 && password.length > 2 && password === confirmPassword) {
            bt.disabled = false;
        } else {
            bt.disabled = true;
        }
    }

    function checkLoginForm() {
        let bt = document.getElementById('submitL');
        let login = $.trim($("#loginL").val());
        let password = $.trim($("#passwordL").val());

        if (login.length > 2 && password.length > 2) {
            bt.disabled = false;
        } else {
            bt.disabled = true;
        }
    }

    function checkForms() {
        checkLoginForm();
        checkRegistrationForm();
    }

    $(document).ready(function () {
        $("#passwordR, #passwordRS , #name , #loginR , #passwordL, #loginL").onkeyup(checkForms);
    });
</script>

</html>
