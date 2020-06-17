package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {

    void update(Student Student) throws SQLException;

    void add(Student student) throws SQLException;

    Student getById(int id) throws SQLException;

    void delete(int id) throws SQLException;

    Student getByNameAndSurname(String name, String surname) throws SQLException;

    List<Student> getAll() throws SQLException;

    List<Student> FindByNameAndSurname(String name, String surname) throws SQLException;


}
