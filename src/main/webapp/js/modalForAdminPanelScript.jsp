<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-09
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function checkUpdateUser() {
        let bt = document.getElementById('modalForAdminPanelUpdateUserSubmit');
        let name = $("#modalForAdminPanelUpdateUserName").val();
        bt.disabled = !(name.length > 1 && name !== "Name");
    }

    function checkAddRider() {
        let bt = document.getElementById('modalForAdminPanelAddRiderSubmit');
        let name = $("#modalForAdminPanelAddRiderName");
        bt.disabled = !(name.length > 1 && name !== "Name");
    }

    function checkUpdateRider() {
        let bt = document.getElementById('modalForAdminPanelUpdateRiderSubmit');
        let name = $("#modalForAdminPanelUpdateRiderName");
        bt.disabled = !(name.length > 1 && name !== "Name");
    }

    function checkAddHorse() {
        let bt = document.getElementById('modalForAdminPanelAddHorserSubmit');
        let name = $("#modalForAdminPanelAddHorseName");
        bt.disabled = !(name.length > 1 && name !== "Name");
    }

    function checkUpdateHorse() {
        let bt = document.getElementById('modalForAdminPanelUpdateHorseSubmit');
        let name = $("#modalForAdminPanelUpdateHorseName");
        bt.disabled = !(name.length > 1 && name !== "Name");
    }
</script>
