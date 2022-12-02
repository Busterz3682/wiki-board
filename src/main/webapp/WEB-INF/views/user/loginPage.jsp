<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/user/userLogin" method="post">
        <ul>
        	<li>로그인페이지</li>
            <label for="">EMAIL</label>
            <li><input type="text" name="email" id="email"></li>
            <label for="">PW</label>
            <li><input type="password" name="pw" id="pw"></li>
        </ul>
    <input type="submit" value="Login"></form>
    </form>
</body>
</html>