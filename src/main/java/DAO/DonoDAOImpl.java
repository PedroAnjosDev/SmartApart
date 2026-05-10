package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import database.DBConnection;
import model.Dono;
 
public class DonoDAOImpl implements DonoDAO {
 
    @Override
    public void create(Dono d) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Dono (Nome, CPF, Data_Nascimento) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(d.getDataNascimento()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Dono read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Dono WHERE Id_Dono = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Dono(
                    rs.getInt("Id_Dono"),
                    rs.getString("Nome"),
                    rs.getString("CPF"),
                    rs.getDate("Data_Nascimento").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Dono d) {
        String sql = "UPDATE Dono SET Nome = ?, CPF = ?, Data_Nascimento = ? WHERE Id_Dono = ?";
        sql = sql.replaceFirst("\\?", "'" + d.getNome() + "'");
        sql = sql.replaceFirst("\\?", "'" + d.getCpf() + "'");
        sql = sql.replaceFirst("\\?", "'" + d.getDataNascimento() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(d.getIdDono()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Dono WHERE Id_Dono = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}
 