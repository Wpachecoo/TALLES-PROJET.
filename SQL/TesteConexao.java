

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConexaoMySQL.conectar();
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Falha ao estabelecer conexão: " + e.getMessage());
        } finally {
            ConexaoMySQL.fechar(conn);
        }
    }
}

