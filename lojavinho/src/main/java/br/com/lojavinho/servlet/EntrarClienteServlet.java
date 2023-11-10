package br.com.lojavinho.servlet;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.dao.ClienteDao;
import br.com.lojavinho.model.UsuarioCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/entrarcliente")
public class EntrarClienteServlet extends HttpServlet {

    // Quando uma solicitação GET é feita para /entrarcliente, esta função é acionada.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Encaminha a requisição para a página de login do cliente.
        req.getRequestDispatcher("entrarCliente.jsp").forward(req, resp);
    }

    // Quando um formulário é enviado via POST, esta função é acionada para verificar as credenciais do cliente.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Obtém os parâmetros do formulário.
        String cpfCliente = req.getParameter("cpfCliente");
        String senhaCliente = req.getParameter("senhaCliente");

        // Cria um objeto UsuarioCliente com as credenciais fornecidas.
        UsuarioCliente usuarioCliente = new UsuarioCliente(cpfCliente, senhaCliente);

        // Verifica se as credenciais do cliente são válidas usando o ClienteDao.
        ClienteDao clienteDao = new ClienteDao();
        boolean isValidUsuarioCliente = clienteDao.verificarCredenciaisCliente(usuarioCliente);

        int statusCliente = clienteDao.obterStatusCliente(cpfCliente);

        if (isValidUsuarioCliente) {
            // Se as credenciais forem válidas, obtenha o status do cliente.


            if (statusCliente == 1) {
                // O cliente está ativo, permita o login.
                req.getSession().setAttribute("logadoUsuarioCliente", cpfCliente);
                resp.sendRedirect("/find-all-vinhos");
            } else {
                // O cliente está inativo, exiba uma mensagem de erro e redirecione de volta para a página de entrarCliente.
                req.setAttribute("message", "Cliente inativo. Entre em contato com o suporte.");
                req.getRequestDispatcher("entrarCliente.jsp").forward(req, resp);
            }
        } else {
            // Se as credenciais forem inválidas, exibe uma mensagem de erro e redireciona de volta para a página de entrarCliente.
            req.setAttribute("message", "Credenciais inválidas!");
            req.getRequestDispatcher("entrarCliente.jsp").forward(req, resp);
        }
    }
    public int obterStatusCliente(String cpfCliente) {
        String SQL = "SELECT STATUS FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                return resultSet.getInt("STATUS");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1; // Valor padrão para cliente não encontrado.
    }
}