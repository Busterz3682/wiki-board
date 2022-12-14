<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Wikipedia Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="canonical" href="http://html5-templates.com/" />
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/resources/wikipedia-template/apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/wikipedia-template/style.css">
<script
	src="${pageContext.request.contextPath}/resources/wikipedia-template/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<div class="wrapAll clearfix">
		<div class="sidebar">
			<div class="logo">
				<a href="/"><img
					src='${pageContext.request.contextPath}/resources/wikipedia-template/img/logo.png'
					alt="logo"></a>
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
			</div>


		</div>
		<div class="mainsection">
			<div class="headerLinks">
				<span class="user">Not logged in</span> <a href="#">Talk</a> <a
					href="#">Contributions</a> <a href="#">Create account</a> <a
					href="#">Log in</a>
			</div>
			<div class="tabs clearfix">
				<div class="tabsLeft">
					<ul>
						<li><a href="#" class="active">문서</a></li>
						<li><a href="http://localhost:8181/debate/debatedetail/${doc.docTitle }">토론</a></li>
					</ul>
				</div>
				<div id="simpleSearch">
					<input type="text" name="searchInput" id="searchInput"
						placeholder="Search Wikipedia" size="12" />
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
				<h1>${doc.docTitle } <a href="http://localhost:8181/wiki/updateDoc/${doc.docTitle }">[편집]</a></h1>
				<p class="siteSub">이 문서의 마지막 수정 시간은 ${doc.docDate } 입니다</p>
				<p class="roleNote">${doc.docContent }</p>

				<div class="articleRight">
					<div class="articleRightInner">
						<img
							src="${pageContext.request.contextPath}/resources/wikipedia-template/img/pencil.jpg"
							alt="pencil" />
					</div>
					This is a blue <a href="">pencil</a>
				</div>
				<div class="contentsPanel">
					<div class="contentsHeader">목차</div>
					<ul>
						<c:forEach items="${chapter }" var="item">
							<li><span>${item.chapterIndex }</span><a href="#">${item.chapterTitle }</a></li>
						</c:forEach>
					</ul>
				</div>
				<c:forEach items="${chapter }" var="item">
					<h2>${item.chapterIndex}.${item.chapterTitle }</h2>
					<c:forEach items="${detail }" var="itemdt">
						<c:if test="${item.chapterIndex == itemdt.chapterIndex }">
							<p>${itemdt.chapterContent }</p>
						</c:if>
					</c:forEach>
				</c:forEach>

				<div class="lavenderBox">
					<div class="header">여기는 추후에 추가예정</div>
					<div class="subtitle linklist">
						<a href="#">여기는</a> <a href="#">뭐할지</a> <a href="#">고민중</a>
					</div>
					<div class="linklist">
						<a href="#">Percipit </a> <a href="#">Mnesarchum </a> <a href="#">Molestie
						</a> <a href="#">Phaedrum </a> <a href="#">Luptatum constituam </a> <a
							href="#">Habeo adipisci </a> <a href="#">Inani zril </a> <a
							href="#">Forensibus sea </a> <a href="#">Habeo adipisci </a> <a
							href="#">Minimum corrumpit </a> <a href="#">Regione suscipit
						</a> <a href="#">Has et partem </a><a href="#">Percipit </a> <a
							href="#">Mnesarchum </a> <a href="#">Molestie </a> <a href="#">Phaedrum
						</a> <a href="#">Luptatum constituam </a> <a href="#">Habeo
							adipisci </a> <a href="#">Inani zril </a> <a href="#">Vel nisl
							albucius </a> <a href="#">Habeo adipisci </a> <a href="#">Minimum
							corrumpit </a> <a href="#">Regione suscipit </a> <a href="#">Percipit
							maiestatis </a> <a href="#">Regione suscipit </a> <a href="#">Percipit
							maiestatis </a>
					</div>

					<div class="subtitle">Subtitle</div>
				</div>

				<div class="categories">
					<a href="#">Minimum corrumpit </a> <a href="#">Regione suscipit
					</a> <a href="#">Has et partem </a>
				</div>

			</div>
			<div class="pagefooter">
				This page was last edited on 29.07.2017 | Template by <a
					href="http://html5-templates.com/" target="_blank" rel="nofollow">HTML5
					Templates</a>
				<!-- Please leave this link unchanged -->
				<div class="footerlinks">
					<a href="#">Privacy policy</a> <a href="#">About</a> <a href="#">Terms
						and conditions</a> <a href="#">Cookie statement</a> <a href="#">Developers</a>
				</div>
			</div>


		</div>
	</div>


	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="${pageContext.request.contextPath}/resources/wikipedia-template/js/vendor/jquery-1.12.0.min.js"><\/script>')
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/wikipedia-template/script.js"></script>


</body>

</html>