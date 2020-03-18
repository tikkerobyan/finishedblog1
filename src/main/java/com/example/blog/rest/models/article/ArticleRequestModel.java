package com.example.blog.rest.models.article;

import java.io.Serializable;
import java.util.Objects;

public class ArticleRequestModel implements Serializable {
    private static final long serialVersionUID = -9191372381262619286L;

    private String author;
    private String title;
    private String content;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleRequestModel that = (ArticleRequestModel) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, content);
    }

    @Override
    public String toString() {
        return "ArticleRequestModel{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
