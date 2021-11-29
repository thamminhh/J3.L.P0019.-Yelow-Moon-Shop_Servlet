/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import minhtq.Cake.CakeDAO;
import minhtq.Cake.CakeDTO;
import minhtq.Cake.CakeError;
import minhtq.users.UsersDTO;

/**
 *
 * @author admin
 */
@WebServlet(name = "CreateNewCakeServlet", urlPatterns = {"/CreateNewCakeServlet"})
public class CreateNewCakeServlet extends HttpServlet {

    private final String CREATE_NEW_CAKE_DEFAULT_PAGE = "createNewCake.html";
    private final String CREATE_NEW_CAKE_PAGE = "createNewCake.jsp";

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateNewCakeServlet.class);

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String url = CREATE_NEW_CAKE_PAGE;
        String searchValue = request.getParameter("lastSearchValue");
        String option = request.getParameter("lastSearchOption");
        String priceFrom = request.getParameter("lastSearchPriceFrom");
        String priceTo = request.getParameter("lastSearchPriceTo");
        
        
        String cakeID = request.getParameter("txtCakeID");
        String cakeName = request.getParameter("txtCakeName");
        String image = request.getParameter("txtImage");
        String description = request.getParameter("txtDescription");
        String sprice = request.getParameter("txtPrice");
        double price = Double.parseDouble(sprice);
        String createDate = request.getParameter("txtCreateDate");
        String expirationDate = request.getParameter("txtExpirationDate");
        String category = request.getParameter("txtCategory");
        boolean status = true;
        String squantity = request.getParameter("txtQuantity");
        int quantity = Integer.parseInt(squantity);

        CakeError errors = new CakeError();

        HttpSession session = request.getSession();
        UsersDTO account = (UsersDTO) session.getAttribute("USER");
            
        try {
            /* TODO output your page here. You may use following sample code. */
            boolean error = false;
            if (cakeID.trim().length() < 4 || cakeID.trim().length() > 20) {
                error = true;
                errors.setCakeIDLengErr("Cake ID phai co kich thuoc 4 - 20 ki tu");
            }
            if (cakeName.trim().length() < 2 || cakeName.trim().length() > 30) {
                error = true;
                errors.setCakeNameLengErr("Cake Name phai co kich thuoc 2 - 30 ki tu");
            }
            if (image.trim().length() == 0) {
                error = true;
                errors.setImgErr("Img phai co duoi .png, .jpeg, .jpg, ...");
            }
            if (description.trim().length() == 0) {
                error = true;
                errors.setDescriptionLengErr("Description can't blank");
            }
            if (sprice.trim().length() == 0 || sprice.matches("^.*[A-Za-z].*$")) {
                error = true;
                errors.setPriceErr("Price must be number and can't be blank");
            }
            if (error) {
                request.setAttribute("CREATEERR", errors);
            } else {
                CakeDAO dao = new CakeDAO();
                CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity);
                boolean result = dao.insertCakeAdminRole(dto);
                if (result) {
                    url = "MainController?"
                        + "btAction=Search"
                        + "&txtSearch=" + searchValue
                        + "&searchOption=" + option
                        + "&txtPriceFrom=" + priceFrom
                        + "&txtPriceTo=" + priceTo;
                    LOGGER.info(account.getUserID() + " Create new Cake");
                }else{
                    url = CREATE_NEW_CAKE_PAGE;
                }
            }

        } catch (NamingException ex) {
            LOGGER.error(ex);
        } catch (SQLException ex) {
            LOGGER.error(ex);
            log("CreateNewCakeServlet_SQL " + ex.getMessage());

            errors.setCakeIDIsExist(cakeID + " da ton tai");
            request.setAttribute("CREATEERR", errors);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CreateNewCakeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CreateNewCakeServlet.class.getName()).log(Level.SEVERE, null, ex);
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

}
