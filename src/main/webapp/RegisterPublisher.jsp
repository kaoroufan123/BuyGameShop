<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/2/17
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>厂商注册</title>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Element组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link href="${pageContext.request.contextPath}/css/ReisterPublisher.css" rel="stylesheet"/>
</head>
<body>
<div id="RegisterHtml" class="RegisterHtml">
    <div id="RegisterHeader">
        <div id="BackgroundColorSet">
            <div class="container layui-container">
                <div id="HeaderBody">
                    <div id="DownloadLoginRegister">
                        <div class="row layui-row">
                            <div class="col-sm-3 col-sm-offset-8" style="color: white; font-size: 12px;">
                                <button id="DownloadAppButton" class="col-sm-5 layui-btn">
                                    <b id="DownloadAppText" onclick="linkSupport()">安装软件</b>
                                </button>
                                <div id="LoginIndex">
                                    &nbsp;
                                    <a href="${pageContext.request.contextPath}/login/loginLink" id="loginlink">登录</a>
                                    &nbsp;<b id="b1">|</b>&nbsp;
                                    <a href="${pageContext.request.contextPath}/login/index" id="indexlink">主页</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="SecondHeader">
                <div id="ICON" class="SecondHeaderFlex">
                    <a href="${pageContext.request.contextPath}/login/index" id="ICONTEXT">GAMES</a>
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
    <div id="RegisterBody" class="RegisterBody">
        <div id="IndexBackground">
            <div id="PublisherJoin">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <div id="JoinText">创建您的账号</div>
                        <br/>
                        <div id="NameDiv">
                            <div id="NameText" class="RegPublisherText">公司名称</div>
                            <input type="text" name="name" id="name" class="layui-input" maxLength="100"
                                   required lay-verify="required"/>
                        </div>
                        <br/>
                        <div id="AccountDiv">
                            <div id="AccountText" class="RegPublisherText">公司邮箱</div>
                            <input type="text" name="account" id="account" maxLength="100" required
                                   lay-verify="required" class="layui-input"/>
                        </div>
                        <br/>
                        <div id="PasswordDiv">
                            <div id="PasswordText" class="RegPublisherText">公司密码</div>
                            <input type="password" name="password" id="password" maxLength="100" required
                                   lay-verify="required" class="layui-input"/>
                        </div>
                        <br/>
                        <div id="CheckPasswordDiv">
                            <div id="CheckPasswordText" class="RegPublisherText">确认密码</div>
                            <input type="password" name="checkPassword" id="checkPassword" maxLength="100"
                                   required lay-verify="required" class="layui-input"/>
                        </div>
                        <br/>
                        <div id="EstablishDateDiv">
                            <div id="EstablishDateText" class="RegPublisherText">创立时间</div>
                            <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
                                <input type="text" name="establishDate" id="establishDate"
                                       class="layui-input"/>
                            </div>
                        </div>
                        <br/>
                        <div id="RegCheck">
                            <label><input type="checkbox" name="checkBox" id="CheckBox" class="CB"/></label>
                            <span id="CheckBoxText" class="CB"> 我已阅读并同意相关协议</span>
                        </div>
                        <br/>
                        <br/>
                        <div id="RegButtonDiv">
                            <button class="layui-btn" id="RegBtn" onclick="checkRegister()">注册</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/RegisterPublisher.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
</body>
</html>
