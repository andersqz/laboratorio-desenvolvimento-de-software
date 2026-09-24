package model;

public class Professor {
    private int id;
    private String nome;
    private String cpf;
    private String disciplina;
    private double salario;
    
    public Professor() {}
    
    public Professor(String nome, String cpf, String disciplina, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.disciplina = disciplina;
        this.salario = salario;
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

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", disciplina=" + disciplina + ", salario=" + salario + '}';
    }
    
    
    
}
