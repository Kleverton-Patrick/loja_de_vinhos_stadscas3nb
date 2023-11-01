<!-- editarcliente.jsp -->

<h2>Editar Cadastro</h2>
<form action="/editarcliente" method="post">
    <div class="form-group">
        <label for="nomeCliente">Usuario:</label>
        <input type="text" id="nomeCliente" name="nomeCliente" required>

    </div>
    <br>

    <div class="form-group">
         <label for="cpfCliente">CPF:</label>
         <input type="text" id="cpfCliente" name="cpfCliente" value="${cliente.cpfCliente}" required>
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

    <div class="form-group">
        <label for="statusCliente">Status do Cliente:</label>
        <select id="statusCliente" name="statusCliente">
            <option value="1">Ativo</option>
            <option value="0">Inativo</option>
        </select>
    </div>

    <br>

    <button type="submit">Salvar Alterações</button>
</form>
