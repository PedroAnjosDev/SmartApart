package model;

import java.time.LocalDateTime;

public class Chamado {

    private int idChamado;
    private String assunto;
    private String descricao;
    private String status;
    private LocalDateTime dataAbertura;

    public Chamado() {}

    public Chamado(int idChamado, String assunto, String descricao, String status, LocalDateTime dataAbertura) {
        this.idChamado = idChamado;
        this.assunto = assunto;
        this.descricao = descricao;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public int getIdChamado() { return idChamado; }
    public void setIdChamado(int idChamado) { this.idChamado = idChamado; }

    public String getAssunto() { return assunto; }
    public void setAssunto(String assunto) { this.assunto = assunto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
}