<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem Vindo</title>
    <link rel="stylesheet" href="/TelaInicial/TelaInicial.css">
    <link rel="stylesheet" href="index.css">
</head>

<body>
    <header class="header">
        <div class="container">
            <div class="logo">
                <a href="http://localhost:8080/">
                    <h1 class="logo-text">WIN-E</h1>
                </a>
            </div>
            <div class="suggestion-button">
                <a href="./entrarCliente.jsp" class="suggestion-link">Entrar</a>
            </div>
        </div>
    </header>

    <!-- Conteúdo -->
    <div class="content">
            <form action="/TelaDeProdutos" method="GET">
                 <button type="submit" class="catalogo">
                       <img src="TelaInicial/IMG_0297.PNG" alt="Imagem Centralizada" class="image-center">
                       <h1 class="texto-catalogo">Conheça nosso catalogo</h1>
                 </button>
            </form>
    </div>

    <!-- INICIO DO RODAPÉ -->
    <footer class="footer">
        <div>
            <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!-- FIM  -->
</body>

</html>
