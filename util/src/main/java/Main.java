import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/10/11.
 */
public class Main {
    public static void main(String[] args) {


//        String s = "<div><p>关联渠道：渠道1</p></div>\n" +
//                "            <p>打包兑换卡详情：</p>\n" +
//                "            <div><p>&nbsp;&nbsp;批次号：共7张，3张未绑定</p>\n" +
//                "                <p>&nbsp;&nbsp;HH10741461，HH10741461，HH10741461，HH10741461</p></div><br />\n" +
//                "            <div><p>&nbsp;&nbsp;批次号：共7张，3张未绑定</p>\n" +
//                "                <p>&nbsp;&nbsp;HH10741461，HH10741461，HH10741461，HH10741461</p></div>";
//        String[] str = s.split("\n");
//        for (String t : str){
//            System.out.println("html += '" + t + "';");
//        }


        String json = "{\"version_type\":\"1,2,2\",\"pageRowCount\":\"30\",\"currentPage\":\"1\"}";
        Type type = new TypeToken<TbUcpaas400NumberPoolDomain>(){}.getType();
        TbUcpaas400NumberPoolDomain a = new Gson().fromJson(json, type);
        System.out.println(a.toString());

    }
}
