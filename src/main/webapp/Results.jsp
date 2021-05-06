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
<p><strong>Высота:</strong> ${inputx}</p>
<p><strong>Длина:</strong> ${inputy}</p>
<p><strong>Ширина:</strong> ${inputz}</p>
<p><strong>Итоговая сумма:</strong> ${price}</p>

<form action="${pageContext.request.contextPath}/Form.jsp">
    <input type="submit" name="sign" value="Назад">
    </form>

</body>
</html>