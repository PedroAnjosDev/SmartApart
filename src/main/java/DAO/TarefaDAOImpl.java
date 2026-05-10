package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import database.DBConnection;
import model.Tarefa;
 
public class TarefaDAOImpl implements TarefaDAO {
 
    @Override
    public void create(Tarefa t) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Tarefa (Id_Funcionario, Id_Chamado, Status) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, t.getIdFuncionario());
            stmt.setInt(2, t.getIdChamado());
            stmt.setString(3, t.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Tarefa read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Tarefa WHERE Id_Tarefa = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tarefa(
                    rs.getInt("Id_Tarefa"),
                    rs.getInt("Id_Funcionario"),
                    rs.getInt("Id_Chamado"),
                    rs.getString("Status"),
                    rs.getTimestamp("Data_Criacao").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Tarefa t) {
        String sql = "UPDATE Tarefa SET Id_Funcionario = ?, Id_Chamado = ?, Status = ? WHERE Id_Tarefa = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(t.getIdFuncionario()));
        sql = sql.replaceFirst("\\?", String.valueOf(t.getIdChamado()));
        sql = sql.replaceFirst("\\?", "'" + t.getStatus() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(t.getIdTarefa()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Tarefa WHERE Id_Tarefa = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}