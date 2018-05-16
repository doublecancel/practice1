package base;

public class BitTest {

    static final int a = 1 << 0;
    static final int b = 1 << 1;
    static final int c = 1 << 2;
    static final int d = 1 << 3;

    public static void main(String[] args) {

        prettyPrint("a|b:", a | b);
        prettyPrint("a|b|d" , a | b | d);
        int temp = a | b | c;
        System.out.println((temp & (1 << 2)));
//        prettyPrint(String.format("%s, %s, %s, %s", (temp & 1 << 1), (temp & 1 << 2), (temp & 1 << 3), (temp & 1 << 4)))  ;
        System.out.println(-1L ^ (-1L << 16));

    }

    public static void prettyPrint(String prefix, int a){
        System.out.println(prefix + ":" + prettyPrint(a));
    }

    public static String prettyPrint(int a){
        return prettyPrint(Integer.toBinaryString(a));
    }
    public static String prettyPrint(String s){


        int length = s.length();
        int a = 0;
        StringBuffer sb = new StringBuffer();
        while (a < length){
            if(s.length() < 4){
                sb.append(s);
                break;
            }
            sb.append(s.substring(a, a + 4) + " / ");
            a += 4;
        }
        return sb.toString();


    }






}
