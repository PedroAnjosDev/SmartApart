package model;

import java.time.LocalDate;

public class Inquilino {

    private int idInquilino;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private boolean proprietario;

    public Inquilino() {}

    public Inquilino(int idInquilino, String nome, String cpf, LocalDate dataNascimento, boolean proprietario) {
        this.idInquilino = idInquilino;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.proprietario = proprietario;
    }

    public int getIdInquilino() { return idInquilino; }
    public void setIdInquilino(int idInquilino) { this.idInquilino = idInquilino; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public boolean isProprietario() { return proprietario; }
    public void setProprietario(boolean proprietario) { this.proprietario = proprietario; }
}