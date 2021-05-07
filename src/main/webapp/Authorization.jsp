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

        <label class=lab for="first">Логин:</label>
        <input class=box type="text" name="login" id="login" value="${login}">
        <label class=lab for="second">Пароль: </label>
        <input class=box type="text" name="password" id="password" value="${password}">
        <input class=btn type="submit" name="input" value="Войти">

    </body>
</html>
