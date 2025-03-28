layui.use('element', function () {
    var element = layui.element;
});

function getPublisherGames(publisherName) {
    console.log(publisherName);
    $.ajax({
        url: "/gamePublisher/findGameProductWithPublisherName",
        type: "GET",
        dataType: "JSON",
        data: {
            name: publisherName
        },
        success: function (data) {
            console.log(data);

            let app = "";
            let price;
            for (let i = 0; i < data.length; i++) {
                if(data[i].price == 0){
                    price = "免费开玩";
                }else{
                    price = "￥"+data[i].price;
                }
                app = app +
                     "<div  class='game-product-div'>"
                    +"<a href='/index/indexGamesMessage?id="+data[i].id+"' class='game-product-link'>"
                    +"<img src='../"+data[i].gamePhoto+"' alt='"+data[i].name+"' />"
                    +"<div class='game-product-message'>"
                    +"<div class='game-product-name'>"+data[i].name+"</div>"
                    +"<div class='game-product-intro'>"+data[i].gameIntro+"</div>"
                    +"<div class='game-product-price'>"+price+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</a>"
                    + "</div>"

                console.log(app);
                $("#game-product-list").html(app);
            }
        }
    })

}
