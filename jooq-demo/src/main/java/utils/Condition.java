package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Condition {

    Map<String, String> whereEqParams = new HashMap<>();
    Map<String, Integer> whereGtParams = new HashMap<>();
    Map<String, Integer> whereLtParams = new HashMap<>();
    Map<String, String> whereNeParams = new HashMap<>();

    List<String> linkedStr = new ArrayList<>();

    public static Condition create(){
        return new Condition();
    }

    private Condition(){}


    public Condition and(){
        linkedStr.add("AND");
        return this;
    }

    public Condition or(){
        linkedStr.add("OR");
        return this;
    }

    public Condition eq(String name, String value){
        whereEqParams.put(name, value);
        return this;
    }

    public Condition ne(String name, String value){
        whereNeParams.put(name, value);
        return this;
    }

    public Condition gt(String name, Integer value){
        whereGtParams.put(name, value);
        return this;
    }

    public Condition lt(String name, Integer value){
        whereLtParams.put(name, value);
        return this;
    }



}
