<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/2/20
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>厂商登录</title>
  <link rel="icon" href="data:,"/>
  <!-- 引入bootstrap -->
  <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet" />
  <!-- 引入layui -->
  <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" />
  <!-- 引入Elemrnt组件 -->
  <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
  <!-- 引入css文件 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login.css" />
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
    <div id="body-border">
      <div id="login-page">
        <div id="login-text">登录</div>
        <div class="layui-form" id="login-form">
          <div id="login-body">
            <br />
            <div id="errorMsg" style="color: red; display: none;text-align: center"></div>
            <div id="login-name">
              <div class="layui-form-item">
                <div id="login-name-text">使用邮箱登录</div>
                <div id="login-name-input" class="layui-input-inline">
                  <input type="text" name="email" id="email" class="layui-input" />
                </div>
              </div>
            </div>
            <div id="login-password">
              <div class="layui-form-item">
                <div id="login-password-text">密码</div>
                <div id="login-password-input" class="layui-input-inline">
                  <input type="password" name="password" id="password" class="layui-input" />
                </div>
              </div>
            </div>
            <div id="login-button-div">
              <button class="layui-btn" id="login-btn" onclick="login()">登录</button>
            </div>
            <div id="nologinhelper-div">
              <a href="${pageContext.request.contextPath}/service/linkService" id="loginhelper">请求帮助，我无法登录</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<%--<script src="https://unpkg.com/element-ui/lib/index.js"></script>--%>
<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/Login.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
</body>
</html>
