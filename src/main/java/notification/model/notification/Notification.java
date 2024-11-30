package notification.model.notification;

import notification.model.sender.NotificationType;

public interface Notification {
    String getMessage();

    String getReceiver();

    String getSender();

    NotificationType getType();
}
