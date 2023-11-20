package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.ClienteDao;
import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.model.Carrinho;
import br.com.lojavinho.model.DadosEntrega;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/atualizarEndereco")
public class AtualizarEnderecoServlet extends HttpServlet  {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String CPF = request.getParameter("numCPF");
            String qtdTotal = request.getParameter("qtdTotal");
            String vlrTotal = request.getParameter("vlrTotal");

            Carrinho carrinho = new Carrinho(CPF, qtdTotal, vlrTotal);

            request.setAttribute("carrinho", carrinho);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaRegistrarEndereco/AtualizarEndereco.jsp");
            dispatcher.forward(request, response);


        }
    }


