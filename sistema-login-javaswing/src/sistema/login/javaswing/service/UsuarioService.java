

package sistema.login.javaswing.service;

import java.time.LocalDate;
import sistema.login.javaswing.model.Usuario;
import sistema.login.javaswing.repository.Arquivo;

public class UsuarioService {
    
    private Arquivo arquivo;
    
    public UsuarioService() {
        arquivo = new Arquivo("alunos");
        arquivo.leArquivo();
    }
    
    public void cadastrarUsuario(String nome, String email, String senha) {
        
        int id = arquivo.gerarNovoId();
        boolean isActive = true;
        LocalDate agora = LocalDate.now();
        String[] roles = {"ADMIN"};
        
        Usuario usuario = new Usuario(id, nome, email, senha, isActive, agora, roles);
        
        arquivo.adicionarUsuario(usuario);
        arquivo.gravaArquivo();
    }
    
    public void validarUsuario(String nome, String email, String senha) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }

        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória.");
        }

        if (senha.length() < 6) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres.");
        }
    }
    
    
    

    
}
