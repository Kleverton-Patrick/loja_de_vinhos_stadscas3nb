package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.model.Carrinho;
import br.com.lojavinho.model.DadosEntrega;
import br.com.lojavinho.model.DadosPagamento;
import br.com.lojavinho.model.ItemCarrinho;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FinalizarCompraServlet")
public class FinalizarCompraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String numCPF = request.getParameter("numCPF");
            String totalQtd = request.getParameter("totalQtd");
            String totalVlr = request.getParameter("totalVlr");


            if (CarrinhoDao.lerItemCarrinho(numCPF).isEmpty()) {
                request.setAttribute("mensagem", "Seu carrinho está vazio. Selecione pelo menos um produto para compra.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Carrinho/Carrinho.jsp");
                dispatcher.forward(request, response);
                return;
            }

            ComprasDao comprasdao = new ComprasDao();
            Carrinho carrinho = new Carrinho(numCPF, totalQtd, totalVlr);
            boolean possuiEndereco = comprasdao.CPFpossuiEndereco(numCPF);


            if (possuiEndereco) {
                List<ItemCarrinho> listaCarrinho = CarrinhoDao.lerItemCarrinho(numCPF);
                request.setAttribute("listaCarrinho", listaCarrinho);
                DadosEntrega dadosEntrega = ComprasDao.obterUltimaCompraPorCPF(numCPF);
                DadosPagamento dadosPagamento = ComprasDao.obterDadosPagamentoPorCPF(numCPF);

                if (dadosPagamento == null) {
                    response.sendRedirect("/TelaCadastroPagamento/CadastroPagamento.jsp");
                    return;
                }

                    request.setAttribute("titularCartao", dadosPagamento.getNomeCartao());
                    request.setAttribute("dataValidade", dadosPagamento.getDataValidade());
                    request.setAttribute("numCartao", dadosPagamento.getNumCartao());


                request.setAttribute("numSeqEntrega", dadosEntrega.getNumSeqEntrega());
                request.setAttribute("numCPF", dadosEntrega.getNumCPF());
                request.setAttribute("CEP", dadosEntrega.getCEP());
                request.setAttribute("endereco", dadosEntrega.getEndereco());
                request.setAttribute("numEndereco", dadosEntrega.getNumEndereco());
                request.setAttribute("complEndereco", dadosEntrega.getComplEndereco());
                request.setAttribute("bairro", dadosEntrega.getBairro());
                request.setAttribute("cidade", dadosEntrega.getCidade());
                request.setAttribute("estado", dadosEntrega.getEstado());

                request.setAttribute("carrinho", carrinho);

                request.setAttribute("listaCarrinho", listaCarrinho);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
                dispatcher.forward(request, response);
            }
            else {

                request.setAttribute("carrinho", carrinho);


                RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaRegistrarEndereco/RegistrarEndereco.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao processar a finalização da compra");
        }
    }
}




