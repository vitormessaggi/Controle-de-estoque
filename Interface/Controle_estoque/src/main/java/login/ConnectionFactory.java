import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por criar e gerenciar a conexão com o banco de dados.
 */
public class ConnectionFactory {

    // Constante que armazena o endereço do driver do MySQL.
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    
    // Constante que armazena a URL do banco de dados.
    // Altere 'estoque' se o nome do seu banco for diferente.
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    
    // Constante para o usuário do banco de dados.
    // SUBSTITUA "seu_usuario" PELO SEU USUÁRIO REAL (ex: "root").
    private static final String USER = "seu_usuario"; 
    
    // Constante para a senha do banco de dados.
    // SUBSTITUA "sua_senha" PELA SUA SENHA REAL.
    private static final String PASSWORD = "sua_senha";

    /**
     * Método público e estático para obter uma conexão com o banco de dados.
     * * @return um objeto do tipo Connection com a conexão estabelecida.
     */
    public static Connection getConnection() {
        try {
            // Tenta carregar a classe do driver na memória.
            Class.forName(DRIVER_CLASS);
            
            // Retorna a conexão estabelecida usando a URL, usuário e senha.
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            // Lança um erro em tempo de execução se o driver .jar não for encontrado.
            throw new RuntimeException("Erro: Driver do banco de dados não encontrado.", e);
            
        } catch (SQLException e) {
            // Lança um erro em tempo de execução para qualquer outro problema de SQL (servidor offline, usuário/senha errados, etc.).
            throw new RuntimeException("Erro na conexão com o banco de dados. Verifique a URL, usuário e senha.", e);
        }
    }
}