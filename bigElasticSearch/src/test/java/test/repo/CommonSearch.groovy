package test.repo

import org.junit.After
import org.junit.Before
import org.junit.Test
/**
 * Created by Administrator on 2017/12/6.
 */
class CommonSearch {

//    private TransportClient client

    @Before void before (){

//        Settings settings = Settings.settingsBuilder()
//                .put("cluster.name", "ucpaas-es") // 设置集群名
//                .put("client.transport.ignore_cluster_name", false)
//                .put("client.transport.sniff", true) // 开启嗅探 , 开启后会一直连接不上, 原因未知
//                .put("node.client", true)
//                .put("properties.transport.tcp.connect_timeout", "60s") // 忽略集群名字验证, 打开后集群名字不对也能连接上
//                .build()
//
//        client = TransportClient.builder().settings(settings).build()
//                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("172.16.5.34", 9300)))

    }

    @Test void test (){

//        GetResponse response = client.prepareGet("blog", "article", "1").execute().actionGet()
//
//        println response.getSourceAsString()

    }

    Object jsonBuilder (){
        Map<String, Object> json = new HashMap<String, Object>()
        json.put("user","kimchy")
        json.put("postDate",new Date())
        json.put("message","trying out Elasticsearch")
        return json
    }


    @After void after (){
//        client.close()
    }
    



}
