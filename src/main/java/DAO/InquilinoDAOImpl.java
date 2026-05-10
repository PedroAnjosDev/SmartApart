package DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import database.DBConnection;
import model.Inquilino;
 
public class InquilinoDAOImpl implements InquilinoDAO {
 
    @Override
    public void create(Inquilino i) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Inquilino (Nome, CPF, Data_Nascimento, Proprietario_bool) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(i.getDataNascimento()));
            stmt.setBoolean(4, i.isProprietario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public Inquilino read(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Inquilino WHERE Id_Inquilino = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Inquilino(
                    rs.getInt("Id_Inquilino"),
                    rs.getString("Nome"),
                    rs.getString("CPF"),
                    rs.getDate("Data_Nascimento").toLocalDate(),
                    rs.getBoolean("Proprietario_bool")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public void update(Inquilino i) {
        String sql = "UPDATE Inquilino SET Nome = ?, CPF = ?, Data_Nascimento = ?, Proprietario_bool = ? WHERE Id_Inquilino = ?";
        sql = sql.replaceFirst("\\?", "'" + i.getNome() + "'");
        sql = sql.replaceFirst("\\?", "'" + i.getCpf() + "'");
        sql = sql.replaceFirst("\\?", "'" + i.getDataNascimento() + "'");
        sql = sql.replaceFirst("\\?", String.valueOf(i.isProprietario()));
        sql = sql.replaceFirst("\\?", String.valueOf(i.getIdInquilino()));
        System.out.println(sql);
    }
 
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Inquilino WHERE Id_Inquilino = ?";
        sql = sql.replaceFirst("\\?", String.valueOf(id));
        System.out.println(sql);
    }
}
 