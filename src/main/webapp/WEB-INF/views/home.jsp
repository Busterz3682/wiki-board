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
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
		<div class="mainsection">
			<div class="headerLinks">
				<c:if test="${sessionScope.user == null }">
					<span class="user">로그인 안됨</span> <a href="#">Talk</a> <a href="#">Contributions</a> <a
						href="http://localhost:8181/user/join">계정 만들기</a> <a href="http://localhost:8181/user/loginPage">Log in</a>
				</c:if>
				<c:if test="${sessionScope.user != null }">
					<span class="user">${sessionScope.user.email }</span> <a href="#">Talk</a> <a href="#">Contributions</a><a href="#">Log out</a>
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
					<input type="text" name="docTitle" id="searchInput" placeholder="Search Wikipedia" size="12" />
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
			<div class="main-box main-top" style="flex: 10;">
				<div class="main-top-left">
				<p><span style="font-size: 1.8rem; margin-top: 0; margin-bottom: .1em;"><a href="/wiki/%EC%9C%84%ED%82%A4%EB%B0%B1%EA%B3%BC:%EC%86%8C%EA%B0%9C" title="위키백과:소개">
				<span style="color: black; font-weight: bold;">위키백과</span></a></span>
				</p>
				<p style="font-size: 1rem; margin-top: .1em; margin-bottom: 1em;">우리 모두가 만들어가는 자유 백과사전<span class="nomobile"><br/>문서 <a href="/wiki/%EC%9C%84%ED%82%A4%EB%B0%B1%EA%B3%BC:%ED%86%B5%EA%B3%84" title="위키백과:통계"><span style="color: #246ad3;"><b>616,518</b></span></a>개와 최근 기여자 <a href="/wiki/%EC%9C%84%ED%82%A4%EB%B0%B1%EA%B3%BC:%ED%86%B5%EA%B3%84" title="위키백과:통계"><span style="color: #246ad3;"><b>1,704</b></span></a>명</span></p>
        		</div>
			</div>
				대문페이지입니다

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
		window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/wikipedia-template/js/vendor/jquery-1.12.0.min.js"><\/script>')
	</script>
	<script src="${pageContext.request.contextPath}/resources/wikipedia-template/script.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>

</body>

</html>