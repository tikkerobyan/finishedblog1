package com.example.blog.rest.models.comment;

import java.io.Serializable;
import java.util.Objects;

public class CommentResponsModel implements Serializable {
    private static final long serialVersionUID = 4805164149341689569L;

    private Long id;
    private String author;
    private String text;
    private Long articleId;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "CommentResponsModel{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", articleId=" + articleId +
                '}';
    }
}
