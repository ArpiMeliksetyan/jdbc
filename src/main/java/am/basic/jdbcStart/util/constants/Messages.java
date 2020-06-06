package am.basic.jdbcStart.util.constants;

public interface Messages {

    String INTERNAL_ERROR_MESSAGE = "Something went wrong";

    String PASSWORD_INVALID_MESSAGE = "Password should be more than 8 characters";

    String USERNAME_INVALID_MESSAGE = "Username should be more than 5 characters";

    String CODE_INVALID_MESSAGE = "Code must be equal 5 digits";

    String WRONG_CODE_MESSAGE = "Incorrect verification code";

    String VERIFICATION_SUCCESS_MESSAGE = "Verification was success, please log in";

    String UNVERIFIED_MESSAGE = "Your account is not verified,please verify !";

    String DUPLICATE_USER_MESSAGE = "There is user with such username";

    String INVALID_CREDENTIALS_MESSAGE = "Wrong username or password";
    
    String USER_NOT_EXIST_MESSAGE = "There is some problem with your account";

    String WRONG_PASSWORD_MESSAGE = "Incorrect password";

    String PASSWORD_CHANGE_SUCCESS_MESSAGE = "Your password successfully changed";

    String SESSION_EXPIRED_MESSAGE = "Your session expired please log in ";

    String REGISTRATION_SUCCESS_MESSAGE = "Registration was success, please log in ";

    String CODE_SUCCESSFULLY_SEND_MESSAGE = "Your code is successfully sent to your email !";
}
