
package beans;


public class Veiculo {
    
    private int id;
    private String modelo;
    private String placa;
    private Pessoa pessoaId;
    
    public Veiculo() {}
    
    public Veiculo(String modelo, String placa, Pessoa p) {
        this.modelo = modelo;
        this.placa = placa;
        this.pessoaId  = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }
    
   public Object[] obterDados() {
       return new Object[] {id, modelo, placa, pessoaId};
   }
}
