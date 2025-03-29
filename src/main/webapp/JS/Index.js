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

    setTimeout(function () {

        // 调用 ajaxGet 函数
        ajaxGet(function (appGames) {

            // 插入新内容到轮播图
            $('#carouselItem').append(appGames);

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
});

function searchGame() {
    let searchName = document.getElementById("search-text").value;
    window.location.href = "../SearchGames.jsp?searchName=" + searchName;
}


