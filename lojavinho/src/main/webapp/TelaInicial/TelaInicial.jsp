<!DOCTYPE html>
<html lang="pt">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem Vindo</title>
    <link rel="stylesheet" href="/TelaInicial/TelaInicial.css">
</head>
<body>
<header class="header">
    <div class="container">
        <div class="logo">
            <h1 class="logo-text">WIN-E</h1>
        </div>
    </div>
    <a href="cadastrocliente.jsp" class="suggestion-link">Login</a>
</header>

<div class="content">
    <div class="image-container">
        <img src="TelaInicial/IMG_0297.PNG" alt="Imagem Centralizada" class="image-center">
    </div>
    <div class="product-button ">
    <form  action="/TelaDeBusca/Produtos.jsp">
    <div class="select-button">
        <button  type="submit" class="product-button" >Clique e conheça nosso catálogo</button>
    </div>
    </form>
    </div>
</div>

<!-- INICIO DO RODAPÉ -->
<footer class="footer">
    <div class="container">
        <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
    </div>
</footer>
<!-- FIM  -->
</body>
</html>
