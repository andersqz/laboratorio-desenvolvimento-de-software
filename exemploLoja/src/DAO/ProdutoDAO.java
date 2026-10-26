
package DAO;

import beans.Categoria;
import beans.Produto;
import conexao.Conexao;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    
    Conexao conexao;
    Connection conn;
    
    public ProdutoDAO() {
        conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    public void inserir(Produto p) {
        
        String query = "INSERT INTO produto(nome, preco, quantidade, id_categoria, isActive, createdAt) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQuantidade());
            stmt.setInt(4, p.getIdCategoria().getId());
            stmt.setBoolean(5, p.getIsActive());
            stmt.setObject(6, p.getCreatedAt());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Não foi possível inserir um produto: " + e.getMessage());
        }
    }
    
    
    public Produto getById(int id) {
        
        String query = "SELECT * FROM produto WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Produto p = new Produto();
            
            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getDouble("preco"));
            p.setQuantidade(rs.getInt("quantidade"));
            CategoriaDAO cDAO = new CategoriaDAO();
            
            Categoria c = cDAO.getById(rs.getInt("id_categoria"));
            p.setIdCategoria(c);
            p.setIsActive(rs.getBoolean("isActive"));
            p.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
            
           return p;
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
            return null;
        }
    }
    
    
    public List<Produto> getAll() {
        
        String query = "SELECT * FROM produto";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery();
            List<Produto> listaP = new ArrayList<>();
            
            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                CategoriaDAO cDAO = new CategoriaDAO();

                Categoria c = cDAO.getById(rs.getInt("id_categoria"));
                p.setIdCategoria(c);
                p.setIsActive(rs.getBoolean("isActive"));
                p.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                
                listaP.add(p);
            }
            
            return listaP;
             
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os produtos: " + e.getMessage());
            return null;
        }
    }
    
    public void editar(Produto p) {
        
        String query = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?, id_categoria = ?, isActive = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQuantidade());
            stmt.setInt(4, p.getIdCategoria().getId());
            stmt.setBoolean(5, p.getIsActive());
            stmt.setInt(6, p.getId());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }
    
    
    public void excluir(int id) {
        
        String query = "DELETE FROM produto WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }
    
    public List<Produto> getProdutoComFiltro(String nome) {
        
        String query = "SELECT * FROM produto WHERE nome LIKE ?";
        
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            List<Produto> listaProdutos = new ArrayList<>();
            
            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                CategoriaDAO cDAO = new CategoriaDAO();
                
                Categoria c = cDAO.getById(rs.getInt("id_categoria"));
                p.setIdCategoria(c);
                p.setIsActive(rs.getBoolean("isActive"));
                p.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                listaProdutos.add(p);
            }
            return listaProdutos;
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
            return null;
        }
    }
    
}
