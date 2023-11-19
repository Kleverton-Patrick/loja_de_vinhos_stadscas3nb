<!-- finalizarCompra.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Finalizar Compra</title>
    <!-- Adicione aqui seus estilos CSS ou links para folhas de estilo externas -->
</head>
<body>

<div>

<div>
    <h1>Detalhes do Pedido:</h1>

        <p><strong>CPF Cliente</strong> ${carrinho.numCPF}</p>
        <p><strong>Quantidade de itens do pedido:</strong> ${carrinho.qtdTotal}</p>
        <p><strong>Valor total do pedido:</strong> ${carrinho.vlrTotal}</p>

</div>

<div>

        <h1>Endereço de entrega:</h1>

        <p><strong>CEP:</strong> ${CEP}</p>
        <p><strong>Endereço:</strong> ${endereco}</p>
        <p><strong>Numero do endereço:</strong> ${numEndereco}</p>
        <p><strong>Complemento:</strong> ${complEndereco}</p>
        <p><strong>Bairro:</strong> ${bairro}</p>
        <p><strong>Cidade:</strong> ${cidade}</p>
        <p><strong>Estado:</strong> ${estado}</p>

</div>

</div>
</body>
</html>
