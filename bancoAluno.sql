CREATE DATABASE escola;

USE escola;

CREATE TABLE professor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14),
    disciplina VARCHAR(100),
    salario DOUBLE
);

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14),
    curso VARCHAR(100),
    matricula VARCHAR(50)
);


INSERT INTO professor (nome, cpf, disciplina, salario) VALUES
('Carlos Silva', '111.111.111-11', 'Matemática', 4500.00),
('Ana Souza', '222.222.222-22', 'Português', 4200.00),
('Marcos Oliveira', '333.333.333-33', 'História', 4000.00),
('Juliana Santos', '444.444.444-44', 'Programação', 5000.00);

INSERT INTO aluno (nome, cpf, curso, matricula) VALUES
('João Pereira', '555.555.555-55', 'Informática', '2026001'),
('Maria Costa', '666.666.666-66', 'Administração', '2026002'),
('Pedro Alves', '777.777.777-77', 'Engenharia', '2026003'),
('Lucas Martins', '888.888.888-88', 'Informática', '2026004'),
('Beatriz Lima', '999.999.999-99', 'Direito', '2026005');


select * from aluno