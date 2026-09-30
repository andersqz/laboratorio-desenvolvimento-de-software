
package DAO;

import beans.Pessoa;
import conexao.Conexao;
import java.sql.*;


public class PessoaDAO {
    Conexao conexao;
    Connection conn;
    
    public PessoaDAO() {
        conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    public void inserir(Pessoa p) {
        
        String query = "INSERT INTO pessoa(nome,sexo,idioma) VALUES (?, ?, ?)";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSexo());
            stmt.setString(3, p.getIdioma());
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa" + e.getMessage());
        }
        
    }
    
    
    public Pessoa getPessoa(int id) {
        
        String query = "SELECT * FROM PESSOA WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Pessoa p = new Pessoa();
            
            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setSexo(rs.getString("sexo"));
            p.setIdioma(rs.getString("idioma"));
            
            return p;
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar pessoa" + e.getMessage());
            return null;
        }
    }
    
    
    public void editar(Pessoa p) {
        
        try {
            String query = "UPDATE PESSOA SET nome = ?, sexo = ?, idioma = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSexo());
            stmt.setString(3, p.getIdioma());
            stmt.setInt(4, p.getId());
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa" + e.getMessage());
        }
    }
    
}
