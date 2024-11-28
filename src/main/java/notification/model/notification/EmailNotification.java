package notification.model.notification;

import notification.util.EmailValidator;
import notification.util.Validator;

public class EmailNotification implements Notification {

    private String message;
    private String receiver;
    private String sender;
    private String title;
    private String email;

    public static Builder builder() {
        return new EmailNotification().new Builder();
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

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public class Builder {

        private Builder() {
        }

        public Builder title(String title) {
            EmailNotification.this.title = title;
            return this;
        }

        public Builder receiver(String receiver) {
            EmailNotification.this.receiver = receiver;
            return this;
        }

        public Builder sender(String sender) {
            EmailNotification.this.sender = sender;
            return this;
        }

        public Builder message(String message) {
            EmailNotification.this.message = message;
            return this;
        }

        public Builder email(String email) {
            EmailNotification.this.email = email;
            return this;
        }

        public EmailNotification build() {
            Validator.validateNotBlankFields(message, receiver, sender);
            //todo setter to choose validator strategy
            new EmailValidator().validate(email);
            return EmailNotification.this;
        }
    }
}
