package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
 
import database.DBConnection;
import model.Visitante;
 
public class VisitanteDAOImpl implements VisitanteDAO {
 
    @Override
    public void create(Visitante v) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Visitante (Nome, CPF, Id_Inquilino, Id_Dono, Prestador_bool) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getCpf());
            if (v.getIdInquilino() != null) stmt.setInt(3, v.getIdInquilino());
            else stmt.setNull(3, Types.INTEGER);
            if (v.getIdDono() != null) stmt.setInt(4, v.getIdDono());
            else stmt.setNull(4, Types.INTEGER);
            stmt.setBoolean(5, v.isPrestador());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Visitante read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Visitante WHERE Id_Visitante = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idInq = rs.getInt("Id_Inquilino");
                Integer idInquilino = rs.wasNull() ? null : idInq;
                int idDn = rs.getInt("Id_Dono");
                Integer idDono = rs.wasNull() ? null : idDn;
                return new Visitante(
                    rs.getInt("Id_Visitante"),
                    rs.getString("Nome"),
                    rs.getString("CPF"),
                    idInquilino,
                    idDono,
                    rs.getBoolean("Prestador_bool")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Visitante v) {
        String sql = "UPDATE Visitante SET Nome = ?, CPF = ?, Id_Inquilino = ?, Id_Dono = ?, Prestador_bool = ? WHERE Id_Visitante = ?";
        sql = sql.replaceFirst("\\?", "'" + v.getNome() + "'");
        sql = sql.replaceFirst("\\?", "'" + v.getCpf() + "'");
        sql = sql.replaceFirst("\\?", v.getIdInquilino() != null ? String.valueOf(v.getIdInquilino()) : "NULL");
        sql = sql.replaceFirst("\\?", v.getIdDono() != null ? String.valueOf(v.getIdDono()) : "NULL");
        sql = sql.replaceFirst("\\?", String.valueOf(v.isPrestador()));
        sql = sql.replaceFirst("\\?", String.valueOf(v.getIdVisitante()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Visitante WHERE Id_Visitante = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}