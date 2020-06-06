package am.basic.jdbcStart.model.exceptions;

public class InvalidParametersException extends Exception {
    public InvalidParametersException(String mesage){
        super(mesage);
    }

    public static void check(boolean expression, String message) throws InvalidParametersException {
        if(expression){
            throw  new InvalidParametersException(message);
        }

    }
}
