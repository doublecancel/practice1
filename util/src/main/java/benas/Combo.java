package benas;

import annotations.Config;
import annotations.Param;

import java.util.Map;

/**
 * @Author liuxianglei
 * @Descriptor
 */
public class Combo {
    private Config config;
    private Map<String, Param> map;
    private Object obj;


    public static Combo create(){
        return new Combo();
    }

    public Combo _1(Config config){
        this.config = config;
        return this;
    }
    public Combo _2(Map<String, Param> map){
        this.map = map;
        return this;
    }
    public Combo _3(Object object){
        this.obj = object;
        return this;
    }


    public Config _get1(){
        return this.config;
    }
    public Map<String, Param> _get2(){
        return this.map;
    }
    public Object _get3(){
        return this.obj;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Map<String, Param> getMap() {
        return map;
    }

    public void setMap(Map<String, Param> map) {
        this.map = map;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
