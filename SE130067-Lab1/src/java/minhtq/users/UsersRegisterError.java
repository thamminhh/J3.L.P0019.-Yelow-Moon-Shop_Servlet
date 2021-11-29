/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.users;

import java.io.Serializable;

/**
 *
 * @author CND
 */
public class UsersRegisterError implements Serializable {

    private String userIDLengErr;
    private String passwordLengErr ;
    private String confirmNotMatch;
    private String fullnameLengErr;
    private String userIDIsExist;
    private String emailLengErr;

    public UsersRegisterError() {
    }

    public String getUserIDLengErr() {
        return userIDLengErr;
    }

    public void setUserIDLengErr(String userIDLengErr) {
        this.userIDLengErr = userIDLengErr;
    }

    public String getPasswordLengErr() {
        return passwordLengErr;
    }

    public void setPasswordLengErr(String passwordLengErr) {
        this.passwordLengErr = passwordLengErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getFullnameLengErr() {
        return fullnameLengErr;
    }

    public void setFullnameLengErr(String fullnameLengErr) {
        this.fullnameLengErr = fullnameLengErr;
    }

    public String getUserIDIsExist() {
        return userIDIsExist;
    }

    public void setUserIDIsExist(String usernameIsExist) {
        this.userIDIsExist = usernameIsExist;
    }

    public String getEmailLengErr() {
        return emailLengErr;
    }

    public void setEmailLengErr(String addressLengErr) {
        this.emailLengErr = addressLengErr;
    }
    
    


}   