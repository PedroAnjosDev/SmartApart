package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import database.DBConnection;
import model.Funcionario;
 
public class FuncionarioDAOImpl implements FuncionarioDAO {
 
    @Override
    public void create(Funcionario f) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Funcionario (Nome, CPF, Data_Nascimento, Funcao) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(f.getDataNascimento()));
            stmt.setString(4, f.getFuncao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Funcionario read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Funcionario WHERE Id_Funcionario = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                    rs.getInt("Id_Funcionario"),
                    rs.getString("Nome"),
                    rs.getString("CPF"),
                    rs.getDate("Data_Nascimento").toLocalDate(),
                    rs.getString("Funcao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Funcionario f) {
        String sql = "UPDATE Funcionario SET Nome = ?, CPF = ?, Data_Nascimento = ?, Funcao = ? WHERE Id_Funcionario = ?";
        sql = sql.replaceFirst("\\?", "'" + f.getNome() + "'");
        sql = sql.replaceFirst("\\?", "'" + f.getCpf() + "'");
        sql = sql.replaceFirst("\\?", "'" + f.getDataNascimento() + "'");
        sql = sql.replaceFirst("\\?", "'" + f.getFuncao() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(f.getIdFuncionario()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Funcionario WHERE Id_Funcionario = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}