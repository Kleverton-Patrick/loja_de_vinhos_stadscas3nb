package br.com.lojavinho.dao;

import br.com.lojavinho.model.Vinho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class VinhoDao {

    public void createVinho(Vinho vinho) {

        String SQL = "INSERT INTO VINHO (NOME) VALUES (?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getNome());
            preparedStatement.execute();

            System.out.println("success in insert vinho");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

}