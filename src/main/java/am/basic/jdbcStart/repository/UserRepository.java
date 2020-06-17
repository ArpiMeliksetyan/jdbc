package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.model.User;

import java.util.List;

public interface UserRepository {


    void update(User user) ;

    User getById(int id) ;

    User getByUsernameAndPassword(String username, String password)  ;

    void add(User user)  ;

    void delete(User user)  ;

    List<User> getAll()  ;

    List<User> FindByNameAndSurname(String name, String surname)  ;

    User getByUsername(String username)  ;

    List<User> findByName(String name);
}
