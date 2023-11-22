<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
    // Obter CPFCliente da sessão
    String cpfCliente = (String) request.getSession().getAttribute("CPFCliente");
%>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TelaDeResultado/Resultado.css">

    <title>Resultado da Busca</title>
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

    <!-- Conteúdo -->
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


             <form action="/AdicionarItem" method="post">

                 <input type="hidden" name="numCPF" value= <%= cpfCliente %>>
                 <input type="hidden" name="numSeqVinho" value="${resultado.id}">
                 <input type="hidden" name="descNomeVinho" value="${resultado.nome}">
                 <input type="hidden" name="vlrProduto" value="${resultado.valor}">
                 <input type="hidden" name="imagem" value="${resultado.imagem}">
                 <input type="number" name="qtdProduto" id="quantidade_${loop.index}" class="quantidadeInput" value="1" min="1" max="${resultado.estoque}">

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
