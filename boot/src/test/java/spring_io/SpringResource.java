package spring_io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by Administrator on 2018/1/16.
 */
@RunWith(JUnit4.class)
public class SpringResource {

    @Test
    public void testClasspathReaource() throws IOException {
        ClassPathResource resource = new ClassPathResource("/abc.txt");


        String filename = resource.getFilename();
        String desc = resource.getDescription();
        String path = resource.getPath();

        System.out.println("filename : " + filename);
        System.out.println("desc : " + desc);
        System.out.println("path : " + path);
        printContent(resource.getInputStream());
    }

    @Test
    public void testSystemResource() throws IOException {
        FileSystemResource resource = new FileSystemResource("F:\\github\\practice\\boot\\src\\test\\resources\\abc.txt");
        System.out.println("exists : " + resource.exists());


    }

    @Test
    public void testContextResource() throws IOException {

    }

    @Test
    public void testResourceUtils() throws IOException {
        File file = ResourceUtils.getFile("classpath:abc.txt");
        System.out.println(file.getName());
        printContent(new FileInputStream(file));
        System.out.println("-----------------------------------------");
        File tempFile = ResourceUtils.getFile("file:F:\\github\\practice\\boot\\src\\test\\resources\\abc.txt");
        printContent(new FileInputStream(tempFile));
    }

    @Test
    public void testFileCopyUtils() throws Exception{
        File source = ResourceUtils.getFile("classpath:abc.txt");
        File target = ResourceUtils.getFile("F:\\github\\practice\\boot\\src\\test\\resources\\aaa.txt");
        FileCopyUtils.copy(source, target);

        String content = FileCopyUtils.copyToString(new InputStreamReader(new FileInputStream(source)));
        System.out.println(content);
        byte[] bs = FileCopyUtils.copyToByteArray(source);
    }

    @Test
    public void testPropertyLoader () throws Exception {
        ClassPathResource resource = new ClassPathResource("/aaa.properties");
        Properties p  = PropertiesLoaderUtils.loadProperties(resource);
        String value = p.getProperty("aaa").toString();
        System.out.println(value);

    }

    @Test
    public void testPaths() throws IOException {
        Files.readAllLines(Paths.get("F:\\github\\practice\\boot\\src\\test\\resources\\aaa.txt")).stream()
                .forEach(System.out::println);
        System.out.println("-------------------------------------------");
        Files.readAllLines(Paths.get("/abc.txt")).forEach(System.out::println);
    }

    @Test
    public void testEncodeResource() throws IOException {
        ClassPathResource resource  = new ClassPathResource("");
        EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
        printContent(resource.getInputStream());


    }


    public void printContent(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);

        }
        if (is != null) {
            is.close();
        }
        if (reader != null) {
            reader.close();
        }
    }


}
