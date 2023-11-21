<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <title>Cadastro de Cartão de Crédito</title>
    <!-- Adicione seus estilos ou links de CSS, se necessário -->
    <link rel="stylesheet" type="text/css" href="/TelaCadastroPagamento/CadastroPagamento.css">
</head>

<body>
    <!-- Cabeçalho -->
    <header class="header">
        <!-- Seu cabeçalho aqui -->
    </header>

    <!-- Conteúdo -->
    <div class="Card-dados">
        <h1>Cadastro de Cartão de Crédito</h1>

        <!-- Formulário para informações do cartão de crédito -->
        <form action="/processarPagamento" method="post">
            <!-- Campos para informações do cartão -->
            <div>
                <label for="numCartao">Número do Cartão:</label>
                <input type="text" id="numCartao" name="numCartao" required>
            </div>

            <div>
                <label for="nomeCartao">Nome no Cartão:</label>
                <input type="text" id="nomeCartao" name="nomeCartao" required>
            </div>

            <div>
                <label for="cvc">CVC:</label>
                <input type="text" id="cvc" name="cvc" required>
            </div>

            <div>
                <label for="validadeCartao">Data de Validade:</label>
                <input type="text" id="validadeCartao" name="validadeCartao" required>
            </div>

            <!-- Adicione campos ocultos ou outros campos necessários -->

            <!-- Botão de Submissão -->
            <button type="submit">Salvar</button>
        </form>
    </div>

    <!-- Rodapé -->
    <footer class="footer">
        <!-- Seu rodapé aqui -->
    </footer>
</body>

</html>
