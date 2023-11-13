package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.Carrinho;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarrinhoDao {

    public void createCarrinho(Carrinho carrinho) {

        String SQL = "INSERT INTO CARRINHO (NUM_SEQUENCIA, DSC_NOME_VINHO, VLR_VENDA, QTD) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, carrinho.getId());
            preparedStatement.setString(2, carrinho.getNome());
            preparedStatement.setString(3, carrinho.getValor());
            preparedStatement.setString(4, carrinho.getQuantidade());
            preparedStatement.execute();

            System.out.println("success in insert compra");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error" + e.getMessage());
        }

    }
}
