
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public final String URL = "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC";
    public final String USER = "root";
    public final String SENHA = "laboratorio";
    
    public Connection getConexao() {
        
        try {
            Connection conn = DriverManager.getConnection(URL, USER, SENHA);
            return conn;
            
        } catch (SQLException e) {
            System.out.println("Erro ao realizar conexao: " + e.getMessage());
            return null;
        }
    }
}
