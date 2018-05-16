package hashing;

/**
 * Created by Administrator on 2018/1/30.
 */
public class HashingTest {

    public static void main(String[] args) {

//        IntStream.range(1, 100).forEach(a -> {
//            String key = "lxl" + a;
//            System.out.println(fnv_32_hash(key));
//        });
        prettyPring(Integer.toBinaryString(16777619));
        prettyPring(Integer.toBinaryString((int)12166136261L));

        prettyPring(Long.toBinaryString(2862933555777941757L));

//        Supplier s = Suppliers.memoize(new Supplier<Object>() {
//            @Override
//            public Object get() {
//                return new User();
//            }
//        });
//        s.get();

    }

    public static void prettyPring(String a){
        StringBuffer sb = new StringBuffer();
        char[] cs = a.toCharArray();
        int b = cs.length / 4;
        for (int i = 0; i < b; i++) {
           sb.append(new String(a.substring(i * 4, (i + 1) * 4))).append("/");
        }
        System.out.println(sb.toString());
    }

    public static int fnv_32_hash(String key){
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++)
            hash = (hash ^ key.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
}
