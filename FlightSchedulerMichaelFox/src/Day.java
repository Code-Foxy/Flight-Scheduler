
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Day {
    private ResultSet rs;
    private Connection con;
    
    public Day(Connection con){
        this.con = con;
    }
    
    public ResultSet getDates(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT DATE FROM DAY");
        }
        catch (Exception e){
            
        }
        return rs;
    }
}
