package DAO;
 
import model.Visitante;
 
public interface VisitanteDAO {
    public void create(Visitante v);
    public Visitante read(int id);
    public void update(Visitante v);
    public void delete(int id);
}
 