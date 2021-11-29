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
import javax.servlet.http.HttpSession;
import minhtq.Cake.CakeDTO;
import minhtq.cart.CartObjectDTO;

/**
 *
 * @author admin
 */
@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/UpdateCartServlet"})
public class UpdateCartServlet extends HttpServlet {

    private final String VIEW_CART_PAGE = "viewcart.jsp";
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(UpdateCartServlet.class);

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

        String squantity = request.getParameter("txtQuantity");
        int quantity = Integer.parseInt(squantity);
        String cakeID = request.getParameter("txtCakeID").trim();
        
        System.out.println(quantity + cakeID);

        String url = VIEW_CART_PAGE;
        try {
            HttpSession session = request.getSession();
            if(session != null){
                CartObjectDTO cartdto = (CartObjectDTO) session.getAttribute("CART");
                if(cartdto != null){
                    CakeDTO cakedto = new CakeDTO();
                    for (CakeDTO cake : cartdto.getItems().values()) {
                        if(cake.getCakeID().equalsIgnoreCase(cakeID)){
                            cakedto = new CakeDTO(cakeID, cake.getCakeName(), cake.getPrice(), quantity);
                        }
                    }
                    cartdto.updateCart(cakedto);
                    session.setAttribute("CART", cartdto);
                    LOGGER.info("User Update cart");
                }
            }
        } catch(Exception e){
            LOGGER.error(e);
        }
        finally {
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
