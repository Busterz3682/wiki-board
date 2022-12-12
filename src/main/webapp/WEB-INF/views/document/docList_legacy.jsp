<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="UTF-8">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/doc-fonts/icomoon/style.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/doc-css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/doc-css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/doc-css/style.css">

<title>Table #${page.currPage }</title>
</head>
<body>
	<div class="content">
		<div class="container">
			<h2 class="mb-5">Table #${page.currPage }</h2>
			<div class="table-responsive">
				<table class="table table-striped custom-table">
					<thead>
						<tr>
							<th scope="col">문서번호</th>
							<th scope="col">문서제목</th>
							<th scope="col">문서내용</th>
							<th scope="col">작성일자</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${doclist }">
							<tr scope="row">
								<td>${list.docId }</td>
								<td>${list.docTitle}</td>
								<td>${list.docContent }</td>
								<td>${list.docDate }</td>
								<td><a
									href="http://localhost:8181/wiki/getDoc?docTitle=${list.docTitle}">상세보기</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${page.prev }">
					<a href="getDocList?currpage=${page.startBlock-1}"><c:out
							value="이전" /></a>
				</c:if>
				<c:forEach var="index" begin="${page.startBlock}"
					end="${page.endBlock }">
					<c:if test="${index==page.currPage }">
						<c:out value="${index }" />
					</c:if>
					<c:if test="${index!=page.currPage }">
						<a href="getDocList?currpage=${index}">${index }</a>
					</c:if>
				</c:forEach>
				<c:if test="${page.next }">
					<a href="getDocList?currpage=${page.endBlock + 1}"><c:out
							value="다음" /></a>
				</c:if>
			</div>
		</div>
	</div>
	<script	src="${pageContext.request.contextPath}/resources/doc-js/jquery-3.3.1.min.js"></script>
	<script	src="${pageContext.request.contextPath}/resources/doc-js/popper.min.js"></script>
	<script	src="${pageContext.request.contextPath}/resources/doc-js/bootstrap.min.js"></script>
	<script	src="${pageContext.request.contextPath}/resources/doc-js/main.js"></script>
</body>
</html>