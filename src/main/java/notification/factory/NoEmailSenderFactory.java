package notification.factory;

import notification.factory.NotificationSenderFactory;
import notification.model.notification.Notification;
import notification.model.sender.NotificationSender;
import notification.model.sender.SmsNotificationSender;
import notification.model.sender.TelegramNotificationSender;

import java.util.List;

public class NoEmailSenderFactory implements NotificationSenderFactory {
    @Override
    public List<NotificationSender<? extends Notification>> get() {
        return List.of(
                new TelegramNotificationSender(),
                new SmsNotificationSender());
    }
}
