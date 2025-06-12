package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioDAO {

    /**
     * Verifica se um usuário com o login e senha especificados existe no banco de dados.
     * @param login O login do usuário a ser verificado.
     * @param senha A senha do usuário.
     * @return true se o usuário existir, false caso contrário.
     */
    public boolean checkLogin(String login, String senha) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        boolean check = false;

        // O try-with-resources garante o fechamento da conexão e do statement
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, login);
            pstmt.setString(2, senha); // Lembre-se que armazenar senhas em texto plano não é seguro!

            // Executa a consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                // Se o ResultSet tiver pelo menos uma linha, o usuário existe.
                if (rs.next()) {
                    check = true;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao verificar login: " + e.getMessage());
            // Você pode lançar uma exceção aqui se preferir
        }
        
        return check;
    }
}