<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%if (request.getSession().getAttribute("AuthCorrect")!="true") {
    request.getRequestDispatcher("/Authorization.jsp").forward(request, response);} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Калькулятор расчеты цены ангара</title>
</head>
<body>
<h1 class=titl>Калькулятор расчета цены ангара</h1>
    <form action="${pageContext.request.contextPath}/JavaCalc" method="post" class=lab>
        <label for="first">Длина:</label>
        <input class=box type="text" name="x" id="x" value="${x}">
        <label for="second">Ширина: </label>
        <input class=box type="text" name="y" id="y" value="${y}">
        <label for="third">Высота: </label>
        <input class=box type="text" name="z" id="z" value="${z}"><br>
        <label for="fourth">Выберите тип строительства ангара: </label>
        <select name="type" class=case>
				<option value="0" >Каркасно-рамочные</option>
				<option value="1" >Каркасно-щитовой</option>
		</select><br>
        <label for="fifth">Выберите форму ангара: </label>
        <select name="formHangar" class=case>
				<option value="0" >Арочный </option>
				<option value="1" >Прямостенный</option>
				<option value="2" >Шатровый</option>
		</select><br>
        <label for="sixth">Выберите тип панели: </label>
        <select name="panel" class=case>
				<option value="0" >Облегчённая сендвич-панель</option>
				<option value="1" >Сендвич-панель</option>
				<option value="2" >Утепленная сендвич-панель</option>
		</select><br>
        <label for="seventh">Выберите сроки(мес.): </label>
        <input class=box type="text" name="time" id="time" value="${time}"><br>
        <label for="eighth">Выберите фундамент: </label>
        <select name="foundation" class=case>
				<option value="0" >Отсутствие</option>
				<option value="1" >Каменный</option>
				<option value="2" >Железобетонный</option>
				<option value="3" >Бетонный</option>
		</select><br>
        <label for="ninth">Выберите тип двери: </label> 
        <select name="door" class=case>
				<option value="0" >Распашные</option>
				<option value="1" >Подъёмно-секционные</option>
				<option value="2" >Шторные</option>
				<option value="3" >Рулонные</option>
		</select><br>
        <label for="tenth">Промокод:</label>
        <input class=box type="text" name="promo" id="promo" value="${promo}"><br>
        <input class=btn type="submit" name="sign" value="Вычислить">
    </form>
    
    <form action="${pageContext.request.contextPath}/Authorization.jsp">
    <input class=btn type="submit" name="sign" value="Назад">
    </form>
    </body>
</html>
