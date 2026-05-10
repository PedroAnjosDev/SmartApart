package DAO;

import model.Encomenda;

public interface EncomendaDAO {
    public void create(Encomenda e);
    public Encomenda read(int id);
    public void update(Encomenda e);
    public void delete(int id);
}