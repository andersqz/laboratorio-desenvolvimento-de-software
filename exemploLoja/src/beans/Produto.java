
package beans;

import java.time.LocalDateTime;


public class Produto {
    
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private Categoria idCategoria;
    private boolean isActive;
    private LocalDateTime CreatedAt;
    
    public Produto() {}
    
    public Produto(String nome, double preco, int qtd, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = qtd;
        this.idCategoria = categoria;
        this.isActive = true;
        this.CreatedAt = LocalDateTime.now();
    }
    
    public Produto(int id,String nome, double preco, int qtd, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = qtd;
        this.idCategoria = categoria;
        this.isActive = true;
        this.CreatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime CreatedAt) {
        this.CreatedAt = CreatedAt;
    }
    
    public Object[] obterDados() {
        return new Object[] {
            id, nome, preco, quantidade,
            idCategoria, isActive, CreatedAt
        };
    }
    
} 
