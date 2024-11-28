package notification.model.sender;

import notification.model.notification.TelegramNotification;

public class TelegramNotificationSender implements NotificationSender<TelegramNotification> {
    @Override
    public void send(TelegramNotification notification) {
        System.out.println("Notification to telegram.");
    }

    @Override
    public NotificationSenderType getType() {
        return NotificationSenderType.TELEGRAM;
    }
}
