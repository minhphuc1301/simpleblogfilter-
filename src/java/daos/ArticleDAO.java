/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ArticleDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author 84909
 */
public class ArticleDAO {

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

    public String generateArticleID() throws SQLException {
        String o = "ART";
        int num = getListOrder().size();;
        String orderID = o + num;
        return orderID;
    }

    public List<ArticleDTO> getListOrder() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ArticleDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select articleID,articleTitle,articleContent,createBy,createDate,status From tblArticle ";
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("articleID");
                    String title = rs.getString("articleTitle");
                    String content = rs.getString("articleContent");
                    String userID = rs.getString("createBy");
                    Date date = rs.getDate("createDate");
                    String stt = rs.getString("status");

                    list.add(new ArticleDTO(id, title, content, userID, date, stt));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
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
        return list;
    }

    public boolean insertNewArticle(ArticleDTO dto) throws Exception {
        boolean check = false;
        String sql = "Insert Into tblArticle(articleID,articleTitle,articleContent,createBy,createDate,status,shortDescription) Values(?,?,?,?,?,?,?)";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getArticleID());
            stm.setString(2, dto.getArticleTitle());
            stm.setString(3, dto.getArticleContent());
            stm.setString(4, dto.getCreateBy());
            stm.setDate(5, dto.getCreateDate());
            stm.setInt(6, 1);
            stm.setString(7, dto.getShortDescription());
            check = stm.executeUpdate() > 0 ? true : false;

        } finally {
            closeConnection();
        }
        return check;
    }

    public int getNumberArticleActive() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select count(*) From tblArticle Where status=2 ";
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                if (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total / 5;
                    if (total % 5 != 0) {
                        countPage++;
                    }
                    return countPage;
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
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
        return 0;
    }

    public int getNumberArticle() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select count(*) From tblArticle ";
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                if (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total / 5;
                    if (total % 5 != 0) {
                        countPage++;
                    }
                    return countPage;
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
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
        return 0;
    }

    public int getNumberArticleByContent(String search) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select count(*) From tblArticle A inner join tblStatus S on A.status=S.statusID where S.statusName=? and A.articleContent like ?";
                stm = con.prepareStatement(sql);

                stm.setString(1, "Active");
                stm.setString(2, "%" + search + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total / 5;
                    if (total % 5 != 0) {
                        countPage++;
                    }
                    return countPage;

                }

            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
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
        return 0;
    }

    public int getNumberArticleByStatus(String status) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int total = 0;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select count(*) From tblArticle A inner join tblStatus S on A.status=S.statusID where S.statusName=? ";
                stm = con.prepareStatement(sql);

                stm.setString(1, status);
                rs = stm.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);

                }

            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
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
        return total;
    }

    public int getNumberArticleBySearch(String search, String status) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select count(*) From tblArticle A inner join tblStatus S on A.status=S.statusID where A.articleTitle like ? and S.statusName=? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                stm.setString(2, status);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total / 5;
                    if (total % 5 != 0) {
                        countPage++;
                    }
                    return countPage;
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
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
        return 0;
    }
 public ArticleDTO getArticleByID(String id) throws Exception {
        ArticleDTO dto = null;
        String sql = "Select A.articleID,A.articleTitle,A.articleContent,A.createBy,A.createDate,S.statusName,A.shortDescription From tblArticle A inner join tblStatus S on A.status=S.statusID Where A.articleID=?";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);

            stm.setString(1, id);

            rs = stm.executeQuery();
            if (rs.next()) {

                dto=new ArticleDTO(rs.getString("articleID"), rs.getString("articleTitle"), rs.getString("articleContent"), rs.getString("createBy"), rs.getDate("createDate"), rs.getString("statusName"),rs.getString("shortDescription"));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<ArticleDTO> getListPagingArticle(int index) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();
        String sql = "Select A.articleID,A.articleTitle,A.articleContent,A.createBy,A.createDate,S.statusName From tblArticle A inner join tblStatus S on A.status=S.statusID order by createDate DESC Offset ? rows fetch next 5 rows only";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, (index - 1) * 5);

            rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new ArticleDTO(rs.getString("articleID"), rs.getString("articleTitle"), rs.getString("articleContent"), rs.getString("createBy"), rs.getDate("createDate"), rs.getString("statusName")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<ArticleDTO> getListPagingArticleByStatus1(String search, int index) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();
        String sql = "Select A.articleID,A.articleTitle,A.articleContent,A.createBy,A.createDate,S.statusName,A.shortDescription From tblArticle A inner join tblStatus S on A.status=S.statusID Where A.articleContent like ? and S.statusName=? order by createDate DESC Offset ? rows fetch next 5 rows only";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            stm.setString(2, "Active");
            stm.setInt(3, (index - 1) * 5);

            rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new ArticleDTO(rs.getString("articleID"), rs.getString("articleTitle"), rs.getString("articleContent"), rs.getString("createBy"), rs.getDate("createDate"), rs.getString("statusName"),rs.getString("shortDescription")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<ArticleDTO> getListPagingArticleBySearch(String search, String status, int index) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();
        String sql = "Select A.articleID,A.articleTitle,A.articleContent,A.createBy,A.createDate,S.statusName From tblArticle A inner join tblStatus S on A.status=s.statusID where A.articleTitle like ? and S.statusName=? order by createDate DESC Offset ? rows fetch next 5 rows only";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            stm.setString(2, status);
            stm.setInt(3, (index - 1) * 5);

            rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new ArticleDTO(rs.getString("articleID"), rs.getString("articleTitle"), rs.getString("articleContent"), rs.getString("createBy"), rs.getDate("createDate"), rs.getString("statusName")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<ArticleDTO> getListPagingArticleByStatus(int index) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();
        String sql = "Select A.articleID,A.articleTitle,A.articleContent,A.createBy,A.createDate,S.statusName,A.shortDescription From tblArticle A inner join tblStatus S on A.status=s.statusID where S.statusName=? order by createDate DESC Offset ? rows fetch next 5 rows only";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "Active");
            stm.setInt(2, (index - 1) * 5);

            rs = stm.executeQuery();
            while (rs.next()) {

                list.add(new ArticleDTO(rs.getString("articleID"), rs.getString("articleTitle"), rs.getString("articleContent"), rs.getString("createBy"), rs.getDate("createDate"), rs.getString("statusName"),rs.getString("shortDescription")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateStatus(int statusID, String articleID) throws Exception {
        boolean check = false;
        String sql = "Update tblArticle Set status=? where articleID=?";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, statusID);
            stm.setString(2, articleID);
            check = stm.executeUpdate() > 0 ? true : false;
        } finally {
            closeConnection();
        }
        return check;
    }
}
