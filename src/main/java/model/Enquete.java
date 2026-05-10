package model;

import java.time.LocalDate;

public class Enquete {

    private int idEnquete;
    private int idSindico;
    private String assunto;
    private int op1;
    private int op2;
    private int op3;
    private int op4;
    private LocalDate data;

    public Enquete() {}

    public Enquete(int idEnquete, int idSindico, String assunto, int op1, int op2, int op3, int op4, LocalDate data) {
        this.idEnquete = idEnquete;
        this.idSindico = idSindico;
        this.assunto = assunto;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.data = data;
    }

    public int getIdEnquete() { return idEnquete; }
    public void setIdEnquete(int idEnquete) { this.idEnquete = idEnquete; }

    public int getIdSindico() { return idSindico; }
    public void setIdSindico(int idSindico) { this.idSindico = idSindico; }

    public String getAssunto() { return assunto; }
    public void setAssunto(String assunto) { this.assunto = assunto; }

    public int getOp1() { return op1; }
    public void setOp1(int op1) { this.op1 = op1; }

    public int getOp2() { return op2; }
    public void setOp2(int op2) { this.op2 = op2; }

    public int getOp3() { return op3; }
    public void setOp3(int op3) { this.op3 = op3; }

    public int getOp4() { return op4; }
    public void setOp4(int op4) { this.op4 = op4; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}