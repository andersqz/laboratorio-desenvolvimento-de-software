package Program;

import java.io.IOException;
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
                        
                        // criar uma nova thread para lidar com o cliente
                        Thread threadCliente = new ThreadServer(clienteSocket);
                        threadCliente.start();
                        
                    } catch (IOException e) {
                        System.out.println("Erro ao aceitar conexão com o cliente!");
                    }
                }
                
                
            } catch (IOException e) {
                System.out.println("Erro ao criar o serverSocker!");
            }
            
                
    }
}
