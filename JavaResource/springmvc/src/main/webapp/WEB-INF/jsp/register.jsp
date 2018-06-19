<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<form:form modelAttribute="user" >
		
		<p>
			<label>用户名：</label>
			<form:input path="username"/>
			<form:errors path="username" delimiter=","/>
		</p>
		<p>
			<label>密码：</label>
			<form:password path="password"/>
			<form:errors path="password" delimiter=","/>
		</p>
		<p>
			<label>姓名：</label>
			<form:input path="name"/>
			<form:errors path="name" delimiter=","/>
		</p>
		<p>
			<label>生日：</label>
			<form:input path="birthday"/>
			<form:errors path="birthday" delimiter=","/>
		</p>
		<p>
			<label>电话：</label>
			<form:input path="phone"/>
			<form:errors path="phone" delimiter=","/>
		</p>
		<p>
			<label>电子邮件：</label>
			<form:input path="email"/>
			<form:errors path="email" delimiter=","/>
		</p>
		<p>
			<label>个人主页：</label>
			<form:input path="url"/>
			<form:errors path="url" delimiter=","/>
		</p>
		<p>
			<label></label>
			<button type="submit">注册</button>
		</p>
	</form:form>
</body>
</html>