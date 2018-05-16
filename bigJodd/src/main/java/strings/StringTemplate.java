package strings;

/**
 * Created by Administrator on 2018/1/15.
 */
public class StringTemplate {

    public static StringTemplate create (){
        return new StringTemplate();
    }

    public static final String START = "$";
    public static final String START_W = "${";
    public static final String END = "}";

    public static final String template = "my name is ${username}, password is ${password}, ok";

    public void parse(String template, Resolver resolver){
       StringBuilder result  = new StringBuilder(template.length());

       int a = 0;
       int length = template.length();

       int startLength = START.length();
       int endLength = END.length();
       int startWLength = START_W.length();


       int b = template.indexOf(START);
       while (b  <  length) {
           if(b == -1){
               return;
           }
           String first = template.substring(0, b);
           String left = template.substring(b, template.length());
           result.append(first) ;
           System.out.println("left : " + left + ", first : " + first);
           int c = left.indexOf(START_W);
           if(c == -1){
               throw new RuntimeException() ;
           }

           int d = left.indexOf(END);
           String key = left.substring(startWLength, d );

           System.out.println("key : " + key);

           String value = resolver.resolve(key);
           result.append(value);

       }






    }



    interface Resolver {
        String resolve(String key);
    }


    public static void main(String[] args) {
        create().parse(template, a -> a + "" );
    }
}
