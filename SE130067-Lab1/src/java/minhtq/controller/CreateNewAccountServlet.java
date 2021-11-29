/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhtq.users.UsersDAO;
import minhtq.users.UsersRegisterError;

/**
 *
 * @author admin
 */
@WebServlet(name = "CreateNewAccountServlet", urlPatterns = {"/CreateNewAccountServlet"})
public class CreateNewAccountServlet extends HttpServlet {

    private final String CREATE_NEW_ACCOUNT_JSP = "createNewAccount.jsp";
    private final String LOGIN_PAGE = "login.html";
    
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateNewAccountServlet.class);

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

        String url = CREATE_NEW_ACCOUNT_JSP;

        UsersRegisterError errors = new UsersRegisterError();

        String userID = request.getParameter("txtUserID");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        String email = request.getParameter("txtEmail");

        try {
            boolean error = false;
            if (userID.trim().length() < 4 || userID.trim().length() > 20) {
                error = true;
                errors.setUserIDLengErr("Username phai co kich thuoc tu 4 - 20 ky tu");
            }
            if (password.trim().length() < 8 || password.trim().length() > 30) {
                error = true;
                errors.setPasswordLengErr("Password phai co kich thuoc tu 8 - 30 ky tu");
            }
            if (!confirm.trim().equalsIgnoreCase(password.trim())) {
                error = true;
                errors.setConfirmNotMatch("Confirm password not match");
            }
            if (fullname.trim().length() < 8 || fullname.trim().length() > 30) {
                error = true;
                errors.setFullnameLengErr("Full Name phai co kich thuoc tu 8 - 30 ky tu");
            }
            if (email.trim().length() < 2 || email.trim().length() > 50) {
                error = true;
                errors.setEmailLengErr("Email phai co kich thuoc tu 2 - 50 ky tu");
            }
            if (error) {
                request.setAttribute("INSERTERR", errors);
            } else {
                UsersDAO userDAO = new UsersDAO();
                boolean result = userDAO.insertAccount(userID, password, fullname, email, false);
                System.out.println(result);
                if (result) {
                    url = LOGIN_PAGE;
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (NamingException ex) {
            LOGGER.error(ex);
        } catch (SQLException ex) {
            LOGGER.error(ex);
            log("CreateAccountServlet_SQL " + ex.getMessage());
            
            errors.setUserIDIsExist(userID + " da ton tai");
            request.setAttribute("INSERTERR", errors);

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
