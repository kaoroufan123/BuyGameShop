layui.use('element', function () {
    var element = layui.element;
});

layui.use('form', function () {
    var form = layui.form;
})

//判断输入框是否为空
function checkMessage(email, password) {

    // 验证邮箱格式的正则表达式
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    // 非空验证
    if (email === "" || password === "") {
        alert("邮箱和密码不能为空！");
        return false;
    } else {
        // 邮箱格式验证
        if (!emailRegex.test(email)) {
            alert("邮箱格式不正确！");
            return false;
        }
    }
    return true;
}


//登录按钮点击事件
 function login() {
    var email = $("#email").val();
    var password = $("#password").val();

    var timestamp = Date.parse(new Date());//获取当前时间戳
    let timeY = format(timestamp);

    let flag = checkMessage(email, password);
    if (flag) {
/*        alert("正在进行前端登录验证");*/
        //使用AJAX进行GET请求后端查询
        $.ajax({
            url:"login/loginUser",
            dataType:"JSON",
            type:"GET",
            data:{
                "email":email,
                "password":password
            },
            success:function (result) {
                if (result.code == 200){
                    alert(result.msg);
                    updateLogTimeJS(email,timeY);
                    window.location.href = "/login/index";
                }else {
                    $("#errorMsg").text(result.msg).show();
                }
            }
        })
    }
}

function format(dataString) {
    //dataString是整数，否则要parseInt转换
    var time = new Date(dataString);
    var year = time.getFullYear();
    var month = time.getMonth()+1;
    var day = time.getDate();
    var hour = time.getHours();
    var minute = time.getMinutes();
    var second = time.getSeconds();
    return year+'-'+(month<10?'0'+month:month)+'-'+(day<10?'0'+day:day)+' '+(hour<10?'0'+hour:hour)+':'+(minute<10?'0'+minute:minute)+':'+(second<10?'0'+second:second)
}

function  updateLogTimeJS(email,logTime){
    $.ajax({
        url:"login/updateLogTime",
        dataType:"JSON",
        type:"GET",
        data:{
            "logTime":logTime,
            "email":email
        }
    })
}

