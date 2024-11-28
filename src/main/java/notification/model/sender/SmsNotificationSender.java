package notification.model.sender;

import notification.model.notification.SmsNotification;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    @Override
    public void send(SmsNotification notification) {
        System.out.println("Notification to sms.");
    }

    @Override
    public NotificationSenderType getType() {
        return NotificationSenderType.SMS;
    }
}
