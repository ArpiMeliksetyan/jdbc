package am.basic.jdbcStart.repository.Impl.spring.jpa;

import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//
//@Repository
//public class UserRepositorySpringJpaImpl implements UserRepository {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    @Transactional
//    public void update(User user) {
//        sessionFactory.getCurrentSession().update(user);
//
//    }
//
//    @Override
//    public User getById(int id) {
//        return null;
//    }
//
//    @Override
//    public User getByUsernameAndPassword(String username, String password) {
//        return null;
//    }
//
//    @Transactional /* (propagation = Propagation.NEVER)*/
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//
//    }
//
//    @Override
//    public void delete(User user) {
//
//    }
//
//    @Override
//    public List<User> getAll() {
//        return null;
//    }
//
//    @Override
//    public List<User> FindByNameAndSurname(String name, String surname) {
//        return null;
//    }
//
//    @Override
//    public User getByUsername(String username) {
//        return null;
//    }
//
//    @Override
//    public List<User> findByName(String name) {
//        return null;
//    }
//}
