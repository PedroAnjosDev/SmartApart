package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import database.DBConnection;
import model.Bloco;
 
public class BlocoDAOImpl implements BlocoDAO {
 
    @Override
    public void create(Bloco b) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Bloco (Nome) VALUES (?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, b.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Bloco read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Bloco WHERE Id_Bloco = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Bloco(
                    rs.getInt("Id_Bloco"),
                    rs.getString("Nome")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Bloco b) {
        String sql = "UPDATE Bloco SET Nome = ? WHERE Id_Bloco = ?";
        sql = sql.replaceFirst("\\?", "'" + b.getNome() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(b.getIdBloco()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Bloco WHERE Id_Bloco = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}