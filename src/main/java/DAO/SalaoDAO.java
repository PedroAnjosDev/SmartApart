package DAO;

import model.Salao;

public interface SalaoDAO {
    public void create(Salao s);
    public Salao read(int id);
    public void update(Salao s);
    public void delete(int id);
}