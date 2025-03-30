<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/3/30
  Time: 08:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game服务：退款</title>
    <link rel="icon" href="data:," />
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet" />
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" />
    <!-- 引入Element组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入css文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/GameRefund.css" />
</head>
<body>
<div id="app">
    <div id="appheader">
        <div id="header-background">
            <div class="container layui-container">
                <div id="downloadloginindex">
                    <div class="row layui-row">
                        <div class="col-sm-3 col-sm-offset-8" id="dl-id">
                            <button id="downloadloginindx-button" class="col-sm-5 layui-btn">
                                <i class="layui-icon" id="download-icon">&#xe601;</i>
                                <b id="downloadapp-text" onclick="linkSupport()">安装软件</b>
                            </button>
                            <div id="loginindex">
                                &nbsp;
                                <a href="${pageContext.request.contextPath}/login/loginLink" id="loginlink">登录</a>
                                &nbsp;<b id="b1">|</b>&nbsp;
                                <a href="${pageContext.request.contextPath}/login/index" id="indexlink">主页</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="second-header">
                    <div id="gameshop-icon">
                        <a href="${pageContext.request.contextPath}/login/index" id="icon-link">GAMES</a>
                    </div>
                    <div id="nav">
                        <ul class="layui-nav" id="layui-nav" lay-filter="">
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/login/index" id="nav-shop">商店</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/GameInventory/Inventory" id="nav-ware">库</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/index/support" id="nav-support">支持</a>
                            </li>
                            <li class="layui-nav-item layui-this">
                                <a href="${pageContext.request.contextPath}/service/linkService" id="nav-service">服务</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="appbody">
        <div class="layui-row">
            <div class="layui-col-md6 layui-col-md-offset3">
                <div id="body_header_text">游戏退款</div>
                <div id="game_refund_text_header">您想要退款哪款游戏？</div>


                <div id="game_list_header_div">

                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexWithUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/GameRefund.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
</body>
</html>
