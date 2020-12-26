

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

public class DAO{


	protected static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException 
	    { 
	        // Initialize all the information regarding 
	        // Database Connection 
	        String dbDriver = "com.mysql.jdbc.Driver"; 
	        String dbURL = "jdbc:mysql:// localhost:3306/"; 
	        // Database name to access 
	        String dbName = "demoprj"; 
	        String dbUsername = "root"; 
	        String dbPassword = "root"; 
	  
	        Class.forName(dbDriver); 
	        Connection con = DriverManager.getConnection(dbURL + dbName, 
	                                                     dbUsername,  
	                                                     dbPassword); 
	        return con; 
	    } 
	
	
public static boolean fetchUserDetails(String name, String password) {
        
        try {
            
        if(name=="Admin" && password=="password") {
        	
        	return true;
                }
                else
        {
        	return false;
        }
        } catch (Exception e) {
            System.out.println(e);
            
        } finally {
             }
        return false;
    }

public static void insertJobPosting(List<String> dataEntered) {
  
	try{
		Connection con = initializeDatabase(); 
  
            PreparedStatement st = con 
                   .prepareStatement("insert into jobs_table values(?, ?,?,?,?,?,?)"); 
  
            for(int i=0; i<dataEntered.size();i++)
            {
            st.setString(i, dataEntered.get(i)); 
            }
  
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close(); 
  
                    } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
          
    
public static ResultSet fetchJobPosting() {
	ResultSet rs = null;
	  
	try{
		Connection con = initializeDatabase(); 
  
            Statement st = con.createStatement();
       		 rs = st.executeQuery("select description,technology, pSkills, "
                           		+ "sSkills,location,openPositions,"
                           		+ "rAmount from jobs_table");
            
            // Close all the connections 
            st.close(); 
             
  
                    } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	return rs;
    } 
          


}