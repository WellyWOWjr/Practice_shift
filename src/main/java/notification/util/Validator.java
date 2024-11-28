package notification.util;

import notification.exception.BlankFieldException;

public interface Validator {
    static void validateNotBlankFields(String message, String receiver, String sender) {
        if (message.isBlank()) {
            throw new BlankFieldException("Message is blank");
        }
        if (receiver.isBlank()) {
            throw new BlankFieldException("Receiver is blank");
        }
        if (sender.isBlank()) {
            throw new BlankFieldException("Sender is blank");
        }
    }

    void validate(String attribute);
}
