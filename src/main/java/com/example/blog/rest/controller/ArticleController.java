package com.example.blog.rest.controller;

import com.example.blog.rest.models.article.ArticleRequestModel;
import com.example.blog.rest.models.article.ArticleResponsModel;
import com.example.blog.service.ArticleService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://interestingnewblog-8365e.firebaseapp.com")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ArticleResponsModel>> findAllfirst() {
        List<ArticleResponsModel> all = articleService.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping(value = "/article")
    public ResponseEntity<ArticleResponsModel> createArticle(@RequestBody ArticleRequestModel articleRequestModel) {
        ArticleResponsModel article = articleService.createArticle(articleRequestModel);
        return ResponseEntity.ok(article);
    }

    @PutMapping(value = "/article/{id}")
    public ResponseEntity<ArticleResponsModel> updateArticle(@PathVariable Long id, @RequestBody ArticleRequestModel articleRequestModel) {
        ArticleResponsModel articleResponsModel = articleService.updateArticle(id, articleRequestModel);
        return ResponseEntity.ok(articleResponsModel);
    }

    @GetMapping(value = "/articles")
    public ResponseEntity<List<ArticleResponsModel>> findAll() {
        List<ArticleResponsModel> all = articleService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/article/{id}")
    public ResponseEntity<ArticleResponsModel> findById(@PathVariable Long id) {
        ArticleResponsModel byId = articleService.findById(id);
        return ResponseEntity.ok(byId);
    }
}
