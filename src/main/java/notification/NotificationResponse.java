package notification;

import lombok.Data;


@Data
public class NotificationResponse {
    private final NotificationResult notificationResult;
    private Throwable throwable;


    public NotificationResponse(NotificationResult notificationResult) {
        this.notificationResult = notificationResult;
    }
}
