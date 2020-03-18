package com.example.blog.rest.models.comment;

import java.io.Serializable;
import java.util.Objects;

public class CommentRequestModel implements Serializable {
    private static final long serialVersionUID = -9153003989960790329L;

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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentRequestModel that = (CommentRequestModel) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(text, that.text) &&
                Objects.equals(articleId, that.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, text, articleId);
    }

    @Override
    public String toString() {
        return "CommentRequestModel{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", articleId=" + articleId +
                '}';
    }
}
