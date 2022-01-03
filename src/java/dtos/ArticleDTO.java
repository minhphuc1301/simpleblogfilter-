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
public class ArticleDTO {

    private String articleID, articleTitle, articleContent, createBy, status, shortDescription;
    private Date createDate;

    public ArticleDTO() {
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public ArticleDTO(String articleID, String articleTitle, String articleContent, String createBy, Date createDate, String status) {
        this.articleID = articleID;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.createBy = createBy;
        this.createDate = createDate;
        this.status = status;
    }

    public ArticleDTO(String articleID, String articleTitle, String articleContent, String createBy, Date createDate, String status, String shortDescription) {
        this.articleID = articleID;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.createBy = createBy;
        this.createDate = createDate;
        this.status = status;
        this.shortDescription = shortDescription;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
