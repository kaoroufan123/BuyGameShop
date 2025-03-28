<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/3/10
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Steam开发者</title>
    <link rel="icon" href="data:,"/>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Elemrnt组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入Css样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PublisherIndex.css"/>
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
                            <li class="layui-nav-item layui-this">
                                <a href="${pageContext.request.contextPath}/login/index" id="nav-shop">商店</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/GameInventory/Inventory" id="nav-ware">库</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/index/support" id="nav-support">支持</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="" id="nav-service">服务</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="appbody-publisher">
        <div id="body-header">
            <div id="publisher-body">

                <div id="publisher-img">
                    <%--<img src="/img/publisherTx/ea/ea.jpg" alt="ea" id="imgs"/>--%>
                </div>
                <div id="publisher-text">
                    <div id="publisher-name">厂商名</div>
                    <div id="publisher-intro">厂商签名</div>
                </div>

            </div>
        </div>
        <div id="body-bgcolor">
            <div id="game-product">
                <div id="game-product-text">所有商品</div>
                <div id="game-product-list">
                    <%--使用.html()导入--%>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/PublisherIndex.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexWithUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
<script>
    let mav = [[${publisherWithName}]];
    /*console.log(mav);*/
    console.log(mav);
    //创作者name
    $("#publisher-name").html(mav[0][0].name);

    //开发者签名
    $("#publisher-intro").html(mav[0][0].intro);

    //开发者头像
    /*<img src="/img/publisherTx/ea/ea.jpg" alt="ea" id="imgs"/>*/
    $("#publisher-img").html("<img src='../"+mav[0][0].photo+"' alt='"+mav[0][0].name+"' id='imgs'/>");


    let publisherName = mav[0][0].name;
    console.log(publisherName);
    getPublisherGames(publisherName);
</script>

</body>
</html>
