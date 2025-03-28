<%--
  Created by IntelliJ IDEA.
  User: 85793
  Date: 2025/3/25
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息：修改头像</title>
    <!-- 引入bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css" rel="stylesheet"/>
    <!-- 引入layui -->
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet"/>
    <!-- 引入Elemrnt组件 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入css文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PageHeader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UpdateUserImg.css"/>
    <!-- 引入Cropper样式 裁剪图片 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css">
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
            <div class="layui-col-md8 layui-col-md-offset2" id="md-body">
                <div id="user-header">
                    <div id="user-img-div">
                        <img src="#" alt="user-img" id="user-img"/>
                    </div>
                    <div id="user-header-link-div">
                        <a href="${pageContext.request.contextPath}/index/linkUserMessage" id="user-name">烤肉饭</a> &raquo
                        <a href="${pageContext.request.contextPath}/userUpdateImgController/UpdateImg" id="update-message">修改头像</a>
                    </div>
                </div>
                <div id="back-mssage-div">
                    <a href="${pageContext.request.contextPath}/index/linkUserMessage"
                       id="back-message">返回您的个人资料</a>
                </div>
                <div id="update-body">
                    <div class="layui-col-md3" id="update-body-left">
                        <div id="user-message-div">
                            <a href="${pageContext.request.contextPath}/userMessage/updateUser" id="user-message"
                               class="user-link">用户资料</a>
                            <a href="${pageContext.request.contextPath}/userUpdateImgController/UpdateImg"
                               id="user-photo" class="user-link">头像</a>
                        </div>
                    </div>
                    <div class="layui-col-md9" id="update-body-right">
                        <div id="padding-body">


                            <form id="uploadForm" method="post" enctype="multipart/form-data">
                                <!-- 隐藏的文件输入 -->
                                <input type="file" id="fileInput" accept="image/*" style="display: none;">
                                <!-- 触发文件选择的按钮 -->
                                <button type="button" onclick="document.getElementById('fileInput').click()"
                                        class="layui-btn">选择图片
                                </button>
                                <!-- 上传按钮 -->
                                <button type="button" onclick="uploadAvatar()" id="uploadBtn" class="layui-btn"
                                        disabled>上传头像
                                </button>
                                <!-- 图片裁剪容器 -->
                                <div style="width: 500px; height: 500px;">
                                    <img id="preview" style="max-width: 100%;">
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/JS/IndexWithUser.js"></script>
<script src="${pageContext.request.contextPath}/JS/Support.js"></script>
<script>

    $(function (){
            $.ajax({
                url: "/userUpdateController/findUserById",
                type: "Post",
                dataType: "JSON",
                data: {
                    id: sessionStorage.getItem("userId")
                },
                success: function (result) {
                    //使用拼接字符串拼接用户头像
                    let appImg = "<img  src='/" + result.photo + "' alt='user-img' id='user-img'/>";
                    $("#user-img-div").html(appImg);
                }
        })
    })


    let cropper = null;

    // 文件选择监听
    document.getElementById('fileInput').addEventListener('change', function (e) {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (event) {
                const img = document.getElementById('preview');
                img.src = event.target.result;

                // 初始化Cropper
                if (cropper) {
                    cropper.destroy();
                }
                cropper = new Cropper(img, {
                    aspectRatio: 1,
                    viewMode: 1,
                    minContainerWidth: 500,
                    minContainerHeight: 500
                });
                document.getElementById('uploadBtn').disabled = false;
            };
            reader.readAsDataURL(file);
        }
    });

    // 上传函数
    function uploadAvatar() {
        cropper.getCroppedCanvas({
            width: 500,
            height: 500,
            imageSmoothingEnabled: true
        }).toBlob((blob) => {
            const formData = new FormData();
            formData.append('avatar', blob, 'avatar.png');
            formData.append('userId', sessionStorage.getItem("userId"));

            // 发送AJAX请求
            fetch('${pageContext.request.contextPath}/userUpdateImgController/uploadAvatar', {
                method: 'POST',
                body: formData
            }).then(response => response.json())
                .then(data => {
                    if (data.success) {
                        alert('上传成功！');
                        // 这里可以更新页面上的头像显示
                        window.location.reload();
                    } else {
                        alert('上传失败：' + data.message);
                    }
                });
        });
    }
</script>
</body>
</html>
