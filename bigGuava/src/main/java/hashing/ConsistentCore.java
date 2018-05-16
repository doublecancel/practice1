package hashing;

import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Administrator on 2017/10/30.
 */
public class ConsistentCore<S> {

    private TreeMap<Long, S> nodes; // 虚拟节点
    private List<S> shards; // 真实机器节点
    private final int NODE_NUM = 100; // 每个机器节点关联的虚拟节点个数

    public ConsistentCore(List<S> shards) {
        super();
        this.shards = shards;
        init();
    }

    private void init() { // 初始化一致性hash环
        nodes = new TreeMap<Long, S>();
        for (int i = 0; i != shards.size(); ++i) { // 每个真实机器节点都需要关联虚拟节点
            final S shardInfo = shards.get(i);

            for (int n = 0; n < NODE_NUM; n++)
                // 一个真实机器节点关联NODE_NUM个虚拟节点
                nodes.put(hash("SHARD-" + i + "-NODE-" + n), shardInfo);

        }
    }

    public S getShardInfo(String key) {
        SortedMap<Long, S> tail = nodes.tailMap(hash(key)); // 沿环的顺时针找到一个虚拟节点
        if (tail.size() == 0) {
            return nodes.get(nodes.firstKey());
        }
        return tail.get(tail.firstKey()); // 返回该虚拟节点对应的真实机器节点的信息
    }

    public Long hash(String key){
        return Hashing.murmur3_128(0x1234ABCD)
                .newHasher()
                .putString(key, Charset.forName("utf8"))
                .hash()
                .asLong();
//        return hash2(key).longValue();
    }

    public Integer hash2(Object key){
        int h;
        int a = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        if(a < 0){
            a = Math.abs(a);
        }
        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {


        ConsistentCore<String> servers = new ConsistentCore(Lists.newArrayList("s1", "s2", "s3", "s4", "s5"));
        Map<String, List<String>> map = new HashMap<>();
        for (int a = 0; a < 200000; a++){
            String s = servers.getShardInfo("abc"+ a);
            if(map.containsKey(s)){
                map.get(s).add("abc"+ a);
                continue;
            }
            map.put(s, Lists.newArrayList("abc"+ a));
        }

//        String result = new Gson().toJson(map);
//        System.out.println(result);
        System.out.println("--------------------------------------------------------");
        for (Map.Entry<String, List<String>> m : map.entrySet()){
            System.out.println(m.getKey() + ",size:" + m.getValue().size());
        }

//        IntStream.range(1, 1000)
//                .forEach(a -> {
//                    boolean flag = servers.hash("abc" + a).equals(servers.hashMurMur("abc" + a));
//                    System.out.println(flag);
//                });

    }



}
