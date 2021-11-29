/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.users;

import minhtq.utils.DBHealper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author CND
 */
public class UsersDAO implements Serializable {

    List<UsersDTO> list;
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public List<UsersDTO> getList() {
        return list;
    }

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

    public boolean checkLogin(String userID, String password) throws NamingException, SQLException {
        
        try{
            con = DBHealper.makeConnection();
            if(con != null){
                String sql = "Select userID "
                        + "From [User] "
                        + "Where userID = ? And password = ?";
               stm = con.prepareStatement(sql);
               stm.setString(1, userID);
               stm.setString(2, password);
               
               rs = stm.executeQuery();
               if(rs.next()){
                   return true;
               }
                
            }
        }finally{
            closeDB();
        }
        return false;
    }
    
    public String getFullName(String userID) throws NamingException, SQLException{
        String fullname = "";
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "Select fullname "
                        + "From Users "
                        + "Where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);

                rs = stm.executeQuery();
                while (rs.next()) {
                    fullname = rs.getString("fullname");
                }
            }
        } finally {
            closeDB();    
        }
        return fullname;
    
    }
    
    public boolean insertAccount(String userID, String password, String fullname, String email, boolean isAdmin) 
            throws NamingException, SQLException{
        try{
            con = DBHealper.makeConnection();
            if(con != null){
            String sql = "Insert into Users(userID, password, fullname, email, isAdmin) "
                    + "Values(?, ?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, userID);
            stm.setString(2, password);
            stm.setString(3, fullname);
            stm.setString(4, email);
            stm.setBoolean(5, isAdmin);
            int row = stm.executeUpdate();
            if(row > 0){
                return true;
            }
        }
        }finally{
            closeDB();
        }
        return false;
        
    }
    
    public UsersDTO getAccount(String userID, String password) throws NamingException, SQLException{
        
        try {
            con = DBHealper.makeConnection();
            if(con != null){
                String sql = "SELECT userID, password, fullName, isAdmin, email "
                        + "FROM Users "
                        + "WHERE userID = ? "
                        + "AND password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String fullname = rs.getString("fullname");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    String email = rs.getString("email");
                    UsersDTO dto = new UsersDTO(userID, password, fullname, email, isAdmin);
                    return dto; 
                }
            }  
        }finally{
            closeDB();
        }
        return null;
    }

    public UsersDTO checkLoginGoogle(String email) throws NamingException, SQLException {

        con = DBHealper.makeConnection();
        try {
            
        } finally {
            closeDB();
        }
        return null;
    }

    
    
}
