<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CadastroProduto.css">
</head>

<body>
    <div class="container">
        <div class="card">
            <h2>Cadastro de Produto</h2>
            <form action="/create-vinho" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="vinho-name">Nome do Vinho</label>
                    <input type="text" name="vinho-name" id="vinho-name" value="${param.name}">
                </div>

                <div class="form-group">
                    <label for="vinho-valor">Valor</label>
                    <input type="text" name="vinho-valor" id="vinho-valor" value="${param.valor}">
                </div>

                <div class="form-group">
                    <label for="vinho-quantidade">Quantidade</label>
                    <input type="text" name="vinho-quantidade" id="vinho-quantidade" value="${param.quantidade}">
                </div>

                <div class="form-group">
                    <label for="vinho-tipo">Tipo do Vinho</label>
                    <input type="text" name="vinho-tipo" id="vinho-tipo" value="${param.tipo}">
                </div>

                <div class="form-group">
                    <label for="vinho-uva">Tipo da Uva</label>
                    <input type="text" name="vinho-uva" id="vinho-uva" value="${param.uva}">
                </div>

                <div class="form-group">
                    <label for="vinho-harmonizacao">Harmonização</label>
                    <input type="text" name="vinho-harmonizacao" id="vinho-harmonizacao" value="${param.harmonizacao}">
                </div>

                <div class="form-group">
                    <label for="image">Imagem do Vinho</label>
                    <input type="file" name="image" id="image">
                </div>

                <div class="button-group">
                                    <button type="submit" class="save-button">Salvar</button>
                                    <button type="button" class="alterar-button">Alterar</button>
                                    <button type="button" class="excluir-button">Excluir</button>
                                    <button type="button" class="excluir-button">Sair</button>
                                </div>
            </form>
        </div>
    </div>
</body>

</html>
