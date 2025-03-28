$(function () {
    $.ajax({
        url:"/GameInventory/findGameInventoryByUserId",
        type:"GET",
        javaType: "JSON",
        data:{
            userId:sessionStorage.getItem("userId")
        },
        success:function (result) {
            let resultJSON = JSON.parse(result);
            /*console.log(resultJSON);*/
            /*console.log(resultJSON[0].table_gameProduct[0].gamePhoto);*/
            let app = "";

            for (let i = 0; i < resultJSON.length; i++) {
                app = app
                    + "<a href='/index/indexGamesMessage?id="+resultJSON[i].table_gameProduct[0].id+"' class='scroll-link'>"
                    + "<div class='scroll-game'>"
                    + "<img src='../" + resultJSON[i].table_gameProduct[0].gamePhoto + "' alt='game-image' class='imgs'/>"
                    + "<span class='game-name'>" + resultJSON[i].table_gameProduct[0].name + "</span>"
                    + "</div>"
                    + "</a>"
            }
            /*console.log(app);*/
            $("#body-left-scroll").html(app);
        }
    })

    InventoryImage();
});

function onClickShop() {
        window.location.href = "/login/index";
}

function InventoryImage(){
    $.ajax({
        url:"/GameInventory/findGameInventoryImageByUserId",
        type:"GET",
        javaType: "JSON",
        data:{
            userId:sessionStorage.getItem("userId")
        },
        success:function (data) {
            let dataJSON = JSON.parse(data);
            console.log(dataJSON);


            let appData = "";

            for (let i = 0; i < dataJSON.length; i++) {
                //当取余0时
                let l = i;
                if(i % 5 === 0){
                    appData +=
                        "<div class='game-vertical-list'>"
                        + "<div class='game-vertical'>"
                        + "<a href='/index/indexGamesMessage?id="+dataJSON[i].table_gameProduct[0].id+"'>"
                        + "<img src='../"+dataJSON[i].table_gameProduct[0].table_verticalImgList[0].verticalImage+"' alt='game-image'/>"
                        + "</a>"
                        + "</div>"
                }else{
                    if((l+1)%5 === 0 || (l+1) === dataJSON.length){
                        appData = appData
                            + "<div class='game-vertical'>"
                            + "<a href='/index/indexGamesMessage?id="+dataJSON[i].table_gameProduct[0].id+"'>"
                            + "<img src='../"+dataJSON[i].table_gameProduct[0].table_verticalImgList[0].verticalImage+"' alt='game-image'/>"
                            + "</a>"
                            + "</div>"
                            + "</div>"
                    }else{
                        appData = appData
                            + "<div class='game-vertical'>"
                            + "<a href='/index/indexGamesMessage?id="+dataJSON[i].table_gameProduct[0].id+"'>"
                            + "<img src='../"+dataJSON[i].table_gameProduct[0].table_verticalImgList[0].verticalImage+"' alt='game-image'/>"
                            + "</a>"
                            + "</div>"
                    }

                }
            }
            $("#body-right-imgs").html(appData);
        }
    })
}