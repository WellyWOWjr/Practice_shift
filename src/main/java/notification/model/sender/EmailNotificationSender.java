package notification.model.sender;

import lombok.extern.slf4j.Slf4j;
import notification.NotificationResponse;
import notification.NotificationResult;
import notification.callback.ResponseCallback;
import notification.model.notification.EmailNotification;

@Slf4j
public class EmailNotificationSender implements NotificationSender<EmailNotification> {
    @Override
    public NotificationResponse send(EmailNotification notification) {
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
        return new NotificationResponse(NotificationResult.OK);
    }

    @Override
    public void sendAsync(
            EmailNotification notification,
            ResponseCallback<EmailNotification> responseCallback) {
        new Thread(() -> responseCallback.onResponse(notification, send(notification))).start();
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
