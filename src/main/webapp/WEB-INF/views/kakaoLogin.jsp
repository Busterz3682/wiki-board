<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>Kakao JavaScript SDK</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="scripts/main.js"></script>
  <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.0/kakao.min.js"
  integrity="${INTEGRITY_VALUE}" crossorigin="anonymous"></script>
  <script>
    // SDK�� �ʱ�ȭ �մϴ�. ����� ���� JavaScript Ű�� �����ؾ� �մϴ�.
    Kakao.init('ab255285e93608e5f37b506d95555b22');

    // SDK �ʱ�ȭ ���θ� �Ǵ��մϴ�.
    console.log(Kakao.isInitialized());
    
  </script>
  <a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
    alt="īī�� �α��� ��ư" />
</a>
<p id="token-result"></p>

<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:8181/kakao'
    });
  }

  let code =
  
  console.log
	
</script>
</head>
<body></body>
</html>