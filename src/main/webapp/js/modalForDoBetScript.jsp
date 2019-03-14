<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-06
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function checkDoBetForm() {
        var button = document.getElementById('submit');
        var select0 = $("#dobetselect0").val();
        var select1 = $("#dobetselect1").val();
        var select2 = $("#dobetselect2").val();
        var select3 = $("#dobetselect3").val();

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
    }
</script>
