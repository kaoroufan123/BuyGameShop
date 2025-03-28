<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/2/22
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册完成跳转中</title>
    <style>
        body {
            background-color: rgb(33, 36, 41);
        }

        #success-text {
            color: white;
            font-size: 30px;
            font-weight: bold;
        }

        #link-skip-text {
            color: white;
        }

        #skip {
            text-decoration: none;
            color: aqua;
        }
    </style>
</head>
<body>
<div id="app">
    <div id="success-text">注册完成，等待<span id="second">5</span>秒后自动跳转</div>
</div>
<div id="link-skip">
    <div id="link-skip-text">如果未跳转，请<a href="Login.jsp" id="skip">点击这里</a></div>
</div>
<script src="JS/jquery.js"></script>
<script>
    let sessionLoginProfession = '${sessionScope.loginProfession}';
    let sessionLoginEmail = '${sessionScope.loginEmail}';
    console.log(sessionLoginProfession+','+sessionLoginEmail);

    var time = 4;
    var timer;
    timer = setInterval(
        function() {
            var second = document.getElementById("second");
            if (time >= 1) {
                second.innerHTML = time;
                time--;
            } else {
                clearInterval(timer);
                location.href = "Login.jsp";
            }
        },
        1000
    );
</script>
</body>
</html>
