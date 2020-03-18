package com.example.blog.persistance.repository;

import com.example.blog.persistance.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
