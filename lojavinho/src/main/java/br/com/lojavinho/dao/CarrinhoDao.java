package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.Carrinho;
import br.com.lojavinho.model.ItemCarrinho;
import br.com.lojavinho.model.Vinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarrinhoDao {

    public boolean lerCarrinho(String numCPF) {

        String SQL = "SELECT * FROM CARRINHO WHERE NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Success in select CARRINHO!");

            if (resultSet != null) {

                connection.close();

                return true;

            }

            connection.close();

            return false;

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

            return false;

        }
    }

    public void inserirCarrinho(Carrinho carrinho) {

        String SQL = "INSERT INTO CARRINHO (NUM_CPF, QTD_TOTAL, VLR_TOTAL) VALUES (?, ?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, carrinho.getNumCPF());
            preparedStatement.setString(2, carrinho.getQtdTotal());
            preparedStatement.setString(3, carrinho.getVlrTotal());

            System.out.println("Success in insert CARRINHO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public void alterarCarrinho(Carrinho carrinho) {

        String SQL = "UPDATE CARRINHO SET QTD_TOTAL = ?, VLR_TOTAL = ? WHERE NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, carrinho.getQtdTotal());
            preparedStatement.setString(2, carrinho.getVlrTotal());
            preparedStatement.setString(3, carrinho.getNumCPF());

            preparedStatement.execute();

            System.out.println("Success in update CARRINHO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public void excluirCarrinho(String numCPF) {

        String SQL = "DELETE FROM CARRINHO WHERE NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);

            preparedStatement.execute();

            System.out.println("Success on delete CARRINHO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public int lerVinhoItemCarrinho(String numCPF, int numSeqVinho) {

        String SQL = "SELECT NUM_SEQUENCIA FROM ITEM_CARRINHO WHERE FK_NUM_CPF = ? AND NUM_SEQ_VINHO = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);
            preparedStatement.setInt(2, numSeqVinho);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Success in select sequence ITEM_CARRINHO!");

            if (resultSet != null) {

                int seqItem = resultSet.getInt("NUM_SEQUENCIA");

                connection.close();

                return seqItem;

            }

            connection.close();

            return 0;

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

            return -1;

        }
    }

    public void inserirItemCarrinho(ItemCarrinho itemCarrinho) {

        String SQL = "INSERT INTO ITEM_CARRINHO (NUM_SEQ_VINHO, DSC_NOME_VINHO, QTD_PRODUTO, VLR_PRODUTO, NUM_CPF, IMAGEM) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, itemCarrinho.getNumSeqVinho());
            preparedStatement.setString(2, itemCarrinho.getDescNomeVinho());
            preparedStatement.setString(3, itemCarrinho.getQtdProduto());
            preparedStatement.setString(4, itemCarrinho.getVlrProduto());
            preparedStatement.setString(5, itemCarrinho.getNumCPF());
            preparedStatement.setString(6, itemCarrinho.getImagem());
            preparedStatement.execute();

            System.out.println("Success in insert ITEM_CARRINHO");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public static List<ItemCarrinho> lerItemCarrinho(String numCPF) {

        String SQL = "SELECT * FROM ITEM_CARRINHO WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null) {

                connection.close();

                return Collections.emptyList();

            }

            List<ItemCarrinho> ItemCarrinho = new ArrayList<>();

            while (resultSet.next()) {

                String itemCarrinhoSeqItem = resultSet.getString("NUM_SEQUENCIA");
                String itemCarrinhoNumSeqVinho = resultSet.getString("NUM_SEQ_VINHO");
                String itemCarrinhoDescNomeVinho = resultSet.getString("DSC_NOME_VINHO");
                String itemCarrinhoQtdProduto = resultSet.getString("QTD_PRODUTO");
                String itemCarrinhoVlrProduto = resultSet.getString("VLR_PRODUTO");
                String itemCarrinhoNumCPF = resultSet.getString("NUM_CPF");
                String itemCarrinhoImagem = resultSet.getString("IMAGEM");

                ItemCarrinho itemCarrinho = new ItemCarrinho(itemCarrinhoSeqItem, itemCarrinhoNumSeqVinho, itemCarrinhoDescNomeVinho, itemCarrinhoQtdProduto, itemCarrinhoVlrProduto, itemCarrinhoNumCPF, itemCarrinhoImagem);

                ItemCarrinho.add(itemCarrinho);
            }

            System.out.println("Success in select ITEM_CARRINHO");

            connection.close();

            return ItemCarrinho;

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

            return Collections.emptyList();

        }
    }

    public void alterarItemCarrinho(ItemCarrinho itemCarrinho) {

        String SQL = "UPDATE ITEM_CARRINHO SET QTD_PRODUTO = ?, VLR_PRODUTO = ? WHERE NUM_SEQUENCIA = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, itemCarrinho.getQtdProduto());
            preparedStatement.setString(2, itemCarrinho.getVlrProduto());
            preparedStatement.setString(3, itemCarrinho.getSeqItem());

            preparedStatement.execute();

            System.out.println("Success in update ITEM_CARRINHO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public void excluirVinhoItemCarrinho(int seqItem) {

        String SQL = "DELETE FROM ITEM_CARRINHO WHERE NUM_SEQUENCIA = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, seqItem);

            preparedStatement.execute();

            System.out.println("Success on delete sequence ITEM_CARRINHO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public void excluirItemCarrinho(String numCPF) {

        String SQL = "DELETE * FROM ITEM_CARRINHO WHERE FK_NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);

            preparedStatement.execute();

            System.out.println("Success on delete ITEM_CARRINHO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }

    public int somarQtdItemCarrinho(String numCPF) {

        String SQL = "SELECT SUM(QTD_PRODUTO) FROM ITEM_CARRINHO WHERE FK_NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Success in select sum ITEM_CARRINHO!");

            if (resultSet != null) {

                int qtdTotal = resultSet.getInt(1);

                connection.close();

                return qtdTotal;

            }

            connection.close();

            return 0;

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

            return -1;

        }
    }

    public Double somarVlrItemCarrinho(String numCPF) {

        String SQL = "SELECT SUM(QTD_PRODUTO * VLR_PRODUTO) FROM ITEM_CARRINHO WHERE FK_NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Success in select sum ITEM_CARRINHO!");

            if (resultSet != null) {

                Double vlrTotal = resultSet.getDouble(1);

                connection.close();

                return vlrTotal;

            }

            connection.close();

            return null;

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

            return null;

        }
    }

    public static String obterEstoque (String numSeqVinho) {

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT QTD_ESTOQUE FROM VINHO WHERE = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, numSeqVinho);

            ResultSet resultSet = statement.executeQuery();

            String quantidade = resultSet.getString("QTD_ESTOQUE");

            System.out.println("success in select * Vinho");

            connection.close();

            return quantidade;

        } catch (SQLException e) {

            System.out.println("fail in database connection");
            System.out.println("Error" + e.getMessage());

            return null;
        }
    }


        public void decrementarEstoque(String numSeqVinho, String qtdProduto) {

            String SQL =  "UPDATE VINHO SET QTD_ESTOQUE = QTD_ESTOQUE - ? WHERE NUM_SEQUENCIA = ?";

            try {

                Connection connection = ConnectionPoolConfig.getConnection();

                System.out.println("Success in database connection!");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, qtdProduto);
                preparedStatement.setString(2, numSeqVinho);

                preparedStatement.execute();

                System.out.println("Successo  ao decrementar do banco!");

                connection.close();

            } catch (Exception e) {

                System.out.println("Fail in database connection!");
                System.out.println("Error: " + e.getMessage());

            }
        }

}
