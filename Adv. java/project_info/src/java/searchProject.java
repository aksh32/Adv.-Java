/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import pojos.ProjectInfo;

/**
 *
 * @author studentadmin
 */
public class searchProject extends HttpServlet {

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
            
            String Project_name = request.getParameter("pName");
            
            Configuration conf = new Configuration();
            conf.configure("hibernate.cfg.xml");
            SessionFactory sesFac = conf.buildSessionFactory();
            Session sess = sesFac.openSession();
            Criteria criteria = sess.createCriteria(ProjectInfo.class);
            criteria.add(Restrictions.eq("projectName", Project_name));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchProject</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Displaying Project Info</h1><hr width='500px'><br><br>");
                ProjectInfo pInfo = (ProjectInfo)criteria.uniqueResult();
                if(pInfo!=null){
                    out.println("<table border='1'>");
                    out.println("<tr align = 'center'><th>Project Id</th><th>Project Name</th><th>Client Name</th><th>Project Manager</th><th>Team Size</th></tr>");
                    out.println("<tr align = 'center'><td>"+ pInfo.getProjectId() +"</td><td>"+ pInfo.getProjectName() +"</td><td>"+ pInfo.getClientName() +"</td><td>"+ pInfo.getProjectManager() +"</td><td>"+ pInfo.getTeamSize() +"</td></tr>");
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
