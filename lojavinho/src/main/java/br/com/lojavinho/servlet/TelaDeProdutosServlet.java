package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.VinhoDao;
import br.com.lojavinho.model.Pais;
import br.com.lojavinho.model.TipoUva;
import br.com.lojavinho.model.TipoVinho;
import br.com.lojavinho.model.Vinho;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit;
import java.io.IOException;
import java.util.List;
@WebServlet({"/TelaDeProdutos", "/entrarcliente/TelaDeProdutos"})
//@WebServlet("/TelaDeProdutos")
public class TelaDeProdutosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String harmonizacaoID = request.getParameter("categoria");
        if (harmonizacaoID != null) {
            switch (harmonizacaoID) {
                case "1":
                    harmonizacaoID = "1";
                    break;
                case "2":
                    harmonizacaoID = "2";
                    break;
                case "3":
                    harmonizacaoID = "3";
                    break;
                case "4":
                    harmonizacaoID = "4";
                default:
                    break;
            }

            if (!harmonizacaoID.isEmpty()) {

                List<Vinho> resultados = VinhoDao.obterCard(harmonizacaoID);

                request.setAttribute("resultados", resultados);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaDeResultado/Resultados.jsp");
                dispatcher.forward(request, response);

                return;
            }

        }

        String nomeVinho = request.getParameter("busca");
        if (nomeVinho != null && !nomeVinho.isEmpty()) {

            List<Vinho> resultados = VinhoDao.obterDetalhesDosVinhos(nomeVinho);

            request.setAttribute("resultados", resultados);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaDeResultado/Resultados.jsp");

            dispatcher.forward(request, response);

            return;
        }

        if (request.getParameter("buscaComposta") != null) {

            String pais = request.getParameter("pais");
            String paisID = null;
            if (pais != null && !pais.isEmpty()) {
                paisID = pais;
            }

            String tipoVinho = request.getParameter("tipoVinho");
            String tipoVinhoID = null;
            if (tipoVinho != null && !tipoVinho.isEmpty()) {
                tipoVinhoID = tipoVinho;
            }

            String tipoUva = request.getParameter("tipoUva");
            String tipoUvaID = null;
            if (tipoUva != null && !tipoUva.isEmpty()) {

                tipoUvaID = tipoUva;

            }

            List<Vinho> resultados = VinhoDao.obterVinhos(paisID, tipoVinhoID, tipoUvaID);

            request.setAttribute("resultados", resultados);

            RequestDispatcher dispatcher = request.getRequestDispatcher("//TelaDeResultado/Resultados.jsp");
            dispatcher.forward(request, response);

            return;

        }


        VinhoDao vinhoDao = new VinhoDao();
        List<Pais> paises = vinhoDao.obterPaises();
        List<TipoVinho> tiposVinho = vinhoDao.obterTiposVinho();
        List<TipoUva> tiposUva = vinhoDao.obterTiposUva();


        request.setAttribute("pais", paises);
        request.setAttribute("tipoVinho", tiposVinho);
        request.setAttribute("tipoUva", tiposUva);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaDeBusca/Produtos.jsp");
        dispatcher.forward(request, response);
    }
}






