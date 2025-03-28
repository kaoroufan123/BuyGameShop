layui.use('element', function () {
    var element = layui.element;
});

//轮播图
layui.use('carousel', function () {
    var carousel = layui.carousel;
    var $ = layui.$;

    //建造实例
    var carouselInstance = carousel.render({
        elem: '#carousel',
        width: "1000px",
        height: "465px",//设置容器宽度
        arrow: 'always',//始终显示箭头
        anim: 'fade',
        /*change: function (obj) {
            let currentIndex = obj.index(); // 获取当前图片索引
            console.log("下标是：" + currentIndex);
            updateTextContent(currentIndex);
        }*/
    });


    let gameData;

    function ajaxGet(callback) {    //使用Ajax查找所有游戏数据
        $.ajax({

            url: "/index/findAllGames",
            type: "GET",
            dataType: "JSON",
            success: function (data) {
                /*console.log(data);*/
                gameData = data;
                /*拼接字符串*/
                let appGames = "";
                for (let i = 0; i < data.length; i++) {
                    appGames = appGames +
                        "<div class='img-div'><a href='/index/indexGamesMessage?id=" + data[i].id + "'><img src='../" + data[i].gamePhoto + "'  alt='" + data[i].name + "' class='rec-img' style='width: 1000px   ;'/></a></div>"
                }
                /*console.log(appGames);*/
                if (typeof callback === 'function') {
                    callback(appGames); // 将 appGames 传递给回调函数
                }
            }
        })
    }

    //触发轮播切换事件
    /*    let index = 1;
        carousel.on('change(carousel)', function(obj){
            //当前条目的索引
           /!* console.log(obj.index);*!/
            index = obj.index;
        });*/

    setTimeout(function () {

        // 调用 ajaxGet 函数
        ajaxGet(function (appGames) {

            // 插入新内容到轮播图
            $('#carouselItem').append(appGames);

            /*updateTextContent(index);*/

            // 重新渲染轮播图（假设 carouselInstance 已定义）
            if (carouselInstance && typeof carouselInstance.reload === 'function') {
                carouselInstance.reload({
                    height: '465px'
                });
            } else {
                console.error("轮播图实例未正确初始化");
            }
        })
    });

    // 定义更新文本内容的函数
    /*function updateTextContent(index) {
        if(gameData[index]) {
            const currentGame = gameData[index];
            console.log(currentGame);
            $("#game-text").text(currentGame.name);
            $("#game-publisher").text(currentGame.publishersList[0].name);
            if(currentGame.price === 0){
                $("#game-price").text("免费开玩");
            }else{
                $("#game-price").text("￥"+currentGame.price);
            }
        }
    }*/

});

function searchGame() {
    let searchName = document.getElementById("search-text").value;
    window.location.href = "../SearchGames.jsp?searchName=" + searchName;
}


