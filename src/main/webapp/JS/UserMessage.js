layui.use('element', function () {
    var element = layui.element;
});

$(function (){
let app = "";
    $.ajax({
        url:"/userMessage/findUserMessageById",
        type:"GET",
        dataType:"JSON",
        data:{
            userId:sessionStorage.getItem("userId")
        },
        success:function (data){
            console.log(data);
            app = app+
                "<img src='../"+data[0].photo+"' alt='用户照片'  id='user-img'/>"
                +"<div id='user-name-div'>"
                +"<span id='user-name'>"+data[0].name+"</span>"
                +"<span id='user-signature'>"+data[0].signature+"</span>"
                +"<div id='update-btn-div'>"
                +"<input type='button' id='update-btn' class='layui-btn' value='修改个人资料' onclick='updateUser()'/>"
                +"</div>"
                +"</div>";
            $("#basic-information").html(app);
            $("#user-title").html("用户信息："+data[0].name);
            findUserGames();
        }
    })
})

function findUserGames(){
    $.ajax({
        url:"/userMessage/findUserGamesById",
        type:"GET",
        dataType:"JSON",
        data:{
            userId:sessionStorage.getItem("userId")
        },
        success:function (dataList){
            findUserGameProduct(dataList);
        }
    })
}

function findUserGameProduct(dataList){
    console.log(dataList);
    let appList = "";
    for(let i = 0;i<dataList.length;i++){
        let date = changeDate(dataList[i].addTime);
        /*console.log(date);*/
        appList = appList
            +"<div class='games-ware'>"
            +"<a href='/index/indexGamesMessage?id="+dataList[i].gameproduct_id+"' class='games-img-link'>"
            +"<img src='../"+dataList[i].table_gameProduct[0].gamePhoto+"' alt='games-photo' class='game-img'/>"
            +"</a>"
            +"<div class='games-text-div'>"
            +"<a href='/index/indexGamesMessage?id="+dataList[i].gameproduct_id+"' class='games-text'>"+dataList[i].table_gameProduct[0].name+"</a>"
            +"</div>"
            +"<div class='game-buyTime-div'>"
            +"<span class='game-buyTime'>"+date+"</span>"
            +"</div>"
            +"</div>"
    }
    $(".games-ware-div").html(appList);
}

function changeDate(dateStr){
    const [year, month, day] = dateStr.split('-');
    /*console.log(chineseDate); */// 输出
    return `${year}年${month}月${day}日`;
}

function updateUser(){
    window.location.href = "/userMessage/updateUser";
}