package notification.util;

import notification.exception.IllegalAttributeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator implements Validator {
    private static final String PHONE_PATTERN = "^(\\+375|80)(25|29|33|44|17)\\d{7}$";
    @Override
    public void validate(String number) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throw new IllegalAttributeException("Invalid number: " + number);
        }
    }
}
