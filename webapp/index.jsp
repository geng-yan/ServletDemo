<%@ page language="java" import = "java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在Form表单中使用验证码</title>
<script type="text/javascript">
//刷新验证码
function changeImg(){
	document.getElementById("validateCodeImg").src = "/drawimage?"+Math.random();
}
</script>
</head>
<body>
<form action="/checkservlet" method="post">
验证码 <input type="text" name = "validateCode"/>
<img alt="验证码看不清换一张" src="/drawimage" id = "validateCodeImg" onclick="changeImg()">
<a href="javascript:void(0)" onclick="changeImg()">看不清换一张</a>
<br />
<input type="submit" value="提交">
</form>
</body>
</html>