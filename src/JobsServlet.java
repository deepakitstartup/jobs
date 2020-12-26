

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

 
@WebServlet("/JobsServlet")
public class JobsServlet extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {  
       PrintWriter out = res.getWriter();  
       res.setContentType("text/html");  
       out.println("<html><body>");  
       try 
       {  
    	   ResultSet rs = DAO.fetchJobPosting();  
           out.println("<table border=1 width=50% height=50%>");  
           out.println("<tr><th>Job Description </th><th>Technology</th><th>Primary Skill</th>"
           		+"<th>Secondary Skill</th><th>Location</th><th>Open Positions</th><th>Referral Amount</th>"
        		 +  "<tr>");  
           while (rs.next()) 
           {  
               String description = rs.getString("description");  
               String technology = rs.getString("technology");  
               String primarySkills = rs.getString("pSkills");  
               String secondarySKills = rs.getString("sSkills");  
               String location = rs.getString("location");  
               String openPositions = rs.getString("openPositions");  
               String referralAmount = rs.getString("rAmount");  
               out.println("<tr>"
               		+ "<td>" + description + "</td><td>" + technology + "</td><td>" + primarySkills + "</td>"
               		+ "<td>" + secondarySKills + "</td><td>" + location + "</td><td>" + openPositions + "</td>"
               		+"<td>" + referralAmount + "</td>"
               				+ "</tr>");   
           }  
           out.println("</table>");  
           out.println("</html></body>");  
            
          }  
           catch (Exception e) 
          {  
           out.println("error");  
       }  
   }  

 
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        
    	List<String> inputList= new ArrayList<String>();
    	inputList.add( request.getParameter("description"));
    	inputList.add( request.getParameter("technology"));
    	inputList.add( request.getParameter("pSkills"));
    	inputList.add( request.getParameter("sSkills"));
    	inputList.add( request.getParameter("location"));
    	inputList.add( request.getParameter("openPositions"));
    	inputList.add( request.getParameter("rAmount"));
    	
    	DAO.insertJobPosting(inputList);
    	PrintWriter out = response.getWriter(); 
        out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>"); 

}
    
}