package br.com.lojavinho.dao;
///
import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.User;
import br.com.lojavinho.model.UsuarioCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public boolean verifyCredentials(User user) {

    String SQL = "SELECT * FROM USR WHERE USERNAME = ?";

    try {

        Connection connection = ConnectionPoolConfig.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setString(1, user.getUsername());

        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("success in select username");

        while (resultSet.next()) {

            String password = resultSet.getString("password");

            if (password.equals(user.getPassword())) {

                return true;
            }
        }

        connection.close();

        return false;

    } catch (Exception e) {

        System.out.println("Error: " + e.getMessage());

        return false;
    }

    }

    public boolean registerUsuarioCliente(String usuarioCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {

        String SQL = "INSERT INTO USUARIO_CLIENTE (USUARIO_NOME_CLIENTE, CPFCLIENTE, EMAILCLIENTE, TELEFONECLIENTE, SENHA_CLIENTE) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuarioCliente);
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


    public boolean verifyCredentialsCliente(UsuarioCliente usuarioCliente) {

        String SQL = "SELECT * FROM USUARIO_CLIENTE WHERE USUARIO_NOME_CLIENTE = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuarioCliente.getUsuarioNomeCliente());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("success in select usuarioNomeCLIENTE");

            while (resultSet.next()) {

                String senhaCliente = resultSet.getString("SENHA_CLIENTE");

                if (senhaCliente.equals(usuarioCliente.getSenhaCliente())) {

                    return true;
                }
            }

            connection.close();

            return false;

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            return false;
        }

    }

}
