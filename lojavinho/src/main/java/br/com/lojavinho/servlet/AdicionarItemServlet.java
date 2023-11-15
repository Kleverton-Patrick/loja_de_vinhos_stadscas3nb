package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.dao.VinhoDao;
import br.com.lojavinho.model.Carrinho;
import br.com.lojavinho.model.ItemCarrinho;
import br.com.lojavinho.model.Vinho;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/AdicionarItem")

public class AdicionarItemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String numSeqVinho = request.getParameter("numSeqVinho");
        String descNomeVinho = request.getParameter("descNomeVinho");
        String qtdProduto = request.getParameter("qtdProduto");
        String vlrProduto = request.getParameter("vlrProduto");
        String numCPF = request.getParameter("numCPF");
        String imagem = request.getParameter("imagem");

        ItemCarrinho Itemcarrinho = new ItemCarrinho(numSeqVinho, descNomeVinho, qtdProduto, vlrProduto, numCPF, imagem);

        CarrinhoDao carrinhoDao = new CarrinhoDao();
        carrinhoDao.inserirItemCarrinho(Itemcarrinho);

        List<ItemCarrinho> carrinho = CarrinhoDao.lerItemCarrinho(numCPF);

        request.setAttribute("carrinho", carrinho);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/Carrinho/Carrinho.jsp");
        dispatcher.forward(request, response);


    }
}