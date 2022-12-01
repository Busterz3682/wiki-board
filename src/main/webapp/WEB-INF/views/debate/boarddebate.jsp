<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	토론페이지
	<table>
		<thead>
			<tr>
				<td>문서제목 :</td>
				<td>${debatedetail[0].docTitle}</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${debatedetail }">
				<tr>
					<td>작성자 : ${item.email }</td>
					<td>작성일 : ${item.regDate }</td>
				</tr>
				<tr>
					<td colspan="2">내용 : ${item.content }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<textarea rows="3" cols="20" name="replycontent" id="replycontent"></textarea>
	<button id="insertButton">댓글작성</button>
</body>
</html>