


<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>ProjetoJDBC</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>22</maven.compiler.source>
        <maven.compiler.target>22</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>





package br.unipar;

import java.sql;
import java.util.Scanner;

public class Main {

    private static final String url = "jdbc:postgresql://localhost:5432/exemplo1";
    private static final String user = "postgres";
    private static final String password = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Tabela Usuário");
            System.out.println("2. Inserir Usuário");
            System.out.println("3. Listar Todos os Usuários");
            System.out.println("4. Alterar Usuário");
            System.out.println("5. Excluir Usuário");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarTabelaUsuario();
                    break;
                case 2:
                    System.out.println("Digite o usuario:");
                    String usuario= scanner.nextLine();
                    System.out.println("Digite a senha:");
                    String senha = scanner.nextLine();
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a data de nascimento (yyyy-mm-dd):");
                    String nascimento = scanner.nextLine();
                    inserirUsuario(usuario, senha, nome, nascimento);
                    break;
                case 3:
                    listarTodosOsUsuarios();
                    break;
                case 4:
                    System.out.println("Digite o ID do usuário a ser alterado:");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o novo usuario:");
                    String novoUsuario = scanner.nextLine();
                    System.out.println("Digite a nova senha:");
                    String novaSenha = scanner.nextLine();
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite a nova data de nascimento:");
                    String novaData = scanner.nextLine();
                    alterarUsuario(idAlterar, novoUsuario, novaSenha, novoNome, novaData);
                    break;
                case 5:
                    System.out.println("Digite o ID do usuário a ser excluído:");
                    int idExcluir = scanner.nextInt();
                    excluirUsuario(idExcluir);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void criarTabelaUsuario() {
        try (Connection conn = connection();
             Statement statement = conn.createStatement()) {

            String SQL = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "codigo serial primary key, "
                    + "usuario varchar(50) unique not null, "
                    + "password varchar(300) not null, "
                    + "nome varchar(50) not null, "
                    + "nascimento date )";

            statement.executeUpdate(SQL);
            System.out.println("TABELA CRIADA!");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void inserirUsuario(String usuario, String password, String nome, String nascimento) {
        String SQL = "INSERT INTO usuarios (usuario, password, nome, nascimento) VALUES (?, ?, ?, ?)";
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setDate(4, Date.valueOf(nascimento));
            preparedStatement.executeUpdate();

            System.out.println("Usuário Inserido!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarTodosOsUsuarios() {
        String SQL = "SELECT * FROM usuarios";
        try (Connection conn = connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("codigo"));
                System.out.println("Usuario: " + resultSet.getString("usuario"));
                System.out.println("Password: " + resultSet.getString("password"));
                System.out.println("Nome: " + resultSet.getString("nome"));
                System.out.println("Nascimento: " + resultSet.getDate("nascimento"));
                System.out.println("-------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alterarUsuario(int id, String usuario, String password, String nome, String nascimento) {
        String SQL = "UPDATE usuarios SET usuario = ?, password = ?, nome = ?, nascimento = ? WHERE codigo = ?";
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setDate(4, Date.valueOf(nascimento));
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

            System.out.println("Usuário Alterado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirUsuario(int id) {
        String SQL = "DELETE FROM usuarios WHERE codigo = ?";
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Usuário Excluído!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



package br.unipar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @BeforeAll
    public static void setup() throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exemplo1", "postgres", "admin123");
             Statement statement = conn.createStatement()) {

            String SQL = "CREATE TABLE IF NOT EXISTS usuarios_test ("
                    + "codigo serial primary key, "
                    + "usuario varchar(50) unique not null, "
                    + "password varchar(300) not null, "
                    + "nome varchar(50) not null, "
                    + "nascimento date )";

            statement.executeUpdate(SQL);
        }
    }

    @Test
    public void testInserirUsuario() {
        String usuario= "diogo";
        String password = "123456";
        String nome = "diogo tairan";
        String nascimento = "30-07-2005";

        Main.inserirUsuario(usuario, password, nome, nascimento);

        assertTrue(usuarioExiste(usuario));
    }

    @Test
    public void testAlterarUsuario() {
        String usuario = "diogo tairan";
        String password = "123456";
        String nome = "diogo santos";
        String nascimento = "30-07-2005";

        Main.inserirUsuario(usuario, password, nome, nascimento);

        int userId = getUsuarioId(usuario);

        String novoUsuario = "diogo tairan";
        String novaSenha = "123456";
        String novoNome = "diogo santos";
        String novaData = "30-07-2005";

        Main.alterarUsuario(userId, novoUsuario, novaSenha, novoNome, novaData);

        assertTrue(usuarioExiste(novoUsuario));
    }

    @Test
    public void testExcluirUsuario() {
        String usuario = "diogo tairan";
        String password = "123456";
        String nome = "diogo santos";
        String nascimento = "25-10-2001";

  Main.inserirUsuario(username, password, nome, nascimento);

    int userId = getUsuarioId(username);

    Main.excluirUsuario(userId);

    assertFalse(usuarioExiste(username));
}

@Test
public void testListarTodosOsUsuarios() {
    Main.listarTodosOsUsuarios();

    assertTrue(true);
}

private boolean usuarioExiste(String usuario) {
    String SQL = "SELECT 1 FROM usuario_test WHERE username = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exemplo1", "postgres", "admin123");
         PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

private int getUsuarioId(String username) {
    String SQL = "SELECT codigo FROM usuarios_test WHERE username = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exemplo1", "postgres", "admin123");
         PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("codigo");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;
}

@AfterAll
public static void tearDown() throws SQLException {
    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exemplo1", "postgres", "admin123");
         Statement statement = conn.createStatement()) {

        statement.executeUpdate("DROP TABLE IF EXISTS usuario_test");
    }
}
}
