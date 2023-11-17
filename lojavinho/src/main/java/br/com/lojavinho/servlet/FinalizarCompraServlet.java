package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.model.DadosEntrega;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FinalizarCompraServlet")
public class FinalizarCompraServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        if (session.getAttribute("logadoUsuarioCliente") != null) {
            String cliente = (String) session.getAttribute("logadoUsuarioCliente");

            DadosEntrega dadosEntrega = ComprasDao.obterUltimaCompraPorCPF(cliente);

            if (dadosEntrega != null) {
                // Adicione os dados à requisição para uso na JSP
                request.setAttribute("enderecoUltimaCompra", dadosEntrega.getEndereco());
                request.setAttribute("cidadeUltimaCompra", dadosEntrega.getCidade());
                request.setAttribute("estadoUltimaCompra", dadosEntrega.getEstado());
            }

            // Redirecione para a página de finalizar compra
            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
            dispatcher.forward(request, response);
        } else {
            // O cliente não está logado, redirecione para a página de login
            response.sendRedirect("entrarCliente.jsp");
        }
    }
}
