package infrastructure;

import application.Launch;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The JDBC Database connector.
 */
public class DatabaseConnector {

    /**
     * The Con.
     */
    static Connection con;
    /**
     * The Rs.
     */
    static ResultSet rs;
    /**
     * The Rsmd.
     */
    static ResultSetMetaData rsmd;
    /**
     * The Prpstmt.
     */
    static PreparedStatement prpstmt;

    /**
     * Create connection.
     */
    public static void createConnection() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ECO_CleanOrder", "sa", "123456");
            System.out.println("Connected");
        } catch (SQLException e) {
            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, (String) null, e);
            System.out.println("failed creating connection");
        }
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        return con;
    }

    /**
     * Get result set result set.
     *
     * @return the result set
     */
    public static ResultSet getResultSet(){
        return rs;
    }

    /**
     * Manual disconnect.
     */
    public static void manualDisconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Query.
     *
     * @param sql the sql
     */
    public static void query(String sql) {
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            System.out.println("preparing statement: OK");
            rs = prpstmt.executeQuery();
            System.out.println("executing statement: OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("query didnt work");
        }
        System.out.println("SELECT: OK");
    }

    /**
     * Update.
     *
     * @param sql the sql
     */
    public static void update(String sql){
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            System.out.println("preparing statement: OK");
            int u = prpstmt.executeUpdate();
            System.out.println("executing statement: OK");
            System.out.println(u + " rows have been affected by update command");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("update didnt work");
        }
    }

    /**
     * Insert.
     *
     * @param sql the sql
     */
    public static void insert(String sql){
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            System.out.println("preparing statement: OK");
            boolean ok = prpstmt.execute();
        } catch ( SQLException e){
            e.printStackTrace();
            System.out.println("insert didnt work, and sql error");
        }
    }

    /**
     * Delete.
     *
     * @param sql the sql
     */
    public static void delete(String sql){
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            System.out.println("preparing statement: OK");
            int ok = prpstmt.executeUpdate();
            System.out.println("executing statement: OK");
        } catch ( SQLException e){
            e.printStackTrace();
            System.out.println("delete didnt work, and sql error");
        }
    }
}

