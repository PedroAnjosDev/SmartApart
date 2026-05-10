package model;

import java.time.LocalDate;

public class Reserva {

    private int idReserva;
    private int idInquilino;
    private int idSalao;
    private LocalDate dataPrevista;
    private String status;

    public Reserva() {}

    public Reserva(int idReserva, int idInquilino, int idSalao, LocalDate dataPrevista, String status) {
        this.idReserva = idReserva;
        this.idInquilino = idInquilino;
        this.idSalao = idSalao;
        this.dataPrevista = dataPrevista;
        this.status = status;
    }

    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public int getIdInquilino() { return idInquilino; }
    public void setIdInquilino(int idInquilino) { this.idInquilino = idInquilino; }

    public int getIdSalao() { return idSalao; }
    public void setIdSalao(int idSalao) { this.idSalao = idSalao; }

    public LocalDate getDataPrevista() { return dataPrevista; }
    public void setDataPrevista(LocalDate dataPrevista) { this.dataPrevista = dataPrevista; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}