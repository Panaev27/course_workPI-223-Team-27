<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Результат вычисления стоимости ангара</title>
</head>
<body>
<h1 class=titl>Результат вычисления стоимости ангара</h1>
<h2>Ваши введеные данные:</h2>
<p class=lab><strong>Длина:</strong> ${xResult}<br>
<strong>Ширина:</strong> ${yResult}<br>
<strong>Высота:</strong> ${zResult}<br>
<strong>Тип ангара:</strong> ${typeResult}<br>
<strong>Форма ангара:</strong> ${formHangarResult}<br>
<strong>Тип панели:</strong> ${panelResult}<br>
<strong>Сроки(мес.):</strong> ${timeResult}<br>
<strong>Тип фундамента:</strong> ${foundationResult}<br>
<strong>Тип двери:</strong> ${doorResult}<br>
<strong>Промокод:</strong> ${promoResult}<br>
<strong>Итоговая сумма: </strong> ${price}</p>

<a  class=link href="/Check.pdf"> Открыть PDF-файл</a><br><br>
<a  class=link href="/Check.pdf" download> Скачать PDF-файл</a><br><br>

<form action="${pageContext.request.contextPath}/Form.jsp">
    <input class=btn type="submit" name="sign" value="Назад">
    </form>

</body>
</html>