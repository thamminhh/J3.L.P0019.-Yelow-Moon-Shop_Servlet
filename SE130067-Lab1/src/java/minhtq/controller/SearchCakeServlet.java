/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
import minhtq.users.UsersDTO;

/**
 *
 * @author admin
 */
@WebServlet(name = "SearchCakeServlet", urlPatterns = {"/SearchCakeServlet"})
public class SearchCakeServlet extends HttpServlet {

    private final String SHOP_JSP = "yellowMoonShop.jsp";
    private final String ACCOUNT_PAGE = "search.jsp";
    private final String ADMIN_PAGE = "adminpage.jsp";

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(SearchCakeServlet.class);

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

        String url = SHOP_JSP;

        String searchValue = request.getParameter("txtSearchValue");
        String searchOption = request.getParameter("searchOption");
        String txtpriceFrom = request.getParameter("txtPriceFrom");
        String txtpriceTo = request.getParameter("txtPriceTo");

        try {
            HttpSession session = request.getSession();
            UsersDTO account = (UsersDTO) session.getAttribute("USER");

            if (account == null) {
                url = SHOP_JSP;
                if (searchValue.trim().length() == 0) {
                    CakeDAO dao = new CakeDAO();
                    dao.getAllCakeSortByDate();
                    List<CakeDTO> result = dao.getListCake();
                    request.setAttribute("RESULT", result);

                }
                if ((searchValue.trim().length() > 0) || (txtpriceFrom.trim().length() > 0 && txtpriceTo.trim().length() > 0)) {
                    if (searchOption.equalsIgnoreCase("Product Name")) {
                        CakeDAO dao = new CakeDAO();
                        dao.getListCakeName(searchValue);
                        List<CakeDTO> result = dao.getListCake();
                        request.setAttribute("RESULT", result);
                        LOGGER.info("End-User search Cake by Name");
                    }
                    if (searchOption.equalsIgnoreCase("Price")) {
                        double priceFrom = Double.parseDouble(txtpriceFrom);
                        double priceTo = Double.parseDouble(txtpriceTo);
                        CakeDAO dao = new CakeDAO();
                        dao.getListCakeByPrice(priceFrom, priceTo);
                        List<CakeDTO> result = dao.getListCake();
                        request.setAttribute("RESULT", result);
                        LOGGER.info("End-User search Cake by Price");
                    }
                    if (searchOption.equalsIgnoreCase("Category")) {
                        CakeDAO dao = new CakeDAO();
                        dao.getListCakeByCategory(searchValue);
                        List<CakeDTO> result = dao.getListCake();
                        request.setAttribute("RESULT", result);
                        LOGGER.info("End-User search Cake by Category");
                    }
                }

            } else {
                if (account.getIsAdmin() == true) {
                    url = ADMIN_PAGE;
                    if (searchValue.trim().length() == 0) {
                        CakeDAO dao = new CakeDAO();
                        dao.getListCakeAdminRole();
                        List<CakeDTO> result = dao.getListCake();
                        request.setAttribute("RESULT", result);
                    }
                    if ((searchValue.trim().length() > 0) || (txtpriceFrom.trim().length() > 0 && txtpriceTo.trim().length() > 0)) {
                        if (searchOption.equalsIgnoreCase("Search By Name")) {
                            CakeDAO dao = new CakeDAO();
                            dao.getListCakeNameAdminRole(searchValue);
                            List<CakeDTO> result = dao.getListCake();
                            request.setAttribute("RESULT", result);
                            LOGGER.info(account.getUserID() + " search Cake by Name");
                        }
                        if (searchOption.equalsIgnoreCase("Search by Price")) {
                            double priceFrom = Double.parseDouble(txtpriceFrom);
                            double priceTo = Double.parseDouble(txtpriceTo);
                            CakeDAO dao = new CakeDAO();
                            dao.getListCakeByPriceAdminRole(priceFrom, priceTo);
                            List<CakeDTO> result = dao.getListCake();
                            request.setAttribute("RESULT", result);
                            LOGGER.info(account.getUserID() + " search Cake by Price");
                        }
                        if (searchOption.equalsIgnoreCase("Category")) {
                            CakeDAO dao = new CakeDAO();
                            dao.getListCakeByCategoryAdminRole(searchValue);
                            List<CakeDTO> result = dao.getListCake();
                            request.setAttribute("RESULT", result);
                            LOGGER.info(account.getUserID() + " search Cake by Category");
                        }
                    }
                } else {
                    url = ACCOUNT_PAGE;
                    if (searchValue.trim().length() == 0) {
                        CakeDAO dao = new CakeDAO();
                        dao.getAllCakeSortByDate();
                        List<CakeDTO> result = dao.getListCake();
                        request.setAttribute("RESULT", result);

                    }
                    if ((searchValue.trim().length() > 0) || (txtpriceFrom.trim().length() > 0 && txtpriceTo.trim().length() > 0)) {
                        if (searchOption.equalsIgnoreCase("Product Name")) {
                            CakeDAO dao = new CakeDAO();
                            dao.getListCakeName(searchValue);
                            List<CakeDTO> result = dao.getListCake();
                            request.setAttribute("RESULT", result);
                            LOGGER.info(account.getUserID() + " search Cake by Name");
                        }
                        if (searchOption.equalsIgnoreCase("Price")) {
                            double priceFrom = Double.parseDouble(txtpriceFrom);
                            double priceTo = Double.parseDouble(txtpriceTo);
                            CakeDAO dao = new CakeDAO();
                            dao.getListCakeByPrice(priceFrom, priceTo);
                            List<CakeDTO> result = dao.getListCake();
                            request.setAttribute("RESULT", result);
                            LOGGER.info(account.getUserID() + " search Cake by Price");
                        }
                        if (searchOption.equalsIgnoreCase("Category")) {
                            CakeDAO dao = new CakeDAO();
                            dao.getListCakeByCategory(searchValue);
                            List<CakeDTO> result = dao.getListCake();
                            request.setAttribute("RESULT", result);
                            LOGGER.info(account.getUserID() + " search Cake by Category");
                        }
                    }

                }
            }

        } catch (NamingException ex) {
            LOGGER.error(ex);
        } catch (SQLException ex) {
            LOGGER.error(ex);
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
