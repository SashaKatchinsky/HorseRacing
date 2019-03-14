<%--
  Created by IntelliJ IDEA.
  User: sashayukhimchuk
  Date: 2019-03-04
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body {
        background-image: url("/images/startBack.jpg");
        background-color: floralwhite;
    }
    .block1 {
        width: 50%;
        float: left;
    }
    .block2 {
        width: 50%;
        float: left;
        position: relative;
    }
    .errormessage {
        color: brown;
    }
    .successmessage {
        color: #0bc408;
    }
    .great_btn {
        background: linear-gradient(to bottom, #0bc408 0%,#09a206 100%);
        color: #fff;
        font-size: 16px;
        text-shadow: 0 1px 0 #757575;
        padding: 4px 0 5px 0;
        margin: 0;
        cursor: pointer;
        border: 0;
        border-top: 1px solid #87c286;
        border-right: 1px solid #0e780c;
        border-left: 1px solid #0e780c;
        border-bottom: 1px solid #0e780c;
        box-shadow: 0 -1px 0 #0e780c, 0 1px 0 #fff;
        width: 150px;
        border-radius: 2px;
    }
</style>