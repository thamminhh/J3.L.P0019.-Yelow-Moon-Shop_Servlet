/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.Cake;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import minhtq.utils.DBHealper;

/**
 *
 * @author admin
 */
public class CakeDAO implements Serializable{

    private List<CakeDTO> listCake;

    public List<CakeDTO> getListCake() {
        return listCake;
    }

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

    public void getAllCakeSortByDate() throws NamingException, SQLException {
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity "
                        + "FROM Cake "
                        + "WHERE status = 1 "
                        + "AND quantity > 0 "
                        + "ORDER by createDate ";

                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity);
                    if (listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public void getListCakeName(String searchFoodName) throws NamingException, SQLException {

        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity "
                        + "FROM Cake "
                        + "WHERE cakeName LIKE ? "
                        + "	AND status = 1 "
                        + "	AND quantity > 0 "
                        + "ORDER BY createDate";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchFoodName + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image").trim();
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity);
                    if (this.listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public void getListCakeByPrice(double priceFrom, double priceTo) throws NamingException, SQLException {

        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity "
                        + "FROM Cake "
                        + "WHERE price BETWEEN ? AND ? "
                        + "AND status = 1 "
                        + "AND quantity > 0 "
                        + "ORDER BY createDate";

                stm = con.prepareStatement(sql);
                stm.setDouble(1, priceFrom);
                stm.setDouble(2, priceTo);

                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity);
                    if (this.listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public void getListCakeByCategory(String searchCategory) throws NamingException, SQLException {

        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity "
                        + "FROM Cake "
                        + "WHERE category LIKE ? "
                        + "AND status = 1 "
                        + "AND quantity > 0 "
                        + "ORDER BY createDate";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchCategory + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, quantity);
                    if (this.listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public void getListCakeNameAdminRole(String searchFoodName) throws NamingException, SQLException {

        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity "
                        + "FROM Cake "
                        + "WHERE cakeName LIKE ? "
                        + "ORDER BY createDate";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchFoodName + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image").trim();
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity);
                    if (this.listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public void getListCakeByPriceAdminRole(double priceFrom, double priceTo) throws NamingException, SQLException {

        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity "
                        + "FROM Cake "
                        + "WHERE price BETWEEN ? AND ?";

                stm = con.prepareStatement(sql);
                stm.setDouble(1, priceFrom);
                stm.setDouble(2, priceTo);

                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity);
                    if (this.listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public void getListCakeByCategoryAdminRole(String searchCategory) throws NamingException, SQLException {

        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity "
                        + "FROM Cake "
                        + "WHERE category LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchCategory + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity);
                    if (this.listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public void getListCakeAdminRole() throws NamingException, SQLException {
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity "
                        + "FROM Cake "
                        + "ORDER by createDate ";

                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity);
                    if (listCake == null) {
                        this.listCake = new ArrayList<>();
                    }
                    this.listCake.add(dto);
                }
            }
        } finally {
            closeDB();
        }
    }

    public CakeDTO getCakeByCakeID(String cakeID) throws NamingException, SQLException {
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "SELECT cakeName, image, description, price, createDate, expirationDate, category, status, quantity "
                        + "FROM Cake "
                        + "WHERE cakeID LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, cakeID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeName = rs.getString("cakeName");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    String createDate = rs.getString("createDate");
                    String expirationDate = rs.getString("expirationDate");
                    String category = rs.getString("category");
                    boolean status = rs.getBoolean("status");
                    int quantity = rs.getInt("quantity");
                    CakeDTO dto = new CakeDTO(cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity);
                    return dto;
                }

            }
        } finally {
            closeDB();
        }
        return null;
    }

    public boolean insertCakeAdminRole(CakeDTO dto) throws NamingException, SQLException {
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO CAKE(cakeID, cakeName, image, description, price, createDate, expirationDate, category, status, quantity) "
                        + "VALUES  (?,?,?,?,?,?,?,?,?,?) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCakeID());
                stm.setString(2, dto.getCakeName());
                stm.setString(3, dto.getImage());
                stm.setString(4, dto.getDescription());
                stm.setDouble(5, dto.getPrice());
                stm.setString(6, dto.getCreateDate());
                stm.setString(7, dto.getExpirationDate());
                stm.setString(8, dto.getCategory());
                stm.setBoolean(9, dto.isStatus());
                stm.setInt(10, dto.getQuantity());
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

    public boolean updateCakeAdminRole(CakeDTO dto) throws NamingException, SQLException {
        try {
            con = DBHealper.makeConnection();
            if (con != null) {
                String sql = "UPDATE CAKE "
                        + "SET cakeName = ?, image = ?, description = ? , price = ?, createDate = ?, expirationDate = ?, category = ?, status = ?, quantity = ? "
                        + "WHERE cakeID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCakeName());
                stm.setString(2, dto.getImage());
                stm.setString(3, dto.getDescription());
                stm.setDouble(4, dto.getPrice());
                stm.setString(5, dto.getCreateDate());
                stm.setString(6, dto.getExpirationDate());
                stm.setString(7, dto.getCategory());
                stm.setBoolean(8, dto.isStatus());
                stm.setInt(9, dto.getQuantity());
                stm.setString(10, dto.getCakeID());
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
