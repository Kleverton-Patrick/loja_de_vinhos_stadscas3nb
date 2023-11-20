<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="TelaFinalizarCompra/FinalizarCompra.css">
    <link rel="stylesheet" href="index.css">
    <title>Finalizar Compra</title>
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
            </div>
        </div>
    </header>

    <!-- Conteúdo -->
    <div class="detalhes-pedido">
        <h1>Detalhes do Pedido:</h1>

        <p><strong>CPF Cliente</strong> ${carrinho.numCPF}</p>
        <p><strong>Quantidade de itens do pedido:</strong> ${carrinho.qtdTotal}</p>
        <p><strong>Valor total do pedido:</strong> ${carrinho.vlrTotal}</p>
    </div>

    <div class="endereco-entrega">
        <h1>Endereço de entrega:</h1>

        <p><strong>CEP:</strong> ${CEP}</p>
        <p><strong>Endereço:</strong> ${endereco}</p>
        <p><strong>Numero do endereço:</strong> ${numEndereco}</p>
        <p><strong>Complemento:</strong> ${complEndereco}</p>
        <p><strong>Bairro:</strong> ${bairro}</p>
        <p><strong>Cidade:</strong> ${cidade}</p>
        <p><strong>Estado:</strong> ${estado}</p>
    </div>

    <!-- Lista de Produtos do Carrinho -->
    <div class="lista-carrinho">
        <h1>Itens do Carrinho:</h1>
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
                <c:forEach var="item" items="${listaCarrinho}">
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
        <form action="/EncerrarCompra" method="post">
            <input type="hidden" name="numCPF" value="${carrinho.numCPF}">
            <button type="submit" class="finalizar-compra-button">Finalizar Compra</button>
        </form>

    </div>

    <!-- Rodapé -->
    <footer class="footer">
        <div>
            <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
        </div>
    </footer>
</body>
</html>
