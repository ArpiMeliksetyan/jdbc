package am.basic.jdbcStart.repository.Impl.spring.jdbc;

import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Data
@Repository
//@Scope("prototype")
public class UserRepositorySpringJdbcImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void update(User user) {

    }

    @Override
    public User getById(int id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = " + id, new UserMapper());
        return user;
    }

    @PostConstruct
    public void befor() {
        System.out.println("Befor");
    }
    @PreDestroy
    public void after(){
        System.out.println("After");
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public void add(User user) {
        String query = "INSERT into user(code,name,password,surname,username,status) VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(query, user.getCode(), user.getName(), user.getPassword(), user.getSurname(), user.getUsername(), user.getStatus());

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> FindByNameAndSurname(String name, String surname) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM  user  WHERE username = '" + username + "'", new UserMapper());
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }


    public static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet sqlRowSet, int rowNum) throws SQLException {
            User user = new User();
            user.setId(sqlRowSet.getInt("id"));
            user.setName(sqlRowSet.getString("name"));
            user.setSurname(sqlRowSet.getString("surname"));
            user.setCode(sqlRowSet.getString("code"));
            user.setUsername(sqlRowSet.getString("username"));
            user.setPassword(sqlRowSet.getString("password"));
            user.setStatus(sqlRowSet.getInt("status"));
            return user;
        }
    }
}
