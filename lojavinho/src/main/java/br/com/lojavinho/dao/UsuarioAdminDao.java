package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.UsuarioAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioAdminDao {

    public boolean verifyCredentials(UsuarioAdmin usuarioAdmin) {

        String SQL = "SELECT DSC_SENHA_ADMIN FROM USUARIO_ADMIN WHERE DSC_EMAIL_ADMIN = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuarioAdmin.getEmailAdmin());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("success in select EmailAdmin");

            if (resultSet != null) {
                while (resultSet.next()) {

                    String senhaAdmin = resultSet.getString("dsc_senha_admin");

                    if (senhaAdmin.equals(usuarioAdmin.getSenhaAdmin())) {

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
}