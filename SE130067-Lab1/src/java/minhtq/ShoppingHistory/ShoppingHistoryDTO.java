package minhtq.ShoppingHistory;

import java.io.Serializable;
import java.util.List;
import minhtq.Cake.CakeDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class ShoppingHistoryDTO implements Serializable{
    
    private String orderID;
    private List<CakeDTO> cakeList;
    private double total;

    public ShoppingHistoryDTO() {
    }

    public ShoppingHistoryDTO(String orderID, List<CakeDTO> cakeList, double total) {
        this.orderID = orderID;
        this.cakeList = cakeList;
        this.total = total;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<CakeDTO> getCakeList() {
        return cakeList;
    }

    public void setCakeList(List<CakeDTO> cakeList) {
        this.cakeList = cakeList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
