package equipes;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoDB {

    private static final String URL;
    private static final String USUARIO;
    private static final String SENHA;

    static {
        Properties props = new Properties();

        try (InputStream input = ConexaoDB.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("application.properties não encontrado no classpath");
            }
            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar application.properties", e);
        }

        URL = props.getProperty("spring.datasource.url");
        USUARIO = props.getProperty("spring.datasource.username");
        SENHA = props.getProperty("spring.datasource.password", "");
    }

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}