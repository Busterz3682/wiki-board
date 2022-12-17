<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Wikipedia Template</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="canonical" href="http://html5-templates.com/" />
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/wikipedia-template/apple-touch-icon.png">
	<!-- Place favicon.ico in the root directory -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/wikipedia-template/style.css">
	<script src="${pageContext.request.contextPath}/resources/wikipedia-template/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<div class="wrapAll clearfix">
		<div class="sidebar">
			<div class="logo">
				<a href="/"><img src='${pageContext.request.contextPath}/resources/wikipedia-template/img/logo.png' alt="logo"></a>
			</div>
			<div class="navigation">
				<ul>
					<li><a href="http://localhost:8181">대문으로</a></li>
					<li><a href="http://localhost:8181/wiki/getRandomDoc">임의의 문서로</a></li>
					<li><a href="http://localhost:8181/wiki/getDocList">전체 문서 목록으로</a></li>
				</ul>
				<h3>Interaction</h3>
				<ul>
					<li><a href="http://localhost:8181/wiki/insertDoc">문서 작성</a></li>
					<li><a href="#">도움말</a></li>
					<li><a href="#">정책과 지침</a></li>
				</ul>
				<c:if test="${sessionScope.user.grade == 'admin' }">
					<h3>관리자 전용</h3>
					<ul>
						<li><a href="http://localhost:8181/wiki/getReqList">삭제요청목록</a></li>
					</ul>
				</c:if>
			</div>


		</div>
		</div>
		<div class="mainsection">
			<div class="headerLinks">
				<c:if test="${sessionScope.user == null }">
					<span class="user">로그인 안됨</span> <a href="#">Talk</a> <a href="#">Contributions</a> <a
						href="http://localhost:8181/user/join">계정 만들기</a> <a href="http://localhost:8181/user/loginPage">Log in</a>
				</c:if>
				<c:if test="${sessionScope.user != null }">
					<span class="user">${sessionScope.user.email }</span> <a href="#">Talk</a> <a href="#">Contributions</a><a href="http://localhost:8181/user/logout">Log out</a>
				</c:if>
					<ul id="searchResult">
          		
          			</ul>
			</div>
			<div class="tabs clearfix">
				<div class="tabsLeft">
					<ul>
						<li><a href="#" class="active">문서</a></li>
						<li><a href="#">토론</a></li>
					</ul>
				</div>
				<div id="simpleSearch">
					<input type="text" name="searchInput" id="searchInput" placeholder="Search Wikipedia" size="12" />
					<div id="submitSearch"></div>
				</div>
				<div class="tabsRight">
					<ul>
						<li><a href="#" class="active">Read</a></li>
						<li><a href="#">View source</a></li>
						<li><a href="#">View history</a></li>
					</ul>
				</div>

			</div>
			<div class="article">
				<h1>전체 문서 목록</h1>
				<p class="siteSub">삭제요청이 들어온 문서 목록</p>
				<p class="roleNote"></p>

				
				<div class="content">
					<div class="container">
						<h2 class="mb-5">Table #${page.currPage }</h2>
						<div class="table-responsive">
							<table class="table table-striped custom-table">
								<thead>
									<tr>
										<th scope="col">문서제목</th>
										<th scope="col"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${reqList }">
										<tr scope="row">
											<td>${list }</td>
											<td>
											<form action="http://localhost:8181/wiki/deleteDoc/${list }" method="post">
												<button type="submit">삭제하기</button>
											</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<c:if test="${page.prev }">
								<a href="getReqList?currpage=${page.startBlock-1}"><c:out
										value="이전" /></a>
							</c:if>
							<c:forEach var="index" begin="${page.startBlock}"
								end="${page.endBlock }">
								<c:if test="${index==page.currPage }">
									<c:out value="${index }" />
								</c:if>
								<c:if test="${index!=page.currPage }">
									<a href="getReqList?currpage=${index}">${index }</a>
								</c:if>
							</c:forEach>
							<c:if test="${page.next }">
								<a href="getReqList?currpage=${page.endBlock + 1}"><c:out
										value="다음" /></a>
							</c:if>
						</div>
					</div>
				</div>

			</div>
			<div class="pagefooter">
				This page was last edited on 29.07.2017 | Template by <a href="http://html5-templates.com/"
					target="_blank" rel="nofollow">HTML5 Templates</a> <!-- Please leave this link unchanged -->
				<div class="footerlinks">
					<a href="#">Privacy policy</a> <a href="#">About</a> <a href="#">Terms and conditions</a> <a
						href="#">Cookie statement</a> <a href="#">Developers</a>
				</div>
			</div>


		</div>
	</div>


	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		window.jQuery || document.write('<script src="js/vendor/jquery-1.12.0.min.js"><\/script>')
	</script>
	<script src="script.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>

</body>

</html>