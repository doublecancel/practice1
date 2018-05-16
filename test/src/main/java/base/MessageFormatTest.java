package base;

import java.text.MessageFormat;

public class MessageFormatTest {
    public static void main(String[] args) {


        String message = MessageFormat.format("abc{0}, aaa{1}", 10, 11);

        System.out.println(message);
    }
}
