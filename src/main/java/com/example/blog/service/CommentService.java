package com.example.blog.service;

import com.example.blog.persistance.models.Article;
import com.example.blog.persistance.models.Comment;
import com.example.blog.persistance.repository.ArticleRepository;
import com.example.blog.persistance.repository.CommentRepository;
import com.example.blog.rest.models.comment.CommentRequestModel;
import com.example.blog.rest.models.comment.CommentResponsModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    private Comment requestToComment(CommentRequestModel commentRequestModel) {
        Comment comment = new Comment();
        comment.setAuthor(commentRequestModel.getAuthor());
        comment.setText(commentRequestModel.getText());
        Article article = articleRepository.findById(commentRequestModel.getArticleId()).get();
        comment.setArticle(article);
        return comment;
    }

    private CommentResponsModel commentToRespons(Comment comment) {
        CommentResponsModel commentResponsModel = new CommentResponsModel();
        commentResponsModel.setAuthor(comment.getAuthor());
        commentResponsModel.setText(comment.getText());
        commentResponsModel.setId(comment.getId());
        commentResponsModel.setArticleId(comment.getArticle().getId());
        return commentResponsModel;
    }

    public CommentResponsModel createComment(CommentRequestModel commentRequestModel) {
        Comment comment = requestToComment(commentRequestModel);
        commentRepository.save(comment);
        return commentToRespons(comment);
    }

    public CommentResponsModel updateComment(Long id, CommentRequestModel commentRequestModel) {
        Comment comment = commentRepository.findById(id).get();
        comment.setText(commentRequestModel.getText());
        comment.setAuthor(commentRequestModel.getAuthor());
        commentRepository.save(comment);
        return commentToRespons(comment);
    }
}
