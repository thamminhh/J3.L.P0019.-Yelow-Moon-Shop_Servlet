/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.users;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author CND
 */
public class UsersDTO implements Serializable {

    private String userID, password, fullname, email;
    private boolean isAdmin;

    public UsersDTO() {
    }

    public UsersDTO(String userID, String password, String fullname, String email, boolean isAdmin) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
