
package Program;

import DAO.PessoaDAO;
import beans.Pessoa;
import conexao.Conexao;

public class Program {
    
        public static void main(String[] args) {
            
        Conexao c = new Conexao();
        c.getConexao();
        
        Pessoa p = new Pessoa();
        p.setNome("Paizao do goias");
        p.setSexo("M");
        p.setIdioma("Inglês");
        
        PessoaDAO pdao = new PessoaDAO();
        pdao.inserir(p);
        
                
    }
}
