package notification;

import notification.exception.ExceptionHandler;
import notification.model.notification.EmailNotification;
import notification.model.notification.Notification;
import notification.model.sender.EmailNotificationSender;
import notification.model.sender.NotificationSender;
import notification.model.sender.NotificationSenderType;
import notification.model.sender.SmsNotificationSender;
import notification.model.sender.TelegramNotificationSender;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //todo tg validator; send in sms, tg
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());

        InputService inputService = new InputService();
        NotificationSenderType senderType = inputService.getSenderType();

        Notification emailNotification = EmailNotification.builder()
                .message("Hello from email")
                .title("Kazakhstan")
                .email("123321@gmail.com")
                .receiver("Nazarbaev")
                .sender("Astana")
                .build();

        List<NotificationSender<? extends Notification>> notificationSenders = new ArrayList<>();

        notificationSenders.add(new SmsNotificationSender());
        notificationSenders.add(new TelegramNotificationSender());
        notificationSenders.add(new EmailNotificationSender());

        NotificationResolver resolver = new NotificationResolver(notificationSenders);
        NotificationSender<? extends Notification> notificationSender = resolver.getNotification(
                senderType);

        FacadeSender facadeSender = new FacadeSender();
        facadeSender.sendNotification(notificationSender, emailNotification);
    }
}
