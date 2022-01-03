/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CommentDTO;
import dtos.StatusDTO;
import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author 84909
 */
public class CommentDAO {

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

    public boolean insertComment(CommentDTO dto) throws Exception {
        boolean check = false;
        String sql = "Insert Into tblComment(articleID,userID,content,userFullName,commentDate) Values (?,?,?,?,?)";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getArticleID());
            stm.setString(2, dto.getUserID());
            stm.setString(3, dto.getContent());
            stm.setString(4, dto.getUserFullName());
            stm.setDate(5, dto.getCommentDate());

            check = stm.executeUpdate() > 0 ? true : false;

        } finally {
            closeConnection();
        }
        return check;
    }

    public List<CommentDTO> getCommentByArticle(String articleID) throws Exception {
        List<CommentDTO> list = new ArrayList<>();
        String sql = "Select articleID,userID,userFullName,content,commentDate From tblComment where articleID=?";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, articleID);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new CommentDTO(rs.getString("articleID"), rs.getString("userID"), rs.getString("content"), rs.getString("userFullName"), rs.getDate("commentDate")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int getTotalCommentByID(String articleID) throws Exception {

        String sql = "Select count(*) From tblComment where articleID=?";
        int total = 0;
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, articleID);
            rs = stm.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            return total;
        } finally {
            closeConnection();
        }

    }
}
