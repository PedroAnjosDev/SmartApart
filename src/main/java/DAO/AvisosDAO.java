package DAO;

import model.Avisos;

public interface AvisosDAO {
    public void create(Avisos a);
    public Avisos read(int id);
    public void update(Avisos a);
    public void delete(int id);
}