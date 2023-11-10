package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.UsuarioCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDao {
    // Método para registrar um novo cliente no banco de dados
    public boolean registroUsuario(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {

        String SQL = "INSERT INTO CLIENTE (DSC_NOME_CLIENTE, NUM_CPF, DSC_EMAIL, NUM_TELEFONE, DSC_SENHA, STATUS) VALUES (?, ?, ?, ?, ?, 1)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, nomeCliente);
            preparedStatement.setString(2, cpfCliente);
            preparedStatement.setString(3, emailCliente);
            preparedStatement.setString(4, telefoneCliente);
            preparedStatement.setString(5, senhaCliente);

            int rowsAffected = preparedStatement.executeUpdate();

            connection.close();

            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (ou seja, registro bem-sucedido)

        } catch (Exception e) {
            System.out.println("Erro no cadastro do Usuário Cliente: " + e.getMessage());
            e.printStackTrace(); //Aqui acontece a depuração, imprime as informações de rastreamento de exceção.
            return false;
        }
    }
    // Método para verificar as credenciais de um cliente ao fazer login
    public boolean verificarCredenciaisCliente(UsuarioCliente usuarioCliente) {

        String SQL = "SELECT DSC_SENHA FROM CLIENTE WHERE NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuarioCliente.getCpfCliente());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("success in select CPFCliente");

            if (resultSet != null && resultSet.next()) {
                String senhaCliente = resultSet.getString("DSC_SENHA");
                int statusCliente = resultSet.getInt("STATUS");

                if (senhaCliente.equals(usuarioCliente.getSenhaCliente()) && statusCliente == 1) {
                    return true; // Apenas permite o login se a senha estiver correta e o cliente estiver ativo (status igual a 1).
                }
            }


            connection.close();

            return false;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace(); // Aqui acontece a depuração, imprime as informações de rastreamento de exceção.
            return false;
        }

    }
    // Método para obter detalhes de um cliente com base no CPF
    public UsuarioCliente obterDetalhesClientePorCpf(String cpfCliente) {
        String SQL = "SELECT * FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                //String cpfCliente = resultSet.getString("NUM_CPF");
                String nomeCliente = resultSet.getString("DSC_NOME_CLIENTE");
                String emailCliente = resultSet.getString("DSC_EMAIL");
                String telefoneCliente = resultSet.getString("NUM_TELEFONE");
                String senhaCliente = resultSet.getString("DSC_SENHA");


                return new UsuarioCliente(null, nomeCliente, telefoneCliente, emailCliente, telefoneCliente);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();// Aqui acontece a depuração, imprime as informações de rastreamento de exceção.

        }

        return null;
    }
    // Método para atualizar o cadastro de um cliente
    public boolean atualizarCadastroCliente(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente, int statusCliente) {
        String SQL = "UPDATE CLIENTE SET DSC_NOME_CLIENTE = ?, DSC_EMAIL = ?, NUM_TELEFONE = ?, DSC_SENHA = ?, STATUS = ? WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, nomeCliente);
            preparedStatement.setString(2, emailCliente);
            preparedStatement.setString(3, telefoneCliente);
            preparedStatement.setString(4, senhaCliente);
            preparedStatement.setInt(5, statusCliente);
            preparedStatement.setString(6, cpfCliente);

            int rowsAffected = preparedStatement.executeUpdate();

            connection.close();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();// Aqui acontece a depuração, imprime as informações de rastreamento de exceção.
            return false;
        }
    }
    // Método para verificar se um CPF já existe no banco de dados
    public boolean verificarCpfExistente(String cpfCliente) {
        String SQL = "SELECT COUNT(*) FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Retorna true se o CPF já existe na tabela
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();// Aqui acontece a depuração, imprime as informações de rastreamento de exceção.
        }

        return false;
    }
    public int obterStatusCliente(String cpfCliente) {
        String SQL = "SELECT STATUS FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                return resultSet.getInt("STATUS");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1; // Valor padrão para cliente não encontrado.
    }
}