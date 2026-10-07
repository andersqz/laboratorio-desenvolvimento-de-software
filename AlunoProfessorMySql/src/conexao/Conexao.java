
package conexao;


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
    
    private final String URL = "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String SENHA = "laboratorio";
    
    public Connection getConexao() {
        
        Connection conn;
        
        try {
            
            conn = DriverManager.getConnection(URL, USER, SENHA);
            System.out.println("Conexão realizada com sucesso!");
            return conn;
            
        } catch (Exception e) {
            System.out.println("Conexão falhou!" + e.getMessage());
            return null;
        }
        
    }
}
