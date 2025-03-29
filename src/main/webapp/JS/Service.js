layui.use('element', function () {
    var element = layui.element;
});

$(function (){
    let id = sessionStorage.getItem('userId');
    console.log(id);

    /* <a href="${pageContext.request.contextPath}/service/retrievePassword" class="my_service_link">
                        <div class="my_service">
                            <div class="my_service_text">找回密码</div>
                            <div class="my_service_icon_div">
                                <i class="layui-icon layui-icon-triangle-r my_service_right_icon" style="font-size: 20px;color: rgb(160,179,203);"></i>
                            </div>
                        </div>
                    </a>*/
    if(id == null || id == ""){
        let appNone =
            "<a href='/service/registerUser' class='my_service_link'>"
            +"<div class='my_service'>"
            +"<div class='my_service_text'>注册账号</div>"
            +"<div class='my_service_icon_div'>"
            +"<i class='layui-icon layui-icon-triangle-r my_service_right_icon' style='font-size: 20px;color: rgb(160,179,203);'></i>"
            +"</div>"
            +"</div>"
            +"</a>"

            +"<a href='/service/retrievePassword' class='my_service_link'>"
            +"<div class='my_service'>"
            +"<div class='my_service_text'>找回密码</div>"
            +"<div class='my_service_icon_div'>"
            +"<i class='layui-icon layui-icon-triangle-r my_service_right_icon' style='font-size: 20px;color: rgb(160,179,203);'></i>"
            +"</div>"
            +"</div>"
            +"</a>"

        $("#my_service_div").html(appNone);
    }else{
        let app =
            "<a href='#' class='my_service_link'>"
            +"<div class='my_service'>"
            +"<div class='my_service_text'>修改密码</div>"
            +"<div class='my_service_icon_div'>"
            +"<i class='layui-icon layui-icon-triangle-r my_service_right_icon' style='font-size: 20px;color: rgb(160,179,203);'></i>"
            +"</div>"
            +"</div>"
            +"</a>"

            +"<a href='#' class='my_service_link'>"
            +"<div class='my_service'>"
            +"<div class='my_service_text'>我不想要这款游戏了</div>"
            +"<div class='my_service_icon_div'>"
            +"<i class='layui-icon layui-icon-triangle-r my_service_right_icon' style='font-size: 20px;color: rgb(160,179,203);'></i>"
            +"</div>"
            +"</div>"
            +"</a>"

        $("#my_service_div").html(app);
    }
})
