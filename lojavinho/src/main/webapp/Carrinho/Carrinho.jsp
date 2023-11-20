<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%

    String cpfCliente = (String) request.getSession().getAttribute("CPFCliente");
%>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Carrinho/Carrinho.css">
    <link rel="stylesheet" href="index.css">
    <title>Carrinho</title>
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
                    <form action='/TelaDeProdutos' method="GET">
                          <button type="submit" class="continuarComprando-button">Continuar comprando</button>
                    </form>
                </c:if>
            </div>
        </div>
    </header>

    <!-- Conteúdo -->
    <div class="txt text-center">
        <h1>Carrinho</h1>
    </div>

    <div class="table-container">
        <c:choose>
            <c:when test="${empty carrinho}">
                <p class="mensagem-carrinho-vazio">Seu carrinho está vazio. Selecione pelo menos um produto para compra.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>Foto do Produto</th>
                            <th>Nome do Vinho</th>
                            <th>Valor Unitário</th>
                            <th>Quantidade</th>
                            <th>Total</th>
                            <th>Ação</th> <!-- Adicionado coluna para o botão de remoção -->
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
                                <td>
                                    <form action="/RemoverItemCarrinhoServlet" method="post">
                                        <input type="hidden" name="numSeqVinho" value="${item.numSeqVinho}">
                                        <input type="hidden" name="numCPF" value="<%= cpfCliente %>">
                                        <button type="submit">Remover</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
</div>


<div class="finalizar-compra">
<c:set var="totalCarrinho" value="0" />
        <c:forEach var="item" items="${carrinho}">
            <c:set var="totalCarrinho" value="${totalCarrinho + item.vlrProduto * item.qtdProduto}" />
        </c:forEach>

        <c:set var="totalQuantidade" value="0" />
        <c:forEach var="item" items="${carrinho}">
            <c:set var="totalQuantidade" value="${totalQuantidade +item.qtdProduto}" />
        </c:forEach>

        <p class="total-text">Valor total do Carrinho: ${totalCarrinho} R$</p>
        <p class="total-text">Quantidade de itens do Carrinho: ${totalQuantidade}</p>

        <form action='/FinalizarCompraServlet' method="post">
            <input type="hidden" name="numCPF" value="<%= cpfCliente %>">
            <input type="hidden" name="totalVlr" value="${totalCarrinho}">
            <input type="hidden" name="totalQtd" value="${totalQuantidade}">
            <button type="submit" class="finalizar-button">Finalizar Pedido</button>
        </form>
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
