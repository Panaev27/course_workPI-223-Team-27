<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Авторизация калькулятора расчета цены ангара</title>
</head>
<body>
<h1 class=titl>Авторизация</h1>
    <form action="${pageContext.request.contextPath}/JavaAuth" method="post" class=lab>
<center>
        <label for="first">Логин:</label>
        <input class=box type="text" name="login" id="login" value="${login}"><br>
        <label for="second">Пароль: </label>
        <input class=box type="text" name="password" id="password" value="${password}"><br>
        <input class=btn type="submit" name="input" value="Войти">
</center>
	</form>
    </body>
</html>
