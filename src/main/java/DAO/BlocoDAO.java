package DAO;
 
import model.Bloco;
 
public interface BlocoDAO {
    public void create(Bloco b);
    public Bloco read(int id);
    public void update(Bloco b);
    public void delete(int id);
}
 