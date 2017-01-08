function GetJsonFunction() {
    var endpoint = 'live'
    var access_key = 'a45fdf9f9b647ff727568bb298baf486';
    var currencies = $('#to').val();
    var url = 'http://apilayer.net/api/' + endpoint + '?access_key=' + access_key + "&currencies=" + currencies;
    $("#link").attr("href", url.toString());
    var jqxhr = $.getJSON(url, function (data) {
        var x = 'USD' + currencies;
        var arr = data['quotes'];
        var tmp = JSON.stringify(arr[x]);
        $("#toAmount").val(tmp);
    })
}
