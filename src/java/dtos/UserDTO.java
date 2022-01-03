/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author 84909
 */
public class UserDTO {
    private String userID,hashCode,fullName,gender,role,status,activeCode;

    public UserDTO() {
    }

    public UserDTO(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public UserDTO(String userID, String hashCode, String fullName, String gender, String role, String status, String activeCode) {
        this.userID = userID;
        this.hashCode = hashCode;
        this.fullName = fullName;
        this.gender = gender;
        this.role = role;
        this.status = status;
        this.activeCode = activeCode;
    }


    public UserDTO(String userID, String fullName, String role, String status) {
        this.userID = userID;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    public UserDTO(String userID, String hashCode, String fullName, String gender, String role, String status) {
        this.userID = userID;
        this.hashCode = hashCode;
        this.fullName = fullName;
        this.gender = gender;
        this.role = role;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
