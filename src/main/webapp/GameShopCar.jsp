<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/4/1
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="data:,"/>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Element组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入css文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/GameShopCar.css"/>
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
                                <a href="${pageContext.request.contextPath}/GameInventory/Inventory"
                                   id="nav-ware">库</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/index/support" id="nav-support">支持</a>
                            </li>
                            <li class="layui-nav-item layui-this">
                                <a href="${pageContext.request.contextPath}/service/linkService"
                                   id="nav-service">服务</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="appbody">
        <div class="layui-row">
            <div class="layui-col-md8 layui-col-md-offset2">

                <div id="search-games-div">
                    <input type="text" name="search" id="search-games" lay-verify="required" autocomplete="off"
                           class="layui-input search-div-class"/>
                    <button type="button" class="layui-btn search-div-class" id="search-btn">搜索</button>
                </div>

                <div id="your_shop_car_text">您的购物车</div>
                <div class="layui-col-md8">
                    <div id="cs_game_list">

                        <%--<div class="cs_game_bg">
                            <div class="cs_game">
                                <div class="cs_game_image_left">
                                    <img src="imgs/apex header.jpg" alt="game_image" class="game_image"/>
                                </div>
                                <div class="cs_game_meg_right">
                                    <div class="cs_game_meg_top">Apex Legends</div>
                                    <div class="cs_game_meg_bottom">
                                        <div class="csgmb_price">￥8888.88</div>
                                        <div class="csgmb_remove">
                                            <a href="#" class="csgmb_remove_link" ">移除</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>--%>

                    </div>
                </div>
                <div class="layui-col-md3 layui-col-md-offset1">
                    <div id="pay_right">
                        <div id="pay_price_div">
                            <div id="pay_price_text">预计总额</div>
                            <div id="pay_price"></div>
                        </div>
                        <div id="pay_btn_div">
                            <input type="button" id="pay_btn" class="layui-btn" value="点击支付" onclick="onClickPay()"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexWithUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/GameShopCar.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
</body>
</html>
