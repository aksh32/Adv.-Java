/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author studentadmin
 */
public class transfer extends HttpServlet {

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
        
        try{
            int from_acc = Integer.parseInt(request.getParameter("from_acc"));
            int to_acc = Integer.parseInt(request.getParameter("to_acc"));
            String msg = null;
            double amt = Double.parseDouble("amt");
            
            Date d = new Date();
            java.sql.Date sqlDate = new java.sql.Date(d.getTime());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db?useSSL=FALSE","root","root");
            Statement st = conn.createStatement();
            Statement st1 = conn.createStatement();
            ResultSet rs = st.executeQuery("select balance from account WHERE acc_no = "+ from_acc);
            ResultSet rs1 = st1.executeQuery("select balance from account WHERE acc_no ="+ to_acc);
            
            if(rs.next() && rs1.next()){
                Double bal = rs.getDouble("balance");
                Double bal1 = rs1.getDouble("balance");
                
                if(bal>amt && bal>0){
                    double updateBal = bal-amt;
                    double addBal1 = bal1+amt;
                    
                    Statement st2 = conn.createStatement();
                    int res = st2.executeUpdate("insert into transaction(from_acc,to_acc,amount,date) VALUES("+ from_acc+","+ to_acc +","+ amt +",'"+ sqlDate +"')");
                    
                    if(res==1){
                        int res1 = st2.executeUpdate("update account set balance ="+updateBal+"Where acc_no = "+from_acc);
                        int res2 = st2.executeUpdate("update account set balance ="+addBal1+"WHERE acc_no = "+to_acc);
                        
                        if(res1==1 && res2==1){
                            msg = "Congratulations! Transaction Successfull";
                        }
                        else{
                            msg = "Sorry! Transaction Unsuccessfull";
                        }
                    }
                }
            } 
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet transfer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+msg+"</h1>");
             out.println("<h1>"+from_acc+"</h1>");
              out.println("<h1>"+to_acc+"</h1>");
              out.println("<h1>"+amt+"</h1>");
                out.println("<h1>"+sqlDate+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }catch(Exception ee){
            System.out.println(ee);
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
