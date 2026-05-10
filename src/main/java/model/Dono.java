package model;

import java.time.LocalDate;

public class Dono {

    private int idDono;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Dono() {}

    public Dono(int idDono, String nome, String cpf, LocalDate dataNascimento) {
        this.idDono = idDono;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getIdDono() { return idDono; }
    public void setIdDono(int idDono) { this.idDono = idDono; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}