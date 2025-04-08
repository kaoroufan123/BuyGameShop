<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="th" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>--%>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/3/7
  Time: 08:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title id="title-header"></title>
    <link rel="icon" href="data:,"/>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Elemrnt组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <%--css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/GameProductIndex.css"/>

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
                                <b id="downloadapp-text" onclick="linkSupport()" >安装软件</b>
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
                                <a href="${pageContext.request.contextPath}/service/linkService" id="nav-service">服务</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="appbody">
        <div id="show-games">
            <div id="search-games-div">
                <input type="text" name="search" id="search-games" lay-verify="required" autocomplete="off" class="layui-input search-div-class"/>
                <button type="button" class="layui-btn search-div-class" id="search-btn" onclick="searchInput()">搜索</button>
            </div><!-- 70% -->
            <div id="games-text">games</div>
            <div id="carousel-and-text"><!-- 70%的全100% -->
                <div id="show-games-carousel" class="flex-right"><!-- 70-100-60 -->
                    <div class="layui-carousel" id="carousel">
                        <div carousel-item id="carousel-items">
                            <%--<div><img src="/img/gameTx/apex%20lengends/screenshot/ss_0c84b409e174ee9175ee45b3cc9e700f3ed5482a.600x338.jpg" alt="1111"/></div>
                            <div><img src="/img/gameTx/apex%20lengends/screenshot/ss_0c84b409e174ee9175ee45b3cc9e700f3ed5482a.600x338.jpg" alt="1111"/></div>
                            <div><img src="/img/gameTx/apex%20lengends/screenshot/ss_0c84b409e174ee9175ee45b3cc9e700f3ed5482a.600x338.jpg" alt="1111"/></div>
                            <div><img src="/img/gameTx/apex%20lengends/screenshot/ss_0c84b409e174ee9175ee45b3cc9e700f3ed5482a.600x338.jpg" alt="1111"/></div>
                            <div><img src="/img/gameTx/apex%20lengends/screenshot/ss_0c84b409e174ee9175ee45b3cc9e700f3ed5482a.600x338.jpg" alt="1111"/></div>--%>
                        </div>
                    </div>
                    <div id="game-price-div">
                        <div id="game-shop-name">购买游戏</div>
                        <div id="game-shop-price-div">
                            <div id="game-shop-price">￥399.00</div>
                            <div id="game-price-btn-div">
                                <button id="game-price-btn">获取游戏</button>
                            </div>

                        </div>
                    </div>
                </div>
                <div id="games-message-right" class="flex-right"><!-- 70-100-40 -->
                    <div id="games-photo-header">
                        <%--<img src="/img/gameTx/apex%20lengends/apex%20header.jpg" alt="111" id="game-header"/>--%>
                    </div>
                    <div id="games-intro"></div>
                    <div id="issuingDate-div">
                        <div id="issuingDate-text">发行日期:</div>
                        <div id="issuingDate-date">2019-02-13</div>
                    </div>
                    <div id="gamePublisher-div">
                        <div id="gamePublisher-text">发行商:</div>
                        <div id="game-publisher"><a href="#" id="game-publisher-link">EA SPORT</a></div>
                    </div>
                    <div id="game-tag-div">
                        <div id="game-tag-text">产品标签:</div>
                        <div id="game-tag-btns">
                            <%--使用JS加入产品标签 button按钮 --%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/JS/GameProductIndex.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexWithUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>

<script>
    // 从Model中获取JSON字符串并解析
    let gameData = JSON.parse('<c:out value="${gameProduct}" escapeXml="false"/>');

    // 控制台打印数据
    /*console.log("接收到的游戏数据：", gameData);*/
    /*console.log(gameData.gamePhoto);*/

    //产品tag标签
    const keywords = gameData.tag.split(' ');
    let tagHtml = "";
    keywords.forEach(keywords =>{
        tagHtml = tagHtml+"<button class='game-tag' style='margin-left: 5px' onclick='getButtonName(this)'>"+keywords+"</button>";
    })
    /*console.log(tagHtml);*/
    $("#game-tag-btns").html(tagHtml);

    //游戏商品名
    $("#games-text").html(gameData.name);
    $("#game-shop-name").html(gameData.name);
    $("#title-header").html("在GAMES上购买"+gameData.name)
    //游戏封面照
    let gamePhotoHtml = "../"+gameData.gamePhoto;
    /*console.log(gamePhotoHtml);*/
    let gamePhoto = "<img src ='"+ gamePhotoHtml+"' alt = '"+gameData.name+"' id = 'game-header' />";
    $("#games-photo-header").html(gamePhoto);

    //游戏简介
    $("#games-intro").html(gameData.gameIntro);

    //发行日期
    $("#issuingDate-date").html(gameData.issuingDate);

    //发行商
    let gamePublisherLink = "<a href='${pageContext.request.contextPath}/gamePublisher/findGamePublisherWithName?name="+gameData.publishersList[0].name+"'  id='game-publisher-link'>"+gameData.publishersList[0].name+"</a>";
    $("#game-publisher").html(gamePublisherLink);

    //价格
    let price = gameData.price;
    if(price == 0){
        $("#game-shop-price").html("免费开玩");
    }else{
        $("#game-shop-price").html("￥"+ gameData.price);
    }

    gameDataNeed(gameData);

</script>
</body>
</html>
