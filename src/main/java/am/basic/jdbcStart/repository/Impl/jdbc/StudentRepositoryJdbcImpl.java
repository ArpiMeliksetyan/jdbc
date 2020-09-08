package am.basic.jdbcStart.repository.Impl.jdbc;

import am.basic.jdbcStart.model.Student;
import am.basic.jdbcStart.model.exceptions.DatabaseException;
import am.basic.jdbcStart.repository.StudentRepository;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJdbcImpl implements StudentRepository {

    private DataSource dataSource;

    public StudentRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public void update(Student student) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name =?, surname=?, balance=? Where id=?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getBalance());
            preparedStatement.setInt(4, student.getId());


            int result = preparedStatement.executeUpdate();
            System.out.println(result);

        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    public void add(Student student) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into student VALUES (0,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getBalance());

            int result = preparedStatement.executeUpdate();
            System.out.println(result);

        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    public Student getById(int id) {

        try {
            Student student = null;
            Connection connection = dataSource.getConnection();
            connection.setReadOnly(true);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT*from student where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                student = fromResulSet(resultSet);

            }
            resultSet.close();
            preparedStatement.close();
            return student;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }


    public void delete(Student student) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from student where id =?");
            preparedStatement.setInt(1, student.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }


    public Student getByNameAndSurname(String name, String surname) {
        try {
            Student student = null;
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT*from student where name = ? and surname=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                student = fromResulSet(resultSet);

            }
            resultSet.close();
            preparedStatement.close();
            return student;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    private Student fromResulSet(ResultSet resultSet) throws SQLException {

        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setSurname(resultSet.getString("surname"));
        student.setBalance(resultSet.getInt("balance"));
        return student;

    }

    public List<Student> getAll() {
        try {
            List<Student> studentList = new ArrayList<>();

            Connection connection = dataSource.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("Select*from student");


            while (resultSet.next()) {
                Student student = fromResulSet(resultSet);
                studentList.add(student);

            }
            resultSet.close();
            return studentList;

        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    public List<Student> FindByNameAndSurname(String name, String surname) throws SQLException {
        try {

            List<Student> studentList1 = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT*from student where name LIKE (Concat('%',?,'%'))and surname LIKE  (Concat('%',?,'%'))");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Student student = fromResulSet(resultSet);
                studentList1.add(student);

            }
            resultSet.close();
            preparedStatement.close();
            return studentList1;
        } catch (Exception ex) {
            throw new DatabaseException(ex);
        }
    }

    public void transfer(Student from, Student to, int amount) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  student set  balance=? where id =?");
            preparedStatement.setInt(1, from.getBalance() - amount);
            preparedStatement.setInt(2, from.getId());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE  student set  balance=? where id =?");
            preparedStatement.setInt(1, to.getBalance() + amount);
            preparedStatement.setInt(2, to.getId());
            preparedStatement.executeUpdate();
            System.out.println("Yuhu");
            Thread.sleep(10000);
            connection.commit();
        } catch (Throwable throwable) {
            connection.rollback();
        }
    }

}
