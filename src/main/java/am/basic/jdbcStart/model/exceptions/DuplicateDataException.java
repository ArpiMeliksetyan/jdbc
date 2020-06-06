package am.basic.jdbcStart.model.exceptions;

public class DuplicateDataException extends  Exception {
    public DuplicateDataException(String mesage) {
        super(mesage);
    }

    public static void check(boolean expression, String message) throws DuplicateDataException {
        if (expression) {
            throw new DuplicateDataException(message);
        }
    }
}
