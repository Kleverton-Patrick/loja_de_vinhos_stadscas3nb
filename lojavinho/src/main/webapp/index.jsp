<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
<body>
<h2>Adicionar Vinho</h2>

<form action="/create-vinho" method="post" enctype="multipart/form-data" >

    <div>
        <label>Nome do Vinho</label>
        <input type="text" name="vinho-name" id="vinho-name" value="${param.name}">
        <input type="hidden" id="id" name="id" value="${param.id}">
    </div>
    <br>
    <div>
        <label>Imagem do Vinho</label>
        <input type="file" name="image" id="image">
    </div>
    <br>
    <button type="submit">Salvar</button>

</form>

</body>
</html>
