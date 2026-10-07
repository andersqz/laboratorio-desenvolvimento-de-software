package DAO;

import beans.Professor;
import conexao.Conexao;
import java.sql.*;

public class ProfessorDAO {
    
    Conexao conexao;
    Connection conn;
    
    public ProfessorDAO() {
        conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    public void inserir(Professor professor) {
        
        String query = "INSERT INTO professores (nome, idade, disciplina) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir professor: " + e.getMessage());
        }
    }
    
    public Professor getProfessor(int id) {
        
        String query = "SELECT * FROM professores WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(
                query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Professor professor = new Professor();
            
            rs.first();
            professor.setId(id);
            professor.setNome(rs.getString("nome"));
            professor.setIdade(rs.getInt("idade"));
            professor.setDisciplina(rs.getString("disciplina"));
            
            return professor;
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar professor: " + e.getMessage());
            return null;
        }
    }
    
    public void editar(Professor professor) {
        
        try {
            String query = "UPDATE professores SET nome = ?, idade = ?, disciplina = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getId());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar professor: " + e.getMessage());
        }
    }
    
    public void excluir(int id) {
        
        try {
            String query = "DELETE FROM professores WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao excluir professor: " + e.getMessage());
        }
    }
}