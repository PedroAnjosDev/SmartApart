package model;

public class Salao {

    private int idSalao;
    private String nome;
    private String status;

    public Salao() {}

    public Salao(int idSalao, String nome, String status) {
        this.idSalao = idSalao;
        this.nome = nome;
        this.status = status;
    }

    public int getIdSalao() { return idSalao; }
    public void setIdSalao(int idSalao) { this.idSalao = idSalao; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}