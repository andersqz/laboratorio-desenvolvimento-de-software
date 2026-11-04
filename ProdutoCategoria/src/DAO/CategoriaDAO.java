
package DAO;

import beans.Categoria;
import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {
    
    Conexao conexao;
    Connection conn;
    
    public CategoriaDAO() {
        conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    public void inserir(Categoria c) {
        
        String query = "INSERT INTO Categoria (Nome, Descricao) VALUES (?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDescricao());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }
    
    
    public Categoria getById(int id) {
        
        String query = "SELECT * FROM Categoria WHERE CategoriaID = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            rs.first();
            Categoria c = new Categoria(rs.getInt("CategoriaID"), rs.getString("Nome"), rs.getString("Descricao"));
            
            return c;
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar categoria: " + e.getMessage());
            return null;
        }
    }
    
    
    public List<Categoria> getAll() {
        
        String query = "SELECT * FROM Categoria";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery();
            List<Categoria> categorias = new ArrayList<>();
            
            while (rs.next()) {
                Categoria c = new Categoria(rs.getInt("CategoriaID"), rs.getString("Nome"), rs.getString("Descricao"));
                categorias.add(c);
            }
            
            return categorias;
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
            return null;
        }
    }
    
    
    public void editar(Categoria c) {
        
        String query = "UPDATE Categoria SET Nome = ?, Descricao = ? WHERE CategoriaID = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDescricao());
            stmt.setInt(3, c.getId());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao editar categoria: " + e.getMessage());
            
        }
    }
    
    
    public void excluir(int id) {
        
        String query = "DELETE FROM Categoria WHERE CategoriaID = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao excluir categoria: " + e.getMessage());
        }
    }
    
    
    public List<Categoria> getCategoriaComFiltro(String nome) {
        
        String query = "SELECT * FROM Categoria WHERE Nome LIKE ?";
                
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            List<Categoria> categorias = new ArrayList<>();
            
            while (rs.next()) {
                
                Categoria c = new Categoria(rs.getInt("CategoriaID"), rs.getString("Nome"), rs.getString("Descricao"));
                
                CategoriaDAO cDAO = new CategoriaDAO();
                
               categorias.add(c); 
            }
            
            return categorias;
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias!" + e.getMessage());
            return null;
        }
    }
}
