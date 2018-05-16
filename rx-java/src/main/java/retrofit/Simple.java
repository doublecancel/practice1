package retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by Administrator on 2017/8/22.
 */
public class Simple {

    public static void main(String[] args) throws Exception {

        Call<ResponseBody> res = RetrofitUtils.getUserService().test();

        System.out.println(res.execute().body().string());

    }


}
