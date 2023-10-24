<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado da Busca</title>
    <link rel="stylesheet" href="Home.css">
</head>
 <header class="header">
        <div class="container">
            <div class="logo">
                <h1 class="logo-text">WIN-E</h1>
<body>
    <div class="content">
         <div class="txt text-center">
        <h1>Resultados da Busca</h1>
        <ul>
            <c:forEach items="${resultados}" var="resultado">
                <li>${resultados}</li>
            </c:forEach>
        </ul>
        </div>
    </div>
     <footer class="footer">
            <div class="container">
                <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
            </div>
        </footer>
</body>

</html>
