package DAO;
 
import model.Dono;
 
public interface DonoDAO {
    public void create(Dono d);
    public Dono read(int id);
    public void update(Dono d);
    public void delete(int id);
}
 