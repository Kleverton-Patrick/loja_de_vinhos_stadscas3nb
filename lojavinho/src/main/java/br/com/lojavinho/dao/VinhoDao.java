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

        String SQL = "INSERT INTO VINHO (DSC_NOME_VINHO, IMAGEM) VALUES (?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getNome());
            preparedStatement.setString(2, vinho.getImagem());
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

            List<Vinho> Vinhos = new ArrayList<>();

            while (resultSet.next()) {

                String vinhoId = resultSet.getString("id");
                String vinhoNome = resultSet.getString("nome");
                String vinhoValor = resultSet.getString("valor");
                String vinhoEstoque = resultSet.getString("estoque");
                String vinhoDescricao = resultSet.getString("descricao");
                String imagem = resultSet.getString("imagem");

                Vinho vinho = new Vinho(vinhoId, vinhoNome, vinhoValor, vinhoEstoque, vinhoDescricao, imagem);

                Vinhos.add(vinho);
            }

            System.out.println("success in select * vinho FIND");

            connection.close();

            return Vinhos;

        } catch (Exception e) {

            System.out.println("fail in database connection FIND");
            System.out.println("Error: " + e.getMessage());

            return Collections.emptyList();
        }
    }

    public void deleteVinhoById(String vinhoId) {

        String SQL = "DELETE VINHO WHERE NUM_SEQUENCIA = ?";

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

        String SQL = "UPDATE VINHO SET DSC_NOME_VINHO = ?, IMAGEM = ? WHERE NUM_SEQUENCIA = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, vinho.getNome());
            preparedStatement.setString(2, vinho.getImagem());
            preparedStatement.setString(3, vinho.getId());
            preparedStatement.execute();

            System.out.println("success in UPDATE vinho ");

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
                int id = resultSet.getInt("NUM_SEQUENCIA");
                String nome = resultSet.getString("DSC_PAIS_PRODUTOR");
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
            String sql = "SELECT * FROM TIPO_VINHO";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("NUM_SEQUENCIA");
                String tipoVinho = resultSet.getString("DSC_TIPO_VINHO");
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
            String sql = "SELECT * FROM TIPO_UVA";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("NUM_SEQUENCIA");
                String tipoUva = resultSet.getString("DSC_TIPO_UVA");
                TipoUva nomeTipoUva = new TipoUva(id, tipoUva);
                listaTipoUva.add(nomeTipoUva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaTipoUva;
    }

    public static List<Vinho> obterDetalhesDosVinhos(String nomeVinho) {
        List<Vinho> Vinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            System.out.println("Conexao bd ok");
            String sql = "SELECT * FROM VINHO WHERE DSC_NOME_VINHO LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nomeVinho + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String vinhoId = resultSet.getString("NUM_SEQUENCIA");
                String vinhoNome = resultSet.getString("DSC_NOME_VINHO");
                String vinhoValor = resultSet.getString("VLR_VENDA");
                String vinhoEstoque = resultSet.getString("QTD_ESTOQUE");
                String vinhoDescricao = resultSet.getString("DESCRICAO");
                String imagem = resultSet.getString("IMAGEM");

                if(!vinhoEstoque.equals("0")){

                Vinho vinho = new Vinho(vinhoId, vinhoNome, vinhoValor, vinhoEstoque, vinhoDescricao, imagem);

                Vinhos.add(vinho);
                }

            }

            System.out.println("success in select * Vinho");

            connection.close();

            return Vinhos;

        } catch (SQLException e) {

            System.out.println("fail in database connection");
            System.out.println("Error" + e.getMessage());

            return Collections.emptyList();
        }

    }

    public static List<Vinho> obterVinhos(String paisID, String tipoVinhoID, String tipoUvaID) {

        List<Vinho> Vinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT * " +
                    "FROM VINHO AS V " +
                    "INNER JOIN PAIS AS P ON P.NUM_SEQUENCIA = V.FK_NUM_SEQ_PAIS " +
                    "INNER JOIN TIPO_UVA AS TU ON TU.NUM_SEQUENCIA = V.FK_NUM_SEQ_TIPO_UVA " +
                    "INNER JOIN TIPO_VINHO AS TV ON TV.NUM_SEQUENCIA = V.FK_NUM_SEQ_TIPO_VINHO " +
                    "WHERE (P.NUM_SEQUENCIA = ? OR ? IS NULL) " +
                    "AND (TU.NUM_SEQUENCIA = ? OR ? IS NULL) " +
                    "AND (TV.NUM_SEQUENCIA = ? OR ? IS NULL)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, paisID);
            statement.setObject(2, paisID);
            statement.setObject(3, tipoUvaID);
            statement.setObject(4, tipoUvaID);
            statement.setObject(5, tipoVinhoID);
            statement.setObject(6, tipoVinhoID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String vinhoId = resultSet.getString("NUM_SEQUENCIA");
                String vinhoNome = resultSet.getString("DSC_NOME_VINHO");
                String vinhoValor = resultSet.getString("VLR_VENDA");
                String vinhoEstoque = resultSet.getString("QTD_ESTOQUE");
                String vinhoDescricao = resultSet.getString("DESCRICAO");
                String imagem = resultSet.getString("IMAGEM");

                if(!vinhoEstoque.equals("0")){

                    Vinho vinho = new Vinho(vinhoId, vinhoNome, vinhoValor, vinhoEstoque, vinhoDescricao, imagem);

                    Vinhos.add(vinho);
                }
            }

            System.out.println("success in select * Vinho");

            connection.close();

            return Vinhos;

        } catch (SQLException e) {

            System.out.println("fail in database connection");
            System.out.println("Error" + e.getMessage());

            return Collections.emptyList();
        }
    }


    public static List<Vinho> obterCard(String HarmonizacaoID) {
        List<Vinho> Vinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            String sql = "SELECT * FROM Vinho WHERE FK_NUM_SEQ_HARMONIZACAO = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, HarmonizacaoID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String vinhoId = resultSet.getString("NUM_SEQUENCIA");
                String vinhoNome = resultSet.getString("DSC_NOME_VINHO");
                String vinhoValor = resultSet.getString("VLR_VENDA");
                String vinhoEstoque = resultSet.getString("QTD_ESTOQUE");
                String vinhoDescricao = resultSet.getString("DESCRICAO");
                String imagem = resultSet.getString("IMAGEM");

                if(!vinhoEstoque.equals("0")){

                    Vinho vinho = new Vinho(vinhoId, vinhoNome, vinhoValor, vinhoEstoque, vinhoDescricao, imagem);

                    Vinhos.add(vinho);
                }
            }

            System.out.println("success in select * Vinho");

            connection.close();

            return Vinhos;

        } catch (SQLException e) {

            System.out.println("fail in database connection");
            System.out.println("Error" + e.getMessage());

            return Collections.emptyList();
        }

    }
}
