import annotations.Config;
import annotations.Param;
import benas.Combo;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 注解的配置方式生成代码
 */
public class GenerateOperate2016 {

    public static final String baseDir = "F:\\github\\practice\\util\\src\\main\\resources\\";
    Configuration configuration = null;

    public static GenerateOperate2016 create() {
        return new GenerateOperate2016();
    }

    /**
     * 初始化生成器
     * @return
     * @throws Exception
     */
    public GenerateOperate2016 init() throws Exception {
        configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        FileTemplateLoader loader = new FileTemplateLoader(new File(baseDir));
        configuration.setTemplateLoader(loader);
        return this;
    }

    /**
     * 生成action块
     * @param combo
     * @throws Exception
     */
    public void generateAction(Combo combo) throws Exception {
        Template template = configuration.getTemplate("operate2016/action.ftl", "UTF-8");
        FileOutputStream os = new FileOutputStream(new File(combo._get1().Action().pathName()));
        template.process(combo, new OutputStreamWriter(os));
    }

    private static Combo resolveClass(Class clazz) throws Exception {
        Config config = (Config) clazz.getAnnotation(Config.class);

        Field[] fs = clazz.getDeclaredFields();
        Map<String, Param> map = new HashMap<>();
        for (Field f : fs) {
            Param param = f.getAnnotation(Param.class);
            String value = param.value();
            map.put(value, param);
        }

        return Combo.create()._1(config)._2(map)._3(GenerateOperate2016.create());
    }

    /**
     * 生成jsp页面
     * @param combo
     * @throws Exception
     */
    public void generateJsp(Combo combo) throws Exception{
        Template template = configuration.getTemplate("operate2016/jsp.ftl", "UTF-8");
        FileOutputStream os = new FileOutputStream(new File(combo._get1().Jsp().jspPath()));
        template.process(combo, new OutputStreamWriter(os));
    }

    public static void generateService() {

    }

    public static void generateMapper() {

    }

    public static String firstToLowerCase(String s) {
        if (com.google.common.base.Strings.isNullOrEmpty(s)) {
            return "";
        }
        char[] cs = s.toCharArray();
        cs[0] = Character.toLowerCase(cs[0]);
        return new String(cs);
    }

    public static String getMethodName(String action){
        int end = action.lastIndexOf("/");
        return action.substring(end + 1, action.length());
    }


    public static void main(String[] args) throws Exception {
//        Combo combo = resolveClass(Params.class);
//        create().init().generateAction(combo);
//        create().init().generateJsp(combo);

        String result = firstToLowerCase("ABCDS");
        System.out.println(result);

    }
    


}
