package edu.miu.cs545labs.service.impl;

import edu.miu.cs545labs.domain.Comment;
import edu.miu.cs545labs.repository.CommentRepo;
import edu.miu.cs545labs.repository.PostRepo;
import edu.miu.cs545labs.service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public List<Comment> getAllPostComments(long postId) {
        return postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found")).getComments();
    }

    @Override
    @Transactional
    public Comment createComment(long postId, Comment comment) {
        var post = postRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        var savedComment = commentRepo.save(comment);
        post.getComments().add(savedComment);
        postRepo.save(post);

        return savedComment;
    }
}
