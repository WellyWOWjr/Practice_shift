package notification.callback;

import lombok.extern.slf4j.Slf4j;
import notification.NotificationResponse;
import notification.NotificationResult;
import notification.model.notification.SmsNotification;

@Slf4j
public class SmsNotificationCallback implements ResponseCallback<SmsNotification> {
    @Override
    public void onResponse(SmsNotification notification, NotificationResponse response) {
        if (response.getNotificationResult() == NotificationResult.OK) {
            log.info("Все нормально, нотификация sms отправлена");
        } else {
            log.error("Неудачная отправка sms-рассылки");
        }
    }
}
