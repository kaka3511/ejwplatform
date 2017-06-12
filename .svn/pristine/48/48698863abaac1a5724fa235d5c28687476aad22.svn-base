
var apiHost = "http://"+window.location.host;
//var apiHost = "https://www.huaaotech.date";
function sendApi(callback, api, params, page, pageSize){
	if(params == null){
		params = {};
	}
	if(page != null){
		params.page = page;
	}
	if(pageSize != null){
		params.pageSize = pageSize;
	}
	if(api.indexOf("/") > 1){
		api = "/"+api;
	}
 
	if(params.method == null){
		params.method = "POST";
	}
	jQuery.ajax ({ 
		url: apiHost+api+".do", 
		type:params.method, 
		data: params, 
		headers: params.headers,
		contentType:"application/x-www-form-urlencoded; charset=UTF-8", 
		success: function(result){ 
			callback(result);
		}
	});
 
}

function initApiUrl(api, params, page, pageSize){
	if(params == null){
		params = {};
	}
	if(page != null){
		params.page = page;
	}
	if(pageSize != null){
		params.pageSize = pageSize;
	}
	if(api.indexOf("/") > 1){
		api = "/"+api;
	}
	return apiHost+api+".do?"+parseParam(params);
}

var parseParam = function(param, key) {
    var paramStr = "";
    if (param instanceof String || param instanceof Number || param instanceof Boolean) {
        paramStr += "&" + key + "=" + encodeURIComponent(param);
    } else {
        $.each(param, function(i) {
            var k = key == null ? i : key + (param instanceof Array ? "[" + i + "]" : "." + i);
            paramStr += '&' + parseParam(this, k);
        });
    }
    return paramStr.substr(1);
};
 
function countTotalPages(pageInfo){
	if(pageInfo == null){
		return 1;
	}
	// "records":328,"page":1,"pageSize":10
	var i = pageInfo.records/pageInfo.pageSize  ;
	if(pageInfo.records % pageInfo.pageSize != 0){
		i ++;
	}
	return Math.floor(i);
}

function computerJqgridPage(grid_selector ,pageBtn){
	var page = $(grid_selector).getGridParam('page');
	if(pageBtn == 'user'){
		page = $(".ui-pg-input").val();
	}
	if(pageBtn == 'first_grid-pager'){
		page = 1;
	}
	if(pageBtn == 'prev_grid-pager'){
		page = page - 1;
	}
	if(pageBtn == 'next_grid-pager'){
		page = page + 1;
	}
	if(pageBtn == 'user'){
		page = $(".ui-pg-input").val();
		
	}
	
	if(page < 1){
		page = 1;
	}
	if(page > total_pages){
		page = total_pages;
	}
	return page;
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}