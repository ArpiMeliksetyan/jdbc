package am.basic.jdbcStart.service;

import am.basic.jdbcStart.repository.Impl.jdbc.CommentRepositoryJdbcImpl;
import am.basic.jdbcStart.repository.Impl.jdbc.UserRepositoryJdbcImpl;
import am.basic.jdbcStart.repository.Impl.jpa.CommentRepositoryJpaImpl;
import am.basic.jdbcStart.repository.Impl.jpa.UserRepositoryJpaImpl;
import am.basic.jdbcStart.util.DataSource;

public class ServiceFactory {
    private static boolean usJpa = true;

    public static UserService getUserService() {
        if (usJpa) {
            return new UserService(new UserRepositoryJpaImpl());
        } else {
            return new UserService(new UserRepositoryJdbcImpl(new DataSource()));
        }
    }

    public static CommentService getCommentService() {
        if (usJpa) {
            return new CommentService(new CommentRepositoryJpaImpl());
        } else {
            return new CommentService(new CommentRepositoryJdbcImpl(new DataSource()));
        }
    }

}
