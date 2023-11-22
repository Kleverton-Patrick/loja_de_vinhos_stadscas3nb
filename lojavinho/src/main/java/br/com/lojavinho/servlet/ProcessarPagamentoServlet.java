package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.dao.PagamentoDao;
import br.com.lojavinho.model.Carrinho;
import br.com.lojavinho.model.DadosEntrega;
import br.com.lojavinho.model.DadosPagamento;
import br.com.lojavinho.model.ItemCarrinho;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/processarPagamento")
public class ProcessarPagamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();


        String nomeCartao = request.getParameter("nomeCartao");
        String numeroCartao = request.getParameter("numCartao");
        String cvc = request.getParameter("cvc");
        String validadeCartao = request.getParameter("validadeCartao");
        String numCPF = (String) session.getAttribute("CPFCliente");


        if (nomeCartao == null || numeroCartao == null || cvc == null || validadeCartao == null || numCPF == null) {
            // Tratar campos nulos, por exemplo, redirecionar para uma página de erro
            response.sendRedirect("/erroCamposNulos.jsp");
            return;
        }


        if (validadeCartao != null && !validadeCartao.isEmpty()) {

            String dataString = "01/" + validadeCartao;


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(dataString, formatter);


            String dataValidade = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            PagamentoDao pagamentoDao = new PagamentoDao();


            DadosPagamento dadosPagamento = new DadosPagamento(numCPF, nomeCartao, numeroCartao, dataValidade, Integer.parseInt(cvc));

            pagamentoDao.inserirDadosPagamento(dadosPagamento);

            List<ItemCarrinho> carrinho = CarrinhoDao.lerItemCarrinho(numCPF);
            request.setAttribute("carrinho", carrinho);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Carrinho/Carrinho.jsp");
            dispatcher.forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String numCPF = (String) session.getAttribute("CPFCliente");


        String cvc = String.valueOf(Integer.parseInt(request.getParameter("cvc")));

        boolean cvcExiste = PagamentoDao.verificarCvc(numCPF, cvc);

        if (cvcExiste) {
            DadosEntrega dadosEntrega = ComprasDao.obterUltimaCompraPorCPF(numCPF);
            request.setAttribute("numSeqEntrega", dadosEntrega.getNumSeqEntrega());
            request.setAttribute("numCPF", dadosEntrega.getNumCPF());
            request.setAttribute("CEP", dadosEntrega.getCEP());
            request.setAttribute("endereco", dadosEntrega.getEndereco());
            request.setAttribute("numEndereco", dadosEntrega.getNumEndereco());
            request.setAttribute("complEndereco", dadosEntrega.getComplEndereco());
            request.setAttribute("bairro", dadosEntrega.getBairro());
            request.setAttribute("cidade", dadosEntrega.getCidade());
            request.setAttribute("estado", dadosEntrega.getEstado());

            DadosPagamento dadosPagamento = ComprasDao.obterDadosPagamentoPorCPF(numCPF);
            request.setAttribute("numSeqPag", dadosPagamento.getNumSequencia());
            request.setAttribute("titularCartao", dadosPagamento.getNomeCartao());
            request.setAttribute("dataValidade", dadosPagamento.getDataValidade());
            request.setAttribute("numCartao", dadosPagamento.getNumCartao());

            String qtdTotal = request.getParameter("qtdTotal");
            String vlrTotal = request.getParameter("vlrTotal");

            Carrinho carrinho = new Carrinho(numCPF, qtdTotal, vlrTotal);

            request.setAttribute("carrinho", carrinho);

            List<ItemCarrinho> listaCarrinho = CarrinhoDao.lerItemCarrinho(numCPF);
            request.setAttribute("listaCarrinho", listaCarrinho);

            request.setAttribute("cvcParameter", cvc);
            request.setAttribute("cvc", cvc);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
            dispatcher.forward(request, response);
        } else {
            DadosEntrega dadosEntrega = ComprasDao.obterUltimaCompraPorCPF(numCPF);
            request.setAttribute("numSeqEntrega", dadosEntrega.getNumSeqEntrega());
            request.setAttribute("numCPF", dadosEntrega.getNumCPF());
            request.setAttribute("CEP", dadosEntrega.getCEP());
            request.setAttribute("endereco", dadosEntrega.getEndereco());
            request.setAttribute("numEndereco", dadosEntrega.getNumEndereco());
            request.setAttribute("complEndereco", dadosEntrega.getComplEndereco());
            request.setAttribute("bairro", dadosEntrega.getBairro());
            request.setAttribute("cidade", dadosEntrega.getCidade());
            request.setAttribute("estado", dadosEntrega.getEstado());

            DadosPagamento dadosPagamento = ComprasDao.obterDadosPagamentoPorCPF(numCPF);
            request.setAttribute("numSeqPag", dadosPagamento.getNumSequencia());
            request.setAttribute("titularCartao", dadosPagamento.getNomeCartao());
            request.setAttribute("dataValidade", dadosPagamento.getDataValidade());
            request.setAttribute("numCartao", dadosPagamento.getNumCartao());

            String qtdTotal = request.getParameter("qtdTotal");
            String vlrTotal = request.getParameter("vlrTotal");
            Carrinho carrinho = new Carrinho(numCPF, qtdTotal, vlrTotal);

            request.setAttribute("carrinho", carrinho);

            List<ItemCarrinho> listaCarrinho = CarrinhoDao.lerItemCarrinho(numCPF);
            request.setAttribute("listaCarrinho", listaCarrinho);

            String erroCvc = "O CVC do cartão está incorreto.";
            request.setAttribute("erroCvc", erroCvc);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
            dispatcher.forward(request, response);
        }
    }

}


