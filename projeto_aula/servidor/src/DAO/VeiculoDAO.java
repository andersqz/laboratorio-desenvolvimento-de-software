
package DAO;

import beans.Pessoa;
import beans.Veiculo;
import java.sql.*;
import conexao.Conexao;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public VeiculoDAO() {
        conexao = new Conexao();
        conn = conexao.getConexao();
    }
    
    
    public void inserir(Veiculo veiculo) {
        
        String query = "INSERT INTO veiculo (modelo, placa, id_pessoa) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaId().getId());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir veiculo: " + e.getMessage());
        }
    }
    
    public Veiculo getVeiculo(int id) {
        
        String query = "SELECT * FROM veiculo WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Veiculo v = new Veiculo();
            
            rs.first();
            v.setId(rs.getInt("id"));
            v.setModelo(rs.getString("modelo"));
            v.setPlaca(rs.getString("placa"));
            PessoaDAO pDAO = new PessoaDAO();
            
            Pessoa p = pDAO.getPessoa(rs.getInt("id_pessoa"));
            v.setPessoaId(p);
            return v;
              
        } catch (SQLException e) {
            System.out.println("");
            return null;
        }
    }
    
    public void editar(Veiculo veiculo) {
        
        String query = "UPDATE veiculo SET modelo = ?, placa = ?, id_pessoa = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaId().getId());
            stmt.setInt(4, veiculo.getId());
            
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veiculo: " + e.getMessage());
        }
    }
    
    public void excluir(int id) {
        
        String query = "DELETE FROM veiculo WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            
            stmt.execute();
           
        } catch (SQLException e) {
            System.out.println("Erro ao excluir veiculo: " + e.getMessage());
        }
    }
    
    
    
    public List<Veiculo> getVeiculos() {
        String query = "SELECT * FROM veiculo";
        
        try {
            PreparedStatement stmt= conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery();
            List<Veiculo> listaVeiculos = new ArrayList<>();
            
            while (rs.next()) {
                
                Veiculo v = new Veiculo();
                
                v.setId(rs.getInt("id"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                PessoaDAO pDAO = new PessoaDAO();
                
                Pessoa p = pDAO.getPessoa(rs.getInt("id_pessoa"));
                v.setPessoaId(p);
                listaVeiculos.add(v);
                
            }
            
            return listaVeiculos;
        } catch (SQLException e) {
            
            System.out.println("");
            return null;
        }
    }
}
