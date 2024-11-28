package notification.model.notification;

import notification.util.NumberValidator;
import notification.util.Validator;

public class SmsNotification implements Notification {

    private String message;
    private String receiver;
    private String sender;
    private String number;

    public static Builder builder() {
        return new SmsNotification().new Builder();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getReceiver() {
        return receiver;
    }

    @Override
    public String getSender() {
        return sender;
    }

    public String getNumber() {
        return number;
    }

    public class Builder {

        private Builder() {
        }

        public SmsNotification.Builder chatId(String chatId) {
            SmsNotification.this.number = chatId;
            return this;
        }

        public SmsNotification.Builder receiver(String receiver) {
            SmsNotification.this.receiver = receiver;
            return this;
        }

        public SmsNotification.Builder sender(String sender) {
            SmsNotification.this.sender = sender;
            return this;
        }

        public SmsNotification.Builder message(String message) {
            SmsNotification.this.message = message;
            return this;
        }

        public SmsNotification build() {
            Validator.validateNotBlankFields(message, receiver, sender);
            new NumberValidator().validate(number);
            return SmsNotification.this;
        }
    }
}
