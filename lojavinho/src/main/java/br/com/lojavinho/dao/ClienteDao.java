package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
//import br.com.lojavinho.model.UsuarioAdmin;
import br.com.lojavinho.model.UsuarioCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDao {

    public boolean registroUsuario(String cliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {

        String SQL = "INSERT INTO CLIENTE (DSC_NOME_CLIENTE, NUM_CPF, DSC_EMAIL, NUM_TELEFONE, DSC_SENHA) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente);
            preparedStatement.setString(2, cpfCliente);
            preparedStatement.setString(3, emailCliente);
            preparedStatement.setString(4, telefoneCliente);
            preparedStatement.setString(5, senhaCliente);

            int rowsAffected = preparedStatement.executeUpdate();

            connection.close();

            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (ou seja, registro bem-sucedido)

        } catch (Exception e) {

            System.out.println("Error in registerUserCliente: " + e.getMessage());

            return false;
        }

    }


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

                    String senhaCliente = resultSet.getString("dsc_senha");

                    if (senhaCliente.equals(usuarioCliente.getSenhaCliente())) {

                        return true;
                    }
                }
            }

            connection.close();

            return false;

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            return false;
        }

    }


    public UsuarioCliente obterDetalhesClientePorNome(String usuarioNomeCliente) {
        String SQL = "SELECT * FROM USUARIO_CLIENTE WHERE USUARIO_NOME_CLIENTE = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, usuarioNomeCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String cpfCliente = resultSet.getString("CPFCLIENTE");
                String emailCliente = resultSet.getString("EMAILCLIENTE");
                String telefoneCliente = resultSet.getString("TELEFONECLIENTE");


                return new UsuarioCliente(usuarioNomeCliente, null, cpfCliente, emailCliente, telefoneCliente);
            }

            connection.close();
        } catch (Exception e) {

        }

        return null;
    }

    public boolean atualizarCadastroCliente(String usuarioNomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {
        String SQL = "UPDATE USUARIO_CLIENTE SET CPFCLIENTE = ?, EMAILCLIENTE = ?, TELEFONECLIENTE = ?, SENHA_CLIENTE = ? WHERE USUARIO_NOME_CLIENTE = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cpfCliente);
            preparedStatement.setString(2, emailCliente);
            preparedStatement.setString(3, telefoneCliente);
            preparedStatement.setString(4, senhaCliente);
            preparedStatement.setString(5, usuarioNomeCliente);

            int rowsAffected = preparedStatement.executeUpdate();

            connection.close();

            return rowsAffected > 0;

        } catch (Exception e) {

            return false;
        }
    }
}