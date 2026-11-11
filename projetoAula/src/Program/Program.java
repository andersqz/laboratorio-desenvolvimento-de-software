package Program;

import DAO.PessoaDAO;
import beans.Pessoa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Program {
    
        public static void main(String[] args) {
            
            int porta = 12345;
            
            try (ServerSocket servidorSocket = new ServerSocket(porta)) {
                System.out.println("Servidor aguardando conexão na porta: " + porta);
                
                while (true) {
                    try {
                        Socket clienteSocket = servidorSocket.accept();
                        System.out.println("Conexão aceita de " + clienteSocket.getInetAddress());
                        ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());
                        ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());
                        
                        int id = in.readInt();
                        System.out.println("ID recebido: " + id);
                        
                        // simule a obtenção de uma pessoa a partir do ID
                        PessoaDAO pdao = new PessoaDAO();
                        Pessoa p = pdao.getPessoa(id);
                        
                        out.writeObject(p);
                        
                    } catch (IOException e) {
                        System.out.println("Erro ao aceitar conexão com o cliente!");
                    }
                }
                
                
            } catch (IOException e) {
                System.out.println("Erro ao criar o serverSocker!");
            }
            
                
    }
}
