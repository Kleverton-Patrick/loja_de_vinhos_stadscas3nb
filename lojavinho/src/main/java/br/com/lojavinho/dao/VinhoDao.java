package br.com.lojavinho.dao;

import br.com.lojavinho.model.Vinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class VinhoDao {

    public void createVinho(Vinho vinho) {

        String SQL = "INSERT INTO VINHO (NAME, IMAGE) VALUES (?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getName());
            preparedStatement.setString(2, vinho.getImage());
            preparedStatement.execute();

            System.out.println("success in insert vinho");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection CREATE");
            System.out.println("Error: " + e.getMessage());

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
                String image = resultSet.getString("image");

                Vinho vinho = new Vinho(vinhoId, vinhoName, image);

                vinhos.add(vinho);
            }

            System.out.println("success in select * vinho FIND");

            connection.close();

            return vinhos;

        } catch (Exception e) {

            System.out.println("fail in database connection FIND");
            System.out.println("Error: " + e.getMessage());

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

        String SQL = "UPDATE VINHO SET NAME = ?, IMAGE = ? WHERE ID = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getName());
            preparedStatement.setString(2, vinho.getImage());
            preparedStatement.setString(3, vinho.getId());
            preparedStatement.execute();

            System.out.println("success in UPDATE vinho UPDATE");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection UPDATE");
            System.out.println("Error: " + e.getMessage());

        }
    }
}
