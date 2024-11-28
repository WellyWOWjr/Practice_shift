package notification.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (throwable instanceof IllegalAttributeException) {
            System.err.println(throwable.getMessage());
            System.exit(0);
        }
        if (throwable instanceof BlankFieldException) {
            System.err.println(throwable.getMessage());
            System.exit(0);
        }
    }
}
