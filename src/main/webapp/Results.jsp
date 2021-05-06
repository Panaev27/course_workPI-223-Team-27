<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат вычисления стоимости ангара</title>
</head>
<body>
<h1>Результат вычисления стоимости ангара</h1>
<h2>Ваши введеные данные:</h2>
<p><strong>Длина:</strong> ${xResult}</p>
<p><strong>Ширина:</strong> ${yResult}</p>
<p><strong>Высота:</strong> ${zResult}</p>
<p><strong>Тип ангара:</strong> ${typeResult}</p>
<p><strong>Форма ангара:</strong> ${formHangarResult}</p>
<p><strong>Тип панели:</strong> ${panelResult}</p>
<p><strong>Сроки(мес.):</strong> ${timeResult}</p>
<p><strong>Тип фундамента:</strong> ${foundationResult}</p>
<p><strong>Тип двери:</strong> ${doorResult}</p>
<p><strong>Промокод:</strong> ${promoResult}</p>
<p><strong>Итоговая сумма: </strong> ${price}</p>

<form action="${pageContext.request.contextPath}/Form.jsp">
    <input type="submit" name="sign" value="Назад">
    </form>

</body>
</html>