<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrinho</title>
    <link rel="stylesheet" href="/Carrinho/Carrinho.css">
    <link rel="stylesheet" href="index.css">
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
                <!-- Verifica se o usuário cliente está logado -->
                <c:if test="${sessionScope.logadoUsuarioCliente == null}">
                    <a href="./entrarCliente.jsp" class="suggestion-link">Entrar</a>
                </c:if>
                <!-- Se logado, exibe as informações do cliente e o botão de logout -->
                <c:if test="${sessionScope.logadoUsuarioCliente != null}">
                    <span>Olá, ${sessionScope.logadoUsuarioCliente}</span>
                    <a href="/saircliente">Sair</a>
                </c:if>
            </div>
        </div>
    </header>

    <!-- Estrutura -->
    <!-- INÍCIO -->
    <div class="txt text-center">
        <h1>Carrinho</h1>
    </div>

    <body>
        <table>
            <thead>
                <tr>
                    <th>Foto do Produto</th>
                    <th>Nome do Vinho</th>
                    <th>Valor Unitário</th>
                    <th>Quantidade</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${carrinho}">
                    <tr>
                        <td><img src="${item.imagem}" alt="Imagem do Produto" width="100"></td>
                        <td>${item.descNomeVinho}</td>
                        <td>R$ ${item.vlrProduto}</td>
                        <td>${item.qtdProduto}</td>
                        <td>R$ ${item.vlrProduto * item.qtdProduto}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

  < !--      <p class="total-text">Total do Carrinho: R$ ${totalCarrinho}</p>  -->

        <button type="button" class="finalizar-button">Finalizar Pedido</button>
    </div>
    </body>

    <!-- INÍCIO DO RODAPÉ -->
    <footer class="footer">
        <div>
            <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!-- FIM -->
</body>

</html>
