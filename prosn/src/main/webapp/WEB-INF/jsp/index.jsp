<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--로그인 안되어 있을 때--%>
<c:if test="${userId eq null}">
    <a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=6ed2b72fdabc00402337b642bd55e31c&redirect_uri=
http://localhost:8080/kakaoLogin">
        <img src="img/kakaologin.png">
    </a>
</c:if>
<c:if test="${userId ne null}">
    <h1>로그인 성공입니다</h1>
    <input type="button" value="로그아웃" onclick="location.href='/logout'">
</c:if>
</body>

</html>
