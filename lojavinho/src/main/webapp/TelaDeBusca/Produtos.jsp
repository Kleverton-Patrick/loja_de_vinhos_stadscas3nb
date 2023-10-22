<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Inicial</title>
    <link rel="stylesheet" href="Home.css">
</head>

<!-- Aqui fica o cabeçalho -->
<header class="header">
    <div class="container">
        <div class="logo">
            <!-- <img src="IMG_0297.PNG" alt="Logo" class="logo-image"> -->
            <h1 class="logo-text">WIN-E</h1>
        </div>

        <form class="search-form" role="search" method="GET" action="/TelaDeProdutos">
            <input type="text" class="search-input" name="busca" placeholder="Busque seu rótulo" aria-label="Search">
            <button  type="submit" class="search-button">Buscar</button>
        </form>
        <div class="suggestion-button">
            <a href="entrarcliente.jsp" class="suggestion-link">Login</a>
        </div>
    </div>
</header>

<body>
</nav>
<!-- Estrutura dos dropd -->

<!-- INICIO -->
<div class="txt">
    <h1>Escolha o seu vinho</h1>
</div>

<main class="content">

    <div class="dropdown-container">

        <div class="dropdown">
            <select class="dropdown-btn" name="pais" id="pais">
                <c:forEach value="${pais}" var="paises">
                    <option value="${PAIS.paisID}">${PAIS.nomePais}</option>
                </c:forEach>
            </select>
        </div>


        <div class="dropdown">
            <select class="dropdown-btn" name="tipoVinho" id="tipoVinho">
                <c:forEach value="${tipoVinho}" var="tiposVinho">
                    <option value="${TipoVinho.tipoVinhoID}">${TipoVinho.nomeTipoVinho}</option>
                </c:forEach>
            </select>
        </div>

        <div class="dropdown">
            <select class="dropdown-btn" name="uva" id="uva">
                <c:forEach value="${tipoipoUva}" var="tiposUva">
                    <option value="${TipoUva.tipoUvaID}">${TipoUva.NomeTipoUva}</option>
                </c:forEach>
            </select>
        </div>


    </div>

</main>
<!-- FIM -->

<div class="cards-container">
    <div class="card">
        <img src="Carne.jpg" alt="Harmonização 1">
        <div class="card-info">
            <h3>CARNE VERMELHA</h3>
            <p>Para cortes de carne vermelha diversos</p>
            <button class="select-button">Selecionar</button>
        </div>
    </div>

    <div class="card">
        <img src="FrutosDoMar.jpg" alt="Harmonização 2">
        <div class="card-info">
            <h3>FRUTOS DO MAR</h3>
            <p>Para Frutos do Mar e comida Japonesa.</p>
            <button class="select-button">Selecionar</button>
        </div>
    </div>

    <div class="card">
        <img src="Queijo.jpg" alt="Harmonização 3">
        <div class="card-info">
            <h3>QUEIJOS</h3>
            <p>Para Queijos Branco,Parmesão e Canastra.</p>
            <button class="select-button">Selecionar</button>
        </div>
    </div>

    <div class="card">
        <img src="SobreMesa.jpg" alt="Harmonização 4">
        <div class="card-info">
            <h3>SOBREMESA</h3>
            <p>Descrição da harmonização 4.</p>
            <button class="select-button">Selecionar</button>
        </div>
    </div>
</div>



<!-- INICIO DO RODAPÉ -->
<footer class="footer">
    <div class="container">
        <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
    </div>
</footer>
<!-- FIM  -->
<
</body>

</html>