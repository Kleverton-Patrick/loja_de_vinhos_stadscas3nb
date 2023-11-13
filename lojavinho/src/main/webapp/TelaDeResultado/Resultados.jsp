<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt">

<html>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
        <title>Resultado da Busca</title>
        <link rel="stylesheet" href="/TelaDeResultado/Resultado.css">
        <link rel="stylesheet" href="index.css">

</head>

<body>

  <header class="header">
        <div class="container">
            <div class="logo">
                <h1 class="logo-text">WIN-E</h1>
        </div>
        </div>
    </header>

    <div>
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
         <footer class="footer">
            <div class="container">
                <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
            </div>
        </footer>

    </body>

</html>
