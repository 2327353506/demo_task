
Vue.prototype.$get = function(url, fuc, err){
    $("#loading").show();
    $.get(url,function(data){
        fuc(data);
        $("#loading").hide();
    });
}
Vue.prototype.$post = function(url, data, fuc, err){
    $.post(url,data,function(data){
        fuc(data);
        $("#loading").hide();
    });
}
function $alert(val){
    $(".alert_message strong").text(val);
    $(".alert_message").show();
}
function close_message(){
    $(".alert_message").hide();
}

