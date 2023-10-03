package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.VinhoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-vinho")
public class DeleteVinhoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vinhoId = req.getParameter("id");

        new VinhoDao().deleteVinhoById(vinhoId);

        resp.sendRedirect("/find-all-vinhos");
    }

}
