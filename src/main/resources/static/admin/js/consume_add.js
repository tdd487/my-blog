$(function () {
    loadSelect();
});
function loadSelect() {
    $('#tConsumeType').empty();
    $.ajax({
        url:'/admin/consumeSelect/consumeList',
        type:"POST",
        success:function (data) {
            console.log(data)
            var desc = JSON.parse(data.desc);//数组
            var arr = desc.data;
            var html = '';
            for(var i =0;i<arr.length;i++) {
                html += '<option value="'+arr[i].TConsumeTypeOption+'">'+arr[i].TConsumeTypeValue+'</option>'
            }
            $('#tConsumeType').append(html);
        }
    });
}
function save() {

    var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    var localhostPaht=curWwwPath.substring(0,pos);
    var url = localhostPaht+'/admin/consume/saveConsume';
    var tConsumeType = $('#tConsumeType').val();
    var tConsumeUser = $('#tConsumeUser').val();
    var tConsumeMoney = $('#tConsumeMoney').val();
    var tConsumePlace = $('#tConsumePalce').val();
    var tConsumeDate = new Date();

    $.ajax({
        url:url,
        type:"POST",
        data:{tConsumeType:tConsumeType,
            tConsumeUser:tConsumeUser,
            tConsumeMoney:tConsumeMoney,
            tConsumePlace:tConsumePlace,
            tConsumeDate:tConsumeDate},
        success:function (data) {
            console.log(data)
            layer.msg("保存成功");
            setTimeout(function () {
                window.location.href="/admin/consume/toConsumeList";
            }, 500);

        }
    });
}
function saveSelect(selectValue){
    var length = $("#tConsumeType option").length;
    if(length>0) {
        length = length+1;
    }
    $.ajax({
        url:'/admin/consumeSelect/saveConsume',
        type:"POST",
        data:{tConsumeTypeOption:length,tConsumeTypeValue:selectValue},
        success:function (data) {
            console.log(data)
            var desc = JSON.parse(data.desc);
            var descCode = desc.respCode;
            if('0000'===descCode) {
                layer.msg(desc.respDesc);
                loadSelect();
            }
        }
    });
}
function addOption() {
    var html='';
    layer.open({
        content: '选项：<input id="selectValue" value="你好"/>'
        ,btn: ['保存']
        ,yes: function(index, layero){
            //按钮【按钮一】的回调
            console.log($('#selectValue').val());
            var selectValue = $('#selectValue').val();
            saveSelect(selectValue);
        }
    });
}