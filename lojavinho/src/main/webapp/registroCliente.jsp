<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilo.css">
    <link rel="stylesheet" href="index.css">
    <title>Cadastro de Cliente</title>
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
            <h2>Cadastro de Cliente</h2>
            <form action="/registroCliente" method="post">
                <span>${requestScope.message}</span>
                <div class="form-group">
                    <label for="nomeCliente">Usuario:</label>
                    <input type="text" id="nomeCliente" name="nomeCliente" required>
                </div>
                <div class="form-group">
                    <label for="cpfCliente">CPF:</label>
                    <input type="text" id="cpfCliente" name="cpfCliente" required oninput="atualizarCPFFormatado()">
                    <span>${requestScope.cpfExistente}</span>
                </div>
                <div class="form-group">
                    <label for="emailCliente">E-mail:</label>
                    <input type="text" id="emailCliente" name="emailCliente" required>
                </div>
                <div class="form-group">
                    <label for="telefoneCliente">Telefone:</label>
                    <input type="text" id="telefoneCliente" name="telefoneCliente" required>
                </div>
                <div class="form-group">
                    <label for="senhaCliente">Senha:</label>
                    <input type="senhaCliente" id="senhaCliente" name="senhaCliente" required>
                </div>
                <button type="submit">Cadastrar</button>
            </form>
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
 <script src="ScriptCPF.js"></script>
</html>
