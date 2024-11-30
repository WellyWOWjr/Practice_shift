package notification;

import notification.callback.EmailNotificationCallback;
import notification.exception.ExceptionHandler;
import notification.factory.AllNotificationSenderFactory;
import notification.factory.NotificationSenderFactory;
import notification.model.notification.EmailNotification;
import notification.model.notification.Notification;
import notification.model.sender.LogNotificationSender;

public class Main {

    public static void main(String[] args) {
        //todo tg validator; send in sms, tg
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());

//        InputService inputService = new InputService();
//        NotificationType senderType = inputService.getSenderType();

        Notification emailNotification = EmailNotification.builder()
                .message("Hello from email")
                .title("Kazakhstan")
                .email("123321@gmail.com")
                .receiver("Nazarbaev")
                .sender("Astana")
                .build();

        NotificationSenderFactory senderFactory = new AllNotificationSenderFactory();
        NotificationResolver resolver = new NotificationResolver(senderFactory.get());

        LogNotificationSender notificationSender = resolver.getNotificationSender(
                emailNotification);

        FacadeSender facadeSender = new FacadeSender();
        facadeSender.sendNotification(
                notificationSender,
                emailNotification,
                new EmailNotificationCallback());
    }
}
