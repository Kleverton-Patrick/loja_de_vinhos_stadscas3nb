package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.VinhoDao;
import br.com.lojavinho.model.Vinho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/find-all-vinhos", "/admin/find-all-vinhos"})
public class ListVinhoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Vinho> vinhos = new VinhoDao().findAllVinhos();

        req.setAttribute("vinhos", vinhos);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}
