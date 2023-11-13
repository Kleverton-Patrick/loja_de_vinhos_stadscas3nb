package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.model.Carrinho;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/AddCart")

public class AddCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String valor = request.getParameter("valor");
        String quantidade = request.getParameter("quantidade");

        Carrinho carrinho = new Carrinho(id, nome, valor, quantidade);

        CarrinhoDao carrinhoDao = new CarrinhoDao();
        carrinhoDao.createCarrinho(carrinho);

        request.getSession().setAttribute("carrinhoAdicionado", true);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaDeBusca/Produtos.jsp");
        dispatcher.forward(request, response);


    }
}