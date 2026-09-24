package model;

public class Aluno {
    private int id;
    private String nome;
    private String cpf;
    private String curso;
    private String matricula;
    
    public Aluno() {}
    
    public Aluno(String nome, String cpf, String curso, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
        this.matricula = matricula;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", curso=" + curso + ", matricula=" + matricula + '}';
    }
    
    
    
}
