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
        <label for="first">Старый логин:</label>
        <input class=box type="text" name="login" id="login" value="${login}"><br>
        <label for="second">Старый пароль: </label>
        <input class=box type="text" name="password" id="password" value="${password}"><br><br>
        <label for="first">Новый логин:</label>
        <input class=box type="text" name="login" id="login" value="${login}"><br>
        <label for="second">Новый пароль: </label>
        <input class=box type="text" name="newPassword" id="newPassword" value="${newPassword}"><br><br>
        <input class=btn type="submit" name="create" value="Создать">
        <input class=btn type="submit" name="change" value="Изменить">
        <input class=btn type="submit" name="del" value="Удалить"><br><br>
        <input class=btn type="submit" name="back" value="Назад">
</center>
	</form>
    </body>
</html>
