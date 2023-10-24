<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Carrinho.css">
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

<title>Carrinho de Compras</title>
</head>

<body>
    <div class="container">
        <div class="card">
            <h2>Carrinho de Compras</h2>
            <table>
                <thead>
                    <tr>
                        <th>Foto do Produto</th>
                        <th>Nome do Vinho</th>
                        <th>Valor Unitário</th>
                        <th>Quantidade</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${carrinho}">
                        <tr>
                            <td><img src="${item.imagem}" alt="Imagem do Produto" width="100"></td>
                            <td>${item.nome}</td>
                            <td>R$ ${item.valor}</td>
                            <td>${item.quantidade}</td>
                            <td>R$ ${item.valor * item.quantidade}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p class="total-text">Total do Carrinho: R$ ${totalCarrinho}</p>

            <button type="button" class="finalizar-button">Finalizar Pedido</button>
        </div>
    </div>
</body>

 <!-- INÍCIO DO RODAPÉ -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!-- FIM -->
