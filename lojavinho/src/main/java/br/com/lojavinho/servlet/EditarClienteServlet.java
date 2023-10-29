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

        String usuarioNomeCliente = (String) req.getSession().getAttribute("logadoUsuarioCliente");


        UsuarioCliente cliente = obterDetalhesClientePorNome(usuarioNomeCliente);


        req.setAttribute("cliente", cliente);


        req.getRequestDispatcher("editarcliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usuarioNomeCliente = req.getParameter("usuarioNomeCliente");
        String cpfCliente = req.getParameter("cpfCliente");
        String emailCliente = req.getParameter("emailCliente");
        String telefoneCliente = req.getParameter("telefoneCliente");
        String senhaCliente = req.getParameter("senhaCliente");


        boolean sucesso = atualizarCadastroCliente(usuarioNomeCliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente);

        if (sucesso) {
            req.setAttribute("message", "Cadastro atualizado com sucesso");
            resp.sendRedirect("/TelaInicial/TelaInicial.html");
            System.out.println("Mensagem: " + req.getAttribute("message"));

        } else {
            req.setAttribute("message", "Falha ao atualizar o cadastro. Tente novamente.");
            req.getRequestDispatcher("editarcliente.jsp").forward(req, resp);
            System.out.println("Mensagem: " + req.getAttribute("message"));

        }
    }

    private UsuarioCliente obterDetalhesClientePorNome(String usuarioNomeCliente) {

        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.obterDetalhesClientePorNome(usuarioNomeCliente);
    }

    private boolean atualizarCadastroCliente(String usuarioNomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {

        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.atualizarCadastroCliente(usuarioNomeCliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente);
    }
}