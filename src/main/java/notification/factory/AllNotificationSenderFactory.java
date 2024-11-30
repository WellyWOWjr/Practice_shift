package notification.factory;

import notification.factory.NotificationSenderFactory;
import notification.model.notification.Notification;
import notification.model.sender.EmailNotificationSender;
import notification.model.sender.NotificationSender;
import notification.model.sender.SmsNotificationSender;
import notification.model.sender.TelegramNotificationSender;

import java.util.ArrayList;
import java.util.List;

public class AllNotificationSenderFactory implements NotificationSenderFactory {
    @Override
    public List<NotificationSender<? extends Notification>> get() {
        List<NotificationSender<? extends Notification>> notificationSenders = new ArrayList<>();

        notificationSenders.add(new SmsNotificationSender());
        notificationSenders.add(new TelegramNotificationSender());
        notificationSenders.add(new EmailNotificationSender());

        return notificationSenders;
    }
}
