package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.Compras;
import br.com.lojavinho.model.DadosEntrega;
import br.com.lojavinho.model.DadosPagamento;
import br.com.lojavinho.model.ItemCarrinho;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class ComprasDao {

    public boolean CPFpossuiEndereco(String CPF) {

        boolean existe = false;

        try (Connection connection = ConnectionPoolConfig.getConnection()) {

            String sql = "SELECT * FROM DADOS_ENTREGA  WHERE NUM_CPF = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, CPF);

            try (ResultSet rs = statement.executeQuery()) {
                existe = rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Fail in database connection");
            System.out.println("Error: " + e.getMessage());
        }

        return existe;
    }

    public static DadosEntrega obterUltimaCompraPorCPF(String cpf) {

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT * FROM DADOS_ENTREGA  WHERE NUM_CPF = ? ";


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String numSeqEntrega = resultSet.getString("NUM_SEQ_ENTREGA");
                String CEP = resultSet.getString("COD_CEP");
                String endereco = resultSet.getString("DSC_ENDERECO");
                String numEndereco = resultSet.getString("NUM_ENDERECO");
                String complEndereco = resultSet.getString("DSC_COMPL_ENDERECO");
                String bairro = resultSet.getString("DSC_BAIRRO");
                String cidade = resultSet.getString("DSC_CIDADE");
                String estado = resultSet.getString("DSC_ESTADO");


                DadosEntrega dadosEntrega = new DadosEntrega(numSeqEntrega, CEP, endereco, numEndereco, complEndereco, bairro, cidade, estado);

                System.out.println("Encontrada compra registrada anteriormente para o CPF");
                connection.close();

                return dadosEntrega;
            } else {
                System.out.println("Nenhuma compra registrada anteriormente para o CPF");
                connection.close();
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Fail in database connection");
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static int registrarCompra(Compras compra, List<ItemCarrinho> listaCarrinho) {
        try (Connection connection = ConnectionPoolConfig.getConnection()) {

            String sqlCompra = "INSERT INTO COMPRA (DTA_OPERACAO, VLR_TOTAL_VENDA, FK_NUM_CPF, FK_NUM_SEQ_PAG, FK_NUM_SEQ_ENTREGA) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatementCompra = connection.prepareStatement(sqlCompra, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatementCompra.setObject(1, compra.getDataOperacao());
                preparedStatementCompra.setBigDecimal(2, compra.getValorTotalVenda());
                preparedStatementCompra.setString(3, compra.getCpfCliente());
                preparedStatementCompra.setString(4, compra.getNumSeqPag());
                preparedStatementCompra.setString(5, compra.getNumSeqEntrega());
                preparedStatementCompra.executeUpdate();

                try (ResultSet generatedKeys = preparedStatementCompra.getGeneratedKeys()) {
                    int compraId = -1;
                    if (generatedKeys.next()) {
                        compraId = generatedKeys.getInt(1);
                    }

                    String sqlItemCompra = "INSERT INTO ITEM_COMPRA (DSC_NOME_VINHO, QTD_VENDIDA_PRODUTO, VLR_VENDIDO_PRODUTO, FK_NUM_SEQ_VINHO, FK_NUM_SEQ_COMPRA) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatementItemCompra = connection.prepareStatement(sqlItemCompra)) {
                        for (ItemCarrinho item : listaCarrinho) {
                            preparedStatementItemCompra.setString(1, item.getDescNomeVinho());
                            preparedStatementItemCompra.setInt(2, Integer.parseInt(item.getQtdProduto()));
                            preparedStatementItemCompra.setBigDecimal(3, new BigDecimal(item.getVlrProduto()));
                            preparedStatementItemCompra.setInt(4, Integer.parseInt(item.getNumSeqVinho()));
                            preparedStatementItemCompra.setInt(5, compraId);
                            preparedStatementItemCompra.addBatch();
                        }
                        preparedStatementItemCompra.executeBatch();

                        return compraId;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Fail in database connection or SQL query!");
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }


    public static Integer obterNumeroSequenciaPorCPF(String numCPF) {
        String SQL = "SELECT NUM_SEQUENCIA FROM COMPRAS WHERE CPF_CLIENTE = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, numCPF);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("NUM_SEQUENCIA");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }
    public static DadosPagamento obterDadosPagamentoPorCPF(String cpf) {
        String sql = "SELECT * FROM DADOS_PAGAMENTO WHERE FK_NUM_CPF = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cpf);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int numSequencia = resultSet.getInt("NUM_SEQUENCIA");
                    String numCPF = resultSet.getString("FK_NUM_CPF");
                    String nomeCliente = resultSet.getString("DSC_NOME_CLIENTE");
                    String numCartao = resultSet.getString("NUM_CARTAO");
                    int cvc = resultSet.getInt("CVC");
                    String dataValidade = resultSet.getString("DATA_VALIDADE");

                    DadosPagamento dadosPagamento = new DadosPagamento(numSequencia, numCPF, nomeCliente, numCartao, cvc, dataValidade);

                    System.out.println("Encontrados dados de pagamento para o CPF");
                    return dadosPagamento;
                } else {
                    System.out.println("Nenhum dado de pagamento encontrado para o CPF");
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados ou na consulta SQL");
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}


