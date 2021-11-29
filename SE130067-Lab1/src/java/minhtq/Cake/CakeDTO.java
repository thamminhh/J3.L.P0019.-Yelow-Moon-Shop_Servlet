/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.Cake;

import java.util.Date;

/**
 *
 * @author admin
 */
public class CakeDTO {
    
    private String cakeID;
    private String cakeName;
    private String image;
    private String description;
    private double price;
    private String createDate;
    private String expirationDate;
    private String category;
    private boolean status;
    private int quantity;

    public CakeDTO() {
    }

    public CakeDTO(String cakeID, String cakeName, String image, String description, double price, String createDate, String expirationDate, String category, boolean status, int quantity) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.category = category;
        this.status = status;
        this.quantity = quantity;
    }

    public CakeDTO(String cakeID, String cakeName, String image, String description, double price, String createDate, String expirationDate, String category, int quantity) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.category = category;
        this.quantity = quantity;
    }

    public CakeDTO(String cakeID, String cakeName, double price, int quantity) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.price = price;
        this.quantity = quantity;
    }
    
    
    

    public String getCakeID() {
        return cakeID;
    }

    public void setCakeID(String cakeID) {
        this.cakeID = cakeID;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }


    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
