package model;

import java.time.LocalDate;

public class Avisos {

    private int idAvisos;
    private int idSindico;
    private String assunto;
    private String texto;
    private LocalDate data;

    public Avisos() {}

    public Avisos(int idAvisos, int idSindico, String assunto, String texto, LocalDate data) {
        this.idAvisos = idAvisos;
        this.idSindico = idSindico;
        this.assunto = assunto;
        this.texto = texto;
        this.data = data;
    }

    public int getIdAvisos() { return idAvisos; }
    public void setIdAvisos(int idAvisos) { this.idAvisos = idAvisos; }

    public int getIdSindico() { return idSindico; }
    public void setIdSindico(int idSindico) { this.idSindico = idSindico; }

    public String getAssunto() { return assunto; }
    public void setAssunto(String assunto) { this.assunto = assunto; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}