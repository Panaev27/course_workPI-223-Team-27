<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор расчеты цены ангара</title>
</head>
<body>
<h1>Калькулятор расчета цены ангара</h1>
    <form action="${pageContext.request.contextPath}/JavaCalc" method="post">
        <label for="first">Высота:</label>
        <input type="text" name="height" id="height" value="${x}">
        <label for="second">Длина: </label>
        <input type="text" name="length" id="length" value="${y}">
        <label for="third">Ширина: </label>
        <input type="text" name="width" id="width" value="${z}"><br>
        <label for="fourth">Выберите тип строительства ангара: </label>
        <select name="type">
				<option value="0" >Каркасно-рамочные</option>
				<option value="1" >Каркасно-щитовой</option>
		</select><br>
        <label for="fifth">Выберите форму ангара: </label>
        <select name="formHangar">
				<option value="0" >Арочный</option>
				<option value="1" >Прямостенный</option>
				<option value="2" >Шатровый</option>
		</select><br>
        <label for="sixth">Выберите тип панели: </label>
        <select name="panel">
				<option value="0" >Облегчённая сендвич-панель</option>
				<option value="1" >Сендвич-панель</option>
				<option value="2" >Утепленная сендвич-панель</option>
		</select><br>
        <label for="seventh">Выберите сроки(мес.): </label>
        <input type="text" name="height" id="height" value="${time}"><br>
        <label for="eighth">Выберите фундамент: </label>
        <select name="foundation">
				<option value="0" >Отсутствие</option>
				<option value="1" >Каменный</option>
				<option value="2" >Железобетонный</option>
				<option value="3" >Бетонный</option>
		</select><br>
        <label for="ninth">Выберите тип двери: </label> 
        <select name="door">
				<option value="0" >Распашные</option>
				<option value="1" >Подъёмно-секционные</option>
				<option value="2" >Шторные</option>
				<option value="3" >Рулонные</option>
		</select><br>
        <label for="tenth">Промокод: </label>
        <input type="text" name="promo" id="promo" value="${promo}"><br>
        <input type="submit" name="sign" value="Calculate">
    </form>
    </body>
</html>
