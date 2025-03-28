/* 加载 element 模块 */
layui.use('element', function () {
    var element = layui.element;
});

/* 加载日期模块 */
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#establishDate' //指定元素
    });
});

/* 加载form模块 */
layui.use('form', function () {
    var form = layui.form;

    //监听提交
    form.on('submit(formDemo)', function (data) {
        layer.msg(JSON.stringify(data.field));
        return false;
    });
});

function clickBtn(name,account,password,establishDate){
    $.ajax({
        type: "get",
        url: "/BuyGamesShop/registerPublisher",
        dataType: "text",
        data: {
            name: name,
            account: account,
            password: password,
            establishDate: establishDate
        },
        success: function (data) {
            if(data == "success"){
                alert("注册成功！");
                document.forms[0].action="../RegisterSuccess.jsp";
                document.forms[0].submit();
            }else if(data == "fail"){
                alert("注册失败！");
            }
        }
    })
}

/*检查输入的数据是否为空*/
function checkRegister() {
    let name = document.getElementById("name").value;
    let account = document.getElementById("account").value;
    let password = document.getElementById("password").value;
    let checkPassword = document.getElementById("checkPassword").value;
    let establishDate = document.getElementById("establishDate").value;
    let checkBox = document.getElementById("CheckBox").checked;

    var flagNull;
    var flagCheckPassword;
    var flagCheckBox;

    if(name == "" || account == "" || password == "" || checkPassword == "" || establishDate == ""){
        alert("请输入完整信息！");
        flagNull = false;
    }else{
        flagNull = true;
    }

    if(flagNull){
        if(password != checkPassword){
            alert("两次密码输入不一致！");
            flagCheckPassword = false;
        }else{
            flagCheckPassword = true;
        }
    }

    if(!checkBox){
        alert("请同意注册协议！");
        flagCheckBox = false;
    }else{
        flagCheckBox = true;
    }

    if(flagNull && flagCheckPassword&& flagCheckBox){
        clickBtn(name,account,password,establishDate);
    }
}

