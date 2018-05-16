package base;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class AsciiTest {
    public static void main(String[] args) {

//        char2Ascii('A');

//        testOxff();

        testCharset();


    }

    public static void testCharset(){
        Charset UTF8 = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = UTF8.encode("你好");
        System.out.println(byteBuffer.array());
    }



    public static void char2Ascii(char c){
        byte b = (byte)c;
        System.out.println(b + "," );
    }

    public static void testOxff(){
        byte a = 123;
        System.out.println("----" + a + "----");
        System.out.println(a + "的二进制源码：" + Integer.toBinaryString(a));

        byte b = -123;
        System.out.println(b + "的二进制原码是：" + Integer.toBinaryString(b));
        System.out.println(b + "的二进制原码是：" + (b & 0xff));
        System.out.println(b + "的二进制原码是：" + Integer.toBinaryString(b & 0xff));

        System.out.println(Integer.parseInt("11111111111111111111111110000101", 2));

    }

}
