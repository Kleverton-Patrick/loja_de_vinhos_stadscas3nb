package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
//import br.com.lojavinho.model.UsuarioAdmin;
import br.com.lojavinho.model.UsuarioCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDao {
    // Método para registrar um novo cliente no banco de dados
    public boolean registroUsuario(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {

        String SQL = "INSERT INTO CLIENTE (DSC_NOME_CLIENTE, NUM_CPF, DSC_EMAIL, NUM_TELEFONE, DSC_SENHA) VALUES (?, ?, ?, ?, ?)";

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

            if (resultSet != null) {
                while (resultSet.next()) {

                    String senhaCliente = resultSet.getString("DSC_SENHA");

                    if (senhaCliente.equals(usuarioCliente.getSenhaCliente())) {

                        return true;
                    }
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
    public boolean atualizarCadastroCliente(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {
        String SQL = "UPDATE CLIENTE SET DSC_NOME_CLIENTE = ?, DSC_EMAIL = ?, NUM_TELEFONE = ?, DSC_SENHA = ? WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, nomeCliente);
            preparedStatement.setString(2, emailCliente);
            preparedStatement.setString(3, telefoneCliente);
            preparedStatement.setString(4, senhaCliente);
            preparedStatement.setString(5, cpfCliente);

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
}