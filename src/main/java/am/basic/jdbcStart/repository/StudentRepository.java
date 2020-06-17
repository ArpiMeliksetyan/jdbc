package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {

    void update(Student student) throws SQLException;

    void add(Student student) throws SQLException;

    Student getById(int id) throws SQLException;

    void delete(Student student) throws SQLException;

    Student getByNameAndSurname(String name, String surname) throws SQLException;

    List<Student> getAll() throws SQLException;

    List<Student> FindByNameAndSurname(String name, String surname) throws SQLException;


}
