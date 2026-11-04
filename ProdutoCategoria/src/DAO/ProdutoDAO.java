
package DAO;

import beans.Categoria;
import beans.Produto;
import conexao.Conexao;
import java.sql.*;
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
        
        String query = "INSERT INTO Produto (CategoriaID, Nome, Preco, Quantidade, Ativo, CriadoEm) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, p.getCategoriaID().getId());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidade());
            stmt.setBoolean(5, p.isAtivo());
            stmt.setObject(6, p.getCriadoEm());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            
        }
    }
    
    
    public Produto getById(int id) {
        
        String query = "SELECT * FROM Produto WHERE ProdutoID = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            rs.first();
            Produto p = new Produto();
            
            p.setId(id);
            p.setNome(rs.getString("Nome"));
            p.setPreco(rs.getDouble("Preco"));
            p.setQuantidade(rs.getInt("Quantidade"));
            
            CategoriaDAO cDAO = new CategoriaDAO();
            
            int idCategoria = rs.getInt("CategoriaID");
            Categoria c = cDAO.getById(idCategoria);
            
            p.setCategoriaID(c);
            p.setAtivo(rs.getBoolean("Ativo"));
            p.setCriadoEm(rs.getTimestamp("CriadoEm").toLocalDateTime().toLocalDate());
            
            return p;
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
            return null;
        }
    }
    
    public List<Produto> getAll() {
        
        String query = "SELECT * FROM Produto";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            
            while (rs.next()) {
                
                Produto p = new Produto();
                
                p.setId(rs.getInt("ProdutoID"));
                p.setNome(rs.getString("Nome"));
                p.setPreco(rs.getDouble("Preco"));
                p.setQuantidade(rs.getInt("Quantidade"));

                CategoriaDAO cDAO = new CategoriaDAO();

                int idCategoria = rs.getInt("CategoriaID");
                Categoria c = cDAO.getById(idCategoria);

                p.setCategoriaID(c);
                p.setAtivo(rs.getBoolean("Ativo"));
                p.setCriadoEm(rs.getTimestamp("CriadoEm").toLocalDateTime().toLocalDate());
                
                produtos.add(p);
            }
            
            return produtos;
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
            return null;
        }
    }
    
    
    public void editar(Produto p) {
        
        String query = "UPDATE Produto SET Nome = ?, Preco = ?, Quantidade = ?, CategoriaID = ?, Ativo = ? WHERE ProdutoID = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQuantidade());
            stmt.setInt(4, p.getCategoriaID().getId());
            stmt.setBoolean(5, p.isAtivo());
            stmt.setInt(6, p.getId());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }
    
    
    public void excluir(int id) {
        
        String query = "DELETE FROM Produto WHERE ProdutoID = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }
    
    
    public List<Produto> getProdutoComFiltro(String nome) {
        
        String query = "SELECT * FROM Produto WHERE Nome LIKE ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            List<Produto> produtos = new ArrayList<>();
            
            while (rs.next()) {
                Produto p = new Produto();
                
                p.setId(rs.getInt("ProdutoID"));
                p.setNome(rs.getString("Nome"));
                p.setPreco(rs.getDouble("Preco"));
                p.setQuantidade(rs.getInt("Quantidade"));

                CategoriaDAO cDAO = new CategoriaDAO();

                int idCategoria = rs.getInt("CategoriaID");
                Categoria c = cDAO.getById(idCategoria);

                p.setCategoriaID(c);
                p.setAtivo(rs.getBoolean("Ativo"));
                p.setCriadoEm(rs.getTimestamp("CriadoEm").toLocalDateTime().toLocalDate());
                
                produtos.add(p);
            }
            
            return produtos;
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
            return null;
        }
    }
}
