
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class Waitlist {
    private ResultSet rs;
    private Connection con;
    private ResultSet output;
    
    public Waitlist(Connection con){
        this.con = con;
    }
    
    public void createNewWaitlist(String cust, String flight, Date day){
        try{
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            PreparedStatement createWaitlist = con.prepareStatement("insert into Waitlist (Customer, Flight, Day, TimeStamp) values (?,?,?,?)");
            createWaitlist.setString(1, cust);
            createWaitlist.setString(2, flight);
            createWaitlist.setDate(3, day);
            createWaitlist.setTimestamp(4, currentTimestamp);
            createWaitlist.executeUpdate();
        }
        catch (Exception e){
            
        }
    }
    
        public ResultSet getCustomers(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT CUSTOMER FROM WAITLIST");
        }
        catch(Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getFlight(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT FLIGHT FROM WAITLIST");
        }
        catch (Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getDay(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT DAY FROM WAITLIST");
        }
        catch (Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getTimeStamp(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT TIMESTAMP FROM WAITLIST");
        }
        catch (Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getStatus(String flight, Date date){
        try{
            if (flight == ""){
                PreparedStatement stmt = con.prepareStatement("select * from waitlist where day = ?");
                stmt.setDate(1, date);
                output = stmt.executeQuery();
            }
            else{
                PreparedStatement stmt = con.prepareStatement("select * from waitlist where flight = ? and day = ?");
                stmt.setString(1, flight);
                stmt.setDate(2, date);
                output = stmt.executeQuery();
            }
        }
        catch (Exception e){
            output = null;
        }
        return output;
    }
}
