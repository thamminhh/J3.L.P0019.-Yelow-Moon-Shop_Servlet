/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";
    private final String PROCESS_REQUEST_CONTROLLER = "ProcessRequestServlet";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String LOGOUT_SERVLET = "LogOutServlet";
    private final String CREATE_NEW_ACCOUNT_SERVLET = "CreateNewAccountServlet";
    private final String SEARCH_CAKE_SERVLET = "SearchCakeServlet";
    private final String CREATE_NEW_CAKE_SERVLET = "CreateNewCakeServlet";
    private final String GET_BY_CAKEID_SERVLET = "GetByCakeIDServlet";
    private final String UPDATE_CAKE_SERVLET = "UpdateCakeServlet";
    private final String ADD_TO_CART_SERVLET = "AddToCartServlet";
    private final String ORDER_SERVLET = "OrderServlet";
    private final String UPDATE_CART_SERVLET = "UpdateCartServlet";
    private final String DELETE_CART_SERVLET = "DeleteCartServlet";

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
        
        String url = LOGIN_PAGE;
        try {
            String button = request.getParameter("btAction");

            if (button == null) {
                url = PROCESS_REQUEST_CONTROLLER;
            } else if (button.equalsIgnoreCase("Login")) {
                url = LOGIN_SERVLET;
            } else if (button.equalsIgnoreCase("Log Out")) {
                url = LOGOUT_SERVLET;
            } else if (button.equalsIgnoreCase("Create New Account")) {
                url = CREATE_NEW_ACCOUNT_SERVLET;
            } else if (button.equalsIgnoreCase("Search")) {
                url = SEARCH_CAKE_SERVLET;
            } else if (button.equalsIgnoreCase("Yellow Moon Shop")) {
                url = SEARCH_CAKE_SERVLET;
            } else if (button.equalsIgnoreCase("Create")) {
                url = CREATE_NEW_CAKE_SERVLET;
            } else if (button.equalsIgnoreCase("Update")) {
                url = GET_BY_CAKEID_SERVLET;
            } else if (button.equalsIgnoreCase("Update Cake")) {
                url = UPDATE_CAKE_SERVLET;
            }else if( button.equalsIgnoreCase("Add To Cart")){
                url = ADD_TO_CART_SERVLET;
            }else if (button.equalsIgnoreCase("Order")){
                url = ORDER_SERVLET;
            }else if (button.equalsIgnoreCase("Update Quantity")){
                url = UPDATE_CART_SERVLET;
            }else if ( button.equalsIgnoreCase("Remove Items")){
                url = DELETE_CART_SERVLET;
            }else if (button.equalsIgnoreCase("Cancel")){
                url = SEARCH_CAKE_SERVLET;
            }
                   
        } finally {
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
