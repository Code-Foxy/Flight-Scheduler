import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Flight {
    private ResultSet rs;
    private String name;
    private int seats;
    private Connection con;
    
    public Flight(Connection con){
        this.con = con;
    }
    
    public ResultSet getFlights(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT NAME FROM FLIGHT");
        }
        catch (Exception e){
            
        }
        return rs;
    }
    
}
