package config;

import entity.City;
import org.jooq.impl.DSL;

import java.util.stream.IntStream;

import static config.ContextHolder.create;

public class DbConfig {

    private static final String TABLE = "city";

    public static void main(String[] args) throws Exception {

        IntStream.range(1, 100).forEach(a -> {
            test();
        });

    }

    private static void test(){
        String sql = create().select(
                DSL.field(City.Field.ID),
                DSL.field(City.Field.NAME),
                DSL.field(City.Field.COUNTRYCODE),
                DSL.field(City.Field.DISTRICT),
                DSL.field(City.Field.POPULATION)
        )
                .from(DSL.table(TABLE))
                .where(
                        DSL.field(City.Field.NAME).eq("Qandahar").or(DSL.field("").like("abc"))
                                .and(
                                        DSL.field(City.Field.COUNTRYCODE).eq("AFG")
                                )
                )
                .orderBy(DSL.field(City.Field.ID).asc())
                .limit(1, 10)
                .getSQL();

        System.out.println(sql);
    }


}
