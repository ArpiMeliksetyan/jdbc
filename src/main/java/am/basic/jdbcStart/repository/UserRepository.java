package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    void update(User user) throws SQLException;

    User getById(int id) throws SQLException;

    User getByUsernameAndPassword(String username, String password) throws SQLException;

    void add(User user) throws SQLException;

    void delete(int id) throws SQLException;

    List<User> getAll() throws SQLException;

    User getByNameAndSurname(String name, String surname) throws SQLException;

    List<User> FindByNameAndSurname(String name, String surname) throws SQLException;

    User getByUsername(String username) throws SQLException;
}
