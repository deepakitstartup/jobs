

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        Boolean loginStatus=DAO.fetchUserDetails(username,password);
 PrintWriter writer = response.getWriter();
 String htmlRespone ;
         if(loginStatus)
         {
        // build HTML code
        htmlRespone = "<html>";
        htmlRespone += "<h2>You are successfully logged in !!!</h2>";    
        htmlRespone += "</html>";        
         }
         else
         {
            
        	 htmlRespone = "<html>";
             htmlRespone += "<h2>Your user name or password is incorrect !!!</h2>";    
             htmlRespone += "</html>";
             
         }
      // return response
         writer.println(htmlRespone);
         
         
    }
 
    
    
}