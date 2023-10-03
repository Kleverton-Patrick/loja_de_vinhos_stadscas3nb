<html>
<body>
<h2>Adicionar Vinho</h2>

<form action="/create-vinho" method="post">

    <label>Nome do Vinho</label>
    <input type="text" name="vinho-name" id="vinho-name" value="${param.name}">
    <input type="hidden" name="id" id="id" value="${param.id}">

    <button type="submit">Salvar</button>

</form>

</body>
</html>
