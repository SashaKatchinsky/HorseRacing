<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body {
        background-image: url("/images/startBack.jpg");
    }
    .userinfo {
        background-color: antiquewhite;
        background-image: url("/images/startBack.jpg");
        top: 100px;
        border: 3px solid #645a4e;
        position: absolute;
        width: 20%;
        top: 7.5%;
        left: 78%;
        padding: 10px;
        line-height: 2px;
    }
    .fontFantasy {
        font-family: Bradley Hand, cursive;
    }
    .great_btn {
        background: linear-gradient(to bottom, #ffffff 10% , #F0FFF0 100%);
        color: black;
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
        width: 245px;
        border-radius: 2px;
    }
    .events {
        background-image: url("/images/startBack.jpg");
        /*border: 3px solid #87c286;*/
        background-color: aliceblue;
        width: 99.5%;
        left: 35%;
    }
    .horseimage {
        border: 5px solid #645a4e;
    }
    .modalDialogForAdminPanel {
        overflow: auto;
        position: fixed;
        font-family: Arial, Helvetica, sans-serif;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background: rgba(0,0,0,0.8);
        z-index: 99999;
        -webkit-transition: opacity 400ms ease-in;
        -moz-transition: opacity 400ms ease-in;
        transition: opacity 400ms ease-in;
        display: none;
        pointer-events: none;
    }
    .modalDialogForAdminPanel:target {
        display: block;
        pointer-events: auto;
    }

    .modalDialogForAdminPanel > div {
        width: 1000px;
        position: relative;
        margin: 10% auto;
        padding: 5px 10px 13px 10px;
        border-radius: 10px;
        background: #fff;
        background: -moz-linear-gradient(#fff, #999);
        background: -webkit-linear-gradient(#fff, #999);
        background: -o-linear-gradient(#fff, #999);
    }


    .modalDialogForBookmakerPanel {
        overflow: auto;
        position: fixed;
        font-family: Arial, Helvetica, sans-serif;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background: rgba(0,0,0,0.8);
        z-index: 99999;
        -webkit-transition: opacity 400ms ease-in;
        -moz-transition: opacity 400ms ease-in;
        transition: opacity 400ms ease-in;
        display: none;
        pointer-events: none;
    }
    .modalDialogForBookmakerPanel:target {
        display: block;
        pointer-events: auto;
    }

    .modalDialogForBookmakerPanel > div {
        width: 950px;
        position: relative;
        margin: 5% auto;
        padding: 5px 20px 13px 20px;
        border-radius: 10px;
        background: #fff;
        background: -moz-linear-gradient(#fff, #999);
        background: -webkit-linear-gradient(#fff, #999);
        background: -o-linear-gradient(#fff, #999);
    }
    .modalDialogForShowBet {
        overflow: auto;
        position: fixed;
        font-family: Arial, Helvetica, sans-serif;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background: rgba(0,0,0,0.8);
        z-index: 99999;
        -webkit-transition: opacity 400ms ease-in;
        -moz-transition: opacity 400ms ease-in;
        transition: opacity 400ms ease-in;
        display: none;
        pointer-events: none;
    }
    .modalDialogForShowBet:target {
        display: block;
        pointer-events: auto;
    }

    .modalDialogForShowBet > div {
        width: 650px;
        position: relative;
        margin: 10% auto;
        padding: 5px 20px 13px 20px;
        border-radius: 10px;
        background: #fff;
        background: -moz-linear-gradient(#fff, #999);
        background: -webkit-linear-gradient(#fff, #999);
        background: -o-linear-gradient(#fff, #999);
    }
    .modalDialogForDoBet {
        position: fixed;
        font-family: Arial, Helvetica, sans-serif;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background: rgba(0,0,0,0.8);
        z-index: 99999;
        -webkit-transition: opacity 400ms ease-in;
        -moz-transition: opacity 400ms ease-in;
        transition: opacity 400ms ease-in;
        display: none;
        pointer-events: none;
    }
    .modalDialogForDoBet:target {
        display: block;
        pointer-events: auto;
    }

    .modalDialogForDoBet > div {
        width: 610px;
        position: relative;
        margin: 10% auto;
        padding: 5px 20px 13px 20px;
        border-radius: 10px;
        background: #fff;
        background: -moz-linear-gradient(#fff, #999);
        background: -webkit-linear-gradient(#fff, #999);
        background: -o-linear-gradient(#fff, #999);
    }
    .modalDialogForCoefficients {
        position: fixed;
        font-family: Arial, Helvetica, sans-serif;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background: rgba(0,0,0,0.8);
        z-index: 99999;
        -webkit-transition: opacity 400ms ease-in;
        -moz-transition: opacity 400ms ease-in;
        transition: opacity 400ms ease-in;
        display: none;
        pointer-events: none;
    }
    .modalDialogForCoefficients:target {
        display: block;
        pointer-events: auto;
    }

    .modalDialogForCoefficients > div {
        width: 1000px;
        position: relative;
        margin: 10% auto;
        padding: 5px 20px 13px 20px;
        border-radius: 10px;
        background: #fff;
        background: -moz-linear-gradient(#fff, #999);
        background: -webkit-linear-gradient(#fff, #999);
        background: -o-linear-gradient(#fff, #999);
    }
    .close {
        background: #606061;
        color: #FFFFFF;
        line-height: 25px;
        position: absolute;
        right: -12px;
        text-align: center;
        top: -10px;
        width: 24px;
        text-decoration: none;
        font-weight: bold;
        -webkit-border-radius: 12px;
        -moz-border-radius: 12px;
        border-radius: 12px;
        -moz-box-shadow: 1px 1px 3px #000;
        -webkit-box-shadow: 1px 1px 3px #000;
        box-shadow: 1px 1px 3px #000;
    }

    .close:hover { background: #00d9ff; }

    .tabs {
        min-width: 320px;
        max-width: 100%;
        padding: 0px;
        margin: 0 auto;
    }
    .tabs>section {
        display: none;
        padding: 15px;
        background: #fff;
        border: 1px solid #ddd;
    }
    .tabs>section>p {
        margin: 0 0 5px;
        line-height: 1.5;
        color: #383838;
        -webkit-animation-duration: 1s;
        animation-duration: 1s;
        -webkit-animation-fill-mode: both;
        animation-fill-mode: both;
        -webkit-animation-name: fadeIn;
        animation-name: fadeIn;
    }

    @-webkit-keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }
    .tabs>input {
        display: none;
        position: absolute;
    }
    .tabs>label {
        display: inline-block;
        margin: 0 0 -1px;
        padding: 15px 25px;
        font-weight: 600;
        text-align: center;
        color: #aaa;
        border: 0px solid #ddd;
        border-width: 1px 1px 1px 1px;
        background: #f1f1f1;
        border-radius: 3px 3px 0 0;
    }
    .tabs>label:before {
        font-family: fontawesome;
        font-weight: normal;
        margin-right: 10px;
    }
    .tabs>label[for*="1"]:before {
        content: "\f19a";
    }
    .tabs>label[for*="2"]:before {
        content: "\f17a";
    }
    .tabs>label[for*="3"]:before {
        content: "\f13b";
    }
    .tabs>label[for*="4"]:before {
        content: "\f13c";
    }
    .tabs>label:hover {
        color: #888;
        cursor: pointer;
    }
    .tabs>input:checked+label {
        color: #555;
        border-top: 1px solid #009933;
        border-bottom: 1px solid #fff;
        background: #fff;
    }

    #tab1:checked~#content-tab1, #tab2:checked~#content-tab2, #tab3:checked~#content-tab3, #tab4:checked~#content-tab4,
    #tab5:checked~#content-tab5, #tab6:checked~#content-tab6, #tab7:checked~#content-tab7, #tab8:checked~#content-tab8 {
        display: block;
    }

    @media screen and (max-width: 680px) {
        .tabs>label {
            font-size: 0;
        }
        .tabs>label:before {
            margin: 0;
            font-size: 18px;
        }
    }

    @media screen and (max-width: 400px) {
        .tabs>label {
            padding: 15px;
        }
    }
</style>