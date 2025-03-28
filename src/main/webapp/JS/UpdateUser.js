layui.use('element', function () {
    var element = layui.element;
});

layui.use(function () {
    var laydate = layui.laydate;
    // 渲染
    laydate.render({
        elem: '#birthday-select'
    });
});

$(function () {
    $.ajax({
        url: "/userUpdateController/findUserById",
        type: "GET",
        dataType: "JSON",
        data: {
            id: sessionStorage.getItem("userId")
        },
        success: function (result) {
            console.log(result);
            //使用拼接字符串拼接用户头像
            let appImg = "<img  src='../" + result.photo + "' alt='user-img' id='user-img'/>";
            $("#user-img-div").html(appImg);

            //使用拼接字符串拼接用户名称
            let app_uumb_user =
                "<p class='uumb-p'>个人资料名称</p>"
                + "<input type='text' name='name' id='uumb-username' class='layui-input' placeholder='请输入您的名称' value='" + result.name + "'/>";
            $("#uumb-username-div").html(app_uumb_user);

            //使用拼接字符串拼接用户性别
            let app_uumb_sex =
                "<p class='uumb-p'>性别</p>"
                + "<div class='layui-form' id='uumb-sex-select-div'>"
                + "<select id='uumb-sex-select'>"
            if (result.sex === 1) {
                app_uumb_sex +=
                    "<option value='0' >请选择：</option>"
                    + "<option value='1' selected>男</option>"
                    + "<option value='2'>女</option>"
            } else if (result.sex === 2) {
                app_uumb_sex +=
                    "<option value='0' >请选择：</option>"
                    + "<option value='1' >男</option>"
                    + "<option value='2' selected>女</option>"
            }
            app_uumb_sex +=
                "</select>"
                + "</div>"
            $("#uumb-sex-div").html(app_uumb_sex);
            // 添加Layui表单重新渲染
            layui.use('form', function(){
                var form = layui.form;
                form.render('select'); // 重新渲染所有select
            });

            //使用拼接字符串拼接用户生日
            let app_birthday =
                "<p class='uumb-p'>生日</p>"
                + "<input type='text' class='layui-input' id='birthday-select' name='birthday' placeholder='yyyy-MM-dd' value='"+result.birthDate+"'>"
            $("#uumb-birthdate-div").html(app_birthday);
            //// 添加Layui日期重新渲染
            layui.use(function () {
                var laydate = layui.laydate;
                // 渲染
                laydate.render({
                    elem: '#birthday-select'
                });
            });

            //使用拼接字符串拼接用户手机号
            let app_phone =
                "<p class='uumb-p'>手机号</p>"
                + "<input type='text' name='phone' id='phone' class='layui-input'  value='" + result.phone + "'/>";
            $("#uumb-phone-div").html(app_phone);

            //使用拼接字符串拼接用户签名
            let app_signature =
                "<p class='uumb-p'>个人签名</p>"
                + "<input type='text' name='signature' id='signature' class='layui-input' value='"+result.signature+"' />";
            $("#uumb-signature-div").html(app_signature);
        }
    })
})

function updateUser() {
    let name = $("#uumb-username").val();
    let sexNum = $("#uumb-sex-select").val();
    let birthday = $("#birthday-select").val();
    let phone = $("#phone").val();
    let signature = $("#signature").val();

    let flag = checkUpdateNull(name, sexNum, birthday, phone, signature);
    let flagPhone = phoneNumber(phone);
    if (flag) {
        if (flagPhone) {
            /*alert("进入ajax");*/
            $.ajax({
                url: "/userUpdateController/updateUser",
                type: "get",
                javaType: "json",
                data: {
                    name: name,
                    sex: sexNum,
                    birthday: birthday,
                    phone: phone,
                    signature: signature,
                    id: sessionStorage.getItem("userId")
                },
                success: function (data) {
                    if (data === "success") {
                        alert("修改成功");
                        window.location.href = "/userMessage/updateUser";
                    } else {
                        alert("修改失败");
                    }
                }
            })
        }
    }
}

// 校验手机号
function phoneNumber(phone){
    let flagPhone = false;
    const reg = /^1(3\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\d|9[0-35-9])\d{8}$/;
    if(reg.test(phone.trim())){
        flagPhone = true;
    }else{
        alert("请输入正确的手机号");
    }
    return flagPhone;
}

// 校验修改信息是否为空
function checkUpdateNull(name, sexNum, birthday, phone, signature) {
    if (!name || name.trim() === "") {
        alert("用户名不能为空");
        return false;
    }
    if (!sexNum || sexNum == 0) {
        alert("请选择性别");
        return false;
    }
    if (!birthday) {
        alert("请选择生日");
        return false;
    }
    if (!phone || phone.trim() === "") {
        alert("手机号不能为空");
        return false;
    }
    if (!signature || signature.trim() === "") {
        alert("签名不能为空");
        return false;
    }
    return true;
}

function back(){
    window.location.href = "/userMessage/updateUser";
}