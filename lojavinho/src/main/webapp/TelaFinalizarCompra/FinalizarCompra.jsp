<!-- finalizarCompra.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Finalizar Compra</title>
    <!-- Adicione aqui seus estilos CSS ou links para folhas de estilo externas -->
</head>
<body>
    <h1>Detalhes da Última Compra</h1>

    <c:if test="${not empty enderecoUltimaCompra}">
        <p><strong>Endereço:</strong> ${enderecoUltimaCompra}</p>
    </c:if>

    <c:if test="${not empty cidadeUltimaCompra}">
        <p><strong>Cidade:</strong> ${cidadeUltimaCompra}</p>
    </c:if>

    <c:if test="${not empty estadoUltimaCompra}">
        <p><strong>Estado:</strong> ${estadoUltimaCompra}</p>
    </c:if>

    <!-- Adicione aqui mais detalhes da compra ou qualquer outra informação que você queira exibir -->

    <!-- Adicione aqui seus scripts JavaScript ou links para scripts externos -->
</body>
</html>
