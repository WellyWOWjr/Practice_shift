package notification;

import notification.model.notification.Notification;
import notification.model.sender.LogNotificationSender;
import notification.model.sender.NotificationSender;
import notification.model.sender.NotificationSenderType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationResolver {
    private final Map<NotificationSenderType, NotificationSender<? extends Notification>> notificationMap;

    public NotificationResolver(List<NotificationSender<? extends Notification>> notificationSenders) {
        this.notificationMap = new HashMap<>();
        for (NotificationSender notificationSender : notificationSenders) {
            notificationMap.put(notificationSender.getType(), notificationSender);
        }
    }

    public NotificationSender<? extends Notification> getNotification(NotificationSenderType senderType) {
        return new LogNotificationSender(notificationMap.get(senderType));
    }
}
