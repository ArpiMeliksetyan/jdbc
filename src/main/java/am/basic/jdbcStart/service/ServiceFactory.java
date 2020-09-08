package am.basic.jdbcStart.service;

import am.basic.jdbcStart.repository.Impl.jdbc.CommentRepositoryJdbcImpl;
import am.basic.jdbcStart.repository.Impl.jdbc.UserRepositoryJdbcImpl;
import am.basic.jdbcStart.repository.Impl.jpa.CommentRepositoryJpaImpl;
import am.basic.jdbcStart.repository.Impl.jpa.UserRepositoryJpaImpl;


public class ServiceFactory {
    private static boolean usJpa = true;



    public static UserService getUserService() {
        return null;
    }

//    public static UserService getUserService() {
//        if (usJpa) {
//            return new UserService(new UserRepositoryJpaImpl());
//        } else {
//            return new UserService(new UserRepositoryJdbcImpl(null));
//        }
//    }
//
//    public static CommentService getCommentService() {
//        if (usJpa) {
//            return new CommentService(new CommentRepositoryJpaImpl());
//        } else {
//            return new CommentService(new CommentRepositoryJdbcImpl());
//        }
//    }

}
