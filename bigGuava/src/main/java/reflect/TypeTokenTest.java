package reflect;

import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 */
public class TypeTokenTest {

    public static void main(String[] args) {

        Type type = new TypeToken<List<UserDomain>>(){}.getType();

        String json = read();
        System.out.println(json);

        List<UserDomain> domains = getGson().fromJson(json, type);


        getGson().toJson(domains);

        domains.forEach(System.out::println);

    }


    public static Gson getGson(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<LocalDateTime>(){}.getType(), new TimeAdapter())
                .create();
        return gson;
    }

    static class TimeAdapter extends TypeAdapter<LocalDateTime> {

        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            out.value(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            String value = in.nextString();
            return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }


    public static String read(){
        String result = "";
        try {
            List<String> list = Files.readAllLines(Paths.get("F:\\github\\practice\\bigGuava\\src\\main\\resources\\data.json"));
            result = Joiner.on("").join(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }






}
