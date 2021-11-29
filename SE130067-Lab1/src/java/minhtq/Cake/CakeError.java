/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.Cake;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class CakeError {
    private String cakeIDLengErr;
    private String cakeIDIsExist;
    private String cakeNameLengErr;
    private String imgErr;
    private String descriptionLengErr;
    private String priceErr;
    private String createDateErr;
    private String expirationDateErr;
    private String categoryLengErr;

    public CakeError() {
    }

    public String getCakeIDLengErr() {
        return cakeIDLengErr;
    }

    public void setCakeIDLengErr(String cakeLengErr) {
        this.cakeIDLengErr = cakeLengErr;
    }

    public String getCakeIDIsExist() {
        return cakeIDIsExist;
    }

    public void setCakeIDIsExist(String cakeIDIsExist) {
        this.cakeIDIsExist = cakeIDIsExist;
    }

    public String getCakeNameLengErr() {
        return cakeNameLengErr;
    }

    public void setCakeNameLengErr(String cakeNameLengErr) {
        this.cakeNameLengErr = cakeNameLengErr;
    }

    public String getImgErr() {
        return imgErr;
    }

    public void setImgErr(String imgErr) {
        this.imgErr = imgErr;
    }

    public String getDescriptionLengErr() {
        return descriptionLengErr;
    }

    public void setDescriptionLengErr(String descriptionLengErr) {
        this.descriptionLengErr = descriptionLengErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getCreateDateErr() {
        return createDateErr;
    }

    public void setCreateDateErr(String createDateErr) {
        this.createDateErr = createDateErr;
    }

    public String getExpirationDateErr() {
        return expirationDateErr;
    }

    public void setExpirationDateErr(String expirationDateErr) {
        this.expirationDateErr = expirationDateErr;
    }

    public String getCategoryLengErr() {
        return categoryLengErr;
    }

    public void setCategoryLengErr(String categoryLengErr) {
        this.categoryLengErr = categoryLengErr;
    }
    
    
    
}
