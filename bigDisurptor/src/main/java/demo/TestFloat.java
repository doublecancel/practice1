package demo;

public class TestFloat {


    public static void main(String[] args) {
        float f = 20014999;
        double d = f;
        double d2 = 20014999;
        System.out.println("f:" + f + ", " + Long.toBinaryString(Double.doubleToLongBits(f)));
        System.out.println("d:" + d + "," + Long.toBinaryString(Double.doubleToLongBits(d)));
        System.out.println("d2:" + d2 + ", " + Long.toBinaryString(Double.doubleToLongBits(d2)));

        double d3 =  20014999;
        float f3 =   20014999;
        int i3 =   20014999;

        prettyPrint(Integer.toBinaryString(i3));
        prettyPrint(0 + "" + Long.toBinaryString(Double.doubleToLongBits(d3)));
        prettyPrint(0 + "" + Integer.toBinaryString(Float.floatToIntBits(f3)));


        System.out.println(2.0 == 2.0);
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
