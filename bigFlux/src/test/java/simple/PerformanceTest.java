package simple;

import com.example.learn.entity.Order;
import com.google.gson.Gson;
import okhttp3.*;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PerformanceTest {

    OkHttpClient client;

    private List<String> data;

    private ExecutorService pool;


    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    static CountDownLatch latch = new CountDownLatch(1999);

    static AtomicInteger count = new AtomicInteger(1);

    @Before
    public void before(){
       client =  new OkHttpClient.Builder()
               .build();
       data = initData();

       pool = Executors.newFixedThreadPool(100);

    }

    private List<String> initData(){
       List<String> data = Lists.newArrayList();
        IntStream.range(1, 2000).forEach(a -> {

            Order order = new Order();
            order.setCustomer_account("liuxianglei@ucpaas.com");
            order.setCustomer_name("liuxainglei");
            order.setGoods_name("电子商品-笔记本");
            order.setPay_money(258000L);
            order.setPay_type("微信支付");
            data.add(new Gson().toJson(order));
        });

       return data;
    }

    //rx  5000     47406       5000    49412
    // 5000 43498     50000 47569

    @Test
    public void test()throws  Exception{

        Long start = System.currentTimeMillis();
        data.forEach(a -> pool.submit(() -> send(a)));
        try{
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }


        Long end = System.currentTimeMillis();

        System.out.println("执行isnert的时间：" + (end - start));



    }

    private void send(String json){
        client =  new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        RequestBody body = RequestBody.create(JSON, json);
        try {
            Request request  = new Request.Builder()
                    .url("http://localhost:10001/order/go")
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
//                System.out.println(response.body().string());
                System.out.println(count.getAndIncrement());
            }
            response.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            latch.countDown();
        }
    }

}
