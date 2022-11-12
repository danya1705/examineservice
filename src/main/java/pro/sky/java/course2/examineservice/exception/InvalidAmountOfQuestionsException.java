package pro.sky.java.course2.examineservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidAmountOfQuestionsException extends RuntimeException {
    public InvalidAmountOfQuestionsException() {
    }

    public InvalidAmountOfQuestionsException(String message) {
        super(message);
    }

    public InvalidAmountOfQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAmountOfQuestionsException(Throwable cause) {
        super(cause);
    }

    public InvalidAmountOfQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
