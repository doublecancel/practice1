package okhttp;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/22.
 */
public class Simple {


    public static void main(String[] args) throws Exception{
//        test1();

        Map map = new HashMap();

        map.put("a", "b");

        System.out.println(new Gson().toJson(map));

        test3("http://192.168.200.120:8001/test", "D:\\abc.pdf", new Gson().toJson(map));

    }




    public static void test1(){


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("http://www.baidu.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void test2(){

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("JSON"), "");
        Request request = new Request.Builder()
                .post(requestBody)
                .url("http://www.baidu.com")
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void test3(String url, String targetPath, String json) throws Exception{

        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(10, TimeUnit.SECONDS)//设置写入超时时间
                .build();

        RequestBody body = RequestBody.create(JSON, json);
        final Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();

        final Call call = client.newCall(request);

        Response response = call.execute();

        System.out.println(response.isSuccessful());

        InputStream is = response.body().byteStream();

        Path p = Paths.get(targetPath);

        Files.copy(is, p);

    }




}
