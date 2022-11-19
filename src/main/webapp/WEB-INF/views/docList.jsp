<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체문서목록</title>
</head>
<body>
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
                <td><a href="http://localhost:8181/wiki/getDoc?docTitle=${list.docTitle}">${list.docTitle}</a></td>
                <td>${list.docContent }</td>
                <td>${list.docDate }</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>

</body>
</html>