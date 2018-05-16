package demo;

public class TestDouble {
    public static void main(String[] args) {



        double d1 = 1.01;
        double d2 = 1.01;

        System.out.println(2.00 - 1.10);
        prettyPrint(Long.toBinaryString(Double.doubleToLongBits(1.10)));
        System.out.println(2.00f - 1.101f);

        double d3 = 8;
        prettyPrint(0 + "" + Long.toBinaryString(Double.doubleToLongBits(0.1)));
        System.out.println("1023:" + Integer.toBinaryString(1023));

    }

    public static String prettyPrint(String s){
        int length = s.length();
        int l = length % 4 == 0 ? length / 4 : length / 4 + 1;
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2  = new StringBuffer();
        for (int a = 0; a < l; a++){
            if(a != l - 1){
                sb.append(s.substring(a * 4, (a + 1) * 4)).append("/");
            }else{
                sb.append(s.substring(a * 4, length));
            }
            if(a <= 10){
                sb2.append("--" + (a + 1) + "-").append("/");
            }else {
                sb2.append("-" +(a + 1) + "-").append("/");
            }
        }
        System.out.println(sb.toString());
        System.out.println(sb2.toString());
        return sb.toString();

    }
}
