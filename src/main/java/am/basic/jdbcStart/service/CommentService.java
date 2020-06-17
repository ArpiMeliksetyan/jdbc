package am.basic.jdbcStart.service;

import am.basic.jdbcStart.model.Comment;
import am.basic.jdbcStart.repository.CommentRepository;

import java.sql.SQLException;
import java.util.List;


public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public List<Comment> getByUserId(int userId) throws SQLException {
        return commentRepository.getByUserId(userId);
    }

    public void add(Comment comment) throws SQLException {

        commentRepository.save(comment);

    }

    public void delete(Comment comment) throws SQLException {

        commentRepository.delete(comment);

    }
}

