<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/res/SMValidator.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		hello world!success!
		<!-- 
		<form action="<%=request.getContextPath() %>/mvc/login">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"  /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"  /></td>
				</tr>
				<tr>
					<td>验证码：<input type="text" name="verificationCode"  /></td>
					<td><img  src="<%=request.getContextPath() %>/mvc/image" id="img">
					<a href='javascript:changeImg();'>看不清？</a>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="登录" /></td>
					<td><input type="reset" name="重置"  /></td>
				</tr>
			</table>
		
		</form>
		 -->
	<script>
    /* new SMValidator('form', {
        required: '请输入内容',
        failCss: 'error',
        failStyle: {color:'#c3f', border:'1px solid #f00'},
        passCss: 'success',
        passStyle: {color: '#090'},
        failHtml: ["<b style='color:#f00'></b>", "!<b style='color:#f00'>×</b>"],
        rules: {
            onlyLetter: [/^[A-Z]*$/i, '请输入字母']
        },
        fields: {
        	username: 'required',
        	password: 'required'
        },
        submit: function(valid, form) {
            if(valid) form.submit();
        }
    }); */
    
</script>

<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img"); 
        img.src = "<%=request.getContextPath() %>/mvc/image?date=" + new Date();
    }
</script>
</body>
</html>