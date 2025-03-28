layui.use('element', function () {
    var element = layui.element;
});

let gameDataA;
function gameDataNeed(gameData) {
    gameDataA = gameData;
    console.log(gameDataA.name);
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
                console.log(gameDataCarousel);
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
            console.log(appGames);
            $('#carousel-items').append(appGames);

            if (carouselInstance && typeof carouselInstance.reload === 'function') {
                carouselInstance.reload({});
            } else {
                console.error("轮播图实例未正确初始化");
            }
        })
    });
});

function searchInput(){
    let text = document.getElementById("search-games").value;
    window.location.href="../SearchGames.jsp?searchName="+text;
}

//获取标签button上name的值
function getButtonName(buttonElement) {
    let buttonName = buttonElement.textContent;
    console.log(buttonName);
    window.location.href="../SearchTag.jsp?tag="+buttonName;
}




