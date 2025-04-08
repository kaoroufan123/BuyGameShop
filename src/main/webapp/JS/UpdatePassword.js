layui.use('element', function () {
    var element = layui.element;
});



function updatePassword(){
    let oldPassword = document.getElementById("oldPassword").value;
    let password = document.getElementById("password").value;
    let password_check = document.getElementById("password_check").value;

    /*console.log(oldPassword+","+password+","+password_check);*/
    if(PasswordCheck(oldPassword,password,password_check)){
        $.ajax({
            url: "/apiUP/updatePassword",
            type: "POST",
            data: {
                userId: sessionStorage.getItem("userId"),
                oldPassword: oldPassword,
                password: password
            },
            success: function (result) {
                /*console.log(result);*/
                if(result.code === "200"){
                    alert("修改成功，请重新登录");
                    window.location.href = "/auth/logout";
                }else if (result.code === "500"){
                    alert("修改失败！");
                }
            }
        })
    }
}

function PasswordCheck(oldPassword,password,password_check){
    let flag;
    if(oldPassword === "" || password === "" || password_check === ""){
        alert("请输入完整信息！");
        flag = false;
    }else{
        if(password === password_check){
            flag = true;
        }else{
            alert("两次密码输入不一致！");
            flag = false;
        }
    }
    return flag
}