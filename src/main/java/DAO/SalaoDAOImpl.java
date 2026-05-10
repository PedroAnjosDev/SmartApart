package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.Salao;

public class SalaoDAOImpl implements SalaoDAO {

    @Override
    public void create(Salao s) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Salao (Nome, Status) VALUES (?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.setString(2, s.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Salao read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Salao WHERE Id_Salao = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Salao(
                    rs.getInt("Id_Salao"),
                    rs.getString("Nome"),
                    rs.getString("Status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Salao s) {
        String sql = "UPDATE Salao SET Nome = ?, Status = ? WHERE Id_Salao = ?";
        sql = sql.replaceFirst("\\?", "'" + s.getNome() + "'");
        sql = sql.replaceFirst("\\?", "'" + s.getStatus() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(s.getIdSalao()));
        System.out.println(sql);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Salao WHERE Id_Salao = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}