package notification.model.sender;

import notification.NotificationResponse;
import notification.NotificationResult;
import notification.callback.ResponseCallback;
import notification.model.notification.SmsNotification;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    @Override
    public NotificationResponse send(SmsNotification notification) {
        System.out.println("Notification to sms.");
        return new NotificationResponse(NotificationResult.OK);
    }

    @Override
    public void sendAsync(SmsNotification notification, ResponseCallback responseCallback) {

    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
