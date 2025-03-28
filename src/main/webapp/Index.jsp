<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/2/22
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎来到游戏商城</title>
    <link rel="icon" href="data:,"/>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Elemrnt组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- CSS文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Index.css"/>

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
                            <li class="layui-nav-item layui-this">
                                <a href="${pageContext.request.contextPath}/login/index" id="nav-shop">商店</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/GameInventory/Inventory" id="nav-ware">库</a>
                            </li>
                            <li class="layui-nav-item">
                                <a href="${pageContext.request.contextPath}/Support.jsp" id="nav-support">支持</a>
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
    <div id="appbody">
        <div id="index-page">
            <div id="left-div" class="box-div">
                <div id="tag-text">按类型浏览</div>
                <div id="tag">
                </div>
            </div>
            <div id="right-div" class="box-div">
                <div id="search-div">
                    <form class="layui-form">
                        <div class="layui-form-item">
                           <%-- <form method="get" action="${pageContext.request.contextPath}/index/findGamesLikeByName">--%>
                                <div id="search-games">
                                    <label><input type="text" id="search-text" name="name"
                                                  class="layui-input"/></label>
                                    <input type="button" class="layui-btn" id="search-btn"  value="搜索"  onclick="searchGame()"/>
                                </div>
                            <%--</form>--%>
                        </div>
                    </form>
                </div>
                <div id="recommend-div">
                    <div id="rec-text" style="color: white">精选和推荐</div>
                    <div id="carousel-div">
                        <!-- 轮播图 -->
                        <div class="layui-carousel" id="carousel" lay-filter="carousel">
                            <!-- 轮播图图片存放位置 -->
                            <div carousel-item id="carouselItem"></div>
                        </div>
                        <%--<div id="carousel-text">
                            <div id="game-text" class="c-text">游戏名</div>
                            <div id="game-publisher" class="c-text">厂商名</div>
                            <div id="game-price" class="c-text">价格</div>
                        </div>--%>
                    </div>
                </div>
                <div id="all-games-div">
                    <div id="all-games-text">所有商品</div>
                    <div id="all-games"><%-- 拼接字符串输入 --%></div>
                    <div id="page-change" class="page-link">
                        <a href="#" id="first" class="page-link-a" onclick="pageHeader()">首页</a>
                        <a href="#" id="up" class="page-link-a" onclick="pageUp()">上一页</a>
                        <a href="#" id="down" class="page-link-a" onclick="pageDown()">下一页</a>
                        <a href="#" id="end" class="page-link-a" onclick="pageFooter()">尾页</a>
                        第<b id="currentPage">1</b>页/共<b id="totalPage">1</b>页
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="end-page-html" style="height: 40px"></div>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexWithUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/Index.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexTag.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexPageGames.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
</body>
</html>
