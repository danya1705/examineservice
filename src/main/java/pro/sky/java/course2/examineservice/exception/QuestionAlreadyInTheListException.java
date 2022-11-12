package pro.sky.java.course2.examineservice.exception;

public class QuestionAlreadyInTheListException extends RuntimeException {

    public QuestionAlreadyInTheListException() {
    }

    public QuestionAlreadyInTheListException(String message) {
        super(message);
    }

    public QuestionAlreadyInTheListException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyInTheListException(Throwable cause) {
        super(cause);
    }

    public QuestionAlreadyInTheListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
