package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/9/15.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        InputStream in = Test.class.getResourceAsStream("/test.txt");

        Reader r = Files.newBufferedReader(Paths.get("F:\\github\\practice\\util\\src\\main\\resources\\test.txt"));
        Type type = new TypeToken<List<Channel>>(){}.getType();
        List<Channel> data = new Gson().fromJson(r, type);
//        data.forEach(System.out::println);
        List<String> fields = data.stream().map(a -> a.getField()).collect(Collectors.toList());

        fields.forEach(a -> {

        });


    }


    static class Channel {
        private String title;
        private String field;
        private String width;
        private String rowspan;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getRowspan() {
            return rowspan;
        }

        public void setRowspan(String rowspan) {
            this.rowspan = rowspan;
        }

        @Override
        public String toString() {
            return "Channel{" +
                    "title='" + title + '\'' +
                    ", field='" + field + '\'' +
                    ", width='" + width + '\'' +
                    ", rowspan='" + rowspan + '\'' +
                    '}';
        }
    }




}
