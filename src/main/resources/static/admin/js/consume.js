
$(function(){
    $("#page").Page({
        totalPages: 9,//分页总数
        liNums: 7,//分页的数字按钮数(建议取奇数)
        activeClass: 'activP', //active 类样式定义
        callBack : function(page){
            console.log(page)
            var curWwwPath=window.document.location.href;
            var pathName=window.document.location.pathname;
            var pos=curWwwPath.indexOf(pathName);
            var localhostPaht=curWwwPath.substring(0,pos);
            var url = localhostPaht+'/admin/consume/consumeList';
            $.ajax({
                url:url,
                type:"POST",
                data:{pageNum:page,pageSize:'5'},
                success:function (data) {
                    $('#content').empty();
                    console.log(data.desc);
                    var desc = JSON.parse(data.desc);
                    var arr = desc.data;
                    var html = '';
                    console.log(arr.length);
                    console.log(arr);
                    for ( var i = 0; i <arr.length; i++){
                        html +='<div style="text-align: center">\n' +
                            '        <p>时间：'+arr[i].TConsumeDate+'</p>\n' +
                            '        <p>地点：'+arr[i].TConsumePlace+'</p>\n' +
                            '        <p>用户：'+arr[i].TConsumeUser+'</p>\n' +
                            '        <p>类型：'+arr[i].TConsumeType+'</p>\n' +
                            '        <p>金额：'+arr[i].TConsumeMoney+'</p>\n' +
                            '    </div>\n' +
                            '    <div style="height: 1px;background-color: #3bc0c3;"></div>';
                    }
                    $('#content').append(html);

                }
            });
        }
    });
});
function toSave() {
    window.location.href="/admin/consume/toConsume";
}