package beans;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FinderDiff {
    public static void main(String[] args) throws Exception{
        List<String> lines = read1();

        System.out.println("---------------------------");
        List<String> lines2 = read3();

        diff(lines, lines2);
    }

    public static void diff(List<String> a, List<String> b){
        a.stream().filter(t -> !b.contains(t.trim())).collect(Collectors.toSet()).forEach(System.out::println);
    }

    public static List<String> read1()throws IOException, Exception{
        List<String> lines =  Files.readAllLines(Paths.get("E:\\aaa.txt"), Charset.forName("GBK"));
//        lines.forEach(System.out::println);
        return lines;
    }

    public static List<String> read3() throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("E:\\bbb.txt"), Charset.forName("GBK"));
//        lines.forEach(System.out::println);
        return lines;
    }
}
