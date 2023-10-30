<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilo.css">
    <title>Tela de login</title>
</head>

<header>
 <!-- Aqui fica o cabeçalho -->
 <header class="header">
    <div class="container">
        <div class="logo">
            <!-- <img src="IMG_0297.PNG" alt="Logo" class="logo-image"> -->
            <h1 class="logo-text">WIN-E</h1>
        </div>

    </div>

</header>


<body>
    <div class="container">
        <div class="login-card">
    <h2>Cadastro de Cliente</h2>
    <form action="/registroCliente" method="post">
        <span>${requestScope.message}</span>
        <br>
        <div class="form-group">
        <label for="cliente">Usuario:</label>
        <input type="text" id="cliente" name="cliente" required>
        </div>


        <div class="form-group">
            <label for="cpfCliente">CPF:</label>
            <input type="text" id="cpfCliente" name="cpfCliente" required>
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

                <button type="submit">Cadastrar</button>
            </form>
        </div>
    </div>
</body>
<script src="main.js"></script>
</html>
