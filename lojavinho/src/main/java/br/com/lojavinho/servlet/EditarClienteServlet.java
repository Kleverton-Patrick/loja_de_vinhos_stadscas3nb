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
        // Quando uma solicitação GET é feita para /editarcliente, esta função é acionada.

        // Obtém o nome do cliente a partir da sessão.
        String nomeCliente = (String) req.getSession().getAttribute("logadoUsuarioCliente");

        // Obtém os detalhes do cliente com base no CPF.
        UsuarioCliente cliente = obterDetalhesClientePorCpf(nomeCliente);

        // Define o objeto do cliente como atributo da requisição para exibição na página de edição.
        req.setAttribute("cliente", cliente);

        // Encaminha a requisição para a página de edição de cliente editarCliente.jsp.
        req.getRequestDispatcher("editarCliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Quando um formulário é enviado via POST, esta função é acionada para atualizar os detalhes do cliente.

        // Obtém os parâmetros do formulário.
        String nomeCliente = req.getParameter("nomeCliente");
        String cpfCliente = req.getParameter("cpfCliente");
        String emailCliente = req.getParameter("emailCliente");
        String telefoneCliente = req.getParameter("telefoneCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        // Tenta atualizar o cadastro do cliente no banco de dados.
        boolean sucesso = atualizarCadastroCliente(nomeCliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente);

        if (sucesso) {
            // Se a atualização for bem-sucedida, exibe uma mensagem de sucesso e redireciona para a página de produtos.
            req.setAttribute("message", "Cadastro atualizado com sucesso");
            req.setAttribute("message", "Cadastro atualizado com sucesso");
            resp.sendRedirect("/TelaDeBusca/Produtos.jsp");
            System.out.println("Mensagem: " + req.getAttribute("message"));

        } else {
            // Se houver falha na atualização, exibe uma mensagem de erro e redireciona de volta para a página de editarCliente.jsp.
            req.setAttribute("message", "Falha ao atualizar o cadastro. Tente novamente.");
            req.getRequestDispatcher("editarCliente.jsp").forward(req, resp);
            System.out.println("Mensagem: " + req.getAttribute("message"));

        }
    }

    private UsuarioCliente obterDetalhesClientePorCpf(String cpfCliente) {
        // Função para obter os detalhes do cliente com base no CPF usando o ClienteDao.
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.obterDetalhesClientePorCpf(cpfCliente);
    }

    private boolean atualizarCadastroCliente(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {
        // Função para atualizar o cadastro do cliente no banco de dados usando o ClienteDao.
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.atualizarCadastroCliente(nomeCliente, cpfCliente, emailCliente, telefoneCliente, senhaCliente);
    }
}