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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
.tip {
  width: 0px;
  height: 0px;
  position: absolute;
  background: transparent;
  border: 10px solid #ccc;
}

.tip-up {
  top: -25px; /* Same as body margin top + border */
  left: 10px;
  border-right-color: transparent;
  border-left-color: transparent;
  border-top-color: transparent;
}

.tip-down {
  bottom: -25px;
  left: 10px;
  border-right-color: transparent;
  border-left-color: transparent;
  border-bottom-color: transparent;  
}

.tip-left {
  top: 10px;
  left: -25px;
  border-top-color: transparent;
  border-left-color: transparent;
  border-bottom-color: transparent;  
}

.tip-right {
  top: 10px;
  right: -25px;
  border-top-color: transparent;
  border-right-color: transparent;
  border-bottom-color: transparent;  
}

.dialogbox .body {
  position: relative;
  max-width: 50%;
  height: auto;
  margin: 20px 10px;
  padding: 5px;
  background-color: #DADADA;
  border-radius: 3px;
  border: 5px solid #ccc;
}

.body .message {
  min-height: 30px;
  border-radius: 3px;
  font-family: Arial;
  font-size: 14px;
  line-height: 1.5;
  color: #797979;
}
</style>	
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
					<li><a href="http://localhost:8181">????????????</a></li>
					<li><a href="http://localhost:8181/wiki/getRandomDoc">????????? ?????????</a></li>
					<li><a href="http://localhost:8181/wiki/getDocList">?????? ?????? ????????????</a></li>
				</ul>
				<h3>Interaction</h3>
				<ul>
					<li><a href="http://localhost:8181/wiki/insertDoc">?????? ??????</a></li>
					<li><a href="#">?????????</a></li>
					<li><a href="#">????????? ??????</a></li>
				</ul>
				<c:if test="${sessionScope.user.grade == 'admin' }">
					<h3>????????? ??????</h3>
					<ul>
						<li><a href="http://localhost:8181/wiki/getReqList">??????????????????</a></li>
					</ul>
				</c:if>
			</div>


		</div>
		<div class="mainsection">
			<div class="headerLinks">
				<c:if test="${sessionScope.user == null }">
					<span class="user">????????? ??????</span> <a href="#">Talk</a> <a href="#">Contributions</a> <a
						href="http://localhost:8181/user/join">?????? ?????????</a> <a href="http://localhost:8181/user/loginPage">Log in</a>
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
						<li><a href="http://localhost:8181/wiki/getDoc/${debatedetail[0].docTitle}">??????</a></li>
						<li><a href="#" class="active">??????</a></li>
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
				<h1>?????? : ${debatedetail[0].docTitle}</h1>
				<p class="siteSub">??? ???????????? ?????? ?????? : ${debatedetail[0].docTitle} ??? ?????? ?????? ??????????????????</p>
				<p class="roleNote"></p>

				<div class="articleRight">
					<div class="articleRightInner">
						<img
							src="${pageContext.request.contextPath}/resources/wikipedia-template/img/pencil.jpg"
							alt="pencil" />
					</div>
					This is a blue <a href="">pencil</a>
				</div>
				<div>
					<ul>
						
					</ul>
				</div>
		        <c:forEach var="item" items="${debatedetail }">
					<div class="container">
					  <div class="dialogbox">
					    <div class="body">
					      <span class="tip tip-left"></span>
						      <div class="message">
				        		<span>
									????????? : ${item.writer } ????????? : ${item.regDate }<br>
									?????? : ${item.content }<button style="float: right;"  id="${item.replyNo }" onclick="addDeleteBtn(this.id)">??????</button>
									<input style="float: right;" type="password" id="pw${item.replyNo }">
								</span>
						      </div>
					    </div>
					  </div>
					</div>	
				</c:forEach>
				<div>
					<p>?????????   &nbsp; <input type="text" name="writer" id="writer"></p> <p>???????????? <input type="password" name="password" id="password"></p>
					<textarea rows="3" cols="40" name="content" id="content"></textarea>
					<button type="button" id="insertReplyBtn">??????</button>
					<input type="hidden" name="docTitle" id="docTitle" value="${debatedetail[0].docTitle}">
				</div>
				<div class="lavenderBox">
					<div class="header">????????? ?????? ???????????? ????????????</div>
					<div class="subtitle linklist">
						<a href="#">?????????</a> <a href="#">?????????</a> <a href="#">?????????</a>
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
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
	<script>
	//?????? ?????? with ajax
	$('#insertReplyBtn').click(function() {
		let docTitle = $('#docTitle').val();
		let content = $('#content').val();
		let writer = $('#writer').val();
		let password = $('#password').val();
		if (content === '') {
			alert('????????? ??????????????????');
		} else if(writer === '') {
			alert('???????????? ??????????????????')
		} else if(password ==='') {
			alert('??????????????? ??????????????????')
		} else {
			$.ajax({
				type : "POST",
				url : "http://localhost:8181/debate/insertreply",
				dataType : "json",
				data : {
					"docTitle" : docTitle,
					"content" : content,
					"writer" : writer,
					"password" : password
				},
				success : function(result) {
					if (result == 1) {
						alert('??????????????????');
						location.reload();
					} else {
						alert('????????????');
					}
				}
			});
		}
	});
	
	function addDeleteBtn(clickedId) {
		let docTitle = $('#docTitle').val();
		let pw = $('#pw'+clickedId).val();
		$.ajax({
			type : "POST",
			url : "http://localhost:8181/debate/deletereply",
			dataType : "json",
			data : {
				"docTitle" : docTitle,
				"password" : pw,
				"replyNo" : clickedId
			},
			success : function(result) {
				if (result == 1) {
					alert('????????????');
					location.reload();
				} else {
					alert('????????????');
				}
			}
		})
	}
	
	</script>
</body>

</html>