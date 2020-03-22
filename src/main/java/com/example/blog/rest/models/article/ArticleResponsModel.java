package com.example.blog.rest.models.article;

import com.example.blog.persistance.models.Article;
import com.example.blog.persistance.models.Comment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ArticleResponsModel implements Serializable {
    private static final long serialVersionUID = 6069949224489481235L;

    private Long id;
    private String author;
    private String title;
    private String content;
    private String imgUrl;
    private Date date;
    private List<Comment> commentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleResponsModel that = (ArticleResponsModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(author, that.author) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(imgUrl, that.imgUrl) &&
                Objects.equals(date, that.date) &&
                Objects.equals(commentList, that.commentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, content, imgUrl, date, commentList);
    }

    @Override
    public String toString() {
        return "ArticleResponsModel{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", date=" + date +
                ", commentList=" + commentList +
                '}';
    }
}
