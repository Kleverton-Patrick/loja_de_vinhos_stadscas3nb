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
        req.getRequestDispatcher("registroCliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cliente = req.getParameter("cliente");
        String cpfCliente = req.getParameter("cpfCliente");
        String emailCliente = req.getParameter("emailCliente");
        String telefoneCliente = req.getParameter("telefoneCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        ClienteDao clienteDao = new ClienteDao();
        boolean isRegistered = clienteDao.registroUsuario(cliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente);

        if (isRegistered) {
            req.getSession().setAttribute("logadoUsuarioCliente", cliente);
            resp.sendRedirect("/TelaDeBusca/Produtos.jsp");
        } else {
            req.setAttribute("message", "Falha ao registrar. Por favor, tente novamente.");
            req.getRequestDispatcher("registroCliente.jsp").forward(req, resp);
            System.out.println("Mensagem: " + req.getAttribute("message"));

        }
    }
}