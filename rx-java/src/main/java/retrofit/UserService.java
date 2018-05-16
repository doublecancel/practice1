package retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/8/22.
 */
@BaseUrl("http://192.168.200.120:8001")
public interface UserService {

    @GET("/user/login/{username}/{password}")
    Res login(@Path("username") String username, @Path("password") String password);


    @GET("/test")
    Call<ResponseBody> test();

}
