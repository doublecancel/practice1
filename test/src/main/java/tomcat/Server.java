package tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {

    static String workingDir = System.getProperty("java.io.tmpdir");
    static File XML = null;
    static File WebRoot = null;
    static File WebInf = null;
    static String source =
            "F:\\github\\practice\\test\\src\\main\\resources\\web.xml";

    public static void main(String[] args) {

        start();

    }


    public static void start(){

        prepare();
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost");
        tomcat.setPort(8081);
        tomcat.setBaseDir(workingDir);
        try {
            tomcat.addWebapp("/", WebRoot.getAbsolutePath());
            System.out.println(WebRoot.getAbsolutePath());
            tomcat.start();
        } catch (ServletException | LifecycleException e) {
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }

    public static void prepare(){


        //创建WebRoot
        createWebRoot();

        //创建WEB-INF
        createWebInf();

        //创建web.xml
        createWebXml(source);

        // lib
        createLib();

        createCLasses();

        createJsp();

    }

    private static void createJsp(){
        final String jspPath = WebRoot.getAbsolutePath();
        try {
            Files.walk(Paths.get("F:\\github\\practice\\test\\src\\main\\resources\\jsp"))
                    .filter(a -> a.toFile().isFile())
                    .forEach(a -> {
                        try {
                            Files.copy(a, new FileOutputStream(jspPath + a.getFileName()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createCLasses(){
        File file = new File(WebInf, "classes");
        file.mkdir();
    }

    private static void createLib(){
        File file = new File(WebInf, "lib");
        file.mkdir();
    }

    private static void createWebRoot(){
        try {
            WebRoot = File.createTempFile("test", "test", null).getCanonicalFile();
            WebRoot.delete();
            WebRoot.mkdir();
        } catch (IOException e) {}
    }

    private static void createWebInf(){
        WebInf = new File(WebRoot, "WEB-INF");
        WebInf.mkdir();
    }

    private static void createWebXml(String source){

        XML = new File(WebInf, "web.xml");
        try {
            InputStream is = new FileInputStream(new File(source));
            Files.copy(is, Paths.get(XML.toURI()));
        } catch (IOException e) {}
    }



}
