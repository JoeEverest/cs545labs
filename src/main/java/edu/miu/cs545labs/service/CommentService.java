package edu.miu.cs545labs.service;

import edu.miu.cs545labs.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllPostComments(long postId);
    Comment createComment(long postId, Comment comment);
}
