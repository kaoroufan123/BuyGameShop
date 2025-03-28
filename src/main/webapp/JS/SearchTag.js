layui.use('element', function () {
    var element = layui.element;
});

$(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let tagName = urlParams.get('tag');

    $("#tag-name").html(tagName);

    ajaxFindTag(tagName);

})

function ajaxFindTag(tagName){
    $.ajax({
        url: "/tag/findGamesByTag",
        type: "GET",
        dataType: "JSON",
        data: {
            tag: tagName
        },
        success: function (data) {
            if(data == ""){
                let appNull = "<div id='not-game'>很抱歉，暂未寻找到游戏</div>";
                $("#search-games-list").html(appNull);
            }else {
                let app = "";
                for (let i = 0; i < data.length; i++) {
                    let priceText = data[i].price;
                    let price;
                    if(priceText == 0){
                        price = "免费开玩";
                    }else{
                        price = "￥"+priceText;
                    }
                    app = app +
                        "<div class='games'>"
                        +"<a href='/index/indexGamesMessage?id="+data[i].id+"' class='games-link'>"
                        +"<img src='../"+data[i].gamePhoto+"' alt='"+data[i].name+"'  class='games-photo' />"
                        +"<div class='games-message'>"
                        +"<div class='games-text'>"+data[i].name+"</div>"
                        +"<div class='games-issuingDate'>"+data[i].issuingDate+"</div>"
                        +"<div class='games-price'>"+price+"</div>"
                        +"</div>"
                        +"</a>"
                        +"</div>"
                }
                $("#search-games-list").html(app);
            }

        }
    })
}