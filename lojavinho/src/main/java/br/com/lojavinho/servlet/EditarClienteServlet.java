package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.ClienteDao;
import br.com.lojavinho.model.UsuarioCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editarcliente")
public class EditarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeCliente = (String) req.getSession().getAttribute("logadoUsuarioCliente");

        UsuarioCliente cliente = obterDetalhesClientePorCpf(nomeCliente);

        req.setAttribute("cliente", cliente);

        req.getRequestDispatcher("editarCliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeCliente = req.getParameter("nomeCliente");
        String cpfCliente = req.getParameter("cpfCliente");
        String emailCliente = req.getParameter("emailCliente");
        String telefoneCliente = req.getParameter("telefoneCliente");
        String senhaCliente = req.getParameter("senhaCliente");
        int statusCliente = Integer.parseInt(req.getParameter("statusCliente"));

        ClienteDao clienteDao = new ClienteDao();

        boolean sucesso = atualizarCadastroCliente(nomeCliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente, statusCliente);

        if (sucesso) {
            req.setAttribute("message", "Cadastro atualizado com sucesso");
            resp.sendRedirect("/TelaDeProdutos");
        } else {
            req.setAttribute("message", "Falha ao atualizar o cadastro. Tente novamente.");
            req.getRequestDispatcher("editarCliente.jsp").forward(req, resp);
        }
    }

    private UsuarioCliente obterDetalhesClientePorCpf(String cpfCliente) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.obterDetalhesClientePorCpf(cpfCliente);
    }

    private boolean atualizarCadastroCliente(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente, int statusCliente) {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.atualizarCadastroCliente(nomeCliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente, statusCliente);
    }
}
