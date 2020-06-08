package application.util;

import java.sql.*;

public class DatabaseManager {

    //public static final String DB_URL = "jdbc:sqlite:bank.db";
    public static final String DB_TEST_URL = "jdbc:sqlite:test.db";

    private static DatabaseManager instance;
    private Connection connection;

    public static DatabaseManager getInstance() {
        if (instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }

    private DatabaseManager(){}

    private Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_TEST_URL);
                System.out.println("Connected Successfully to DB");
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return connection;
    }


    public ResultSet executeQuery(String sql){
        try {
            return this.getConnection().createStatement().executeQuery(sql);
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
    }

    public boolean executeInsert(String sql){
        try {
            PreparedStatement stmtInsert = getConnection().prepareStatement(sql);
            stmtInsert.executeUpdate();
            return true;
        } catch (SQLException e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return false;
        }
    }

    public boolean executeUpdate(String sql){
        try {
            getConnection().createStatement().executeUpdate(sql);
            return true;
        } catch (SQLException e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return false;
        }
    }


}
