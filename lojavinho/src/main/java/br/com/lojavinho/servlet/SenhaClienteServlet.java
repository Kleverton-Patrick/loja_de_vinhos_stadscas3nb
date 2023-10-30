package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.ClienteDao;
import br.com.lojavinho.model.UsuarioCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/senhaCliente")
public class SenhaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("senhaCliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cpfCliente = req.getParameter("cpfCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        UsuarioCliente usuarioCliente = new UsuarioCliente(cpfCliente, senhaCliente);

        boolean isValidUsuarioCliente = new ClienteDao().verificarCredenciaisCliente(usuarioCliente);

        if (isValidUsuarioCliente) {

            req.getSession().setAttribute("logadoUsuarioCliente", cpfCliente);
            //req.getSession().setAttribute("loggedUser", cpfCliente);

            resp.sendRedirect("/find-all-vinhos");

        } else {

            req.setAttribute("message", "Invalid credentials!");

            req.getRequestDispatcher("senhaCliente.jsp").forward(req, resp);

        }

    }
}