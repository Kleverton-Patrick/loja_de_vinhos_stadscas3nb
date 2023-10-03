package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.VinhoDao;
import br.com.lojavinho.model.Vinho;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-vinho")
public class CreateVinhoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String vinhoId = req.getParameter("id");
        String vinhoName = req.getParameter("vinho-name");

        Vinho vinho = new Vinho(vinhoId, vinhoName);

        VinhoDao vinhoDao = new VinhoDao();

        if (vinhoId.isBlank()) {

            vinhoDao.createVinho(vinho);

        } else {

            vinhoDao.updateVinho(vinho);
        }

        resp.sendRedirect("/find-all-vinhos");

    }

}
