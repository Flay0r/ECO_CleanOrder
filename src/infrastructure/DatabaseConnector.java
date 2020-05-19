package infrastructure;

import application.Launch;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {

    static Connection con;
    static ResultSet rs;
    static ResultSetMetaData rsmd;
    static PreparedStatement prpstmt;

    public static void createConnection() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ECO_CleanOrder", "sa", "123456");
            System.out.println("Connected");
        } catch (SQLException e) {
            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, (String) null, e);
            System.out.println("failed creating connection");
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static ResultSet getResultSet(){
        return rs;
    }

    public static void manualDisconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
}
