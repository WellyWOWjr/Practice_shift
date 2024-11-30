package notification.callback;

import notification.NotificationResponse;
import notification.model.notification.Notification;

public interface ResponseCallback<T extends Notification> {
    void onResponse(T notification, NotificationResponse response);
}
