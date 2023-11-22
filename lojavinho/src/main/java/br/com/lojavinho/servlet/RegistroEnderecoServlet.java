package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.dao.ClienteDao;
import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.model.Carrinho;
import br.com.lojavinho.model.DadosEntrega;
import br.com.lojavinho.model.DadosPagamento;
import br.com.lojavinho.model.ItemCarrinho;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registroEndereco")

public class RegistroEnderecoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String CPF = request.getParameter("numCPF");
        String CEP = request.getParameter("CEP");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");



        ClienteDao clienteDao = new ClienteDao();



        clienteDao.registrarEndereco(CPF, CEP, endereco, numero, complemento, bairro, cidade, estado);


        String qtdTotal = request.getParameter("qtdTotal");
        String vlrTotal = request.getParameter("vlrTotal");


        Carrinho carrinho = new Carrinho(CPF, qtdTotal, vlrTotal);

        List<ItemCarrinho> listaCarrinho = CarrinhoDao.lerItemCarrinho(CPF);

        DadosEntrega dadosEntrega = ComprasDao.obterUltimaCompraPorCPF(CPF);

        request.setAttribute("numSeqEntrega", dadosEntrega.getNumSeqEntrega());
        request.setAttribute("CEP", dadosEntrega.getCEP());
        request.setAttribute("endereco", dadosEntrega.getEndereco());
        request.setAttribute("numEndereco", dadosEntrega.getNumEndereco());
        request.setAttribute("complEndereco", dadosEntrega.getComplEndereco());
        request.setAttribute("bairro", dadosEntrega.getBairro());
        request.setAttribute("cidade", dadosEntrega.getCidade());
        request.setAttribute("estado", dadosEntrega.getEstado());

        request.setAttribute("carrinho", carrinho);

        request.setAttribute("listaCarrinho", listaCarrinho);

        DadosPagamento dadosPagamento = ComprasDao.obterDadosPagamentoPorCPF(CPF);

        if (dadosPagamento == null) {
            response.sendRedirect("/TelaCadastroPagamento/CadastroPagamento.jsp");
            return;
        }

        else {
            request.setAttribute("titularCartao", dadosPagamento.getNomeCartao());
            request.setAttribute("dataValidade", dadosPagamento.getDataValidade());
            request.setAttribute("numCartao", dadosPagamento.getNumCartao());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/TelaFinalizarCompra/FinalizarCompra.jsp");
            dispatcher.forward(request, response);

        }


    }
}
