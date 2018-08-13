/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
public class OrderProcessing extends HttpServlet {

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
            String flv = request.getParameter("flavor");
            int size = Integer.parseInt(request.getParameter("size"));
            int qty = Integer.parseInt(request.getParameter("qty"));
            int price = 0;
            
            switch(flv){
                case "Vanilla":
                    price+=30;
                    break;
                case "Strawberry":
                    price+=40;
                    break;
                case "Kiwi":
                    price+=40;
                    break;
                case "Mango":
                    price+=50;
                    break;
                case "Chocolate":
                    price+=50;
                    break;
            }
            
            switch(size){
                case 1:
                    price+=100;
                    break;
                case 2:
                    price+=150;
                    break;
                case 3:
                    price+=200;
                    break;
                case 4:
                    price+=250;
                    break;
            }
            
            int amt = price * qty;
            HttpSession session = request.getSession();
            session.setAttribute("amt", amt);
            session.setAttribute("flavor", flv);
            session.setAttribute("qty", qty);
            
            String name = new String();
            String add = new String();
            String empty = new String();
            Cookie ck[] = request.getCookies();
            
            if(ck!=null){
<<<<<<< HEAD
                for(Cookie ck1:ck){
                    String cookieName = null;
=======
                String cookieName = null;
                for(Cookie ck1:ck){
>>>>>>> 13cc87430928da53f44ee6ab92282c0797efed80
                    cookieName = ck1.getName();
                    if(cookieName.equals("cname")){
                        name = ck1.getValue();
                        session.setAttribute("cname", name);
                    }
                    if(cookieName.equals("cadd")){
                        add = ck1.getValue();
                        session.setAttribute("cadd", add);
                    }
                }
            }
            
            if(name.equals(empty)){
                session.setAttribute("page", "customer");
                RequestDispatcher rd = request.getRequestDispatcher("/CustomerDetails.html");
                rd.forward(request, response);
            }
            else{
                session.setAttribute("page", "order");
                RequestDispatcher rd = request.getRequestDispatcher("OrderPlaced");
                rd.forward(request, response);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderProcessing</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderProcessing at " + request.getContextPath() + "</h1>");
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
