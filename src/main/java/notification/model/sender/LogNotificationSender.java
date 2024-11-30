package notification.model.sender;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import notification.NotificationResponse;
import notification.NotificationResult;
import notification.callback.ResponseCallback;
import notification.model.notification.Notification;

@Slf4j
@Getter
public class LogNotificationSender implements NotificationSender {

    private final NotificationSender notificationSender;

    public LogNotificationSender(NotificationSender<? extends Notification> notificationSender) {
        this.notificationSender = notificationSender;
    }

    @Override
    public NotificationResponse send(Notification notification) {
        log.info("Начинаем отправку сообщения {}", notificationSender.getType());
        notificationSender.send(notification);
        log.info("Отправка {} сообщения завершена", notificationSender.getType());
        return new NotificationResponse(NotificationResult.OK);
    }

    @Override
    public void sendAsync(Notification notification, ResponseCallback responseCallback) {

    }

    @Override
    public NotificationType getType() {
        return notificationSender.getType();
    }
}
