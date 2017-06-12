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
var payResult = "${payResult}";
var mailNum = "${mailNum}";
$(document).ready(function(){
	if(payResult == "02"){
		$('#msg').html("您的订单已支付，EMS运单号"+mailNum);
	}
});

</script>
<div class="container-fluid">
  <h4 id="msg">您的订单尚未支付,请进入收银台支付，谢谢！</h4>
</div>
</body>  
</html>  
