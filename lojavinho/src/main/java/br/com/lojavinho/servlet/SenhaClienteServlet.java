package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.UserDao;
import br.com.lojavinho.model.UsuarioCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entrarcliente")
public class SenhaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("entrarcliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuarioNomeCliente = req.getParameter("usuarioNomeCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        UsuarioCliente usuarioCliente = new UsuarioCliente(usuarioNomeCliente, senhaCliente);

        boolean isValidUsuarioCliente = new UserDao().verifyCredentialsCliente(usuarioCliente);

        if (isValidUsuarioCliente) {

            //req.getSession().setAttribute("loggedUserCliente", usuarioNomeCliente);
            req.getSession().setAttribute("loggedUser", usuarioNomeCliente);

            resp.sendRedirect("/find-all-vinhos");

        } else {

            req.setAttribute("message", "Invalid credentials!");

            req.getRequestDispatcher("entrarcliente.jsp").forward(req, resp);

        }

    }
}