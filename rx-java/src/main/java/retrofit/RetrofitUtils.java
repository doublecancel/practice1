package retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/8/22.
 */
public class RetrofitUtils {

    static Map<Class<?>, Object> map = new ConcurrentHashMap<>();


    public static UserService getUserService(){

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.200.120:8001")
                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);

        return userService;
    }

    public static <T> T getService(Class<?> clazz){

        BaseUrl baseUrl = clazz.getAnnotation(BaseUrl.class);

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.value())
                .client(client)
                .build();

        return (T)retrofit.create(clazz);

    }












}
