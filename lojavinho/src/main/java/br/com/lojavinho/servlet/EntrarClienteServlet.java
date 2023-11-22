package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.ClienteDao;
import br.com.lojavinho.model.UsuarioCliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entrarcliente")
public class EntrarClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("entrarCliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cpfCliente = req.getParameter("cpfCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        UsuarioCliente usuarioCliente = new UsuarioCliente(cpfCliente, senhaCliente);

        ClienteDao clienteDao = new ClienteDao();

        String mensagemErro = clienteDao.verificarCredenciaisEStatusCliente(usuarioCliente);

        if (mensagemErro == null) {

            String nomeCliente = clienteDao.obterNomeClientePorCpf(cpfCliente);

            req.getSession().setAttribute("CPFCliente", cpfCliente);

            req.getSession().setAttribute("logadoUsuarioCliente", nomeCliente);
            resp.sendRedirect("/registroCliente");
        } else {

            req.setAttribute("message", mensagemErro);
            req.getRequestDispatcher("entrarCliente.jsp").forward(req, resp);
        }
    }
}
