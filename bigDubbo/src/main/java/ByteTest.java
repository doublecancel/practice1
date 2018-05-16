import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2017/12/7.
 */
public class ByteTest {

    public static void main(String[] args) {

        test1();

    }

    public static void test1(){

        String str = "hwllo world";
        byte[] bs = str.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bs.length);

        System.out.println("mark:" + buffer.mark() + ",position:" + buffer.position() + ",limit:" + buffer.limit() + ",capacoty:" + buffer.capacity());
        System.out.println("----------------------write------------------------");
        for (int a = 0; a < bs.length; a++){
            buffer.put(bs[a]);
            System.out.println("mark:" + buffer.mark() + ",position:" + buffer.position() + ",limit:" + buffer.limit() + ",capacoty:" + buffer.capacity());
        }

        System.out.println("flip--------------------------");
        buffer.flip();

        System.out.println("mark:" + buffer.mark() + ",position:" + buffer.position() + ",limit:" + buffer.limit() + ",capacoty:" + buffer.capacity());
        System.out.println("----------------------read------------------------");
        for (int a = 0; a < bs.length; a++){
            buffer.get();

            System.out.println("mark:" + buffer.mark() + ",position:" + buffer.position() + ",limit:" + buffer.limit() + ",capacoty:" + buffer.capacity());

        }


    }


}
