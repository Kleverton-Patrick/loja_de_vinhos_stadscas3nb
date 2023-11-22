package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.dao.PagamentoDao;
import br.com.lojavinho.model.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EncerrarCompra")
public class EncerrarCompraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String numCPF = (String) session.getAttribute("CPFCliente");

        String cvcParam = request.getParameter("cvc");

        if (cvcParam == null || cvcParam.trim().isEmpty()) {
            DadosEntrega dadosEntrega = ComprasDao.obterUltimaCompraPorCPF(numCPF);
            request.setAttribute("numCPF", dadosEntrega.getNumCPF());
            request.setAttribute("CEP", dadosEntrega.getCEP());
            request.setAttribute("endereco", dadosEntrega.getEndereco());
            request.setAttribute("numEndereco", dadosEntrega.getNumEndereco());
            request.setAttribute("complEndereco", dadosEntrega.getComplEndereco());
            request.setAttribute("bairro", dadosEntrega.getBairro());
            request.setAttribute("cidade", dadosEntrega.getCidade());
            request.setAttribute("estado", dadosEntrega.getEstado());

            DadosPagamento dadosPagamento = ComprasDao.obterDadosPagamentoPorCPF(numCPF);
            request.setAttribute("titularCartao", dadosPagamento.getNomeCartao());
            request.setAttribute("dataValidade", dadosPagamento.getDataValidade());
            request.setAttribute("numCartao", dadosPagamento.getNumCartao());

            String qtdTotal = request.getParameter("qtdTotal");
            String vlrTotal = request.getParameter("vlrTotal");

            Carrinho carrinho = new Carrinho(numCPF, qtdTotal, vlrTotal);

            request.setAttribute("carrinho", carrinho);

            List<ItemCarrinho> listaCarrinho = CarrinhoDao.lerItemCarrinho(numCPF);
            request.setAttribute("listaCarrinho", listaCarrinho);

            String erroCvc = "Forneça um CVC válido para finalizar a compra!.";
            request.setAttribute("erroCvc", erroCvc);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                int cvc = Integer.parseInt(cvcParam);

                boolean cvcExiste = PagamentoDao.verificarCvc(numCPF, String.valueOf(cvc));

                if (cvcExiste) {
                    List<ItemCarrinho> listaCarrinho = CarrinhoDao.lerItemCarrinho(numCPF);
                    numCPF = request.getParameter("numCPF");
                    String numSeqPag = request.getParameter("numSeqPag");
                    String numSeqEntrega = request.getParameter("numSeqEntrega");


                    BigDecimal valorTotalVenda = calcularValorTotal(listaCarrinho);

                    Compras compras = new Compras();
                    compras.setCpfCliente(numCPF);
                    compras.setDataOperacao(LocalDateTime.now());
                    compras.setValorTotalVenda(valorTotalVenda);
                    compras.setNumSeqPag(numSeqPag);
                    compras.setNumSeqEntrega(numSeqEntrega);

                    ComprasDao.registrarCompra(compras, listaCarrinho);

                    CarrinhoDao.excluirCarrinho(numCPF);

                    response.sendRedirect("/PaginaDeConfirmacao/paginaDeConfirmacao.jsp");
                } else {

                    request.setAttribute("erroCvc", "Código CVC incorreto. Por favor, verifique e tente novamente.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (NumberFormatException e) {

                request.setAttribute("erroCvc", "Por favor, forneça um código CVC válido.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaCadastroPagamento/CadastroPagamento.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private BigDecimal calcularValorTotal(List<ItemCarrinho> listaCarrinho) {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrinho item : listaCarrinho) {
            BigDecimal valorItem = new BigDecimal(item.getVlrProduto());
            BigDecimal quantidade = new BigDecimal(item.getQtdProduto());
            total = total.add(valorItem.multiply(quantidade));
        }
        return total;
    }
}



