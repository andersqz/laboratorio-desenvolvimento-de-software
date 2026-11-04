
package beans;

import java.time.LocalDate;
import java.util.Objects;


public class Produto {
    
    private int id;
    private Categoria categoriaID;
    private String nome;
    private double preco;
    private int quantidade;
    private boolean ativo;
    private LocalDate criadoEm;

    public Produto() {
    }

    public Produto(int id, Categoria categoriaID, String nome, double preco, int quantidade, boolean ativo, LocalDate criadoEm) {
        this.id = id;
        this.categoriaID = categoriaID;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
    }

    public Produto(Categoria categoriaID, String nome, double preco, int quantidade, boolean ativo, LocalDate criadoEm) {
        this.categoriaID = categoriaID;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(Categoria categoriaID) {
        this.categoriaID = categoriaID;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }
    
    
    public Object[] obterDados() {
        return new Object[] {id, categoriaID, nome, preco, quantidade, ativo, criadoEm};
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.categoriaID);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 59 * hash + this.quantidade;
        hash = 59 * hash + (this.ativo ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.criadoEm);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.categoriaID, other.categoriaID)) {
            return false;
        }
        return Objects.equals(this.criadoEm, other.criadoEm);
    }
    
    
}
