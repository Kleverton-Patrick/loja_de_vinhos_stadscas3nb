<!-- editarcliente.jsp -->

<h2>Editar Cadastro</h2>
<form action="/editarcliente" method="post">
    <div class="form-group">
        <label for="usuarioNomeCliente">Usuario:</label>
        <input type="text" id="usuarioNomeCliente" name="usuarioNomeCliente" value="${cliente.usuarioNomeCliente}" required>
    </div>
    <br>
    <div class="form-group">
        <label for="emailCliente">E-mail:</label>
        <input type="text" id="emailCliente" name="emailCliente" required>
    </div>

    <br>
    <div class="form-group">
        <label for="telefoneCliente">Telefone:</label>
        <input type="text" id="telefoneCliente" name="telefoneCliente" required>
    </div>

    <br>
    <div class="form-group">
        <label for="senhaCliente">Senha:</label>
        <input type="senhaCliente" id="senhaCliente" name="senhaCliente" required>
    </div>

    <br>

    <button type="submit">Salvar Alterações</button>
</form>
