package br.com.lojavinho.servlet;

import br.com.lojavinho.dao.CarrinhoDao;
import br.com.lojavinho.dao.ComprasDao;
import br.com.lojavinho.model.Compras;
import br.com.lojavinho.model.ItemCarrinho;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EncerrarCompra")
public class EncerrarCompraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numCPF = request.getParameter("numCPF");
        List<ItemCarrinho> listaCarrinho = CarrinhoDao.lerItemCarrinho(numCPF);

        BigDecimal valorTotalVenda = calcularValorTotal(listaCarrinho);

        Compras compras = new Compras();
        compras.setCpfCliente(numCPF);
        compras.setDataOperacao(LocalDateTime.now());
        compras.setValorTotalVenda(valorTotalVenda);

        ComprasDao.registrarCompra(compras, listaCarrinho);

        CarrinhoDao.excluirCarrinho(numCPF);

        response.sendRedirect("/paginaDeConfirmacao.jsp");
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



