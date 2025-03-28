<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/3/24
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息：编写个人资料</title>
    <link rel="icon" href="data:," />
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet" />
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" />
    <!-- 引入Element组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入css文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UpdateUser.css" />
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
                            <li class="layui-nav-item  layui-this">
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
            <div class="layui-col-md8 layui-col-md-offset2" id="md-body">
                <div id="user-header">
                    <div id="user-img-div">
                        <img src="#" alt="user-img" id="user-img" />
                    </div>
                    <div id="user-header-link-div">
                        <a href="${pageContext.request.contextPath}/index/linkUserMessage" id="user-name">烤肉饭</a> &raquo
                        <a href="${pageContext.request.contextPath}/userMessage/updateUser" id="update-message">编写个人资料</a>
                    </div>
                </div>
                <div id="back-mssage-div">
                    <a href="${pageContext.request.contextPath}/index/linkUserMessage" id="back-message">返回您的个人资料</a>
                </div>
                <div id="update-body">
                    <div class="layui-col-md3" id="update-body-left">
                        <div id="user-message-div">
                            <a href="${pageContext.request.contextPath}/userMessage/updateUser" id="user-message" class="user-link">用户资料</a>
                            <a href="${pageContext.request.contextPath}/userUpdateImgController/UpdateImg" id="user-photo" class="user-link">头像</a>
                        </div>
                    </div>
                    <div class="layui-col-md9" id="update-body-right">
                        <div id="padding-body">
                            <div id="message-text-div">
                                <div id="message-text-h1">用户资料</div>
                                <p id="message-text">设置您的个人资料和详情。</p>
                                <p id="message-text-p2">您的个人资料名称和头像会在整个平台上代表您，必需适合向所有受众展示。</p>
                            </div>
                            <div id="update-user-message-div">
                                <p id="uum-p">资料</p>
                                <div id="update-user-message-body">
                                    <div id="uumb-username-div">
                                        <p class="uumb-p">个人资料名称</p>
                                        <input type="text" name="name" id="uumb-username" class="layui-input" placeholder="请输入您的名称"/>
                                    </div>
                                    <div id="uumb-sex-div">
                                        <p class="uumb-p">性别</p>
                                        <div class="layui-form" id="uumb-sex-select-div">
                                            <select id="uumb-sex-select">
                                                <option value="0">请选择：</option>
                                                <option value="1">男</option>
                                                <option value="2" >女</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div id="uumb-birthdate-div">
                                        <p class="uumb-p">出生日期</p>
                                        <input type="text" class="layui-input" id="birthday-select"
                                               name="birthday" placeholder="yyyy-MM-dd" />
                                    </div>

                                    <div id="uumb-phone-div">
                                        <p class="uumb-p">联系电话</p>
                                        <input type="text" name="phone" id="phone" class="layui-input" />
                                    </div>

                                    <div id="uumb-signature-div">
                                        <p class="uumb-p">个人签名</p>
                                        <input type="text" name="signature" id="signature"
                                               class="layui-input"/>
                                    </div>
                                    <div id="uumb-btn-div">
                                        <input type="button" id="clear-btn" class="layui-btn" value="取消" onclick="back()"/>
                                        <input type="button" id="save-btn" class="layui-btn" value="保存" onclick="updateUser()"/>
                                    </div>
                                </div>
                            </div>
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
<script src="${pageContext.request.contextPath}/JS/UpdateUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
</body>
</html>
