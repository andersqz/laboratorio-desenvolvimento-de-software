package sistema.login.javaswing.model;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private boolean isActive;
    private LocalDate createdAt;
    private String[] roles;
    
    public Usuario() {}
    
    public Usuario(int id, String nome, String email, String senha, boolean isActive, LocalDate data, String[] roles) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isActive = isActive;
        this.createdAt = data;
        this.roles = roles;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String[] getRoles() {
        return roles;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
