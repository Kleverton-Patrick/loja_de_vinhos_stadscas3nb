<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
    <html>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <head>
        <title>Resultado da Busca</title>
        <link rel="stylesheet" href="/TelaDeBusca/Home.css">
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


    <div class="content">
             <div class="txt text-center">
        <div>

            <c:forEach items="${resultados}" var="resultado">

            <div class="card" style="width: 18rem;">
              <img src="${resultado.image}" class="card-img-top" alt="...">
              <div class="card-body">
                <h2 class="card-title">${resultado.name}</h5>
                <h5 class="card-info p"> ${resultado.description} </h1>
                <a href="#" class="btn btn-primary">Comprar</a>
              </div>
            </div>

            </c:forEach>

        </div>
      </div>
    </div>
</div>
<!--
  <div class="content">
            <h1>Resultados da Busca</h1>
            <c:forEach var="vinho" items="${vinhosSobremesa}">
                <ul>
                 <li>${vinhosSobremesa}</li>
                </c:forEach>
                </ul>

-->

        </div>
         <footer class="footer">
            <div class="container">
                <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
            </div>
        </footer>
    </body>

</html>
