package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import database.DBConnection;
import model.Chamado;
 
public class ChamadoDAOImpl implements ChamadoDAO {
 
    @Override
    public void create(Chamado c) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Chamado (Assunto, Descricao, Status) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getAssunto());
            stmt.setString(2, c.getDescricao());
            stmt.setString(3, c.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Chamado read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Chamado WHERE Id_Chamado = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Chamado(
                    rs.getInt("Id_Chamado"),
                    rs.getString("Assunto"),
                    rs.getString("Descricao"),
                    rs.getString("Status"),
                    rs.getTimestamp("Data_Abertura").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Chamado c) {
        String sql = "UPDATE Chamado SET Assunto = ?, Descricao = ?, Status = ? WHERE Id_Chamado = ?";
        sql = sql.replaceFirst("\\?", "'" + c.getAssunto() + "'");
        sql = sql.replaceFirst("\\?", "'" + c.getDescricao() + "'");
        sql = sql.replaceFirst("\\?", "'" + c.getStatus() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(c.getIdChamado()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Chamado WHERE Id_Chamado = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}