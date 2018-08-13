/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author studentadmin
 */
public class OrderPlaced extends HttpServlet {

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
        HttpSession session = request.getSession();
            
            if((session.getAttribute("page").toString()).equals("customer")){
                Cookie cname = new Cookie("cname",request.getParameter("name"));
                Cookie cadd = new Cookie("cadd",request.getParameter("add"));
                response.addCookie(cname);
                response.addCookie(cadd);
                session.setAttribute("cname", request.getParameter("name"));
                session.setAttribute("cadd", request.getParameter("add"));
            }
        try (PrintWriter out = response.getWriter()) {
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderPlaced</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Thank You!</h1><h3> "+session.getAttribute("cname")+ "</h3><h1> Your Order Details are </h1>");
            out.println("<table border=1>");
            out.println("<tr>");
            out.println("<th>Adddress</th>");
            out.println("<th>Qty.</th>");
            out.println("<th>Price</th>");
            out.println("<th>Flavor</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>"+ session.getAttribute("cadd") +"</td>");
            out.println("<td>"+ session.getAttribute("qty") +"</td>");
            out.println("<td>"+ session.getAttribute("amt") +"</td>");
            out.println("<td>"+ session.getAttribute("flavor") +"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br>");
            out.println("<br>");
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
