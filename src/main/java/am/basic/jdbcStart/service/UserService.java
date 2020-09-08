package am.basic.jdbcStart.service;

import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.model.exceptions.*;
import am.basic.jdbcStart.repository.Impl.jdbc.UserRepositoryJdbcImpl;
import am.basic.jdbcStart.repository.Impl.jpa.UserRepositoryJpaImpl;
import am.basic.jdbcStart.repository.Impl.spring.crud.UserRepositoryCrud;
import am.basic.jdbcStart.repository.UserRepository;
import am.basic.jdbcStart.util.encoder.Generator;
import am.basic.jdbcStart.util.encoder.Md5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static am.basic.jdbcStart.util.constants.Messages.*;

@Service
public class UserService {

    private UserRepositoryCrud userRepository;

    @Autowired
    public UserService(UserRepositoryCrud userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void register(User user) throws DuplicateDataException {
        User duplicate = userRepository.getByUsername(user.getUsername());
        DuplicateDataException.check(duplicate != null, DUPLICATE_USER_MESSAGE);
        user.setPassword(Md5Encoder.encode(user.getPassword()));
        user.setCode(Generator.getRandomDigits(5));
        user.setStatus(0);
        userRepository.save(user);
    }

    public User login(String username, String password) throws NotFoundException, UnverifiedException {

        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null || !Md5Encoder.matches(password, user.getPassword()), INVALID_CREDENTIALS_MESSAGE);
        UnverifiedException.check(user.getStatus() != 1, UNVERIFIED_MESSAGE);
        return user;
    }

    public User changePassword(String username, String password, String newPassword) throws NotFoundException, AccessDeniedException {

        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        AccessDeniedException.check(!user.getPassword().equals(password), WRONG_PASSWORD_MESSAGE);
        user.setPassword(newPassword);
        userRepository.save(user);
        return user;
    }

    @Transactional
    public void sendCode(String username) throws NotFoundException {

        User user = userRepository.getByUserN(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        user.setCode(Generator.getRandomDigits(5));
//            send code to user by email
        userRepository.save(user);
    }

    @Transactional

    public void recoverPassword(String username, String code, String password) throws NotFoundException, AccessDeniedException {

        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        AccessDeniedException.check(!user.getCode().equals(code), WRONG_CODE_MESSAGE);
        user.setPassword(password);
        userRepository.save(user);
    }

    public void verify(String username, String code) throws NotFoundException, AccessDeniedException {

        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        AccessDeniedException.check(!user.getCode().equals(code), WRONG_CODE_MESSAGE);
        user.setStatus(1);
        userRepository.save(user);
    }
}
