
package cadastro_de_alunos;
public class Aluno {

    private String nome;
    private String dataNasc;
    private String sexo;
    private int matricula;
    private String curso;
    private String cpf;
    private String ruaCasa;
    private int numeroCasa;
    private String bairroCasa;
    private String cidadeCasa;
    private int cepCasa;
    private String estado;
    private int telefone;

    public Aluno() {}
    
    public Aluno(String nome, String dataNasc, String sexo, int matricula, String curso, String cpf, 
            String ruaCasa, int numeroCasa, String bairroCasa, String cidadeCasa, int cepCasa, String estado, int telefone) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.ruaCasa = ruaCasa;
        this.numeroCasa = numeroCasa;
        this.bairroCasa = bairroCasa;
        this.cidadeCasa = cidadeCasa;
        this.cepCasa = cepCasa;
        this.estado = estado;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRuaCasa() {
        return ruaCasa;
    }
    public void setRuaCasa(String ruaCasa) {
        this.ruaCasa = ruaCasa;
    }
    public int getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public String getBairroCasa() {
        return bairroCasa;
    }
    public void setBairroCasa(String bairroCasa) {
        this.bairroCasa = bairroCasa;
    }
    public String getCidadeCasa() {
        return cidadeCasa;
    }
    public void setCidadeCasa(String cidadeCasa) {
        this.cidadeCasa = cidadeCasa;
    }
    public int getCepCasa() {
        return cepCasa;
    }
    public void setCepCasa(int cepCasa) {
        this.cepCasa = cepCasa;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    

    public Object[] obterDados() {
        return new Object[] 
        {
            nome, 
            dataNasc, 
            sexo,
            matricula, 
            curso, 
            cpf,
            ruaCasa, 
            numeroCasa, 
            bairroCasa,
            cidadeCasa, 
            cepCasa, 
            estado,
            telefone
        };
    }
    
    
    
    
    
    @Override
public String toString() {
    return "Aluno{" +
            "nome='" + nome + '\'' +
            ", dataNasc='" + dataNasc + '\'' +
            ", sexo='" + sexo + '\'' +
            ", matricula=" + matricula +
            ", curso='" + curso + '\'' +
            ", cpf='" + cpf + '\'' +
            ", ruaCasa='" + ruaCasa + '\'' +
            ", numeroCasa=" + numeroCasa +
            ", bairroCasa='" + bairroCasa + '\'' +
            ", cidadeCasa='" + cidadeCasa + '\'' +
            ", cepCasa=" + cepCasa +
            ", estado='" + estado + '\'' +
            ", telefone=" + telefone +
            '}';
}
}