package notification.model.notification;

import notification.model.sender.NotificationType;
import notification.util.Validator;

public class TelegramNotification implements Notification {

    private final String message;
    private final String receiver;
    private final String sender;
    private final String chatId;

    private TelegramNotification(Builder builder) {
        this.message = builder.message;
        this.receiver = builder.receiver;
        this.sender = builder.sender;
        this.chatId = builder.chatId;
    }

    public static Builder builder() {
        return new Builder();
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

    @Override
    public NotificationType getType() {
        return NotificationType.TELEGRAM;
    }

    public String getChatId() {
        return chatId;
    }

    public static class Builder {
        private String chatId;
        private String receiver;
        private String sender;
        private String message;

        private Builder() {
        }

        public TelegramNotification.Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        public TelegramNotification.Builder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public TelegramNotification.Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public TelegramNotification.Builder message(String message) {
            this.message = message;
            return this;
        }

        public TelegramNotification build() {
            Validator.validateNotBlankFields(message, receiver, sender);
            return new TelegramNotification(this);
        }
    }
}
