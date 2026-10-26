
package DAO;

import beans.Categoria;
import conexao.Conexao;
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
        
        String query = "INSERT INTO categoria (nome, descricao) VALUES (?, ?)";
        
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
        
        String query = "SELECT * FROM categoria WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            rs.first();
            Categoria c = new Categoria(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
            return c;
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar categoria: " + e.getMessage());
            return null;
        }
    }
    
    public List<Categoria> getAll() {
        String query = "SELECT * FROM categoria";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery();
            List<Categoria> listaC = new ArrayList<>();
            
            while (rs.next()) {
                
                Categoria c = new Categoria(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));
                listaC.add(c);
            }
            
            return listaC;
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
            return null;
        }
    }
    
    public void editar(Categoria c) {
        
        String query = "UPDATE categoria SET nome = ?, descricao = ? WHERE id = ?";
        
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
        
        String query = "DELETE FROM categoria WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao exlcuir categoria: " + e.getMessage());
        }
        
    }
    
}
