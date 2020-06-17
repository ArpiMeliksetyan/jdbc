package am.basic.jdbcStart.repository.Impl.jpa;

import am.basic.jdbcStart.model.Comment;
import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.repository.CommentRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import am.basic.jdbcStart.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class CommentRepositoryJpaImpl  implements CommentRepository {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Comment> getByUserId(int userId)  {

        String query = "SELECT * FROM user WHERE userId = :nameParameter";
        Session session = sessionFactory.openSession();
        NativeQuery<Comment> nativeQuery = session.createNativeQuery(query, Comment.class);
        nativeQuery.setParameter("nameParameter", userId);
        List<Comment> comments = nativeQuery.getResultList();
        return comments;
    }

    @Override
    public void save(Comment comment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();

    }

    @Override
    public void delete(Comment comment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(comment);
        session.getTransaction().commit();

    }
}
