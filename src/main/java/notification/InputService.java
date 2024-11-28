package notification;

import notification.model.sender.NotificationSenderType;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner = new Scanner(System.in);

    public NotificationSenderType getSenderType() {
        System.out.println("Enter sender type: ");
        String senderType = scanner.next();
        return NotificationSenderType.valueOf(senderType.toUpperCase());
    }
}
