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
import minhtq.Cake.CakeDTO;
import minhtq.Order.OrderDAO;
import minhtq.Order.OrderDTO;
import minhtq.OrderDetail.OrderDetailDAO;
import minhtq.cart.CartObjectDTO;

/**
 *
 * @author admin
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {
    private final String ORDER_SUSESS_PAGE = "susess.html";
    private final String FAIL_PAGE = "orderfail.html";

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
        
        
        String phonenumber = request.getParameter("txtPhoneNumber");
        String name = request.getParameter("txtName");
        String address = request.getParameter("txtAddress");
        
        String url = FAIL_PAGE;
        
        
        try  {
            HttpSession session = request.getSession();
            CartObjectDTO cartdto = (CartObjectDTO) session.getAttribute("CART");
            
            OrderDAO orderdao = new OrderDAO();
            OrderDetailDAO orderdetaildao = new OrderDetailDAO();
            int orderID = orderdao.insertOrder(phonenumber, name, address);
            if(orderID > 0){
                for(CakeDTO item : cartdto.getItems().values()){
                    boolean result = orderdetaildao.insertOrderDetail(orderID, item.getCakeID(), item.getQuantity());
                    if(result){
                        url = ORDER_SUSESS_PAGE; 
                    }
                }
            }
            
        } catch (NamingException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
