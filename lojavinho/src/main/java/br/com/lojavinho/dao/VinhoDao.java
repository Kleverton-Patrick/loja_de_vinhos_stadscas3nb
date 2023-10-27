package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.Pais;
import br.com.lojavinho.model.TipoUva;
import br.com.lojavinho.model.TipoVinho;
import br.com.lojavinho.model.Vinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VinhoDao {

    public void createVinho(Vinho vinho) {

        String SQL = "INSERT INTO VINHO (NAME, IMAGE) VALUES (?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getName());
            preparedStatement.setString(2, vinho.getImage());
            preparedStatement.execute();

            System.out.println("success in insert vinho CREATE");

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

    public static List<Pais> obterPaises() {
        List<Pais> listaDePaises = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT * FROM PAIS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("PAISID");
                String nome = resultSet.getString("NOMEPAIS");
                Pais pais = new Pais(id, nome);
                listaDePaises.add(pais);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDePaises;
    }

    public static List<TipoVinho> obterTiposVinho() {
        List<TipoVinho> listaTiposVinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT * FROM TIPOVINHO";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("TIPOVINHOID");
                String tipoVinho = resultSet.getString("NOMETIPOVINHO");
                TipoVinho nomeTipoVinho = new TipoVinho(id, tipoVinho);
                listaTiposVinhos.add(nomeTipoVinho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaTiposVinhos;
    }

    public static List<TipoUva> obterTiposUva() {
        List<TipoUva> listaTipoUva = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT * FROM TIPOUVA";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("TIPOUVAID");
                String tipoUva = resultSet.getString("NOMETIPOUVA");
                TipoUva nomeTipoUva = new TipoUva(id, tipoUva);
                listaTipoUva.add(nomeTipoUva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaTipoUva;
    }

    public static List<String> obterNomesDosVinhos(String nomeVinho) {
        List<String> nomesDosVinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            System.out.println("Conexao bd ok");
            String sql = "SELECT NOMEVINHO FROM VINHO WHERE NOMEVINHO LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nomeVinho + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nomeVinho = resultSet.getString("NOMEVINHO");
                nomesDosVinhos.add(nomeVinho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomesDosVinhos;
    }

    public static List<String> obterVinhos(String paisID, String tipoVinhoID, String tipoUvaID) {
        List<String> nomesDosVinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT V.NomeVinho " +
                    "FROM Vinho AS V " +
                    "INNER JOIN Pais AS P ON P.PaisID = V.PaisId " +
                    "INNER JOIN TipoUva AS TU ON TU.TipoUvaID = V.TipoUvaId " +
                    "INNER JOIN TipoVinho AS TV ON TV.TipoVinhoID = V.TipoVinhoId " +
                    "WHERE (P.PaisID = ? OR ? IS NULL) " +
                    "AND (TU.TipoUvaID = ? OR ? IS NULL) " +
                    "AND (TV.TipoVinhoID = ? OR ? IS NULL)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, paisID);
            statement.setObject(2, paisID);
            statement.setObject(3, tipoUvaID);
            statement.setObject(4, tipoUvaID);
            statement.setObject(5, tipoVinhoID);
            statement.setObject(6, tipoVinhoID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nomeVinho = resultSet.getString("NomeVinho");
                nomesDosVinhos.add(nomeVinho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomesDosVinhos;
    }


    public static List<String> obterVinhosSobremesa(String sobreMesa) {
        List<String> vinhosSobremesa = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT nomeVinho FROM Vinho WHERE HarmonizacaoId = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, sobreMesa);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nomeVinho = resultSet.getString("nomeVinho");
                vinhosSobremesa.add(nomeVinho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vinhosSobremesa;
    }

}
