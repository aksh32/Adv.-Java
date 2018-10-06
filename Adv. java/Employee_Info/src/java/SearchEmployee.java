/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojos.Employees;

/**
 *
 * @author studentadmin
 */
public class SearchEmployee extends HttpServlet {

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
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            
            Configuration conf = new Configuration();
            conf.configure("hibernate.cfg.xml");
            SessionFactory sf = conf.buildSessionFactory();
            Session ses = sf.openSession();
            
            if(request.getParameter("asc") == null){
                
                String hql = "FROM Employees E WHERE E.address.cityName = '"+ request.getParameter("cName")+"'";
                Query query = ses.createQuery(hql);
                List <Employees> results = query.list();
                out.println("<h3>These Are The Employees From </h3><h1>" + request.getParameter("cName") + "</h1> <hr width='500px'> <br> <br>");
                out.println("<table border='1'>");
                out.println("<tr>"
                            + "<tr>"
                            + "<th>First Name</th>"
                            + "<th>Last Name</th>"
                            + "<th>Address</th>"
                            + "</tr>"
                            + "</tr");
                for(Employees E:results){
                    out.println("<tr>"
                            + "<tr>"
                            + "<td>"+ E.getFName()+"</td>"
                            + "<td>"+ E.getLName()+"</td>"
                            + "<td>"+ E.getAddress().getStreetName()+" , "+ E.getAddress().getCityName()+" , " +E.getAddress().getStateName()+"</td>"
                            + "</tr>"
                            + "</tr");
                }
                out.println("</table>");
            }
            else{
                String hql1 = "From Employees E WHERE E.address.cityName = '"+ request.getParameter("cName") +"' ORDER BY E.LName ASC";
                Query query1 = ses.createQuery(hql1);
                List <Employees> results1 = query1.list();
                
                out.println("<h3>These Are The Employees From </h3><h1>" + request.getParameter("cName") + "</h1> <hr width='500px'> <br> <br>");
                out.println("<table border='1'>");
                out.println("<tr>"
                            + "<tr>"
                            + "<th>First Name</th>"
                            + "<th>Last Name</th>"
                            + "<th>Address</th>"
                            + "</tr>"
                            + "</tr");
                for(Employees E:results1){
                    out.println("<tr>"
                            + "<tr>"
                            + "<td>"+ E.getFName()+"</td>"
                            + "<td>"+ E.getLName()+"</td>"
                            + "<td>"+ E.getAddress().getStreetName()+" , "+ E.getAddress().getCityName()+" , " +E.getAddress().getStateName()+"</td>"
                            + "</tr>"
                            + "</tr");
                }
                out.println("</table>");
            }
            
            
            
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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
