package br.com.lojavinho.dao;

import br.com.lojavinho.config.ConnectionPoolConfig;
import br.com.lojavinho.model.ItemCarrinho;
import br.com.lojavinho.model.UsuarioCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDao {

    public boolean registrarCliente(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente) {

        String SQL = "INSERT INTO CLIENTE (DSC_NOME_CLIENTE, NUM_CPF, DSC_EMAIL, NUM_TELEFONE, DSC_SENHA, STATUS) VALUES (?, ?, ?, ?, ?, 1)";

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
            e.printStackTrace(); // Aqui acontece a depuração, imprime as informações de rastreamento de exceção.
            return false;
        }
    }

    // Constantes para mensagens de erro
    public static final String CREDENCIAIS_INVALIDAS = "Credenciais inválidas";
    public static final String CLIENTE_INATIVO = "Cliente inativo, Atualize seu Cadastro.";
    public static final String USUARIO_NAO_CADASTRADO = "Usuário não cadastrado";

    public String verificarCredenciaisEStatusCliente(UsuarioCliente usuarioCliente) {
        String SQL = "SELECT DSC_SENHA, STATUS FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, usuarioCliente.getCpfCliente());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                int statusCliente = resultSet.getInt("STATUS");

                // Verifica se o status está ativo (1)
                if (statusCliente == 1) {
                    String senhaCliente = resultSet.getString("DSC_SENHA");

                    // Verifica se a senha está correta
                    if (senhaCliente.equals(usuarioCliente.getSenhaCliente())) {
                        return null;
                    } else {
                        return CREDENCIAIS_INVALIDAS;
                    }
                } else {
                    return CLIENTE_INATIVO;
                }
            }

            connection.close();

            return USUARIO_NAO_CADASTRADO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UsuarioCliente obterDetalhesClientePorCpf(String cpfCliente) {
        String SQL = "SELECT * FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String nomeCliente = resultSet.getString("DSC_NOME_CLIENTE");
                String emailCliente = resultSet.getString("DSC_EMAIL");
                String telefoneCliente = resultSet.getString("NUM_TELEFONE");
                String senhaCliente = resultSet.getString("DSC_SENHA");

                return new UsuarioCliente(null, nomeCliente, telefoneCliente, emailCliente, telefoneCliente);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean validarCredenciais(String cpfCliente, String senhaCliente) {
        String SQL = "SELECT COUNT(*) FROM CLIENTE WHERE NUM_CPF = ? AND DSC_SENHA = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);
            preparedStatement.setString(2, senhaCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizarCadastroCliente(String nomeCliente, String cpfCliente, String emailCliente, String telefoneCliente, String senhaCliente, int statusCliente) {

        if (validarCredenciais(cpfCliente, senhaCliente)) {
            String SQL = "UPDATE CLIENTE SET DSC_NOME_CLIENTE = ?, DSC_EMAIL = ?, NUM_TELEFONE = ?, DSC_SENHA = ?, STATUS = ? WHERE NUM_CPF = ?";

            try {
                Connection connection = ConnectionPoolConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, nomeCliente);
                preparedStatement.setString(2, emailCliente);
                preparedStatement.setString(3, telefoneCliente);
                preparedStatement.setString(4, senhaCliente);
                preparedStatement.setInt(5, statusCliente);
                preparedStatement.setString(6, cpfCliente);

                int rowsAffected = preparedStatement.executeUpdate();

                connection.close();

                return rowsAffected > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean verificarCpfExistente(String cpfCliente) {
        String SQL = "SELECT COUNT(*) FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public String obterNomeClientePorCpf(String cpfCliente) {
        String SQL = "SELECT DSC_NOME_CLIENTE FROM CLIENTE WHERE NUM_CPF = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpfCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                String nomeCliente = resultSet.getString("DSC_NOME_CLIENTE");
                connection.close();
                return nomeCliente;
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void registrarEndereco (String numCPF, String CEP, String endereco, String numero, String complemento, String bairro, String cidade, String estado) {

        String SQL = "INSERT INTO DADOS_ENTREGA (NUM_CPF, COD_CEP, DSC_ENDERECO, NUM_ENDERECO, DSC_COMPL_ENDERECO, DSC_BAIRRO, DSC_CIDADE, DSC_ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, numCPF);
            preparedStatement.setString(2, CEP);
            preparedStatement.setString(3, endereco);
            preparedStatement.setString(4, numero);
            preparedStatement.setString(5, complemento);
            preparedStatement.setString(6, bairro);
            preparedStatement.setString(7, cidade);
            preparedStatement.setString(8, estado);
            preparedStatement.execute();

            System.out.println("Successo ao inserir endereco em DADOS_ENTREGA");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }
    }


    public void atualizarEndereco(String cpf, String cep, String endereco, String numero, String complemento, String bairro, String cidade, String estado) {

        String SQL = "UPDATE DADOS_ENTREGA SET COD_CEP = ?, DSC_ENDERECO = ?, NUM_ENDERECO =?, DSC_COMPL_ENDERECO =?, DSC_BAIRRO =?, DSC_CIDADE =?, DSC_ESTADO =? WHERE NUM_CPF = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Success in database connection!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cep);
            preparedStatement.setString(2, endereco);
            preparedStatement.setString(3, numero);
            preparedStatement.setString(4, complemento);
            preparedStatement.setString(5, bairro);
            preparedStatement.setString(6, cidade);
            preparedStatement.setString(7, estado);
            preparedStatement.setString(8, cpf);
            preparedStatement.execute();

            System.out.println("Successo ao atualizar endereco em DADOS_ENTREGA");

            connection.close();

        } catch (Exception e) {

            System.out.println("Fail in database connection!");
            System.out.println("Error: " + e.getMessage());

        }

    }
}