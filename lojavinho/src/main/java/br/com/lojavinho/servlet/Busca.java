package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.VinhoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Busca")
public class Busca extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    String nomeVinho = request.getParameter("busca");

        if (nomeVinho != null && !nomeVinho.isEmpty()) {
        List<String> nomesDosVinhos = VinhoDao.obterNomesDosVinhos(nomeVinho);
        request.setAttribute("resultados", nomesDosVinhos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaDeBusca/Resultado.jsp");
        dispatcher.forward(request, response);
    }
   }
}

