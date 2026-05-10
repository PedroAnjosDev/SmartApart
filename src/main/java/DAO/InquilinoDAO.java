package DAO;
 
import model.Inquilino;
 
public interface InquilinoDAO {
    public void create(Inquilino i);
    public Inquilino read(int id);
    public void update(Inquilino i);
    public void delete(int id);
}