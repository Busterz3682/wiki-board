<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.1/kakao.min.js"
	integrity="sha384-eKjgHJ9+vwU/FCSUG3nV1RKFolUXLsc6nLQ2R1tD0t4YFPCvRmkcF8saIfOZNWf/"	crossorigin="anonymous">
</script>
<script>
        Kakao.init('ab255285e93608e5f37b506d95555b22'); // 사용하려는 앱의 JavaScript 키 입력
    </script>
</head>

<body>


	<a id="kakao-login-btn" href="javascript:loginWithKakao()"> 
	<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
	</a>
	<script>
	function loginWithKakao() {
	    Kakao.Auth.authorize({
	      redirectUri:'http://localhost:8181/kakao',
	    });
	  }
    </script>
</body>

</html>