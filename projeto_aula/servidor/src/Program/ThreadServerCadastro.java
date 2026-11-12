
package Program;

import DAO.PessoaDAO;
import beans.Pessoa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ThreadServerCadastro extends Thread {
    private Socket clienteSocket;
    
    public ThreadServerCadastro(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }
    
    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());
            
            Pessoa pessoa = (Pessoa) in.readObject();
            
            PessoaDAO pdao = new PessoaDAO();
            pdao.inserir(pessoa);
            
            
            
        } catch (IOException e) {
            System.out.println("Erro ao lidar com o cliente");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Erro na classe Pessoa");
        }
    }
}
