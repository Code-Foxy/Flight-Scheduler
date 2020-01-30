import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
    private ResultSet rs;
    private Connection con;
    
    public Customer(Connection con){
        this.con = con;
    }
    
    public ResultSet getCustomers(){
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT NAME FROM CUSTOMERS");
            }
        catch (Exception e){
            
        }
        return rs;
    }
    
    public void addCustomer(String name){
        try{
            String sql = "INSERT INTO CUSTOMERS (NAME) VALUES ('"+name+"')";
            Statement stmt = con.createStatement();
            stmt.execute(sql);
        }
        catch (Exception e){
            
        }     
    }
}
