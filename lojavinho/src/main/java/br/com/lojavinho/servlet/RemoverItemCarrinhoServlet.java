package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.model.ItemCarrinho;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RemoverItemCarrinhoServlet")
public class RemoverItemCarrinhoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String numSeqVinho = request.getParameter("numSeqVinho");
            String numCPF = request.getParameter("numCPF");


            CarrinhoDao.excluirItemCarrinho(numSeqVinho, numCPF);

            List<ItemCarrinho> carrinho = CarrinhoDao.lerItemCarrinho(numCPF);
            request.setAttribute("carrinho", carrinho);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Carrinho/Carrinho.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {

            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir item do carrinho");
        }
    }
}

