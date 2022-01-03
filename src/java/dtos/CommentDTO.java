/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author 84909
 */
public class CommentDTO {

    private String id, articleID, userID, content, userFullName;
    private Date commentDate;

    public CommentDTO() {
    }

    public CommentDTO(String articleID, String userID, String content, String userFullName, Date commentDate) {
        this.articleID = articleID;
        this.userID = userID;
        this.content = content;
        this.userFullName = userFullName;
        this.commentDate = commentDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }


}
