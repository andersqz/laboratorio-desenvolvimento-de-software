
package beans;


public class Categoria {
    
    private int id;
    private String nome;
    private String descricao;
    
    public Categoria() {}
    
    public Categoria(String nome, String desc) {
        this.nome = nome;
        this.descricao = desc;
    }
    
    public Categoria(int id, String nome, String desc) {
        this.id = id;
        this.nome = nome;
        this.descricao = desc;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
