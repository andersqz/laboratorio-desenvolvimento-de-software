
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connection.Conexao;
import java.util.ArrayList;
import model.Professor;
import java.sql.ResultSet;


public class ProfessorDAO {
    
    private Conexao conexao;
    private Connection conn;
    private ArrayList<Professor> professores;
    
    public ProfessorDAO() {
        conexao = new Conexao();
        conn = conexao.getConexao();
        professores = new ArrayList<Professor>();
    }
    
    public void inserir(Professor p) {
        
        String query = "INSERT INTO Professor (Nome, Cpf, Disciplina, Salario)"
                + "VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getDisciplina());
            stmt.setDouble(4, p.getSalario());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir professor" + e.getMessage());
        }
    }
    
    public ArrayList<Professor> selecionarTodos() {
        
        String query = "SELECT Id, Nome, Cpf, Disciplina, Salario FROM Professor";
        
        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                
                Professor p = new Professor(
                rs.getInt("Id"),
                rs.getString("Nome"),
                rs.getString("Cpf"),
                rs.getString("Disciplina"),
                rs.getDouble("Salario")
                );
                
                professores.add(p);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos professores" + e.getMessage());
        }
        
        return professores;
    }
}
