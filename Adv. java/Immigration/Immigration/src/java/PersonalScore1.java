/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author studentadmin
 */
public class PersonalScore1 extends HttpServlet {

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
            int points = 0;
        String fname = request.getParameter("fname");
        String lname= request.getParameter("lname");
        String name = fname+" "+lname;
        int agegrp = Integer.parseInt(request.getParameter("agegrp"));
        String maritalstat = request.getParameter("maritstat");
        int noc = Integer.parseInt(request.getParameter("NoOfChild"));
        
        switch(agegrp){
            case 1:
                points+=15;
                break;
            case 2:
                points+=10;
                break;
            case 3:
                points+=5;
                break;
            case 4:
                points+=3;
                break;
        }
        
        switch(maritalstat){
            case "married":
                points+=5;
                break;
            case "unmarried":
                points+=3;
                break;
        }
        
        switch(noc){
            case 1:
                points+=10;
                break;
            case 2:
                points+=5;
                break;
            case 3:
                points+=2;
                break;
        }
        
        HttpSession ses = request.getSession();
        ses.setAttribute("Points", points);
        ses.setAttribute("name", name);
        ses.setAttribute("page", "PersonalScore1");
        
        if(points>=20){
            RequestDispatcher rd = request.getRequestDispatcher("/education.html");
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("invalidScore");
            rd.forward(request, response);
        }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonalScore1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersonalScore1 at " + request.getContextPath() + "</h1>");
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
