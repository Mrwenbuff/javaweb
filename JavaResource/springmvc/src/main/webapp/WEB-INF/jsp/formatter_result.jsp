<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>日期：<fmt:formatDate value="${ formatter.date }" pattern="yyyy-MM-dd"/></li>
		<li>小数：<fmt:formatNumber value="${ formatter.decimal }" pattern="#,##0.00"/></li>
		<li>百分比：<fmt:formatNumber value="${ formatter.percent }" pattern="#0.00%"/></li>
	</ul>
</body>
</html>