<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Inicial</title>
    <link rel="stylesheet" href="/TelaDeBusca/Home.css">
</head>

<body>
    <header class="header">
        <div class="container">
            <div class="logo">
                <h1 class="logo-text">WIN-E</h1>
        </div>
            <form class="search-form" role="search" method="GET" action="/TelaDeProdutos">
                <input type="text" class="search-input" name="busca" placeholder="Busque seu rótulo" aria-label="Search">
                <button type="submit" class="search-button">Buscar</button>
            </form>
            <div class="suggestion-button">
                <a href="entrarcliente.jsp" class="suggestion-link">Login</a>
            </div>
        </div>
    </header>

    <!-- Estrutura dos dropdowns -->
    <!-- INÍCIO -->
    <div class="txt text-center">
        <h1>Escolha o seu vinho</h1>
    </div>

<div class="dropdown-container ">
    <select class="dropdown-btn text-center" name="pais" id="pais"> <!-- Adicionado a classe text-center -->
        <option value="">Selecione o país</option>
        <c:forEach items="${pais}" var="pais">
            <option value="${pais.paisID}">${pais.nomePais}</option>
        </c:forEach>
    </select>


    <div class="dropdown text-center"> <!-- Adicionado a classe text-center -->
        <select class="dropdown-btn" name="tipoVinho" id="tipoVinho">
            <option value="">Selecione o tipo de vinho</option>
            <c:forEach items="${tipoVinho}" var="tipoVinho">
                <option value="${tipoVinho.tipoVinhoID}">${tipoVinho.nomeTipoVinho}</option>
            </c:forEach>
        </select>
    </div>

    <div class="dropdown text-center"> <!-- Adicionado a classe text-center -->
        <select class="dropdown-btn" name="uva" id="uva">
            <option value="">Selecione o tipo de uva</option>
            <c:forEach items="${tipoUva}" var="tipoUva">
                <option value="${tipoUva.tipoUvaID}">${tipoUva.nomeTipoUva}</option>
            </c:forEach>
        </select>
    </div>
</div>

    <!-- FIM -->

    <div class="cards-container">
        <div class="card">
            <img src="Carne.jpg" alt="Harmonização 1">
            <div class="card-info">
                <h3>CARNE VERMELHA</h3>
                <p>Para cortes de carne vermelha diversos</p>
                <button class="select-button">Selecionar</button>
            </div>
        </div>

        <div class="card">
            <img src="FrutosDoMar.jpg" alt="Harmonização 2">
            <div class "card-info">
                <h3>FRUTOS DO MAR</h3>
                <p>Para Frutos do Mar e comida Japonesa.</p>
                <button class="select-button">Selecionar</button>
            </div>
        </div>

        <div class="card">
            <img src="Queijo.jpg" alt="Harmonização 3">
            <div class="card-info">
                <h3>QUEIJOS</h3>
                <p>Para Queijos Branco, Parmesão e Canastra.</p>
                <button class="select-button">Selecionar</button>
            </div>
        </div>

        <div class="card">
            <img src="SobreMesa.jpg" alt="Harmonização 4">
            <div class="card-info">
                <h3>SOBREMESA</h3>
                <p>Descrição da harmonização 4.</p>
                <button class="select-button">Selecionar</button>
            </div>
        </div>
    </div>

    <!-- INÍCIO DO RODAPÉ -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!-- FIM -->

</body>

</html>
