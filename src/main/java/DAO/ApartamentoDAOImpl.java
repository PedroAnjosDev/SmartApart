package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import database.DBConnection;
import model.Apartamento;

public class ApartamentoDAOImpl implements ApartamentoDAO {

    @Override
    public void create(Apartamento a) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Apartamento (Id_Bloco, Id_Inquilino, Id_Dono, Numero) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a.getIdBloco());
            if (a.getIdInquilino() != null) stmt.setInt(2, a.getIdInquilino());
            else stmt.setNull(2, Types.INTEGER);
            stmt.setInt(3, a.getIdDono());
            stmt.setInt(4, a.getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Apartamento read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Apartamento WHERE Id_Apartamento = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idInq = rs.getInt("Id_Inquilino");
                Integer idInquilino = rs.wasNull() ? null : idInq;
                return new Apartamento(
                    rs.getInt("Id_Apartamento"),
                    rs.getInt("Id_Bloco"),
                    idInquilino,
                    rs.getInt("Id_Dono"),
                    rs.getInt("Numero")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Apartamento a) {
        String sql = "UPDATE Apartamento SET Id_Bloco = ?, Id_Inquilino = ?, Id_Dono = ?, Numero = ? WHERE Id_Apartamento = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(a.getIdBloco()));
        sql = sql.replaceFirst("\\?", a.getIdInquilino() != null ? String.valueOf(a.getIdInquilino()) : "NULL");
        sql = sql.replaceFirst("\\?", String.valueOf(a.getIdDono()));
        sql = sql.replaceFirst("\\?", String.valueOf(a.getNumero()));
        sql = sql.replaceFirst("\\?", String.valueOf(a.getIdApartamento()));
        System.out.println(sql);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Apartamento WHERE Id_Apartamento = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}