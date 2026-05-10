package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import database.DBConnection;
import model.Encomenda;

public class EncomendaDAOImpl implements EncomendaDAO {

    @Override
    public void create(Encomenda e) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Encomenda (Id_Inquilino, Id_Dono, Id_Apartamento, Status) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            if (e.getIdInquilino() != null) stmt.setInt(1, e.getIdInquilino());
            else stmt.setNull(1, Types.INTEGER);
            if (e.getIdDono() != null) stmt.setInt(2, e.getIdDono());
            else stmt.setNull(2, Types.INTEGER);
            stmt.setInt(3, e.getIdApartamento());
            stmt.setString(4, e.getStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Encomenda read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Encomenda WHERE Id_Encomenda = ?";
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
                return new Encomenda(
                    rs.getInt("Id_Encomenda"),
                    idInquilino,
                    idDono,
                    rs.getInt("Id_Apartamento"),
                    rs.getTimestamp("Data_Recebimento").toLocalDateTime(),
                    rs.getString("Status")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Encomenda e) {
        String sql = "UPDATE Encomenda SET Id_Inquilino = ?, Id_Dono = ?, Id_Apartamento = ?, Status = ? WHERE Id_Encomenda = ?";
        sql = sql.replaceFirst("\\?", e.getIdInquilino() != null ? String.valueOf(e.getIdInquilino()) : "NULL");
        sql = sql.replaceFirst("\\?", e.getIdDono() != null ? String.valueOf(e.getIdDono()) : "NULL");
        sql = sql.replaceFirst("\\?", String.valueOf(e.getIdApartamento()));
        sql = sql.replaceFirst("\\?", "'" + e.getStatus() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(e.getIdEncomenda()));
        System.out.println(sql);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Encomenda WHERE Id_Encomenda = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}