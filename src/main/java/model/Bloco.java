package model;

public class Bloco {

    private int idBloco;
    private String nome;

    public Bloco() {}

    public Bloco(int idBloco, String nome) {
        this.idBloco = idBloco;
        this.nome = nome;
    }

    public int getIdBloco() { return idBloco; }
    public void setIdBloco(int idBloco) { this.idBloco = idBloco; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}