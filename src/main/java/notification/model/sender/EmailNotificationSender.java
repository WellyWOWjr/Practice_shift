package notification.model.sender;

import notification.model.notification.EmailNotification;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {
    @Override
    public void send(EmailNotification notification) {
        System.out.printf(
                """
                        Отправитель: %s
                        E-mail: %s
                        Заголовок: %s
                        Сообщение: %s
                        Получатель: %s
                        """,
                notification.getSender(),
                notification.getEmail(),
                notification.getTitle(),
                notification.getMessage(),
                notification.getReceiver());
    }

    @Override
    public NotificationSenderType getType() {
        return NotificationSenderType.EMAIL;
    }
}
