<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체문서목록(토론)</title>
</head>
<body>
	<p>문서 제목을 누르면 해당 문서에 대한 토론페이지로 이동합니다</p>
    <table>
        <thead>
            <tr>
                <td>문서번호</td>
                <td>문서제목</td>
                <td>문서내용</td>
                <td>작성일자</td>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="list" items="${doclist }">
            <tr>
                <td>${list.docId }</td>
                <td><a href="http://localhost:8181/debate/debatedetail?docTitle=${list.docTitle}">${list.docTitle}</a></td>
                <td>${list.docContent }</td>
                <td>${list.docDate }</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>

</body>
</html>