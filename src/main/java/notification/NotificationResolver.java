package notification;

import notification.exception.NullSenderException;
import notification.model.notification.Notification;
import notification.model.sender.LogNotificationSender;
import notification.model.sender.NotificationSender;
import notification.model.sender.NotificationType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationResolver {
    private final Map<NotificationType, NotificationSender<? extends Notification>> notificationMap;

    public NotificationResolver(List<NotificationSender<? extends Notification>> notificationSenders) {
        this.notificationMap = new HashMap<>();
        for (NotificationSender notificationSender : notificationSenders) {
            notificationMap.put(notificationSender.getType(), notificationSender);
        }
    }

    public LogNotificationSender getNotificationSender(Notification notification) {
        LogNotificationSender logNotificationSender = new LogNotificationSender(notificationMap.get(
                notification.getType()));
        if (logNotificationSender.getNotificationSender() == null) {
            throw new NullSenderException("Отправитель не определен");
        }
        return logNotificationSender;
    }
}
