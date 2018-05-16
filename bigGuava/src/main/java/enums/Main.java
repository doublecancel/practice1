package enums;

import com.google.common.base.Enums;
import com.google.common.collect.EnumBiMap;
import com.google.common.collect.EnumMultiset;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        int a = StudengScore.XIAO_HONG.total();
        System.out.println(a);


        StudengScore[] ss = StudengScore.values();
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i].toString());
        }


        System.out.println(StudengScore.valueOf("XIAO_HUA").toString());
        System.out.println(StudengScore.valueOf("XIAO_HUA").ordinal());


        int c = Text.add(EnumSet.of(Text.Status.A, Text.Status.D));
        System.out.println("----------------- : " + c);

        EnumBiMap<Sale, DBType> map = EnumBiMap.create(Sale.class, DBType.class);
        map.put(Sale.THURSDAY, DBType.DELETE);

        map.forEach((t, b) -> {
            System.out.println(t.toString() + " : " + b.toString());
        });

        EnumMap<Sale, String> enumMap = new EnumMap<Sale, String>(Sale.class);
        enumMap.put(Sale.FRIDAY, "ok");


        Field f = Enums.getField(Sale.THURSDAY);
        System.out.println(f.getName());
        System.out.println("----------------------------------------------");
        EnumMultiset set = EnumMultiset.create(Sale.class);
        set.add(Sale.THURSDAY);
        set.add(Sale.THURSDAY);
        int y = set.count(Sale.THURSDAY);
        System.out.println(y);
        set.stream().forEach(System.out :: println);

      }
}
