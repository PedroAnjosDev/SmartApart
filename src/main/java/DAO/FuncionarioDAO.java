package DAO;
 
import model.Funcionario;
 
public interface FuncionarioDAO {
    public void create(Funcionario f);
    public Funcionario read(int id);
    public void update(Funcionario f);
    public void delete(int id);
}
 