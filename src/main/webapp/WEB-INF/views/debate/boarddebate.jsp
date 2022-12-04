<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
	<textarea rows="3" cols="20" name="content" id="content"></textarea>
	<button type="button" id="insertReplyBtn">댓글작성하기</button>
	<input type="hidden" name="docTitle" id="docTitle"
		value="${debatedetail[0].docTitle}">
	<input type="hidden" name="email" id="email" value="Email-댓글작성테스트중">
</body>
<script>
	window.onload = function() {
		//댓글 등록 with ajax
		$('#insertReplyBtn').click(function() {
			var docTitleA = $('#docTitle').val();
			var emailA = $('#email').val();
			var contentA = $('#content').val();
			if (contentA === '') {
				alert('내용을 입력해주세요');
			} else {
				$.ajax({
					type : "POST",
					url : "<c:url value='/debate/insertreply'/>",
					dataType : "json",
					data : {
						docTitle : docTitleA,
						email : emailA,
						content : contentA
					},
					success : function(result) {
						if (result == 1) {
							alert('댓글등록성공');
							location.reload();
						} else {
							alert('오류발생');
						}
					}
				});
			}
		});
	}
</script>
</html>