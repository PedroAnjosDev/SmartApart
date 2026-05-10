package model;

import java.time.LocalDate;

public class Sindico {

    private int idSindico;
    private int idInquilino;
    private LocalDate dataPosse;
    private LocalDate dataFinalPosse; // pode ser null
    private String status;

    public Sindico() {}

    public Sindico(int idSindico, int idInquilino, LocalDate dataPosse, LocalDate dataFinalPosse, String status) {
        this.idSindico = idSindico;
        this.idInquilino = idInquilino;
        this.dataPosse = dataPosse;
        this.dataFinalPosse = dataFinalPosse;
        this.status = status;
    }

    public int getIdSindico() { return idSindico; }
    public void setIdSindico(int idSindico) { this.idSindico = idSindico; }

    public int getIdInquilino() { return idInquilino; }
    public void setIdInquilino(int idInquilino) { this.idInquilino = idInquilino; }

    public LocalDate getDataPosse() { return dataPosse; }
    public void setDataPosse(LocalDate dataPosse) { this.dataPosse = dataPosse; }

    public LocalDate getDataFinalPosse() { return dataFinalPosse; }
    public void setDataFinalPosse(LocalDate dataFinalPosse) { this.dataFinalPosse = dataFinalPosse; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}