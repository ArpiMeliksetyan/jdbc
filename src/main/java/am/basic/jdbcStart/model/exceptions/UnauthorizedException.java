package am.basic.jdbcStart.model.exceptions;

public class UnauthorizedException extends Exception {
    public UnauthorizedException(String mesage) {
        super(mesage);
    }

    public static void check(boolean expression, String message) throws UnauthorizedException {
        if (expression) {
            throw new UnauthorizedException(message);
        }
    }

}
