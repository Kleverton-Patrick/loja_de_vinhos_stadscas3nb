package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.ClienteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registroCliente")
public class RegistroClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Quando uma solicitação GET é feita, encaminha para a página de registro do cliente.
        req.getRequestDispatcher("registroCliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Quando um formulário é enviado via POST, este método é acionado para processar o registro do cliente.

        // Obtém os parâmetros do formulário
        String nomeCliente = req.getParameter("nomeCliente");
        String cpfCliente = req.getParameter("cpfCliente");
        String emailCliente = req.getParameter("emailCliente");
        String telefoneCliente = req.getParameter("telefoneCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        ClienteDao clienteDao = new ClienteDao();
        boolean cpfJaCadastrado = clienteDao.verificarCpfExistente(cpfCliente);

        if (cpfJaCadastrado) {

            // Se o CPF já está cadastrado, exibe uma mensagem de erro e redireciona de volta para a página registroCliente.jsp.
            req.setAttribute("cpfExistente", "CPF já cadastrado!");
            req.getRequestDispatcher("registroCliente.jsp").forward(req, resp);
            System.out.println("Mensagem: " + req.getAttribute("cpfExistente"));
        } else {

            // Se o CPF não está cadastrado, tenta registrar o cliente.
            boolean isRegistered = clienteDao.registroUsuario(nomeCliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente);

            if (isRegistered) {

                // Registro bem sucedido, redirecione para a página escolhida.
                req.getSession().setAttribute("logadoUsuarioCliente", nomeCliente);
                resp.sendRedirect("/TelaDeBusca/Produtos.jsp");
            } else {

                // Falha no registro, exiba uma mensagem de erro
                req.setAttribute("message", "Falha ao registrar. Por favor, tente novamente.");
                req.getRequestDispatcher("registroCliente.jsp").forward(req, resp);
                System.out.println("Mensagem: " + req.getAttribute("message"));
            }
        }
    }
}