package hashing;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2018/1/29.
 */
public class TestConsitent {

    public static Map<String, List<String>> result = new HashMap<>();

    public static void main(String[] args) {

//        map.forEach((k, v) -> {
//            System.out.println("map , k : " + k + ", v : " + v);
//        });
        ImmutableList<String> servers = ImmutableList.of("db1", "db2", "db3", "db4");
        test(servers);

        System.out.println("-------------------");
        result = new HashMap<>();
        ImmutableList<String> servers2 = ImmutableList.of("db1", "db2", "db3", "db4", "db5");
        test(servers2);
    }

    public static void test(ImmutableList<String> servers){

        TreeMap<Integer, String> map = getServer(servers);
        prepareData(map);
//        System.out.println(Joiner.on("\n").withKeyValueSeparator("=").join(map));
        result.forEach((k, v) -> {
            System.out.println("server : " + k + ", size : " + v.size());
        });
    }

    public static void prepareData (TreeMap<Integer, String> map){

        IntStream.range(1, 1000000).forEach(a -> {
            String name = String.format("lxl%s", a);
            Integer id = hash(name);
            Integer serverId = map.firstEntry().getKey();
            if(map.tailMap(id).size() > 0){
                serverId = map.tailMap(id).firstKey();
            }
            if(result.containsKey(map.get(serverId))){
                result.get(map.get(serverId)).add(name);
            }else{
                result.put(map.get(serverId), Lists.newArrayList(name));
            }
        });
    }

    public static TreeMap<Integer, String> getServer(ImmutableList<String> servers){
        TreeMap<Integer, String> m = new TreeMap<>();
        for (int a = 0; a < servers.size(); a++) {
            m.put(hash(servers.get(a)), servers.get(a));
        }
        return m;
    }


    static final int hash(String key) {
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
//        Integer s =  Hashing.murmur3_128(0x1234ABCD)
//                .newHasher()
//                .putString(key, Charset.forName("utf8"))
//                .hash()
//                .asInt();
//        if(s < 0){
//            s = Math.abs(s);
//        }
//        return s;
    }






}
