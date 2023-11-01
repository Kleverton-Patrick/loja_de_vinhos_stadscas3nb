
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
            <h2>Area do Cliente</h2>
            <form action="/entrarcliente" method="post">
                    <span>${requestScope.message}</span>

                <br>
                <div class="form-group">
                    <label for="cpfCliente">CPF Cliente:</label>
                    <input type="text" id="cpfCliente" name="cpfCliente" required>
                </div>
                <div class="form-group">
                    <label for="senhaCliente">Senha:</label>
                    <input type="password" id="senhaCliente" name="senhaCliente" required>
                </div>
                <button type="submit">Entrar</button>
            </form>
            <a href="/registroCliente" class="register-button">Registrar</a>
            <a href="/TelaDeBusca/Produtos.jsp">Ver Produtos</a>
        </div>
    </div>
</body>
<script src="main.js"></script>
</html>