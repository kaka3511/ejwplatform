<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>EMS收银台</title>  
</head>  
<link rel="stylesheet" href="http://www.huaaotech.tech/static/assets/css/bootstrap.min.css" />
<script src="http://www.huaaotech.tech/static/js/jquery.js"></script>
<script src="http://www.huaaotech.tech/static/assets/js/bootstrap.min.js"></script>
<body> 

<script type="text/javascript">
window.jQuery || document.write("<script src='/static/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
 
<script type="text/javascript">
var recordId = "${recordId}";
var token = "${token}";
$(document).ready(function(){
	$.post("/api/ems/emsPay.do", {"id": recordId, "token": token}, function(data){
		if(data.code > 0){
			$("#msg").html(data.msg);
		}else{
			$.each(data.data, function(key, value){
				$('input[name="'+key+'"]').val(value);
			});
			$("#ems_form").submit();
		}
	});
	
});

</script>
<div class="container-fluid">
  <h4 id="msg">正在跳转到EMS收银台.....</h4>
<!-- 测试支付URL  <form id="ems_form" action="http://211.156.193.150/EMSPay-test/payEnter" method="post"> -->
  <form id="ems_form" action="http://211.156.193.150/EMSPay/payEnter" method="post">
      <input name="bizOrderNo" type="hidden" value=""/>
      <input name="orderName" type="hidden" value=""/>
      <input name="bizType" type="hidden" value=""/>
      <input name="payType" type="hidden" value=""/>
      <input name="payAmount" type="hidden" value=""/>
      <input name="currency" type="hidden" value=""/>
      <input name="appKey" type="hidden" value=""/>
      <input name="charset" type="hidden" value=""/>
      <input name="payWay" type="hidden" value=""/>
      <input name="sign" type="hidden" value=""/>
</form>
</div>
</body>  
</html>  
