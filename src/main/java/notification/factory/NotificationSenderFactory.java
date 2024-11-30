package notification.factory;

import notification.model.notification.Notification;
import notification.model.sender.NotificationSender;

import java.util.List;

public interface NotificationSenderFactory {
    List<NotificationSender<? extends Notification>> get();
}
