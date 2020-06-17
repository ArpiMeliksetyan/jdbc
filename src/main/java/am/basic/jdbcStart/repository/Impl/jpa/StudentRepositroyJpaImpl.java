package am.basic.jdbcStart.repository.Impl.jpa;

import am.basic.jdbcStart.model.Student;
import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.repository.StudentRepository;
import am.basic.jdbcStart.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class StudentRepositroyJpaImpl implements StudentRepository {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void update(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();

    }

    @Override
    public void add(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

    }

    @Override
    public Student getById(int id) {
        Session session = sessionFactory.openSession();
        Student student = session.find(Student.class, id);
        return student;
    }

    @Override
    public void delete(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }

    @Override
    public Student getByNameAndSurname(String name, String surname) {

        String query = "SELECT * FROM student WHERE name = :name AND surname = :surname ";
        Session session = sessionFactory.openSession();
        NativeQuery<Student> nativeQuery = session.createNativeQuery(query, Student.class);
        nativeQuery.setParameter("name", name);
        nativeQuery.setParameter("sunname", surname);
        Student student = nativeQuery.uniqueResult();
        return student;
    }

    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        NativeQuery<Student> nativeQuery = session.createNativeQuery("SELECT * FROM student", Student.class);
        List<Student> students = nativeQuery.getResultList();
        return students;
    }

    @Override
    public List<Student> FindByNameAndSurname(String name, String surname) throws SQLException {
        String query = "SELECT * FROM student WHERE name LIKE(CONCAT('%',:nameParameter,'%')) AND  surname LIKE(CONCAT('%',:surnameParam,'%'))";
        Session session = sessionFactory.openSession();
        NativeQuery<Student> nativeQuery = session.createNativeQuery(query, Student.class);
        nativeQuery.setParameter("nameParameter", name);
        nativeQuery.setParameter("surnameParam", surname);
        List<Student> students = nativeQuery.getResultList();
        return students;

    }
}
