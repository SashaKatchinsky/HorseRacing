<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-06
  Time: 08:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    $(document).ready(function () {
        $("#passwordR, #passwordRS , #name , #loginR").onkeyup(checkRegistrationForm);
    });

    function checkLoginForm() {
        var bt = document.getElementById('submitL');
        var login = $("#loginL").val();
        var password = $("#passwordL").val();

        if (login.length > 2 && password.length > 2) {
            bt.disabled = false;
        } else {
            bt.disabled = true;
        }
    }

    $(document).ready(function () {
        $("#passwordL, #loginL").onkeyup(checkLoginForm);
    });
</script>
