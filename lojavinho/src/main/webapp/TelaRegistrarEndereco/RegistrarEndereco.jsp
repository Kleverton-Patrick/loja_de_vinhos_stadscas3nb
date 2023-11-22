    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    <%
        String cpfCliente = (String) request.getSession().getAttribute("CPFCliente");
    %>

    <!DOCTYPE html>
    <html lang="pt">

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="TelaRegistrarEndereco/Registro.css">
        <link rel="stylesheet" href="Carrinho/Carrinho.css">
        <link rel="stylesheet" href="index.css">
        <link rel="stylesheet" href="TelaRegistrar/Registro.css">

        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
        <title>Registrar Endereco</title>
    </head>

    <body>
        <!-- Aqui fica o cabeçalho -->
        <header class="header">
            <div class="container">
                <div class="logo">
                    <a href="http://localhost:8080/">
                        <h1 class="logo-text">WIN-E</h1>
                    </a>
                </div>
                <div class="suggestion-button">
                <!-- Verifica se o usuário cliente está logado -->
                    <c:if test="${sessionScope.logadoUsuarioCliente == null}">
                        <a href="./entrarCliente.jsp" class="suggestion-link">Entrar</a>
                    </c:if>
                    <!-- Se logado, exibe as informações do cliente e o botão de logout -->
                    <c:if test="${sessionScope.logadoUsuarioCliente != null}">
                        <span>Olá, ${sessionScope.logadoUsuarioCliente}</span>
                        <a href="/saircliente">Sair</a>
                        <form action='/TelaDeProdutos' method="GET">
                              <button type="submit" class="continuarComprando-button">Continuar comprando</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </header>



        <div>
 <div class="Card-endereco">
         <div class="txt text-center">
                    <h1>Cadastro de Endereço</h1>


                    <form action="/registroEndereco" method="post">


                    <input type="hidden" name="qtdTotal" value="${carrinho.qtdTotal}">
                    <input type="hidden" name="vlrTotal" value="${carrinho.vlrTotal}">


                       <input type="hidden" name="numCPF" value="<%= cpfCliente %>">


                        <div>
                            <label for="CEP">CEP:</label>
                            <input type="text" id="CEP" name="CEP" required>
                        </div>

                        <div>
                            <label for="endereco">Endereço:</label>
                            <input type="text" id="endereco" name="endereco" required>
                        </div>

                        <div>
                            <label for="numero">Número:</label>
                            <input type="text" id="numero" name="numero" required pattern="[0-9]+">
                        </div>

                        <div>
                            <label for="complemento">Complemento:</label>
                            <input type="text" id="complemento" name="complemento" required>
                        </div>

                         <div>
                             <label for="bairro">Bairro:</label>
                             <input type="text" id="bairro" name="bairro" required>
                         </div>

                         <div>
                             <label for="cidade">Cidade:</label>
                             <input type="text" id="cidade" name="cidade" required>
                         </div>

                         <div>
                             <label for="estado">Estado:</label>
                             <select id="estado" name="estado" required>
                                 <option value="" disabled selected>Selecione um estado</option>
                                 <option value="AC">AC</option>
                                 <option value="AL">AL</option>
                                 <option value="AP">AP</option>
                                 <option value="AM">AM</option>
                                 <option value="BA">BA</option>
                                 <option value="CE">CE</option>
                                 <option value="DF">DF</option>
                                 <option value="ES">ES</option>
                                 <option value="GO">GO</option>
                                 <option value="MA">MA</option>
                                 <option value="MT">MT</option>
                                 <option value="MS">MS</option>
                                 <option value="MG">MG</option>
                                 <option value="PA">PA</option>
                                 <option value="PB">PB</option>
                                 <option value="PR">PR</option>
                                 <option value="PE">PE</option>
                                 <option value="PI">PI</option>
                                 <option value="RJ">RJ</option>
                                 <option value="RN">RN</option>
                                 <option value="RS">RS</option>
                                 <option value="RO">RO</option>
                                 <option value="RR">RR</option>
                                 <option value="SC">SC</option>
                                 <option value="SP">SP</option>
                                 <option value="SE">SE</option>
                                 <option value="TO">TO</option>
                             </select>
                         </div>
</div>
                        <!-- Botão de submissão do formulário -->
                        <button type="submit">Cadastrar Endereço</button>

                    </form>


        </div>


        <!-- INÍCIO DO RODAPÉ -->
        <footer class="footer">
            <div>
                <p>&copy; 2023 WIN-E. Todos os direitos reservados.</p>
            </div>
        </footer>
        <!-- FIM -->


        <script>
            $(document).ready(function(){
                $('#CEP').mask('00000-000');
            });
        </script>

        <script>
            $(document).ready(function(){
                $('#numero').mask('0#');
            });
        </script>

    </body>
    </html>
