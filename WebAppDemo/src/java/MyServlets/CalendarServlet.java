/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlets;

import com.zyl.bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zz
 */
@WebServlet(name = "CalendarServlet", urlPatterns = {"/CalendarServlet"})
public class CalendarServlet extends HttpServlet {
    private static final long serialVersionUID = -1915463532411657451L;
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalendarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalendarServlet at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        Map<String,String> data = getData();
        response.setContentType("text/html;charset= UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("userpwd");
        
        try (PrintWriter out = response.getWriter()) {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CalendarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Hello " + data.get("username") + ", " + data.get("message") + "</h2>");
            out.println("<h2>The time right now is : " + new Date() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.0
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("userpwd");
        User currentUser = User.login(username, password);
        if (currentUser != null) {
            response.sendRedirect("HomePage.jsp");
        }else{
            request.getRequestDispatcher("/Login.jsp").include(request, response);
        }
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
    
    private Map<String,String> getData(){
        Map<String,String> data = new HashMap<>();
        data.put("username", "Guest");
        data.put("message", "Welcome to my world!");
        return  data;
    }

}
