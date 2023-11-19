package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.model.Carrinho;
import br.com.lojavinho.model.DadosEntrega;
import br.com.lojavinho.model.ItemCarrinho;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FinalizarCompraServlet")
public class FinalizarCompraServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String numCPF = request.getParameter("numCPF");
        String totalQtd = request.getParameter("totalQtd");
        String totalVlr = request.getParameter("totalVlr");

        ComprasDao comprasdao = new ComprasDao();

        Carrinho carrinho = new Carrinho(numCPF, totalQtd, totalVlr);

        boolean possuiEndereço = comprasdao.CPFpossuiEndereco(numCPF);

        if(possuiEndereço == true) {

            DadosEntrega dadosEntrega = ComprasDao.obterUltimaCompraPorCPF(numCPF);

            request.setAttribute("CEP", dadosEntrega.getCEP());
            request.setAttribute("endereco", dadosEntrega.getEndereco());
            request.setAttribute("numEndereco", dadosEntrega.getNumEndereco());
            request.setAttribute("complEndereco", dadosEntrega.getComplEndereco());
            request.setAttribute("bairro", dadosEntrega.getBairro());
            request.setAttribute("cidade", dadosEntrega.getCidade());
            request.setAttribute("estado", dadosEntrega.getEstado());



            request.setAttribute("carrinho", carrinho);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
            dispatcher.forward(request, response);


        }

        else{

            response.sendRedirect("/TelaFinalizarCompra/RegistrarEndereco.jsp");

        }

    }
}




/*
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


 */



