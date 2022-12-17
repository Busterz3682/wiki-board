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
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/resources/wikipedia-template/apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/wikipedia-template/style.css">
<script
	src="${pageContext.request.contextPath}/resources/wikipedia-template/js/vendor/modernizr-2.8.3.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
					<li><a href="http://localhost:8181/wiki/getRandomDoc">임의의
							문서로</a></li>
					<li><a href="http://localhost:8181/wiki/getDocList">전체 문서
							목록으로</a></li>
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
				<span class="user">로그인 안됨</span> <a href="#">Talk</a> <a
					href="#">Contributions</a> <a href="#">계정 만들기</a> <a
					href="http://localhost:8181/user/loginPage">Log in</a>
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
					<input type="text" name="docTitle" id="searchInput"
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
				<form action="${pageContext.request.contextPath}/user/join" method="post"
					class="validation-form" novalidate enctype="multipart/form-data"
					onsubmit="return formcheck()" name="fc">
					<div class="mb-4">
						<label for="email">이메일</label> <input type="email"
							class="form-control" id="email" placeholder="you@example.com"
							required name="email"> <span id="msgId"></span>
					</div>

					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="emailCode">인증코드</label> <input type="text"
								class="form-control" id="emailCode" placeholder="" value=""
								required name="emailCode"> <span id="msgCodeChk"></span>
						</div>

						<div class="col-md-6 mb-3">
							<button class="btn btn-info code" type="button" id="codeChk"
								style="display: none">확인</button>
						</div>
						<button class="btn btn-info code2" type="button" id="sendCode">이메일
							인증코드 발송하기</button>
					</div>
					<div class="mb-3">
						<label for="password">비밀번호(*)</label> <input type="password"
							class="form-control" id="password" placeholder="비밀번호" required
							name="password"> <span id="msgPw"></span>
						<div class="invalid-feedback">비밀번호.</div>
					</div>
					<label for="passwordCH">비밀번호확인(*)</label> <input type="password"
						class="form-control" id="pwChk" placeholder="비밀번호 확인"
						required name="pwChk"> <span id="msgPwChk"></span>
					<button class="btn btn-info btn-lg btn-block" type="submit">가입하기</button>
				</form>

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
	/* submit formcheck */
	function formcheck(){
		/*1.공백체크*/
		let rtn = false;
		  if(fc.email.value === '') {
			  alert("이메일을 입력해주세요.");
		      fc.id.focus();
		  } else if(fc.emailCode.value === '') {
			  alert("이메일 인증코드를 확인해주세요");
			  fc.emailCode.focus();
		  } else if(fc.password.value === '') {
			  alert("비밀번호를 입력해주세요");
			  fc.pw.focus();
		  } else if(fc.pwChk.value === '') {
			  alert("비밀번호를 입력해주세요");
			  fc.pwChk.focus();
		/*2.올바르지않은입력값*/
		  } else if($("#sendCode").text() != "인증되었습니다") {
			  alert("이메일 인증을 진행해주세요")
			  fc.emailCode.focus();
		  } else if(fc.password.value != fc.pwChk.value){
			  alert("비밀번호가 일치하지 않습니다")
			  fc.password.focus();
		  } else {
			  alert('회원가입이 완료되었습니다');
			  rtn = true;
		  }
		  return rtn;
	}
	/*이메일 인증코드 발송*/
	var code = "";
	$('#sendCode').click(function() {
		if($('#email').val() == "") {
			alert('아이디(이메일)을 입력해주세요.');
			return;
		} 
		$("#sendCode").attr('disabled', true);
		const id = $('#email').val();
		$.ajax({
			type: "post",
			url: "http://localhost:8181/user/idCheck",
			data: {"email" : id},
			dataType: "text",
			success: function(result) {
				if(result == "ok"){
					$.ajax({
						type: "post",
						url: "http://localhost:8181/user/mailCheck",
						data: {"email" : id},
						dataType : "text",
						success: function(result) {
							if(result != 'notvalid'){
								$('#codeChk').show();
								code = result;
								alert('인증번호가 발송되었습니다 이메일을 확인해주세요');
								document.getElementById("sendCode").innerHTML = "인증번호가 발송되었습니다";
								document.getElementById("sendCode").style.backgroundColor = "gray";
							} else {
								alert('메일전송실패');
								$("#sendCode").attr('disabled', false);
							}
						},
						error: function() {
							alert('오류발생');
						}
					});	
				} else if(result == 'exist') {
					alert('이미 가입된 이메일입니다');
					$("#sendCode").attr('disabled', false);
				}
				
			},
			error: function() {
				alert('서버에러 입니다. 관리자에게 문의하세요.');
				location.reload();
			}
		});	
	});
	/* 인증번호 확인 */
	let inputCode = document.getElementById("emailCode");
	$('#codeChk').click(function(){
		if( code === document.getElementById("emailCode").value ){
			$('#email').attr('readonly', true);
			$('#emailCode').attr('readonly', true);
			$('#codeChk').hide();
			document.getElementById("sendCode").innerHTML = "인증되었습니다";
		} else {
			alert('인증번호가 일치하지 않습니다 이메일을 확인해주세요');
			$('#emailCode').focus();
		}
	});
	/*아이디 형식(이메일) 검사 스크립트*/
	let id = document.getElementById("email");
	id.onkeyup = function() {
	    var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	    if(regex.test(document.getElementById("email").value )) {
	        document.getElementById("email").style.borderColor = "green";
	        document.getElementById("msgId").innerHTML = "사용가능한 이메일입니다."; 
	    } else {
	        document.getElementById("email").style.borderColor = "red";
	        document.getElementById("msgId").innerHTML = "형식에 맞지 않는 이메일입니다";
	    }
	}
	</script>
</body>


</html>