layui.use('element', function () {
    var element = layui.element;
});

let gameDataA;

function gameDataNeed(gameData) {
    gameDataA = gameData;
    /*console.log(gameDataA.name);*/
}

layui.use('carousel', function () {
    var carousel = layui.carousel;
    var $ = layui.$;


    //建造实例
    let carouselInstance = carousel.render({
        elem: '#carousel',
        width: '100%', //设置容器宽度
        arrow: 'always' //始终显示箭头
        //,anim: 'updown' //切换动画方式
    });


    /*    ajaxGameProduct();*/

    let gameDataCarousel;

    function ajaxGameProduct(callback) {
        $.ajax({
            url: "/game/gameScreen?id=" + gameDataA.id,
            type: "GET",
            dataType: "JSON",
            success: function (data) {
                /*console.log(data);*/
                gameDataCarousel = data;
                /*console.log(gameDataCarousel);*/
                /*拼接字符串*/
                let appGames = "";
                for (let i = 0; i < data.length; i++) {
                    appGames = appGames +
                        "<div><img src='/" + data[i].screenShot + "' alt='" + gameData.name + "'/></div>"
                }
                if (typeof callback === 'function') {
                    callback(appGames); // 将 appGames 传递给回调函数
                }
            }
        })

    }

    setTimeout(function () {
        ajaxGameProduct(function (appGames) {
            /*console.log(appGames);*/
            $('#carousel-items').append(appGames);

            if (carouselInstance && typeof carouselInstance.reload === 'function') {
                carouselInstance.reload({});
            } else {
                console.error("轮播图实例未正确初始化");
            }
        })
    });
});

function searchInput() {
    let text = document.getElementById("search-games").value;
    window.location.href = "../SearchGames.jsp?searchName=" + text;
}

//获取标签button上name的值
function getButtonName(buttonElement) {
    let buttonName = buttonElement.textContent;
    /*console.log(buttonName);*/
    window.location.href = "../SearchTag.jsp?tag=" + buttonName;
}

$(function () {
    // 获取URL的查询参数部分
    const queryString = window.location.search;
    // 创建URLSearchParams对象解析参数
    const urlParams = new URLSearchParams(queryString);
    // 直接获取id的值
    const id = urlParams.get('id');



    $.ajax({
        url: "/game/findUWH",
        type: "get",
        data: {
            userId:sessionStorage.getItem("userId"),
            gameId:id
        },
        success: function (data) {
            console.log(data);

            if (data == "11") {
                //如果data = 11就表示用户已经拥有该游戏，需要将购买按钮禁用
                let appBtn = "<button id='game-price-btn' class='layui-btn layui-btn-disabled'>已拥有</button>";
                $("#game-price-btn-div").html(appBtn);
            } else if (data == "101") {
                //如果data = 101就表示用户没有该游戏，但是存在于购物车中，购买按钮value变成已存在于购物车中，点进跳转购物车
                let appJump = "<button id='game-price-btn' class='layui-btn' onclick='linkSC()'>已在购物车</button>";
                $("#game-price-btn-div").html(appJump);
            }else if (data == "1000"){
                //如果data = 1000就表示用户该游戏也没有存在于购物车，点击购买按钮将该游戏存入购物车中
                let appBuy = "<button id='game-price-btn' class='layui-btn' onclick='insGameShopCar(gameDataA)'>获取游戏</button>";
                $("#game-price-btn-div").html(appBuy);
            }
        }
    })
})

function insGameShopCar(gameData) {
    console.log(gameData);

    //判断如何商品价格是免费的，就直接将游戏存入用户的游戏库中，否则就存入购物车中
    /*console.log("价格是："+gameData.price);*/
    if (gameData.price == "0"){

        console.log("订单编号："+orderNumberFun());
        console.log("支付时间："+nowTime());

        $.ajax({
            url: "/game/insertUG",
            type: "POST",
            data:{
                //传入订单编号，用户id，游戏id和支付时间
                orderNumber:orderNumberFun(),
                userId: sessionStorage.getItem("userId"),
                gpId: gameData.id,
                payTime: nowTime()
            },
            success: function (result) {
                console.log(result);
                if(result.code == "200" && result.data == "1"){
                    alert("购买成功");
                    window.location.reload();
                }else{
                    alert("购买失败");
                }
            }
        })
    }else{
        //将商品信息存入购物车中，并跳转购物车页面
        console.log("购物车添加成功");
        $.ajax({
            url: "/game/insertSC",
            type: "GET",
            dataType: "JSON",
            data: {
                userId: sessionStorage.getItem("userId"),
                gpId: gameData.id,
                gamePrice: gameData.price
            },
            success: function (data) {
                console.log(data);
                if (data > "0") {
                    window.location.href = "/game/linkSC";
                } else {
                    alert("购物车添加失败");
                }
            }
        })
    }


}

function linkSC(){
    window.location.href = "/game/linkSC";
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



    
