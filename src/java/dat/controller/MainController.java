package dat.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class MainController extends HttpServlet {

    private final String loginPage = "login.html";
    private final String searchServlet = "SearchController";
    private final String loginServlet = "LoginController";
    private final String deleteServlet = "DeleteController";
    private final String updateServlet = "UpdateController";
    private final String nullController = "NullController";
    private final String additemtoController = "AddItemController";
    private final String viewCartPage = "viewCart.jsp";
    private final String removeitems = "RemoveItemController";
    private final String createAccount = "CreateAccountController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "";
        String button = request.getParameter("btAction");
        if (button == null) {
            url = nullController;
        } else if (button.equals("Login")) {
            url = loginServlet;
        } else if (button.equals("Search")) {
            url = searchServlet;
        } else if (button.equals("Del")) {
            url = deleteServlet;
        } else if (button.equals("Update")) {
            url = updateServlet;
        } else if (button.equals("Add To Cart")) {
            url = additemtoController;
        } else if (button.equals("View Cart")) {
            url = viewCartPage;
        } else if (button.equals("Remove From Cart")){
            url = removeitems;
        } else if (button.equals("CreateNewAccount")){
            url = createAccount;
        } else if (button.equals("Login Page")){
            url = loginPage;
        }
                

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        out.close();

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
