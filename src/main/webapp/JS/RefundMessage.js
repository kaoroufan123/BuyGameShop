layui.use('element', function () {
    var element = layui.element;
});

$(function () {
    $.ajax({
        url: "/refundMessage/findGameById",
        type: "get",
        dataType: "json",
        data: {
            userId: sessionStorage.getItem("userId")
        },
        success: function (data) {
            console.log(data);

            let dateTime = changeDate(data.addTime);
            let app =
                  "<div id='game_IaT'>"
                +"<div id='game_image_div'>"
                +"<img src='../"+data.table_gameProduct[0].gamePhoto+"' alt='game-image' id='game_image'/>"
                +"</div>"
                +"<div id='game_name_text'>"+data.table_gameProduct[0].name+"</div>"
                +"</div>"
                +"<div id='game_ad'>"
                +"<div id='username_text' class='game_ad_text'>账户:<span id='username'>&nbsp;"+data.table_user[0].name+"</span>"
                +"</div>"
                +"<div id='addTime_text' class='game_ad_text'>购买日期:<span id='addTime'>&nbsp;"+dateTime+"</span></div>"
                +"<span id='game_price' hidden>"+data.table_gameProduct[0].price+"</span>"
                +"<span id='game_id_text' hidden>"+data.table_gameProduct[0].id+"</span>"
                +"<div id='refund_btn_div'>"
                +"<input type='button' class='layui-btn' id='refund_btn' value='退款' onclick='onclickRefund()'/>"
                +"</div>"
                +"</div>";
            $("#game_fBody").html(app);
        }
    })
})

function onclickRefund(){
    let refundCheck = confirm("确定退款吗？");
    if(refundCheck){
        alert("执行退款操作");

        $.ajax({
            url: "/refundMessage/refundGame",
            type: "get",
            data: {
                newBalance: document.getElementById("game_price").innerHTML,
                userId: sessionStorage.getItem("userId"),
                gpId: document.getElementById("game_id_text").innerHTML
            },
            success: function (data) {
                console.log(data);
                if(data.code === "200"){
                    alert("退款成功");
                    window.location.href = "/GameRefund/linkGR";
                }else if(data.code === "500"){
                    alert("退款失败");
                }
            }
        })
    }
}


function changeDate(dateStr){
    const [year, month, day] = dateStr.split('-');
    return `${year}年${month}月${day}日`;
}