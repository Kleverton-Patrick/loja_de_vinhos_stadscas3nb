package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.UsuarioAdminDao;
import br.com.lojavinho.model.UsuarioAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginAdmin")
public class LoginAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("loginAdmin.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emailAdmin = req.getParameter("emailAdmin");
        String senhaAdmin = req.getParameter("senhaAdmin");

        UsuarioAdmin usuarioAdmin = new UsuarioAdmin(emailAdmin, senhaAdmin);

        boolean inValidUser = new UsuarioAdminDao().verifyCredentials(usuarioAdmin);

        if (inValidUser) {

            req.getSession().setAttribute("loggedUser", emailAdmin);

            resp.sendRedirect("/find-all-vinhos");

        } else {

            req.setAttribute("message", "Invalid credentials!");

            req.getRequestDispatcher("loginAdmin.jsp").forward(req, resp);
        }
    }
}
