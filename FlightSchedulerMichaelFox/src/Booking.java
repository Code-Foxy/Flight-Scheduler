
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class Booking {
    private ResultSet rs;
    private Connection con;
    private ResultSet output;
    
    public Booking(Connection con){
        this.con = con;
    }
    
    public void createNewBooking(String cust, String flight, Date day){
        try{
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            PreparedStatement createBooking = con.prepareStatement("insert into Bookings (Customer, Flight, Day, TimeStamp) values (?,?,?,?)");
            createBooking.setString(1, cust);
            createBooking.setString(2, flight);
            createBooking.setDate(3, day);
            createBooking.setTimestamp(4, currentTimestamp);
            createBooking.executeUpdate();
        }
        catch (Exception e){
            
        }
    }
    
    public ResultSet getCustomers(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT CUSTOMER FROM BOOKINGS");
        }
        catch(Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getFlight(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT FLIGHT FROM BOOKINGS");
        }
        catch (Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getDay(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT DAY FROM BOOKINGS");
        }
        catch (Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getTimeStamp(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT TIMESTAMP FROM BOOKINGS");
        }
        catch (Exception e){
            rs = null;
        }
        return rs;
    }
    
    public ResultSet getStatus(String flight, Date date){
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Bookings where flight = ? and day = ?");
            stmt.setString(1, flight);
            stmt.setDate(2, date);
            output = stmt.executeQuery();
        }
        catch (Exception e){
            output = null;
        }
        return output;
    }
}
