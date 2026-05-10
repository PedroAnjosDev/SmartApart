package DAO;
 
import model.Chamado;
 
public interface ChamadoDAO {
    public void create(Chamado c);
    public Chamado read(int id);
    public void update(Chamado c);
    public void delete(int id);
}
 