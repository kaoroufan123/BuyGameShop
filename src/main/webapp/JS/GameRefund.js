layui.use('element', function() {
    var element = layui.element;
});

$(function() {
    $.ajax({
        url: "/GameRefund/findGPByUserId",
        type: "get",
        dataType: "json",
        data:{
            id:sessionStorage.getItem("userId")
        },
        success: function (data) {
            console.log(data);
            let app = "";
            for (let i = 0; i < data.length; i++) {
                app +=
                    "<a href='/refundMessage/linkRM?gpId="+data[i].gameproduct_id+"' class='game_list_link'>"
                    +"<div class='game_list_div'>"
                    +"<div class='game_image_div'>"
                    +"<img src='../"+data[i].table_gameProduct[0].gamePhoto+"' alt='game-refund-image' class='game_image'/>"
                    +"</div>"
                    +"<div class='game_text'>"+data[i].table_gameProduct[0].name+"</div>"
                    +"<div class='game_list_icon_div'>"
                    +"<i class='layui-icon layui-icon-triangle-r game_list_icon' style='font-size: 20px;color: rgb(160,179,203);'></i>"
                    +"</div>"
                    +"</div>"
                    +"</a>"
            }
            $("#game_list_header_div").html(app);
        }
    })
})