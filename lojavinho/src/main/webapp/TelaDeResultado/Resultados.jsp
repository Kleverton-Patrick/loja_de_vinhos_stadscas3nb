<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado da Busca</title>
    <link rel="stylesheet" href="/TelaDeResultado/Resultado.css">
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
        <h1>Resultados da Busca</h1>
    </div>


 <c:forEach items="${resultados}" var="resultado" varStatus="loop">
         <section class="card">
             <div class="icon">
                 <img src="${resultado.imagem}" alt="...">
             </div>

             <h2 class="card-title">${resultado.nome}</h2>
             <h5 class="card-info p"> ${resultado.descricao} </h5>
             <h5 class="card-info p"> Valor: ${resultado.valor} </h5>
             <h5 class="card-info p"> QTD em estoque: ${resultado.estoque} </h5>


             <form action="/AddCart" method="post">
                 <input type="hidden" name="id" value="${resultado.id}">
                 <input type="hidden" name="nome" value="${resultado.nome}">
                 <input type="hidden" name="valor" value="${resultado.valor}">
                  <input type="number" name="quantidade" id="quantidade_${loop.index}" class="quantidadeInput" value="1" min="1" max="${resultado.estoque}">

                 <button type="submit" onclick="adicionarAoCarrinho()"> ADICIONAR AO CARRINHO </button>
             </form>
         </section>
     </c:forEach>
    </div>


    <!-- INÍCIO DO RODAPÉ -->
    <footer class="footer">
        <div>
            <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!-- FIM -->
</body>

</html>
