package DAO;
 
import model.Apartamento;
 
public interface ApartamentoDAO {
    public void create(Apartamento a);
    public Apartamento read(int id);
    public void update(Apartamento a);
    public void delete(int id);
}
 