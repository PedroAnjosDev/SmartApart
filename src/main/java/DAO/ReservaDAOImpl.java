package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.Reserva;

public class ReservaDAOImpl implements ReservaDAO {

    @Override
    public void create(Reserva r) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Reserva (Id_Inquilino, Id_Salao, Data_Prevista, Status) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, r.getIdInquilino());
            stmt.setInt(2, r.getIdSalao());
            stmt.setDate(3, java.sql.Date.valueOf(r.getDataPrevista()));
            stmt.setString(4, r.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reserva read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Reserva WHERE Id_Reserva = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Reserva(
                    rs.getInt("Id_Reserva"),
                    rs.getInt("Id_Inquilino"),
                    rs.getInt("Id_Salao"),
                    rs.getDate("Data_Prevista").toLocalDate(),
                    rs.getString("Status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Reserva r) {
        String sql = "UPDATE Reserva SET Id_Inquilino = ?, Id_Salao = ?, Data_Prevista = ?, Status = ? WHERE Id_Reserva = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(r.getIdInquilino()));
        sql = sql.replaceFirst("\\?", String.valueOf(r.getIdSalao()));
        sql = sql.replaceFirst("\\?", "'" + r.getDataPrevista() + "'");
        sql = sql.replaceFirst("\\?", "'" + r.getStatus() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(r.getIdReserva()));
        System.out.println(sql);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Reserva WHERE Id_Reserva = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}