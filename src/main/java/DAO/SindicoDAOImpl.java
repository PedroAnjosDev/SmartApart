package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import database.DBConnection;
import model.Sindico;
 
public class SindicoDAOImpl implements SindicoDAO {
 
    @Override
    public void create(Sindico s) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Sindico (Id_Inquilino, Data_Posse, Data_Final_Posse, Status) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, s.getIdInquilino());
            stmt.setDate(2, java.sql.Date.valueOf(s.getDataPosse()));
            stmt.setDate(3, s.getDataFinalPosse() != null ? java.sql.Date.valueOf(s.getDataFinalPosse()) : null);
            stmt.setString(4, s.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Sindico read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Sindico WHERE Id_Sindico = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                java.sql.Date dataFinal = rs.getDate("Data_Final_Posse");
                return new Sindico(
                    rs.getInt("Id_Sindico"),
                    rs.getInt("Id_Inquilino"),
                    rs.getDate("Data_Posse").toLocalDate(),
                    dataFinal != null ? dataFinal.toLocalDate() : null,
                    rs.getString("Status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Sindico s) {
        String sql = "UPDATE Sindico SET Id_Inquilino = ?, Data_Posse = ?, Data_Final_Posse = ?, Status = ? WHERE Id_Sindico = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(s.getIdInquilino()));
        sql = sql.replaceFirst("\\?", "'" + s.getDataPosse() + "'");
        sql = sql.replaceFirst("\\?", s.getDataFinalPosse() != null ? "'" + s.getDataFinalPosse() + "'" : "NULL");
        sql = sql.replaceFirst("\\?", "'" + s.getStatus() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(s.getIdSindico()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Sindico WHERE Id_Sindico = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}