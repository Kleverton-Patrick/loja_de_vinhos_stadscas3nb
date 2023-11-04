<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilo.css">
    <link rel="stylesheet" href="index.css">
    <title>Área do Cliente</title>
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
                <a href="#" class="suggestion-link" onclick="goBack()">Voltar</a>
            </div>
        </div>
    </header>

    <div class="container">
        <div class="login-card">
            <h2>Área do Cliente</h2>
            <form action="/entrarcliente" method="post">
                <span>${requestScope.message}</span>

                <br>
                <div class="form-group">
                    <label for="cpfCliente">CPF Cliente:</label>
                    <input type="text" id="cpfCliente" name="cpfCliente" required>
                </div>
                <div class="form-group">
                    <label for="senhaCliente">Senha:</label>
                    <input type="password" id="senhaCliente" name="senhaCliente" required>
                </div>
                <button type="submit">Entrar</button>
            </form>
            <a href="/registroCliente" class="register-button">Registrar-se</a>
        </div>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
    <script src="main.js"></script>

    <!-- INICIO DO RODAPÉ -->
    <footer class="footer">
        <div>
            <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!-- FIM  -->
</body>

</html>