<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Catalogo</title>
    <link rel="stylesheet" href="/TelaDeBusca/Home.css">
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

                        <!-- Adiciona o botão "Carrinho" -->
                        <form action="/AdicionarItem" method="GET">
                            <button type="submit" class="carrinho-button">Carrinho</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </header>


    <!-- Estrutura dos dropdowns -->
    <!-- INÍCIO -->
    <div class="txt text-center">
        <h1>Escolha o seu vinho</h1>
    </div>

    <!-- Pesquisa -->
                <form class="search-form" role="search" method="GET" action="/TelaDeProdutos">
                    <input type="text" class="search-input" name="busca" placeholder="Busque seu rótulo" aria-label="Search">
                    <button type="submit" class="search-button">Buscar</button>
                </form>
                </form>

<form class="search-form" role="search" method="GET" action="/TelaDeProdutos">
    <select class="dropdown-btn text-center" name="pais" id="pais">
        <option value="">Selecione o país</option>
        <c:forEach items="${pais}" var="pais">
            <option value="${pais.paisID}">${pais.nomePais}</option>
        </c:forEach>
    </select>

    <div class="dropdown text-center">
        <select class="dropdown-btn" name="tipoVinho" id="tipoVinho">
            <option value="">Selecione o tipo de vinho</option>
            <c:forEach items="${tipoVinho}" var="tipoVinho">
                <option value="${tipoVinho.tipoVinhoID}">${tipoVinho.nomeTipoVinho}</option>
            </c:forEach>
        </select>
    </div>

    <div class="dropdown text-center">
        <select class="dropdown-btn" name="tipoUva" id="tipoUva">
            <option value="">Selecione o tipo de uva</option>
            <c:forEach items="${tipoUva}" var="tipoUva">
                <option value="${tipoUva.tipoUvaID}">${tipoUva.nomeTipoUva}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="search-button" name="buscaComposta">Buscar</button>
</form>

    <div class="cards-container">
        <div class="card">
            <img src="/TelaDeBusca/Carne.jpg" alt="Harmonização 1">
            <div class="card-info">
                <h3>CARNE VERMELHA</h3>
                <p>Para cortes de carne vermelha diversos</p>
                <form action="/TelaDeProdutos" method="get">
                <input type="hidden" name="categoria" value="1">
                <button class="select-button" type="submit" name="buscarHarmonizacao">Selecionar</button>
            </form>
            </div>
        </div>

        <div class="card">
            <img src="/TelaDeBusca/FrutosDoMar.jpg" alt="Harmonização 2">
            <div class="card-info">
                <h3>FRUTOS DO MAR</h3>
                <p>Para Frutos do Mar e comida Japonesa.</p>
                <form action="/TelaDeProdutos" method="get">
                <input type="hidden" name="categoria" value="2">
                 <button class="select-button" type="submit" name="buscarHarmonizacao">Selecionar</button>
             </form>
            </div>
        </div>

        <div class="card">
            <img src="/TelaDeBusca/Queijo.jpg" alt="Harmonização 3">
            <div class="card-info">
                <h3>QUEIJOS</h3>
                <p>Para Queijos Branco, Parmesão e Canastra.</p>
             <form action="/TelaDeProdutos" method="get">
             <input type="hidden" name="categoria" value="3">
              <button class="select-button" type="submit" name="buscarHarmonizacao">Selecionar</button>
            </form>
            </div>
        </div>

  <div class="card">
      <img src="/TelaDeBusca/SobreMesa.jpg" alt="Harmonização 4">
      <div class="card-info">
          <h3>SOBREMESA</h3>
          <p>Descrição da harmonização 4.</p>
          <form action="/TelaDeProdutos" method="get">
              <input type="hidden" name="categoria" value="4">
              <button class="select-button" type="submit" name="buscarHarmonizacao">Selecionar</button>
          </form>
      </div>
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
