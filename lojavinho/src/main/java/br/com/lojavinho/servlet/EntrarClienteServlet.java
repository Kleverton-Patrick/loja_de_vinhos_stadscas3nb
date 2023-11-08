package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.ClienteDao;
import br.com.lojavinho.model.UsuarioCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entrarcliente")
public class EntrarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Quando uma solicitação GET é feita para /entrarcliente, esta função é acionada.

        // Encaminha a requisição para a página de login do cliente.
        req.getRequestDispatcher("entrarCliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Quando um formulário é enviado via POST, esta função é acionada para verificar as credenciais do cliente.

        // Obtém os parâmetros do formulário.
        String cpfCliente = req.getParameter("cpfCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        // Cria um objeto UsuarioCliente com as credenciais fornecidas.
        UsuarioCliente usuarioCliente = new UsuarioCliente(cpfCliente, senhaCliente);

        // Verifica se as credenciais do cliente são válidas usando o ClienteDao.
        boolean isValidUsuarioCliente = new ClienteDao().verificarCredenciaisCliente(usuarioCliente);

        if (isValidUsuarioCliente) {
            // Se as credenciais forem válidas, define o CPF do cliente como atributo da sessão (Entrada bem-sucedida).
            req.getSession().setAttribute("logadoUsuarioCliente", cpfCliente);

            // Redireciona para a página escolhida.
            resp.sendRedirect("/TelaDeProdutos");

        } else {
            // Se as credenciais forem inválidas, exibe uma mensagem de erro e redireciona de volta para a página de entrarCliente.
            req.setAttribute("message", "Invalid credentials!");
            req.getRequestDispatcher("entrarCliente.jsp").forward(req, resp);

        }

    }
}