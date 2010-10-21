function igo_common(method, text, callback_name) {
    var enc_text = encodeURIComponent(text);
    var query = "text="+enc_text+"&callback="+callback_name;
    var url = "http://igo-morp.appspot.com/"+method+"_jsonp?"+query;
    
    var elem = document.createElement('div'); 
    elem.innerHTML = "<script type='text/javascript' src='"+url+"'><\/script>";
    document.getElementById("igo_jsonp_block").appendChild(elem);
}
function igo_parse(text, callback_name) {
    igo_common("parse", text, callback_name);
}

function igo_wakati(text, callback_name) {
    igo_common("wakati", text, callback_name);
}

document.write("<div id='igo_jsonp_block'></div>");