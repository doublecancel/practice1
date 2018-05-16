import benas.Menu;
import org.jooq.Record1;
import utils.ConnectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.jooq.impl.DSL.*;

public class GenerateSQL {

    public static GenerateSQL instance = new GenerateSQL();

    public static void main(String[] args) {
        //当前menuid的最大值
//        Integer menu_max_id = instance.queryMenuMaxId();
//
//        instance.insertMenu(instance.initMenu(menu_max_id));


    }

    private Menu initMenu(Integer menu_max_id){

        InputStream in = GenerateSQL.class.getResourceAsStream("/Menu.properties");
        Properties p = new Properties();
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Menu.create().menu_id(menu_max_id + 1)
                .menu_name(p.getProperty("menu_name"))
                .remark(p.getProperty("remark"))
                .menu_url(p.getProperty("menu_url"))
                .menu_class(p.getProperty("menu_class"))
                .menu_type(p.getProperty("menu_type"))
                .level(Integer.parseInt(p.getProperty("level")))
                .parent_id(p.getProperty("parent_id"))
                .sort(Integer.parseInt(p.getProperty("sort")))
                .status(p.getProperty("status"))
                .web_id(Integer.parseInt(p.getProperty("web_id")));

    }


    private Integer queryMenuMaxId(){
        Record1<Object> r = ConnectionUtils.create()
                .select(max(field("menu_id")))
                .from(table("tb_ucpaas_menu"))
                .fetchOne();

        return (Integer) r.value1();

    }

    private int insertMenu(Menu menu){
         String sql = ConnectionUtils.create().insertInto(table("tb_ucpaas_menu"),
                 field("menu_id"),
                 field("menu_name"),
                 field("remark"),
                 field("menu_url"),
                 field("menu_class"),
                 field("menu_type"),
                 field("level"),
                 field("parent_id"),
                 field("sort"),
                 field("status"),
                 field("web_id")
         )
                .values(menu.getMenu_id(),
                        menu.getMenu_name(),
                        menu.getRemark(),
                        menu.getMenu_url(),
                        menu.getMenu_class(),
                        menu.getMenu_type(),
                        menu.getLevel(),
                        menu.getParent_id(),
                        menu.getSort(),
                        menu.getStatus(),
                        menu.getWeb_id()
                        ).getSQL();

        System.out.println(sql);
         return 0;
    }










}
