package br.com.lojavinho.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet({"/TelaInicial", "/entrarcliente/TelaInicial"})
//@WebServlet("/TelaInicial")
public class TelaInicialServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher
                ("/TelaInicial/TelaInicial.jsp").forward(req, resp);

    }
}



