package notification.model.sender;

import notification.NotificationResponse;
import notification.NotificationResult;
import notification.callback.ResponseCallback;
import notification.model.notification.TelegramNotification;

public class TelegramNotificationSender implements NotificationSender<TelegramNotification> {
    @Override
    public NotificationResponse send(TelegramNotification notification) {
        System.out.println("Notification to telegram.");
        return new NotificationResponse(NotificationResult.OK);
    }

    @Override
    public void sendAsync(TelegramNotification notification, ResponseCallback responseCallback) {

    }

    @Override
    public NotificationType getType() {
        return NotificationType.TELEGRAM;
    }
}
