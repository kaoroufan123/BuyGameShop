<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/3/20
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title id="user-title">用户信息</title>
    <link rel="icon" href="data:,"/>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Elemrnt组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- CSS文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link href="${pageContext.request.contextPath}/css/UserMessage.css" rel="stylesheet"/>
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
                                <a href="${pageContext.request.contextPath}/Login.jsp" id="loginlink">登录</a>
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
                            <li class="layui-nav-item ">
                                <a href="${pageContext.request.contextPath}/login/index" id="nav-shop">商店</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/GameInventory/Inventory" id="nav-ware">库</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/Support.jsp" id="nav-support">支持</a>
                            </li>
                            <li class="layui-nav-item layui-this">
                                <a href="" id="nav-service">服务</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="appbody">
        <div class="layui-row">
            <div class="layui-col-md6 layui-col-md-offset3" id="md6-body">
                <div id="body-inline">
                    <div id="basic-information">
                        <%--<img src="#" alt="用户头像" id="user-img"/>
                        <div id="user-name-div">
                            <span id="user-name">烤肉饭</span>
                            <span id="user-signature">你所热爱的就是你的生活你所热爱的就是你的生活你所热爱的就是你的生活</span>
                            <div id="update-btn-div">
                                <input type="button" id="update-btn" class="layui-btn" value="修改个人资料"/>
                            </div>
                        </div>--%>
                    </div>
                    <div id="myWareHouse-div">
                        <div id="myWareHouse-text">我的库</div>
                        <div id="myWareHouse-body">
                            <div class="games-ware-div">
                                <%--<div class="games-ware">
                                    <a href="#" class="games-img-link">
                                        <img src="#" alt="game-header" class="game-img"/>
                                    </a>
                                    <div class="games-text-div">
                                        <a href="#" class="games-text">APEX LEGENDS</a>
                                    </div>
                                    <div class="game-buyTime-div">
                                        <span class="game-buyTime">2025年1月1日</span>
                                    </div>
                                </div>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexWithUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/UserMessage.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
</body>
</html>
