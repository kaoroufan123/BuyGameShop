
let userId;
$(function () {
    //填充用户
    let app = "";
    $.ajax({
        url: "/user/findUserNAP",
        type: "POST",
        dataType: "JSON",
        success: function (result) {
                        /*console.log(result);*/
                        /*console.log(result.userName);*/
            app = app +
                "<div class='user-container'>"
                +"<span id='userIdSpan' hidden>"+result.userId+"</span>"
                +"<div class='user-text'>"
                +"<a href='/index/linkUserMessage'><span class='user-name' >" + result.userName + "</span></a>"
                + "<span class='user-balance'>" + "￥" + result.userBalance + "</span>"
                +"</div>"
                + "<a href='/index/linkUserMessage'><img src='../" + result.userPhoto + "' alt='用户头像' class='user-img'/></a>"
                +"<a href='#' id='user-logout' onclick='userLoginOut()'>退出登录</a>"
                +"</div>";
                /*console.log(app);*/
            $("#loginindex").html(app);
            sessionStorage.setItem("userId", result.userId);
        }

    })
})

function userLoginOut(){
    let logoutCheck = confirm("确定退出登录吗？");
    if (logoutCheck) {
        sessionStorage.setItem("userId", "");
        location.href = "/auth/logout";
    }
}
