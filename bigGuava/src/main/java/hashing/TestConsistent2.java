package hashing;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by Administrator on 2018/1/29.
 */
public class TestConsistent2 {

    public static int shared = 100;
    public static Map<String, List<String>> result = new HashMap<>();
    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("bd1", "db2", "db3", "db4");
        putData(getShared(list));

        result.forEach((k, v) -> {
            System.out.println(k + ":" + v.size());
        });
    }

    public static TreeMap<Integer, String> getShared(List<String> servers){
        TreeMap<Integer, String> res = new TreeMap<>();
        for (int a = 0; a < servers.size(); a++){
            String name = servers.get(a) + "_shared_";
            for(int b = 0; b < shared; b++){
               res.put(hash(name + b), servers.get(a));
            }
        }

        return res;
    }

    public static void putData(TreeMap<Integer, String> treeMap){
        for (int i = 0; i < 100000; i++) {
            String value = "lxl + " + i;
            SortedMap map = treeMap.tailMap(hash(value));
            Integer first =  0;
            if(map.size() == 0){
                first = treeMap.firstEntry().getKey();
            }else{
                first = treeMap.tailMap(hash(value)).firstKey();
            }
            if(result.containsKey(treeMap.get(first))){
                result.get(treeMap.get(first)).add(value);
            }
            else{
                result.put(treeMap.get(first), Lists.newArrayList(value));
            }
        }
    }
    //fnv1_32_HASH 算法
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
