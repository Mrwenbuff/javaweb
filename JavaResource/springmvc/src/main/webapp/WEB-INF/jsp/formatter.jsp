<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="formatter">
		<p>
			<label>日期：</label>
			<form:input path="date"/>
		</p>
		<p>
			<label>小数：</label>
			<form:input path="decimal"/>
		</p>
		<p>
			<label>百分比：</label>
			<form:input path="percent"/>
		</p>
		<p>
			<label></label>
			<button type="submit">提交数据</button>
		</p>
	</form:form>
</body>
</html>