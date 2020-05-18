package infrastructure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DtbWrapper {

    public static ResultSet resultSet;
    static PreparedStatement prpstmt;

    public static void select(String sql) {
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            resultSet = prpstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println("select OK");
    }

    public static void update(String sql) {
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            int result = prpstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println("update OK, rows affected: " + resultSet);
    }

    public static void insert(String sql) {
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            int result = prpstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println("insert OK");
    }

    public static void delete(String sql) {
        try {
            prpstmt = DatabaseConnector.getConnection().prepareStatement(sql);
            int result = prpstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println("delete OK");
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    //TODO not finished, maybe not necessary
    public static void cleanup() {
        try {
            resultSet.close();
            prpstmt.close();
            DatabaseConnector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Method for software login according to position om employee
     *
     * @param UserID
     * @param password
     * @return
     * @throws SQLException
     */
    public static boolean checkLogin(int UserID, String password) throws SQLException {
        boolean result = false;
        select("select * from LogCred where EmployeeID=" + UserID);
        ResultSetMetaData meta = resultSet.getMetaData();
        String code;
        if(!resultSet.next()) {
            System.out.println("no data from select");
        } else {
                code = resultSet.getString("Code");
                System.out.println("Code: " + code);
                if (password == code) {
                    result = true;
                }
        }
        return result;
    }
}
