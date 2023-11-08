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

<main class="cards">


    <c:forEach items="${resultados}" var="resultado">

        <section class="card">
              <div class="icon">
                 <img src="${resultado.image}" alt="...">
              </div>

                <h2 class="card-title">${resultado.name}</h5>
                <h5 class="card-info p"> ${resultado.description} </h1>
                <a href="#" class="btn btn-primary">Comprar</a>

        </section>
    </c:forEach>

</main>

        </div>
         <footer class="footer">
            <div class="container">
                <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
            </div>
        </footer>
    </body>

</html>