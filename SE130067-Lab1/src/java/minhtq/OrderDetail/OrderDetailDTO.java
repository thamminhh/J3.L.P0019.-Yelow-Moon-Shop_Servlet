/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.OrderDetail;

/**
 *
 * @author admin
 */
public class OrderDetailDTO {
    
    private int orderID;
    private String cakeID;
    private int quantity;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderID, String cakeID, int quantity) {
        this.orderID = orderID;
        this.cakeID = cakeID;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCakeID() {
        return cakeID;
    }

    public void setCakeID(String cakeID) {
        this.cakeID = cakeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
