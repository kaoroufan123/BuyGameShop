layui.use('element', function () {
    var element = layui.element;
});

const params = new URLSearchParams(window.location.search);
const searchName = params.get('searchName');

/*console.log(searchName);*/

$(function () {
    // 使用 ajax获取
    $.ajax({
        url: "/gameProduct/findGameProductLike",
        type: "get",
        dataType: "JSON",
        data: {
            name: searchName
        },
        success: function (data) {
            /*console.log(data);*/
            /*alert(data);*/
            splice(data);
        }
    })
})

function splice(data) {
    if(data == ""){
        let appNull = "<div id='not-game'>很抱歉，暂未寻找到游戏</div>";
        console.log(appNull);
        $("#search-games-list").html(appNull);
    }else{
        let app = "";
        for (let i = 0; i < data.length; i++) {
            let priceText = data[i].price;
            let price;
            if (priceText == 0) {
                price = "免费开玩";
            }else{
                price = "￥"+priceText
            }
            app = app +
                /*class='games-link'*/
                "<div class='games'>"
                + "<a href='/index/indexGamesMessage?id="+data[i].id+"' class='games-link'>"
                + "<img src='../" + data[i].gamePhoto + "' alt='" + data[i].name + "' class='games-photo'/>"
                +"<div class='games-message'>"
                +"<div class='games-text'>"+data[i].name+"</div>"
                +"<div class='games-issuingDate'>"+data[i].issuingDate+"</div>"
                +"<div class='games-price'>"+price+"</div>"
                +" </div>"
                + "</a>"
                + "</div>"
        }
        console.log(app);
        $("#search-games-list").html(app);
    }

}

function searchGamesOnclick(){
    let searchName = $("#search-game-text").val();

    if (searchName == ""){
        window.location.href = "../SearchGames.jsp";
    }else{
        $.ajax({
            url: "/gameProduct/findGameProductLike",
            type: "get",
            dataType: "JSON",
            data: {
                name: searchName
            },
            success: function (data) {
                splice(data);
            }
        })
    }


}