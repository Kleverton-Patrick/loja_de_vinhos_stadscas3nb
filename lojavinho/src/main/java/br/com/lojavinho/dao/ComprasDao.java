package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.Compras;
import br.com.lojavinho.model.DadosEntrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComprasDao {

        public static DadosEntrega obterUltimaCompraPorCPF(String cpf) {

            try (Connection connection = ConnectionPoolConfig.getConnection()) {
                String sql = "SELECT * FROM DADOS_ENTREGA " +
                        "WHERE CPF_CLIENTE = ? " +
                        "ORDER BY DATA_ENTREGA DESC " +
                        "LIMIT 1";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, cpf);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String codCep = resultSet.getString("COD_CEP");
                    String endereco = resultSet.getString("DESC_ENDERECO");
                    String enderecoComplemento = resultSet.getString("DESC_COMPL_ENDERECO");
                    String bairro = resultSet.getString("DESC_BAIRRO");
                    String cidade = resultSet.getString("DESC_CIDADE");
                    String estado = resultSet.getString("DESC_ESTADO");



                    DadosEntrega dadosEntrega = new DadosEntrega(codCep, endereco,enderecoComplemento, bairro, cidade, estado);

                    System.out.println("Success in selecting last purchase by CPF");
                    connection.close();

                    return dadosEntrega;
                } else {
                    System.out.println("No purchase found for the given CPF");
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


