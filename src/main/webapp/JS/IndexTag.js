$(function () {
    $.ajax({
        url: "/index/findAllTags",
        type: "POST",
        dataType: "JSON",
        success: function (data) {
            /*console.log(data);*/
            let app="";
            for (let i = 0; i < data.length; i++) {
                app = app +
                    "<a href='/SearchTag.jsp?tag="+data[i].tagName+"' class='tagLink' style='text-decoration: none'>" + data[i].tagName + "</a><br/>";
            }
            $("#tag").html(app);
        }
    })
})