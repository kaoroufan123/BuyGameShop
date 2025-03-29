layui.use('element', function () {
    var element = layui.element;
});

function rpOnclick(){
    let email = $("#email").val();
    let password = $("#password").val();
    let confirmPassword = $("#password_check").val();

    let flagCheck = rpCheck(email,password,confirmPassword);
    if(flagCheck){
        $.ajax({
            url:"/retrievePassword/findEmail",
            type:"get",
            dataType:"text",
            data:{
                email:email
            },
            success:function (data) {
                if(data === "has"){
                    /*alert("进入修改密码");*/
                    $.ajax({
                        url:"/retrievePassword/updatePassword",
                        type:"get",
                        dataType:"text",
                        data:{
                            email:email,
                            password:password
                        },
                        success:function (data) {
                            if(data === "success"){
                                alert("修改成功");
                                window.location.href = "/loginUser/loginLink";
                            }else{
                                alert("修改失败");
                            }
                        }
                    })
                }else{
                    alert("该邮箱不存在");
                }
            }
        })
    }
}

function rpCheck(email,password,confirmPassword){
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    let flag = false;
    if(email === "" || password === "" || confirmPassword === ""){
        alert("请填写完整信息");
    }else{
        if(!emailRegex.test(email)){
            alert("请输入正确的邮箱格式！");
        }else{
            if(password !== confirmPassword){
                alert("两次密码输入不一致！");
            }else{
                flag = true;
            }
        }
    }
    return flag;
}