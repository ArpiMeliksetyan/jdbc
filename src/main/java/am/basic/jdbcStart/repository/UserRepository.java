package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void update(User user) throws SQLException {
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
    }

    public User getById(int id) throws SQLException {
        User user = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where id =?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = fromResulSet(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    public User getByUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where username =? and password = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = fromResulSet(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    private User fromResulSet(ResultSet resultSet) throws SQLException {

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setCode(resultSet.getString("code"));
        user.setStatus(resultSet.getInt("status"));
        return user;

    }

    public void add(User user) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into user VALUES (0,?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getCode());
        preparedStatement.setInt(6, user.getStatus());

        int result = preparedStatement.executeUpdate();


    }

    public void delete(int id) throws SQLException {

        User user = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from user where id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public List<User> getAll() throws SQLException {

        List<User> userList = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("Select*from user ");


        while (resultSet.next()) {
            User user = fromResulSet(resultSet);
            userList.add(user);

        }
        resultSet.close();
        return userList;

    }

    public User getByNameAndSurname(String name, String surname) throws SQLException {

        User user = null;

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT*from user where name = ? and surname=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            user = fromResulSet(resultSet);

        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    public List<User> FindByNameAndSurname(String name, String surname) throws SQLException {
        List<User> userList1 = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT*from user where name LIKE (Concat('%',?,'%'))and surname LIKE  (Concat('%',?,'%'))");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            User user = fromResulSet(resultSet);
            userList1.add(user);

        }
        resultSet.close();
        preparedStatement.close();
        return userList1;
    }

    public User getByUsername(String username) throws SQLException {
        User user = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where username =? ");
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = fromResulSet(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }


}
