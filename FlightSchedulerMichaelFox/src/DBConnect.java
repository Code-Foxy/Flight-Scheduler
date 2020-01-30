
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private final static String username = "java";
    private final static String password = "java";
    private final static String url = "jdbc:derby://localhost:1527/FlightSchedulerDBMichaelFox";
    private static Connection con;
     
    public static Connection getConnection(){
        try{
        con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            
        }
        return con;
    }
}
