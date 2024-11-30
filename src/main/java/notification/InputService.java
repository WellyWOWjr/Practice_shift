package notification;

import notification.model.sender.NotificationType;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner = new Scanner(System.in);

    public NotificationType getSenderType() {
        System.out.println("Enter sender type: ");
        String senderType = scanner.next();
        return NotificationType.valueOf(senderType.toUpperCase());
    }
}
