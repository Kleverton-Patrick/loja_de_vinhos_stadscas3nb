package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.VinhoDao;
import br.com.lojavinho.model.Vinho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-vinho")
public class CreateVinhoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vinhoNome = request.getParameter("vinho-name");
        System.out.println(vinhoNome);

        //super.doPost(request, response);

        //System.out.println(vinhoNome);

        Vinho vinho = new Vinho(vinhoNome);
        new VinhoDao().createVinho(vinho);

        request.getRequestDispatcher("index.html").forward(request, response);

    }

}
