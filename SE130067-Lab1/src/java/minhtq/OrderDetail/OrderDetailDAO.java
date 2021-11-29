/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import minhtq.utils.DBHealper;

/**
 *
 * @author admin
 */
public class OrderDetailDAO {
    
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    private void closeDB() throws NamingException, SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
     public boolean insertOrderDetail(int orderID, String cakeID, int quantity) throws NamingException, SQLException {
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO OrderDetail (OrderID, cakeID, quantity) "
                        + "VALUES  (?,?,?) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, orderID);
                stm.setString(2, cakeID);
                stm.setInt(3, quantity);
                int row = stm.executeUpdate();
                if (row > 0) {
                   return true;
                    }
            }
        } finally {
            closeDB();
        }
        return false;
    }
}
