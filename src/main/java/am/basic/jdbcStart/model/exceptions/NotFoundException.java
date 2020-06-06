package am.basic.jdbcStart.model.exceptions;

public class NotFoundException extends  Exception {
    public NotFoundException(String mesage){
        super(mesage);
    }

    public static void check(boolean expression, String message) throws NotFoundException {
        if(expression){
            throw  new NotFoundException(message);
        }

    }
}
