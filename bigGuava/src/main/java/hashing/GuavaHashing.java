package hashing;

import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;

import java.util.*;

/**
 * Created by Administrator on 2018/1/29.
 */
public class GuavaHashing {

    public static void main(String[] args) {
        Map<String, List<String>> map1 = test1();
        System.out.println("--------------------------------");
        Map<String, List<String>> map2 = test2();


        Map<String, Set<String>> map = differ(map1, map2);
        System.out.println("--------------------------------------------");
        map.forEach((k, v) -> {
           System.out.println(k + ":" + v.size());
       });

    }

    public static Map<String, Set<String>>  differ(Map<String, List<String>> map1, Map<String, List<String>> map2 ){
        Map<String, Set<String>> diff = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : map1.entrySet()){
            String key = entry.getKey();
            List<String> list2 = map2.get(key);

            List<String> list1 = entry.getValue();
            Set<String> list3 = new HashSet<>();
            for (String s : list1) {
                if(!list2.contains(s)){
                   list3.add(s);
                }
            }

            for (String s : list2) {
                if(!list1.contains(s)){
                    list3.add(s);
                }
            }

            diff.put(key, list3);

        }
        return diff;
    }
    public static  Map<String, List<String>> test1(){

        List<String> servers = Lists.newArrayList("db1", "db2", "db3", "db4", "db5", "db6");
        Map<String, List<String>> res  = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            String name = "lxl"  + i;
            int a = Hashing.consistentHash(name.hashCode(), servers.size()) ;
            String server = servers.get(a);
            if(res.containsKey(server)){
                res.get(server).add(name);
            }else{
                res.put(server, Lists.newArrayList(name));
            }
        }
        res.forEach((k, v) -> {
            System.out.println(k + ":" + v.size());
        });
        return res;
    }

    public static Map<String, List<String>> test2(){

        List<String> servers = Lists.newArrayList("db1", "db2", "db3", "db4", "db5", "db6", "db7");
        Map<String, List<String>> res  = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            String name = "lxl"  + i;
            int a = Hashing.consistentHash(name.hashCode(), servers.size()) ;
            String server = servers.get(a);
            if(res.containsKey(server)){
                res.get(server).add(name);
            }else{
                res.put(server, Lists.newArrayList(name));
            }
        }
        res.forEach((k, v) -> {
            System.out.println(k + ":" + v.size());
        });
        return res;
    }

    public static int test3(int hash, int buckets){
        int candidate = 0;
        int next;

        // Jump from bucket to bucket until we go out of range
        while (true) {
            next = (int) ((candidate + 1) / ((double) ((int) (2862933555777941757L * hash + 1 >>> 33) + 1)) / (0x1.0p31));
            if (next >= 0 && next < buckets) {
                candidate = next;
            } else {
                return candidate;
            }
        }
    }
}
