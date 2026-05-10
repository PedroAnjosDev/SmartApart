package model;
 
public class Apartamento {
 
    private int idApartamento;
    private int idBloco;
    private Integer idInquilino; // pode ser null
    private int idDono;
    private int numero;
 
    public Apartamento() {}
 
    public Apartamento(int idApartamento, int idBloco, Integer idInquilino, int idDono, int numero) {
        this.idApartamento = idApartamento;
        this.idBloco = idBloco;
        this.idInquilino = idInquilino;
        this.idDono = idDono;
        this.numero = numero;
    }
 
    public int getIdApartamento() { return idApartamento; }
    public void setIdApartamento(int idApartamento) { this.idApartamento = idApartamento; }
 
    public int getIdBloco() { return idBloco; }
    public void setIdBloco(int idBloco) { this.idBloco = idBloco; }
 
    public Integer getIdInquilino() { return idInquilino; }
    public void setIdInquilino(Integer idInquilino) { this.idInquilino = idInquilino; }
 
    public int getIdDono() { return idDono; }
    public void setIdDono(int idDono) { this.idDono = idDono; }
 
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
}