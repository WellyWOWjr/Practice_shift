package notification;

import lombok.extern.slf4j.Slf4j;
import notification.callback.ResponseCallback;
import notification.model.notification.Notification;
import notification.model.sender.NotificationSender;

@Slf4j
public class FacadeSender {

    public void sendNotification(
            NotificationSender notificationSender,
            Notification notification,
            ResponseCallback responseCallback) {
        notificationSender.sendAsync(notification, responseCallback);
    }
}
