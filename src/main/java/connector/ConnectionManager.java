package connector;
import java.sql.*;
public class ConnectionManager {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/COSMAS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection conn = null;
    
    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
