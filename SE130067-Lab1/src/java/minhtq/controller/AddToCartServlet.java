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
import minhtq.users.UsersDTO;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    private final String SHOP_JSP = "yellowMoonShop.jsp";
    private final String ACCOUNT_PAGE = "search.jsp";

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(AddToCartServlet.class);

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

        String cakeID = request.getParameter("cakeID").trim();
        String cakeName = request.getParameter("cakeName").trim();
        String sprice = request.getParameter("price").trim();
        double price = Double.parseDouble(sprice);
        String squantity = request.getParameter("quantity").trim();
        int quantity = Integer.parseInt(squantity);

        String url = SHOP_JSP;

        String searchValue = request.getParameter("lastSearchValue");
        String option = request.getParameter("lastSearchOption");
        String priceFrom = request.getParameter("lastSearchPriceFrom");
        String priceTo = request.getParameter("lastSearchPriceTo");

        try {

            HttpSession session = request.getSession();
            UsersDTO account = (UsersDTO) session.getAttribute("USER");
            if (account != null) {
                CartObjectDTO cart = (CartObjectDTO) session.getAttribute("CART");
                if (cart == null) {
                    cart = new CartObjectDTO();
                }
                CakeDTO dto = new CakeDTO(cakeID, cakeName, price, quantity);
                cart.addFoodToCart(dto);
                session.setAttribute("CART", cart);
                if (searchValue.trim().length() > 0 || priceFrom.trim().length() > 0 && priceTo.trim().length() > 0) {
                    url = "MainController?"
                            + "btAction=Search"
                            + "&txtSearchValue=" + searchValue
                            + "&searchOption=" + option
                            + "&txtPriceFrom=" + priceFrom
                            + "&txtPriceTo=" + priceTo;
                    LOGGER.info(account.getUserID() + " Add to cart");
                }
            } else {
                CartObjectDTO cart = (CartObjectDTO) session.getAttribute("CART");
                if (cart == null) {
                    cart = new CartObjectDTO();
                }
                CakeDTO dto = new CakeDTO(cakeID, cakeName, price, quantity);
                cart.addFoodToCart(dto);
                session.setAttribute("CART", cart);
                if (searchValue.trim().length() > 0 || priceFrom.trim().length() > 0 && priceTo.trim().length() > 0) {
                    url = "MainController?"
                            + "btAction=Search"
                            + "&txtSearchValue=" + searchValue
                            + "&searchOption=" + option
                            + "&txtPriceFrom=" + priceFrom
                            + "&txtPriceTo=" + priceTo;
                    LOGGER.info("End-User Add to cart");
                }
            }

        } catch (Exception e) {
            LOGGER.error(e);
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
