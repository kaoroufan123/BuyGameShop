layui.use('element', function () {
    var element = layui.element;
})

layui.use('form', function () {
    var form = layui.form;
})

/*//监听提交
form.on('submit(formDemo)', function (data) {
    layer.msg(JSON.stringify(data.field));
    return false;
});*/

function regUser() {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let checkPassword = document.getElementById("checkPassword").value;
    let phone = document.getElementById("phone").value;
    let checkBox = document.getElementById("checkbox").checked;
    let regTime = new Date().toISOString().slice(0, 19).replace('T', ' ');

    /*    alert(email+" "+password+" "+checkPassword+" "+phone+" "+checkBox+" "+regTime);*/

    if (name=="" || email == "" || password == "" || checkPassword == "" || phone == "") {
        alert("请输入完整信息！");
    } else {
        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(email)) {
            alert("请输入正确的邮箱格式！");
        } else {
            if (password != checkPassword) {
                alert("两次密码输入不一致！");
            } else {
                if (checkBox == false) {
                    alert("请勾选同意服务条款！");
                } else {
                    reg(name,email,password,phone,regTime);
                }
            }
        }
    }
}

function reg(name,email,password,phone,regTime) {
   /* alert("name="+name+" email="+email+" password="+password+" phone="+phone+" regTime="+regTime);*/

    $.ajax({
        async: false,
        type: "get",
        url: "/registerUser/checkUserEmail",
        dataType: "text",
        data: {
            email: email
        },
        success: function (data) {
            alert(data);
            if (data == "has") {
                alert("邮箱已存在！");
            } else if (data == "none") {
                $.ajax({
                    async: false,
                    type: "get",
                    url: "/registerUser/insertUser",
                    dataType: "text",
                    data: {
                        name: name,
                        email: email,
                        password: password,
                        phone: phone,
                        regTime: regTime
                    },
                    success: function (result) {
                        if(result == "success"){
                            alert("注册成功！");
                            document.forms[0].action="../RegisterSuccess.jsp";
                            document.forms[0].submit();
                        }else{
                            alert("注册失败！");
                        }
                    }
                })
            }
        }
    })
}
