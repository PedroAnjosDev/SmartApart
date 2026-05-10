package DAO;
 
import model.Sindico;
 
public interface SindicoDAO {
    public void create(Sindico s);
    public Sindico read(int id);
    public void update(Sindico s);
    public void delete(int id);
}