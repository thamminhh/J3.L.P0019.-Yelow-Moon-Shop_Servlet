/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.Order;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class OrderDTO implements Serializable{
    
    private int orderID;
    private String phoneNumber;
    private String name;
    private String address;
    private String currentDate;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, String phoneNumber, String name, String address, String currentDate) {
        this.orderID = orderID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.currentDate = currentDate;
    }
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    
    
}
