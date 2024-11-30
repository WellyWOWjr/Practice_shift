package notification.exception;

import lombok.extern.slf4j.Slf4j;

import java.lang.Thread.UncaughtExceptionHandler;

@Slf4j
public class ExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (throwable instanceof IllegalAttributeException) {
            System.err.println(throwable.getMessage());
            System.exit(0);
        } else if (throwable instanceof BlankFieldException) {
            System.err.println(throwable.getMessage());
            System.exit(0);
        } else if (throwable instanceof NullSenderException) {
            log.error(throwable.getMessage(), throwable);
        } else {
            log.error("Неизвестная ошибка: ", throwable);
        }
    }
}
