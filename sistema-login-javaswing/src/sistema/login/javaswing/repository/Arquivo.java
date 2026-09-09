/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.login.javaswing.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import sistema.login.javaswing.model.Usuario;

/**
 *
 * @author anderson
 */
public class Arquivo {
    
    private FileReader arqR;
    private BufferedReader leitor;
    
    private FileWriter arqW;
    private BufferedWriter escritor;
    
    private ArrayList<Usuario> listaUsuarios;
    
    public String nomeArquivo;
    
    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaUsuarios = new ArrayList<>();
    }
    
    public ArrayList<Usuario> leArquivo() {
        listaUsuarios.clear();
        
        try {
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);
            
            String linha;
            
            while ((linha = leitor.readLine()) != null) {
                
                String[] espacos = linha.split(";");
                
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(espacos[0]));
                usuario.setNome(espacos[1]);
                usuario.setEmail(espacos[2]);
                usuario.setSenha(espacos[3]);
                usuario.setActive(Boolean.parseBoolean(espacos[4]));
                usuario.setCreatedAt(LocalDate.parse(espacos[5]));
                usuario.setRoles(espacos[6].split(","));
           
                listaUsuarios.add(usuario);
            }
            arqR.close();
            leitor.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaUsuarios;
    }
    
    
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public void gravaArquivo() {
        
        try {
            arqW = new FileWriter(nomeArquivo + ".txt", false);
            escritor = new BufferedWriter(arqW);
            
            for (Usuario u : listaUsuarios) {
                
                escritor.write(
                        u.getId() + ";" + 
                        u.getNome() + ";" + 
                        u.getEmail() + ";" + 
                        u.getSenha() + ";" + 
                        u.isActive() + ";" + 
                        u.getCreatedAt() + ";" +
                        String.join(",", u.getRoles())
                );
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
    
    
    public int gerarNovoId() {
        int maiorId = 0;

        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getId() > maiorId) {
                maiorId = usuario.getId();
            }
        }
        return maiorId + 1;
    }
    
}
