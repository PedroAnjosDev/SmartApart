package DAO;

import model.Reserva;

public interface ReservaDAO {
    public void create(Reserva r);
    public Reserva read(int id);
    public void update(Reserva r);
    public void delete(int id);
}