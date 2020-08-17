// //跳转页数
// function page_click(item) {
//     //获取点击项的id
//     var pageItemId = $(item).attr("id");
//     //首页
//     if (pageItemId == "firstPage") {
//         var page = 1;
//         $("#firstPage").attr("href","/pageSelectStudent/"+page);
//     }
//     //上一页
//     if (pageItemId == "beforePage") {
//         pageNumber = $("#currentPage").attr("value");
//         var page = pageNumber - 1;
//         $("#beforePage").attr("href","/pageSelectStudent/"+page);
//     }
//     //下一页
//     if (pageItemId == "nextPage") {
//         pageNumber = parseInt($("#currentPage").attr("value"));
//         var totalNumber = $("#totalPage").val();
//         var page = pageNumber + 1;
//         $("#nextPage").attr("href","/pageSelectStudent/"+page);
//     }
//     //尾页
//     if (pageItemId == "lastPage") {
//         var page = $("#totalPage").val();
//         $("#lastPage").attr("href","/pageSelectStudent/"+page);
//     }
// }