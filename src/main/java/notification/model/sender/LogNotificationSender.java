package notification.model.sender;

import lombok.extern.slf4j.Slf4j;
import notification.model.notification.Notification;

@Slf4j
public class LogNotificationSender implements NotificationSender {

    private final NotificationSender notificationSender;

    public LogNotificationSender(NotificationSender<? extends Notification> notificationSender) {
        this.notificationSender = notificationSender;
    }

    @Override
    public void send(Notification notification) {
        log.info("Начинаем отправку сообщения {}", notificationSender.getType());
        notificationSender.send(notification);
        log.info("Отправка {} сообщения завершена", notificationSender.getType());
    }

    @Override
    public NotificationSenderType getType() {
        return notificationSender.getType();
    }
}
