package br.com.lojavinho.dao;

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
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getName());
            preparedStatement.execute();

            System.out.println("success in insert vinho");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public List<Vinho> findAllVinhos() {

        String SQL = "SELECT * FROM VINHO";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Vinho> vinhos = new ArrayList<>();

            while (resultSet.next()) {

                String vinhoId = resultSet.getString("id");
                String vinhoName = resultSet.getString("name");

                Vinho vinho = new Vinho(vinhoId, vinhoName);

                vinhos.add(vinho);
            }

            System.out.println("success in select * vinho");

            connection.close();

            return vinhos;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }

    public void deleteVihnoById(String vinhoId) {

        String SQL = "DELETE VINHO WHERE ID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, vinhoId);
            preparedStatement.execute();

            System.out.println("success on delete vinho with id: " + vinhoId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public void updateVinho(Vinho vinho) {

        String SQL = "UPDATE VINHO SET NAME = ? WHERE ID = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getName());
            preparedStatement.setString(2, vinho.getId());
            preparedStatement.execute();

            System.out.println("success in UPDATE vinho");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }
    }
}