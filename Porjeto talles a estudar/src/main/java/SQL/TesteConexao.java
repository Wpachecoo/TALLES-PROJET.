package SQL;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConexaoMySQL.conectar();
            if (conn != null) {
                System.out.println("Pode conectar patrão");
            }
        } catch (SQLException e) {
            System.out.println("Vai entrar n men: " + e.getMessage());
        } finally {
            ConexaoMySQL.fechar(conn);
        }
    }
}

