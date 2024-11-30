package notification.callback;

import lombok.extern.slf4j.Slf4j;
import notification.NotificationResponse;
import notification.NotificationResult;
import notification.model.notification.EmailNotification;

@Slf4j
public class EmailNotificationCallback implements ResponseCallback<EmailNotification> {
    @Override
    public void onResponse(EmailNotification notification, NotificationResponse response) {
        if (response.getNotificationResult() == NotificationResult.OK) {
            log.info("Все нормально, нотификация отправлена, email: {}", notification.getEmail());
        } else {
            log.error("Неудачная отправка email-рассылки");
        }
    }
}
