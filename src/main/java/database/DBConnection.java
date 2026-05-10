package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String PASSWORD = "17072008";
    private static final String USER = "postgres";
    private static DBConnection instance = null;
    private Connection connection;

    private DBConnection() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", USER, PASSWORD);
        } 
        catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar", e);            
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

}
