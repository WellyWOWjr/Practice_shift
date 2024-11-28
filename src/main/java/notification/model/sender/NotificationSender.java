package notification.model.sender;

import notification.model.notification.Notification;

public interface NotificationSender<T extends  Notification> {
    void send(T notification);

    NotificationSenderType getType();
}
