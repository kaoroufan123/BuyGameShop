<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/2/21
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Elemrnt组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css"/>
    <!-- 引入css文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/RegisterUser.css"/>
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
                                <b id="downloadapp-text">安装软件</b>
                            </button>
                            <div id="loginindex">
                                &nbsp;
                                <a href="Login.jsp" id="loginlink">登录</a>
                                &nbsp;<b id="b1">|</b>&nbsp;
                                <a href="#" id="indexlink">主页</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="second-header">
                    <div id="gameshop-icon">
                        <a href="#" id="icon-link">GAMES</a>
                    </div>
                    <div id="nav">
                        <ul class="layui-nav" id="layui-nav">
                            <li class="layui-nav-item">
                                <a href="" id="nav-shop">商店</a>
                            </li>
                            <li class="layui-nav-item ">
                                <a href="" id="nav-ware">库</a>
                            </li>
                            <li class="layui-nav-item layui-this">
                                <a href="" id="nav-support">支持</a>
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
        <div id="body-boder" class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md12" id="mdAll">
                    <div id="register-page">
                        <div id="reg-user-text">创建您的账户</div>
                        <div id="reg-user-body">
                            <form class="layui-form form-horizontal" id="reg-form">
                                <div id="name-div">
                                    <div class="layui-form-item">
                                        <div id="reg-name-text">名称</div>
                                        <div id="reg-name-input" class="layui-input-inline">
                                            <label id="name-lab"><input type="text" name="name" id="name"
                                                                        class="layui-input"/></label>
                                        </div>
                                    </div>
                                </div>
                                <div id="email-div">
                                    <div class="layui-form-item">
                                        <div id="reg-email-text">电子邮件地址</div>
                                        <div id="reg-email-input" class="layui-input-inline">
                                            <label id="email-lab"><input type="text" name="email" id="email"
                                                                         class="layui-input"/></label>
                                        </div>
                                    </div>
                                </div>
                                <div id="password-div">
                                    <div class="layui-form-item">
                                        <div id="reg-password-text">密码</div>
                                        <div id="reg-password-input" class="layui-input-inline">
                                            <label><input type="password" name="password" id="password"
                                                          class="layui-input"/></label>
                                        </div>
                                    </div>
                                </div>
                                <div id="checkPassword-div">
                                    <div class="layui-form-item">
                                        <div id="reg-checkPassword-text">确认密码</div>
                                        <div id="reg-checkPassword-input" class="layui-input-inline">
                                            <label><input type="password" name="checkPassword"
                                                          id="checkPassword" class="layui-input"/></label>
                                        </div>
                                    </div>
                                </div>
                                <div id="phone-div">
                                    <div class="layui-form-item">
                                        <div id="reg-phone-text">手机</div>
                                        <div id="reg-phone-input" class="layui-input-inline">
                                            <label><input type="text" name="phone" id="phone"
                                                          class="layui-input"/></label>
                                        </div>
                                    </div>
                                </div>

                            </form>
                            <div id="checkBox-div">
                                <div id="checkBox-checked">
                                    <label id="reg-checkBox-text"><input type="checkbox" name="checkbox"
                                                                         id="checkbox"/>&nbsp;我已同意相关协议</label>
                                </div>
                            </div>
                            <div id="button-div">
                                <button class="layui-btn" id="layui-btn" onclick="regUser()">注册</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 引入相关JS文件 -->
<script src="${pageContext.request.contextPath}/layui/lay/modules/element.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/RegisterUser.js"></script>
</body>
</html>
