package model;

import java.time.LocalDateTime;

public class Encomenda {

    private int idEncomenda;
    private Integer idInquilino;   // pode ser null
    private Integer idDono;        // pode ser null
    private int idApartamento;
    private LocalDateTime dataRecebimento;
    private String status;

    public Encomenda() {}

    public Encomenda(int idEncomenda, Integer idInquilino, Integer idDono, int idApartamento, LocalDateTime dataRecebimento, String status) {
        this.idEncomenda = idEncomenda;
        this.idInquilino = idInquilino;
        this.idDono = idDono;
        this.idApartamento = idApartamento;
        this.dataRecebimento = dataRecebimento;
        this.status = status;
    }

    public int getIdEncomenda() { return idEncomenda; }
    public void setIdEncomenda(int idEncomenda) { this.idEncomenda = idEncomenda; }

    public Integer getIdInquilino() { return idInquilino; }
    public void setIdInquilino(Integer idInquilino) { this.idInquilino = idInquilino; }

    public Integer getIdDono() { return idDono; }
    public void setIdDono(Integer idDono) { this.idDono = idDono; }

    public int getIdApartamento() { return idApartamento; }
    public void setIdApartamento(int idApartamento) { this.idApartamento = idApartamento; }

    public LocalDateTime getDataRecebimento() { return dataRecebimento; }
    public void setDataRecebimento(LocalDateTime dataRecebimento) { this.dataRecebimento = dataRecebimento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}