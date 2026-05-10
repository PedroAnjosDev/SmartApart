package model;

import java.time.LocalDate;

public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String funcao;

    public Funcionario() {}

    public Funcionario(int idFuncionario, String nome, String cpf, LocalDate dataNascimento, String funcao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.funcao = funcao;
    }

    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
}