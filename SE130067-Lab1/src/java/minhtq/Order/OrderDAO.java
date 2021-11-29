/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.Order;

import java.io.Serializable;
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
public class OrderDAO implements Serializable {

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

    public int insertOrder(String phoneNumber, String name, String address) throws NamingException, SQLException {
        int id = 0;
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO Invoice (phoneNumber, name, address, CurrentDate) "
                        + "VALUES  (?,?,?,?) ";
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, phoneNumber);
                stm.setString(2, name);
                stm.setString(3, address);
                stm.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                int row = stm.executeUpdate();
                
                if (row > 0) {
                    rs = stm.getGeneratedKeys();
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                }

            }
        } finally {
            closeDB();
        }

        return id;

    }

}
