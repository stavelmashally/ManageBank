package application.model;

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

//    public void initDatabase(){
//        try {
//            Statement statement = getConnection().createStatement();
//
//            statement.execute("CREATE TABLE IF NOT EXISTS employees " +
//                    "(ID INT PRIMARY KEY     NOT NULL," +
//                    " fname          TEXT    NOT NULL, " +
//                    " lname          TEXT    NOT NULL, " +
//                    " email          TEXT    NOT NULL, " +
//                    " password       TEXT    NOT NULL, " +
//                    " role           TEXT    NOT NULL, " +
//                    " privileges     TEXT)");
//
//            statement.execute("INSERT INTO employees (ID,fname,lname,email,password,role,privileges) " +
//                    "VALUES (1234, 'stav', 'elmashally', 'stav@gmail.com', '123456', 'manager', 'A' );");
//            statement.close();
//            getConnection().close();
//        } catch (SQLException e){
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//        }
//    }
}
