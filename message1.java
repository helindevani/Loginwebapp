/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author Helin Devani
 */
public class message1 extends HttpServlet {

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
                String sql="select * from logininfo";
                Statement stmt;
                stmt=con.createStatement();
                Resultset rs;
                rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    String user=rs.getString(1);
                    String pass=rs.getString(2);
                    String email=rs.getString(3);
                }  
            } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        String user1=req.getParameter("name1");
        String pass2=req.getParameter("pass1");
        
        if(user1=user && pass2==pass)
        {
            System.out.println("your username is"+user1+ "email id is" +email);
        }
        else
        {
             System.out.println("your data is not there you must be first register you");
        }
    }
}
