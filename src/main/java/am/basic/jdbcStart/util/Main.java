package am.basic.jdbcStart.util;

import am.basic.jdbcStart.model.Comment;

import am.basic.jdbcStart.model.Student;
import am.basic.jdbcStart.model.Teacher;
import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.model.exceptions.DuplicateDataException;
import am.basic.jdbcStart.model.exceptions.NotFoundException;
import am.basic.jdbcStart.repository.CommentRepository;
import am.basic.jdbcStart.repository.Impl.jpa.CommentRepositoryJpaImpl;
import am.basic.jdbcStart.repository.Impl.jpa.UserRepositoryJpaImpl;
import am.basic.jdbcStart.repository.Impl.spring.jdbc.UserRepositorySpringJdbcImpl;
import am.basic.jdbcStart.repository.UserRepository;
import am.basic.jdbcStart.service.UserService;
import am.basic.jdbcStart.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DuplicateDataException, NotFoundException {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
//        UserRepositoryCrud userRepository = (UserRepositoryCrud) applicationContext.getBean("userRepositoryJpa");

//        UserRepositorySpringJdbcImpl userRepositorySpringJdbc = applicationContext.getBean(UserRepositorySpringJdbcImpl.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.sendCode("arpi@mail.ru");






//        SessionFactory sessionFactory = applicationContext.getBean(SessionFactory.class);
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Teacher teacher =  new Teacher();
//        teacher.setName("Tatevik");
//        session.save(teacher);
//
//        Student student = new Student();
//        student.setName("Ani");
//        List<Teacher> teacherList = new ArrayList<>();
//        teacherList.add(teacher);
//        student.setTeachers(teacherList);
//
//
//        session.save(student);
//        session.getTransaction().commit();




//        System.out.println(userRepository);
//        System.out.println(userRepository1);
//        User user = userRepository.getById(1);
//        System.out.println(user);

//        UserRepositoryCrud userRepository = new UserRepositoryJpaImpl();
//        User user = userRepository.getById(18);
//        System.out.println(user);
//
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Student student = session.find(Student.class,13);
//            System.out.println(student);

//        Comment comment = Comment.builder().id(1).userId(18).description("asas").name("wow").build();
//        System.out.println(comment);


//        StudentRepositoryJdbcImpl studentRepository = new StudentRepositoryJdbcImpl(new DataSource());

//        Student student = studentRepository.getById(1);
//        Student student1 = studentRepository.getById(2);
//        studentRepository.transfer(student, student1, 10);

//        Student student = new Student();
//
//
//        System.out.println(studentRepository.getAll());


//        UserRepositoryJdbcImpl userRepository = new UserRepositoryJdbcImpl(new DataSource());


//        Student student = studentRepository.getById(5);
//        System.out.println(student);
//        student.setName("Garik");
//        studentRepository.update(student);
//
//        Student student1 = new Student();
//        student1.setName("Ruben");
//        student1.setSurname("Manukyan");
//        studentRepository.add(student1);

//        studentRepository.delete(15);

//        Student student = studentRepository.getByNameAndSurname("Arpi","Meliksetyan");
//        System.out.println(student);
//        List<Student> studentList = studentRepository.getAll();
//        System.out.println(studentList);
//
//
//    List<Student> studentList1 = studentRepository.FindByNameAndSurname("Arpi","Meliksetyan");
//        System.out.println(studentList1);
    }
}


//        printStudent();
//        printTeacher();
//        String s = "bsDhkdfa87fjalksfd";
//        Pattern pattern = Pattern.compile("^[a-zA-Z]{5}.*$");
//        Matcher matcher = pattern.matcher(s);
//        System.out.println(matcher.matches());

// mail stugelelu validation
//        String s1 = "arpi@mail.ru";
//        Pattern pattern1 = Pattern.compile("^(.+)@(.+)\\.(.+)$");
//        Matcher matcher1 = pattern1.matcher(s1);
//        System.out.println(matcher1.matches());

//        prepareStatementGetStudentById();

//        insertStudent();
//        updateStudent();

//    public static void updateStudent () throws SQLException {
//        Connection connection = DataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name =? Where id=?");
//        preparedStatement.setString(1,"Updates Name");
//        preparedStatement.setInt(2,14);
//        int result = preparedStatement.executeUpdate();
//        System.out.println(result);
//
//    }
//
//
//    public static void insertStudent() throws SQLException {
//        Connection connection = DataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into student values (0,?,?,?)");
//        preparedStatement.setString(1,"New name");
//        preparedStatement.setString(2, "New Surname");
//        preparedStatement.setInt(3,1);
//        int result = preparedStatement.executeUpdate();
//        System.out.println(result);
//
//
//    }
//
//
//        public static void prepareStatementGetStudentById() throws SQLException {
//            Connection connection = DataSource.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("Select*From student where id =? and name LIKE (Concat('%',?,'%'))");
//            preparedStatement.setInt(1,11);
//            preparedStatement.setString(2,"alex");
//            ResultSet resultSet= preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String surname = resultSet.getString("surname");
//
//                System.out.println(id + " " + name + " " + surname);
//            }
//        }
//
//
//
//    public static void printStudent() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        String query = "Select * FROM student where id= ";
//        System.out.println("Please insert id");
//        query +=scanner.nextInt();
//        System.out.println("executing query:" + query);
//
//        Connection connection = DataSource.getConnection();
//        Statement statement = connection.createStatement();
////        ResultSet resultSet = statement.executeQuery("Select * FROM student");
//        ResultSet resultSet = statement.executeQuery(query);
//
//        while (resultSet.next()) {
//
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            String surname = resultSet.getString("surname");
//
//            System.out.println(id + " " + name + " " + surname);
//        }
//        resultSet.close();
//        statement.close();
//        connection.close();
//


//    public static void printTeacher() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        String query1 = "Select * FROM teacher where id= ";
//        System.out.println("Please insert id");
//        query1 +=scanner.nextInt();
//        System.out.println("executing query1:" + query1);
//
//        Connection connection = DataSource.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(query1);
//
//        while (resultSet.next()) {
//
//            int id = resultSet.getInt("id");
//            String name= resultSet.getString("name");
//            String surname = resultSet.getString("surname");
//
//            System.out.println(id + " " + name + " " + surname);
//        }
//        resultSet.close();
//        statement.close();
//        connection.close();
//}

