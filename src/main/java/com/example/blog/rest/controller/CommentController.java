package com.example.blog.rest.controller;

import com.example.blog.rest.models.comment.CommentRequestModel;
import com.example.blog.rest.models.comment.CommentResponsModel;
import com.example.blog.service.CommentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/comment")
    public ResponseEntity<CommentResponsModel> createComment(@RequestBody CommentRequestModel commentRequestModel) {
        CommentResponsModel comment = commentService.createComment(commentRequestModel);
        return ResponseEntity.ok(comment);
    }

    @PutMapping(value = "/comment/{}")
    public ResponseEntity<CommentResponsModel> updateComment(@PathVariable Long id, @RequestBody CommentRequestModel commentRequestModel) {
        CommentResponsModel commentResponsModel = commentService.updateComment(id, commentRequestModel);
        return ResponseEntity.ok(commentResponsModel);
    }
}