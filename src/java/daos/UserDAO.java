/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author 84909
 */
public class UserDAO {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public void closeConnection() throws Exception {
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

    public String getActiveCode(String userID) throws Exception {
        String code = null;
        String sql = "Select activeCode from tblUser Where userID=?";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, userID);
            rs = stm.executeQuery();
            if (rs.next()) {

                return code = rs.getString("activeCode");
            }

        } finally {
            closeConnection();
        }
        return code;
    }

    public boolean updateActiveCode(String userID,String activeCode) throws Exception {
        boolean check = false;
        String sql = "Update tblUser set activeCode=? where userID=?";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1,activeCode);
            stm.setString(2, userID);

            check = stm.executeUpdate() > 0 ? true : false;

        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertUser(UserDTO dto) throws Exception {
        boolean check = false;
        String sql = "Insert Into tblUser(userID,hashCode,fullName,gender,role,status,activeCode) Values (?,?,?,?,?,?,?)";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getUserID());
            stm.setString(2, dto.getHashCode());
            stm.setString(3, dto.getFullName());
            stm.setString(4, dto.getGender());
            stm.setString(5, dto.getRole());
            stm.setString(6, dto.getStatus());
            stm.setString(7, "");
            check = stm.executeUpdate() > 0 ? true : false;

        } finally {
            closeConnection();
        }
        return check;
    }

    public UserDTO checkLogin(String username, String hashCode) throws Exception {
        boolean check = false;
        UserDTO dto = null;
        String sql = "Select userID,fullName,role,status From tblUser Where userID=? and hashCode=?";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, hashCode);
            rs = stm.executeQuery();
            if (rs.next()) {
                dto = new UserDTO(rs.getString("userID"), rs.getString("fullName"), rs.getString("role"), rs.getString("status"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateStatus(String userID, String status) throws Exception {
        boolean check = false;
        String sql = "Update tblUser set status=? where userID=?";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, status);
            stm.setString(2, userID);

            check = stm.executeUpdate() > 0 ? true : false;

        } finally {
            closeConnection();
        }
        return check;
    }
}
