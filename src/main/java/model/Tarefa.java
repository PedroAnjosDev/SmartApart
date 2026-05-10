package model;

import java.time.LocalDateTime;

public class Tarefa {

    private int idTarefa;
    private int idFuncionario;
    private int idChamado;
    private String status;
    private LocalDateTime dataCriacao;

    public Tarefa() {}

    public Tarefa(int idTarefa, int idFuncionario, int idChamado, String status, LocalDateTime dataCriacao) {
        this.idTarefa = idTarefa;
        this.idFuncionario = idFuncionario;
        this.idChamado = idChamado;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public int getIdTarefa() { return idTarefa; }
    public void setIdTarefa(int idTarefa) { this.idTarefa = idTarefa; }

    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    public int getIdChamado() { return idChamado; }
    public void setIdChamado(int idChamado) { this.idChamado = idChamado; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}