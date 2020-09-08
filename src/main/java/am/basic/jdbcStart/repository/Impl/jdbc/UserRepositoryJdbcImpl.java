package am.basic.jdbcStart.repository.Impl.jdbc;

import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.model.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class UserRepositoryJdbcImpl implements am.basic.jdbcStart.repository.UserRepository {

    private DataSource dataSource;

    @Autowired
    public UserRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void init() {
        System.out.println("creating user repository jdbc");
    }


    @Override
    public void update(User user) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  USER  SET name= ?, surname=?, username=?, password=?, code=?, status=? where id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getCode());
            preparedStatement.setInt(6, user.getStatus());
            preparedStatement.setInt(7, user.getId());

            int result = preparedStatement.executeUpdate();
            System.out.println("result = " + result);
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }

    }

    @Override
    public User getById(int id) {
        try {
            User user = null;
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("Select * FROM user where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = fromResultSet(resultSet);
            }
            resultSet.close();
            statement.close();
            return user;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        try {
            User user = null;
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where username =? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = fromResultSet(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            return user;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    private User fromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setCode(resultSet.getString("code"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setStatus(resultSet.getInt("status"));
        return user;
    }

    @Override
    public void add(User user) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into user VALUES (0,?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getCode());
            preparedStatement.setInt(6, user.getStatus());

            int result = preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    @Override
    public void delete(User user) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from user where id =?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    @Override
    public List<User> getAll() {
        try {

            List<User> userList = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("Select*from user ");


            while (resultSet.next()) {
                User user = fromResultSet(resultSet);
                userList.add(user);

            }
            resultSet.close();
            return userList;

        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    public User getByNameAndSurname(String name, String surname) {

        try {

            User user = null;

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT*from user where name = ? and surname=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                user = fromResultSet(resultSet);

            }
            resultSet.close();
            preparedStatement.close();
            return user;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    @Override
    public List<User> FindByNameAndSurname(String name, String surname) {
        try {
            List<User> userList1 = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT*from user where name LIKE (Concat('%',?,'%'))and surname LIKE  (Concat('%',?,'%'))");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                User user = fromResultSet(resultSet);
                userList1.add(user);

            }
            resultSet.close();
            preparedStatement.close();
            return userList1;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    @Override
    public User getByUsername(String username) {
        try {
            User user = null;
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where username =? ");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = fromResultSet(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            return user;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    @Override
    public List<User> findByName(String name) {
        try {
            List<User> users = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("Select * FROM user where name LIKE(CONCAT('%',?,'%'))");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = fromResultSet(resultSet);
                users.add(user);
            }
            resultSet.close();
            statement.close();
            return users;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

    }
}

