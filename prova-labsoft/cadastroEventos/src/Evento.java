
public class Evento {
    private String nome;
    private String data;
    private String local;
    private String tipo;
    private String modalidade;
    private String situacao;
    
    public Evento() {}
    
   public Evento(String nome, String data, String local, String tipo, String modalidade, String situacao) {
       this.nome = nome;
       this.data = data;
       this.local = local;
       this.tipo = tipo;
       this.modalidade = modalidade;
       this.situacao = situacao;
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Evento{" + "nome=" + nome + ", data=" + data + ", local=" + local + ", tipo=" + tipo + ", modalidade=" + modalidade + ", situacao=" + situacao + '}';
    }
   
   
    public Object[] obterDados() {
        return new Object[] {nome, data, local, tipo, modalidade, situacao};
    }
    
   
}
