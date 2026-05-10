package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.Avisos;

public class AvisosDAOImpl implements AvisosDAO {

    @Override
    public void create(Avisos a) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Avisos (Id_Sindico, Assunto, Texto, Data) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a.getIdSindico());
            stmt.setString(2, a.getAssunto());
            stmt.setString(3, a.getTexto());
            stmt.setDate(4, java.sql.Date.valueOf(a.getData()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Avisos read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Avisos WHERE Id_Avisos = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Avisos(
                    rs.getInt("Id_Avisos"),
                    rs.getInt("Id_Sindico"),
                    rs.getString("Assunto"),
                    rs.getString("Texto"),
                    rs.getDate("Data").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Avisos a) {
        String sql = "UPDATE Avisos SET Id_Sindico = ?, Assunto = ?, Texto = ?, Data = ? WHERE Id_Avisos = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(a.getIdSindico()));
        sql = sql.replaceFirst("\\?", "'" + a.getAssunto() + "'");
        sql = sql.replaceFirst("\\?", "'" + a.getTexto() + "'");
        sql = sql.replaceFirst("\\?", "'" + a.getData() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(a.getIdAvisos()));
        System.out.println(sql);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Avisos WHERE Id_Avisos = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}