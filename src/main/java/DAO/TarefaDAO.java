package DAO;
 
import model.Tarefa;
 
public interface TarefaDAO {
    public void create(Tarefa t);
    public Tarefa read(int id);
    public void update(Tarefa t);
    public void delete(int id);
}
 