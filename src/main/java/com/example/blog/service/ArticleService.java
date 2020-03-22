package com.example.blog.service;

import com.example.blog.persistance.models.Article;
import com.example.blog.persistance.models.Comment;
import com.example.blog.persistance.repository.ArticleRepository;
import com.example.blog.persistance.repository.CommentRepository;
import com.example.blog.rest.models.article.ArticleRequestModel;
import com.example.blog.rest.models.article.ArticleResponsModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    private Article requestToArticle(ArticleRequestModel articleRequestModel) {
        Article article = new Article();
        article.setAuthor(articleRequestModel.getAuthor());
        article.setContent(articleRequestModel.getContent());
        article.setTitle(articleRequestModel.getTitle());
        article.setImgUrl(articleRequestModel.getImgUrl());
        return article;
    }

    private ArticleResponsModel articleToRespons(Article article) {
        ArticleResponsModel articleResponsModel = new ArticleResponsModel();
        articleResponsModel.setAuthor(article.getAuthor());
        articleResponsModel.setContent(article.getContent());
        articleResponsModel.setTitle(article.getTitle());
        articleResponsModel.setDate(article.getDate());
        articleResponsModel.setId(article.getId());
        articleResponsModel.setImgUrl(article.getImgUrl());
        List<Comment> allByArticle_id = commentRepository.findAllByArticle_Id(article.getId());
        articleResponsModel.setCommentList(allByArticle_id);
        return articleResponsModel;
    }

    public ArticleResponsModel createArticle(ArticleRequestModel articleRequestModel) {
        Article article = requestToArticle(articleRequestModel);
        articleRepository.save(article);
        return articleToRespons(article);
    }

    public List<ArticleResponsModel> findAll() {
        List<Article> all = articleRepository.findAll();
        return all.stream()
                .map(this::articleToRespons)
                .collect(Collectors.toList());
    }

    public ArticleResponsModel findById(Long id){
        Article article = articleRepository.findById(id).get();
        return articleToRespons(article);
    }

    public ArticleResponsModel updateArticle(Long id , ArticleRequestModel articleRequestModel){
        Article article = articleRepository.findById(id).get();
        article.setTitle(articleRequestModel.getTitle());
        article.setContent(articleRequestModel.getContent());
        article.setAuthor(articleRequestModel.getAuthor());
        articleRepository.save(article);
        return articleToRespons(article);
    }


}
