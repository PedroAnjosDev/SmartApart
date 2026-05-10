package model;

public class Visitante {

    private int idVisitante;
    private String nome;
    private String cpf;
    private Integer idInquilino; // pode ser null
    private Integer idDono;      // pode ser null
    private boolean prestador;

    public Visitante() {}

    public Visitante(int idVisitante, String nome, String cpf, Integer idInquilino, Integer idDono, boolean prestador) {
        this.idVisitante = idVisitante;
        this.nome = nome;
        this.cpf = cpf;
        this.idInquilino = idInquilino;
        this.idDono = idDono;
        this.prestador = prestador;
    }

    public int getIdVisitante() { return idVisitante; }
    public void setIdVisitante(int idVisitante) { this.idVisitante = idVisitante; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Integer getIdInquilino() { return idInquilino; }
    public void setIdInquilino(Integer idInquilino) { this.idInquilino = idInquilino; }

    public Integer getIdDono() { return idDono; }
    public void setIdDono(Integer idDono) { this.idDono = idDono; }

    public boolean isPrestador() { return prestador; }
    public void setPrestador(boolean prestador) { this.prestador = prestador; }
}