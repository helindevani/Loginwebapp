
package com.mycompany.loginwebapplication;

import jakarta.jms.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out= res.getWriter();
        
        String username=req.getParameter("name");
        String password=req.getParameter("pass");
        String email=req.getParameter("email");
        
         String url="jdbc:mysql://localhost:3306/login_info";
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection) DriverManager.getConnection(url,"root","");
                if(con!=null)
                {
                    System.out.println("sucessfully connected");
                }
                String sql="insert into logininfo values(?,?,?)";
                PreparedStatement pst;
                pst=con.prepareStatement(sql);
       
                pst.setString(1,username);
                pst.setString(2,password);
                pst.setString(3,email);
                pst.executeUpdate();
                
                out.println("you have successfull created your account");  
            } 
        catch (ClassNotFoundException ex) 
        {
            //exception
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
