package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.Compras;
import br.com.lojavinho.model.DadosEntrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                    String CEP = resultSet.getString("COD_CEP");
                    String endereco = resultSet.getString("DSC_ENDERECO");
                    String numEndereco = resultSet.getString("NUM_ENDERECO");
                    String complEndereco = resultSet.getString("DSC_COMPL_ENDERECO");
                    String bairro = resultSet.getString("DSC_BAIRRO");
                    String cidade = resultSet.getString("DSC_CIDADE");
                    String estado = resultSet.getString("DSC_ESTADO");



                    DadosEntrega dadosEntrega = new DadosEntrega(CEP, endereco, numEndereco, complEndereco, bairro, cidade, estado );

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
    }


