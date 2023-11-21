package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.DadosPagamento;

import java.sql.*;

public class PagamentoDao {
    public static void inserirDadosPagamento(DadosPagamento dadosPagamento) {
        String sql = "INSERT INTO Dados_pagamento (FK_NUM_CPF, DSC_NOME_CLIENTE, NUM_CARTAO, CVC, DATA_VALIDADE) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, dadosPagamento.getNumCPF());
            statement.setString(2, dadosPagamento.getNomeCartao());
            statement.setString(3, dadosPagamento.getNumCartao());
            statement.setInt(4, dadosPagamento.getCvc());
            statement.setDate(5, Date.valueOf(((dadosPagamento.getDataValidade()))));

            // Executar a instrução SQL
            statement.executeUpdate();

            System.out.println("Dados de pagamento inseridos com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados ou na execução da consulta SQL");
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static boolean verificarCvc(String numCPF, int cvc) {
        String sql = "SELECT COUNT(*) FROM Dados_pagamento WHERE FK_NUM_CPF = ? AND CVC = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, numCPF);
            statement.setInt(2, cvc);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados ou na execução da consulta SQL");
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
    }


