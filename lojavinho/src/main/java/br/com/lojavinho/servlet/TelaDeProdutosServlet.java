package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.VinhoDao;
import br.com.lojavinho.model.Pais;
import br.com.lojavinho.model.TipoUva;
import br.com.lojavinho.model.TipoVinho;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit;
import java.io.IOException;
import java.util.List;

@WebServlet("/TelaDeProdutos")
public class TelaDeProdutosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            List<Pais> paises = VinhoDao.obterPaises();
            List<TipoVinho> tiposVinho = VinhoDao.obterTiposVinho();
            List<TipoUva> tiposUva = VinhoDao.obterTiposUva();

            request.setAttribute("pais", paises);
            request.setAttribute("tipoVinho", tiposVinho);
            request.setAttribute("tipoUva", tiposUva);

            String contextPath = request.getContextPath();
            String jspPath = "/TelaDeBusca/Produtos.jsp";
            String fullPath = contextPath + jspPath;

            RequestDispatcher dispatcher = request.getRequestDispatcher(fullPath);
            dispatcher.forward(request, response);

        }
    }

}


