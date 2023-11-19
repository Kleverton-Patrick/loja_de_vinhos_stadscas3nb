<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TelaFinalizarCompra/RegistrarEndereco.css">
    <link rel="stylesheet" href="index.css">
    <title>Registrar Endereço</title>
</head>

<body>
    <!-- Aqui fica o cabeçalho -->
    <header class="header">
        <div class="container">
            <div class="logo">
                <a href="http://localhost:8080/">
                    <h1 class="logo-text">WIN-E</h1>
                </a>
            </div>
            <div class="suggestion-button">
                <!-- Se logado, exibe as informações do cliente e o botão de logout -->
                <c:if test="${sessionScope.logadoUsuarioCliente != null}">
                    <span>Olá, ${sessionScope.logadoUsuarioCliente}</span>
                    <a href="/saircliente">Sair</a>
                </c:if>
                            <div class="suggestion-button">
                                <a href="#" class="suggestion-link" onclick="goBack()">Voltar</a>
                            </div>
            </div>
        </div>
    </header>

    <!-- Conteúdo -->
        <div class="txt text-center">
            <h1>Cadastro de Endereço</h1>
        </div>

            <form action="/registroEndereco" method="post">

                <div class="form-group">
                    <label for="nomeCliente">Usuario:</label>
                    <input type="text" id="nomeCliente" name="nomeCliente" required>
                </div>

                <div class="form-group">
                    <label for="CEP">CEP:</label>
                    <input type="text" id="CEP" name="CEP" required>
                </div>

                <div class="form-group">
                    <label for="endereco">Endereço:</label>
                    <input type="text" id="endereco" name="endereco" required>
                </div>

                <div class="form-group">
                    <label for="numero">Número:</label>
                    <input type="text" id="numero" name="numero" required>
                </div>

                <div class="form-group">
                    <label for="complemento">Complemento:</label>
                    <input type="text" id="complemento" name="complemento" required>
                </div>

                 <div class="form-group">
                     <label for="complemento">Complemento:</label>
                     <input type="text" id="complemento" name="complemento" required>
                 </div>

                 <div class="form-group">
                     <label for="complemento">Complemento:</label>
                     <input type="text" id="complemento" name="complemento" required>
                 </div>

                 <div class="form-group">
                      <label for="complemento">Complemento:</label>
                      <input type="text" id="complemento" name="complemento" required>
                 </div>

                <!-- Botão de submissão do formulário -->
                <button type="submit">Cadastrar Endereço</button>

            </form>

    <!-- Script para voltar à página anterior -->
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
    <!-- Script principal -->
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
