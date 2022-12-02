<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="1. ${sessionScope.isLogin } "></c:out><br>
<c:out value="2. ${sessionScope }"></c:out><br>
<c:if test="${sessionScope == null }">
세션끝남
</c:if>
<br>
로그인성공테스트중
</body>
</html>