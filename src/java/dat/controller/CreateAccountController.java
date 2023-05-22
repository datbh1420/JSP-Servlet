/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.controller;

import dat.registration.InsertRegistrationError;
import dat.registration.RegistrationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class CreateAccountController extends HttpServlet {
    private static String createPage = "createNewAccount.html";
    private static String createPageAgain = "createNewAccount.jsp";
    private static String loginPage = "login.html";
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = createPage;
        boolean Error = false;
        InsertRegistrationError ire = new InsertRegistrationError();
        try (PrintWriter out = response.getWriter()) {
            try {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String confirm = request.getParameter("txtConfirm");
                String fullname = request.getParameter("txtFullname");
                
                if (username.trim().length() < 2 || username.trim().length() > 15) {
                    Error = true;
                    ire.setUsernameLengthErr("username is required 2-15 chars");
                }
                if (password.trim().length() < 6 || password.trim().length() > 20) {
                    Error = true;
                    ire.setPasswordLengthErr("password is required 6-20 chars");
                } 
                if(!password.trim().equals(confirm.trim())){
                    Error = true;
                    ire.setConfirmNotMath("Confirm password not matched");
                }
                if (fullname.trim().length() < 6 || fullname.trim().length() > 40) {
                    Error = true;
                    ire.setFullnameLengthErr("fullname is required 6-40 chars");
                }
                if(Error){
                    request.setAttribute("INSERTERROR", ire);
                    url = createPageAgain;
                }else{
                    RegistrationDAO dao = new RegistrationDAO();
                    boolean result = dao.insert(username, password, fullname, false);
                    if (result) {
                        url = loginPage;
                    }
                }
            } catch (SQLException ex) {
                request.setAttribute("INSERTERROR", ire);
                Error=true;
                ire.setUsernameIsExistErr("username is exist!");
                ex.printStackTrace();
            } finally {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
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
