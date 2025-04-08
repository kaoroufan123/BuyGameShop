layui.use('element', function () {
    var element = layui.element;
});

let priceAll = 0;
$(function () {


    $.ajax({
        url: "/shopCar/findShopCarByUserId",
        type: "post",
        data: {
            userId: sessionStorage.getItem("userId")
        },
        success: function (result) {

            console.log(result);

            if (result.code == 200 && result.data.length > 0) {
                let app = "";
                for (let i = 0; i < result.data.length; i++) {
                    let price = "";
                    if (!(result.data[i].price == "0")) {
                        price = "￥" + result.data[i].price;
                        priceAll = priceAll + result.data[i].price;
                    }

                    app = app +
                        "<div class='cs_game_bg'>"
                        + "<div class='cs_game'>"
                        + "<div class='cs_game_image_left'>"
                        + "<span class='gameCar_id' hidden>" + result.data[i].id + "</span>"
                        + "<img src='../" + result.data[i].table_gameProduct[0].gamePhoto + "'  alt='game_image' class='game_image' />"
                        + "</div>"
                        + "<div class='cs_game_meg_right'>"
                        + "<div class='cs_game_meg_top'>" + result.data[i].table_gameProduct[0].name + "</div>"
                        + "<div class='cs_game_meg_bottom'>"
                        + "<div class='csgmb_price'>" + price + "</div>"
                        + "<div class='csgmb_remove'>"
                        + "<a href='#' class='csgmb_remove_link' onclick='onClickRemove(" + result.data[i].id + ")'>移除</a>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "</div>";
                }
                $("#cs_game_list").html(app);
            } else {
                $("#cs_game_list").html("<div id='notGame_inCar'>还未在购物车内添加商品</div>");
            }
            /*console.log(priceAll);*/
            $("#pay_price").html("￥" + priceAll);
        }
    })
})

function onClickRemove(gameId) {

    console.log(gameId);

    const spanElement = document.querySelector(".gameCar_id");
    const value = spanElement.textContent;
    console.log("value is:"+value);
    $.ajax({
        url: "/shopCar/deleteShopCarByUserId",
        type: "get",
        data: {
            id: gameId
        },
        success: function (result) {
            console.log(result);
            if (result.code == 200 && result.data == 1) {
                alert("移除成功");
                window.location.reload();
            } else {
                alert("移除失败");
            }
        }
    })
}

function onClickPay() {
    let price = document.getElementById("pay_price").innerHTML;
    console.log("总价格是：" + price);
    if (price == "￥0") {
        alert("请先添加商品");
    } else {
        /*alert("支付中");*/
        //查询用户余额
        $.ajax({
            url: "/userMessage/findUserBalanceById",
            type: "post",
            data: {
                userId: sessionStorage.getItem("userId")
            },
            success: function (result) {
                /*console.log(result);
                console.log(result.data);
                console.log(priceAll);*/
                let oldBalance = result.data;
                if(priceAll > result.data){
                    alert("余额不足，请充值");
                }else{
                    console.log("余额充足，进入购买");
                    //查询购物车中所有的游戏id
                    $.ajax({
                        url: "/shopCar/findShopCarByUserId",
                        type: "post",
                        data: {
                            userId: sessionStorage.getItem("userId")
                        },
                        success: function (result) {
                            console.log(result);
                            if (result.code == 200 && result.data.length > 0) {
                                //循环遍历购物车中的游戏id，生成订单
                                for (let i = 0; i < result.data.length; i++) {
                                    $.ajax({
                                        url: "/shopCar/insertUwh",
                                        type: "post",
                                        data: {
                                            orderNumber: orderNumberFun(),
                                            userId: sessionStorage.getItem("userId"),
                                            gpId: result.data[i].table_gameProduct[0].id,
                                            payTime: nowTime()
                                        },
                                        success: function (result) {
                                            //如果购物车中的游戏删除成功
                                            console.log(result);
                                            if (result.code == 200 && result.data == 1) {
                                                //用户余额 - 购物车总价格
                                                $.ajax({
                                                    url: "/shopCar/updateUserBalance",
                                                    type: "post",
                                                    data: {
                                                        userId: sessionStorage.getItem("userId"),
                                                        balance: oldBalance - priceAll
                                                    },
                                                    success: function (result) {
                                                        console.log(result);
                                                        if (result.code == 200 && result.data == 1) {
                                                            alert("购买成功");
                                                            window.location.href = "/GameInventory/Inventory";
                                                        } else {
                                                            alert("购买失败");
                                                        }
                                                    }
                                                })
                                            } else {
                                                alert("删除失败");
                                            }
                                        }
                                    })
                                }
                            }
                        }
                    })
                }

            }
        })


    }
}


//当前时间，精确到秒
function  nowTime(){
    const date = new Date();
    const formattedTime = date
        .toLocaleString("zh-CN", {
            year: "numeric",
            month: "2-digit",
            day: "2-digit",
            hour: "2-digit",
            minute: "2-digit",
            second: "2-digit",
            hour12: false, // 使用 24 小时制
        })
        .replace(/\//g, "-") // 将斜杠替换为短横
        .replace(/,/g, "");  // 移除逗号（某些语言环境会添加）

    return formattedTime;
}

//订单编号生成器
function orderNumberFun(){
    const now = new Date();

    // 生成时间部分（年月日时分秒，共14位）
    const year = now.getFullYear(); // 4位
    const month = String(now.getMonth() + 1).padStart(2, '0'); // 补零
    const day = String(now.getDate()).padStart(2, '0');
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');
    const seconds = String(now.getSeconds()).padStart(2, '0');

    // 生成四位随机数（1000-9999）
    const randomPart = Math.floor(Math.random() * 9000 + 1000);

    // 拼接完整订单号
    return `${year}${month}${day}${hours}${minutes}${seconds}${randomPart}`;
}
