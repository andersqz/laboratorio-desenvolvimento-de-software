
package DAO;

import beans.Aluno;
import conexao.Conexao;
import java.sql.*;

public class AlunoDAO {
    
    Conexao conexao;
    Connection conn;
    
    public AlunoDAO() {
        conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    public void inserir(Aluno aluno) {
        
        String query = "INSERT INTO alunos (nome, idade, curso) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            
            stmt.execute();
            
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
        }
    }
    
    public Aluno getALuno(int id) {
        
        String query = "SELECT * FROM alunos WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Aluno aluno = new Aluno();
            
            rs.first();
            aluno.setId(id);
            aluno.setNome(rs.getString("nome"));
            aluno.setIdade(rs.getInt("idade"));
            aluno.setCurso(rs.getString("curso"));
            
            return aluno;
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar aluno" + e.getMessage());
            return null;
        }
    }
    
    public void editar(Aluno aluno) {
        
        try {
            String query = "UPDATE alunos SET nome = ?, idade = ?, curso = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getId());
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno" + e.getMessage());
        }
    }
    
    public void excluir(int id){
        
        try {
            String query = "DELETE FROM alunos WHERE id = ?";
            
           PreparedStatement stmt = conn.prepareStatement(query);
           stmt.setInt(1, id);
           stmt.execute();
           
        } catch (SQLException e) {
            System.out.println("Erro ao excluir aluno: " + e.getMessage());
        }
    }
    
}
