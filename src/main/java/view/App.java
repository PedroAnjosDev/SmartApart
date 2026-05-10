package view;

import java.time.LocalDate;
import java.time.Month;

import DAO.DonoDAOImpl;
import model.Dono;

public class App {

    public static void main(String[] args) {

        Dono d = new Dono();

        d.setNome("Julio");
        d.setCpf("43243455434");
        d.setDataNascimento(LocalDate.of(2009, Month.APRIL, 12));

        DonoDAOImpl dao = new DonoDAOImpl();
        dao.create(d);

    }
}