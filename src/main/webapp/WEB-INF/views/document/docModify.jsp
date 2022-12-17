<%@page import="java.util.ArrayList"%>
<%@page import="com.side.wiki.vo.DetailVO"%>
<%@page import="java.util.List"%>
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
<script>
let ci = 2;
function addChapter(){
	  let addFrm = '<h2><input type="text" name="chapterTitle" id="chapterTitle" placeholder="목차를 입력해주세요" value="'+ ci +'"><input id="addChap" type="button" onClick="addChapter()" value="추가"></h2>'
    +'<p><textarea name="chapterContent'+ci+'" id="chapterContent" cols="30" rows="10">'+ ci +'</textarea></p><input id="addCont" type="button" onClick="addContent()" value="추가">'
    +'<input type="hidden" name="chapterIndex" value="'+ ci +'">';
    $('#inputWrap').append(addFrm);
    ci++;
	}

function addContent(){
	let addFrm = '<p><textarea name="chapterContent'+ (ci-1) +'" id="chapterContent" cols="30" rows="10">'+ (ci-1) +'</textarea></p><input id="addCont" type="button" onClick="addContent()" value="추가">';
	$('#inputWrap').append(addFrm);
	
}
</script>	
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
					<span class="user">${sessionScope.user.email }</span> <a href="#">Talk</a> <a href="#">Contributions</a><a href="http://localhost:8181/user/logout">Log out</a>
				</c:if>
					<ul id="searchResult">
          		
          			</ul>
			</div>
			<div class="tabs clearfix">
				<div class="tabsLeft">
					<ul>
						<li><a href="http://localhost:8181/wiki/getDoc/${doc.docTitle }" class="active">문서</a></li>
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
			<form method="post" action="http://localhost:8181/wiki/updateDoc">
				<h1><input type="text" name="docTitle" id="docTitle" value="${doc.docTitle}" readonly="readonly"></h1>
				<p class="siteSub">위키백과, 우리 모두의 백과사전.</p>
				<p class="roleNote"><input type="text" name="docContent" id="docContent" value="${doc.docContent }"></p>

				<div class="articleRight">
					<div class="articleRightInner">
						<img src="img/pencil.jpg" alt="pencil" />
					</div>
					This is a blue <a href="">pencil</a>
				</div>
				<c:forEach items="${chapter }" var="item">
					<h2><input type="text" name="chapterTitle" id="chapterTitle" value="${item.chapterTitle }"></h2>
					<c:forEach items="${detail }" var="itemdt">
						<c:if test="${item.chapterIndex == itemdt.chapterIndex }">
							<p><textarea name="chapterContent${item.chapterIndex }" id="chapterContent" cols="75" rows="5">${itemdt.chapterContent }</textarea>
								<input type="hidden" name="detailIndex" value="${itemdt.detailIndex }">
							</p>
						</c:if>
					</c:forEach>
				</c:forEach>
				<button type="submit">등록하기</button>
			</form>
				<div class="lavenderBox">
					<div class="header">Panel title</div>
					<div class="subtitle linklist"><a href="#">Lorem</a> <a href="#">Ipsum</a> <a
							href="#">Dolorestitas</a> </div>
					<div class="linklist">
						<a href="#">Percipit </a> <a href="#">Mnesarchum </a> <a href="#">Molestie </a> <a
							href="#">Phaedrum </a> <a href="#">Luptatum constituam </a> <a href="#">Habeo adipisci </a>
						<a href="#">Inani zril </a> <a href="#">Forensibus sea </a> <a href="#">Habeo adipisci </a> <a
							href="#">Minimum corrumpit </a> <a href="#">Regione suscipit </a> <a href="#">Has et partem
						</a><a href="#">Percipit </a> <a href="#">Mnesarchum </a> <a href="#">Molestie </a> <a
							href="#">Phaedrum </a> <a href="#">Luptatum constituam </a> <a href="#">Habeo adipisci </a>
						<a href="#">Inani zril </a> <a href="#">Vel nisl albucius </a> <a href="#">Habeo adipisci </a>
						<a href="#">Minimum corrumpit </a> <a href="#">Regione suscipit </a> <a href="#">Percipit
							maiestatis </a> <a href="#">Regione suscipit </a> <a href="#">Percipit maiestatis </a>
					</div>

					<div class="subtitle">Subtitle</div>
				</div>

				<div class="categories">
					<a href="#">Minimum corrumpit </a> <a href="#">Regione suscipit </a> <a href="#">Has et partem </a>
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
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>

</body>

</html>