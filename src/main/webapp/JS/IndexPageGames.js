let nowPage;
let pageAll;

$(function () {
    $.ajax({
        url: "/index/findGamesPage",
        type: "get",
        dataType: "json",
        data: "nowPage=" + 1,
        success: function (data) {
            /*console.log(data);*/
            PageAll(data);
        }
    })
})

function PageAll(data) {
    $("#all-games").empty();

    nowPage = data.nowPage;
    pageAll = data.pageAll;

    let app = "";
    for (let i = 0; i < data.gameProductList.length; i++) {
        let price = data.gameProductList[i].price;
        let priceText;
        if (price == 0) {
            priceText = "免费开玩";
        } else {
            priceText = "￥" + price;
        }

        let date = data.gameProductList[i].issuingDate;
        const dateParts = date.split('-');
        const formatted = `${dateParts[0]}年${parseInt(dateParts[1])}月${parseInt(dateParts[2])}日`;

        app = app +
            " <div class = 'games'>"
            + "<a href='/index/indexGamesMessage?id="+data.gameProductList[i].id+"' class='games-alink' style='text-decoration: none'>"
            + "<img src='../" + data.gameProductList[i].gamePhoto + "' alt='" + data.gameProductList[i].name + "' class='img'/>"
            + "<div class='games-message'>"
            + "<div class='games-text'>" + data.gameProductList[i].name + "</div>"
            + "<div class='games-publisher'>" + data.gameProductList[i].publishersList[0].name + "</div>"
            + "<div class='games-tag'>" + data.gameProductList[i].tag + "</div>"
            + "</div>"
            + "<div class='games-message-right'>"
            + "<div class='games-price'>" + priceText + "</div>"
            + "<div class='games-issuingDate'>" + formatted + "</div>"
            + "</div>"
            + "</a>"
            + "</div>"
    }
    $("#all-games").append(app);

    /*console.log(app);*/

    document.getElementById("currentPage").textContent = nowPage;
    document.getElementById("totalPage").textContent = pageAll;

}


//首页
function pageHeader() {
    $.ajax({
        url: "/index/findGamesPage",
        type: "get",
        dataType: "json",
        data: "nowPage=" + 1,
        success: function (data) {
            PageAll(data);
        }
    })
}

//上一页
function pageUp() {
    /*console.log("上一页点击开始判断前的nowpage是："+nowPage);*/
    if (nowPage != 1) {
        $("#tab").empty();
        nowPage = nowPage - 1;
        $.ajax({
            url: "/index/findGamesPage",
            data: "nowPage=" + nowPage,
            dataType: "JSON",
            type: "POST",
            success: PageAll
        })
    } else {
        alert("已经是第一页了");
    }
}

//下一页
function pageDown() {
    console.log("下一页点击开始判断前的nowPage是：" + nowPage);
    if (nowPage == pageAll) {
        alert("已经是最后一页了");
    } else {
        $("#tabDiv").empty();
        nowPage = nowPage + 1;
        $.ajax({
            url: "/index/findGamesPage",
            data: "nowPage=" + nowPage,
            dataType: "JSON",
            type: "POST",
            success: PageAll
        })
    }
}

//页脚
function pageFooter() {
    $("#tabDiv").empty();
    nowPage = pageAll;
    $.ajax({
        url: "/index/findGamesPage",
        data: "nowPage=" + pageAll,
        dataType: "JSON",
        type: "POST",
        success: PageAll
    })

}

