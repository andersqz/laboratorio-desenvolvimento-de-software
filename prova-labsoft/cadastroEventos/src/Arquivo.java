
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Arquivo {
    
    private ArrayList<Evento> eventos;
    private String nomeArquivo;
    
    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        eventos = new ArrayList<>();
    }
    
    public ArrayList<Evento> leArquivo() {
        
        eventos.clear();
        
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo + ".txt"))) {
            
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                
                String[] campos = linha.split(";");
                
                Evento ev = new Evento(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]);
                eventos.add(ev);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return eventos;
    }
    
    
    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    
    
    public void gravaArquivo() {
        
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo + ".txt", false))) {
            
            for (Evento ev : eventos) {
                
                escritor.write(
                        ev.getNome() + ";" + ev.getData() + ";" + ev.getLocal() + ";" + ev.getTipo() + ";" + ev.getModalidade() + ";" + ev.getSituacao());
                
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
