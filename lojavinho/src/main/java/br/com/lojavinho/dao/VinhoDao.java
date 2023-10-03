package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.Vinho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VinhoDao {

    public void createVinho(Vinho vinho) {

        String SQL = "INSERT INTO VINHO (NAME) VALUES (?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getName());
            preparedStatement.execute();

            System.out.println("success in insert vinho CREATE");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection CREATE");

        }

    }

    public List<Vinho> findAllVinhos() {

        String SQL = "SELECT * FROM VINHO";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Vinho> vinhos = new ArrayList<>();

            while (resultSet.next()) {

                String vinhoId = resultSet.getString("id");
                String vinhoName = resultSet.getString("name");

                Vinho vinho = new Vinho(vinhoId, vinhoName);

                vinhos.add(vinho);
            }

            System.out.println("success in select * vinho FIND");

            connection.close();

            return vinhos;

        } catch (Exception e) {

            System.out.println("fail in database connection FIND");

            return Collections.emptyList();
        }
    }

    public void deleteVinhoById(String vinhoId) {

        String SQL = "DELETE VINHO WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, vinhoId);
            preparedStatement.execute();

            System.out.println("success on delete vinho with id: DELETE " + vinhoId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection DELETE");

        }

    }

    public void updateVinho(Vinho vinho) {

        String SQL = "UPDATE VINHO SET NAME = ? WHERE ID = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getName());
            preparedStatement.setString(2, vinho.getId());
            preparedStatement.execute();

            System.out.println("success in UPDATE vinho UPDATE");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection UPDATE");
            System.out.println("Error: " + e.getMessage());

        }
    }
}