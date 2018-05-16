package lazy;

import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/12/14.
 */
public class Test {

    public static void main(String[] args) {

        Supplier<Singleton> suppliers = () -> new Singleton();
        Supplier<Singleton> supplier = Suppliers.memoize(suppliers);
        Singleton y = supplier.get();

        IntStream.range(1, 100).forEach(a -> {
            Singleton s = supplier.get();
//            System.out.println(s == y);
        });

        Suppliers.memoizeWithExpiration(suppliers, 1, TimeUnit.SECONDS);//每秒创建新的额对象

        Function function = com.google.common.base.Functions.constant(1);
        com.google.common.base.Functions.identity();//返回自身
        Map<String, Integer> map = Maps.newHashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        Function mapfunction = com.google.common.base.Functions.forMap(map);

        IntStream.range(1, 100).forEach(a -> {
//            System.out.println(function.apply(a));
            System.out.println(mapfunction.apply("a"));
        });



        Predicates.isNull();
        Predicates.equalTo("ab");




    }


}
