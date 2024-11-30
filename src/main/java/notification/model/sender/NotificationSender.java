package notification.model.sender;

import notification.NotificationResponse;
import notification.callback.ResponseCallback;
import notification.model.notification.Notification;

public interface NotificationSender<T extends  Notification> {
    NotificationResponse send(T notification);

    void sendAsync(T notification, ResponseCallback<T> responseCallback);

    NotificationType getType();
}
