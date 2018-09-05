/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author studentadmin
 */
public class ViewTT extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String day=request.getParameter("day");  
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable?useSSL =FALSE","root","root");  
                Statement stmt=con.createStatement(); 
                ResultSet rs=stmt.executeQuery("select subjects.Course from subjects left join timetable on subjects.Subject_id = timetable.Sub_id where Day ='"+ day +"' order by timetable.Slot_id");          
                Statement stmt1=con.createStatement();                
                ResultSet rs1=stmt1.executeQuery("SELECT Time from slots");
                out.println("<center>");
                out.println("<h2>Here is Your TimeTable</h2>");
                out.println("<br>");
                out.println("<br>");
                out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=50%>");                 
                out.println("<tr><th>Time</th><th>Subject</th></tr>");           
                while(rs.next() &&  rs1.next()){
                    out.println("<tr>");
                    out.println("<td><center>"+rs1.getString(1)+"</center></td>");
                    out.print("<td><center>"+rs.getString(1)+"</center></td>");
                    out.println("<tr>");            
                }           
                out.println("</table>");                      
                out.println("</center>");
            }catch(Exception e){
                out.println(""+e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
