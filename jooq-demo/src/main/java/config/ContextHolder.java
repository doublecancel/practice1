package config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ContextHolder {


    private static Connection connection = null;
    private static DSLContext create = null;

    static {

        InputStream is = ContextHolder.class.getResourceAsStream("/jdbc.properties");
        Properties p = new Properties();
        try {
            p.load(is);
            connection = DriverManager.getConnection(p.getProperty("jdbc.url"),
                    p.getProperty("jdbc.username"),
                    p.getProperty("jdbc.password"));
            Class.forName(p.getProperty("jdbc.driverClassName"));
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
        create = DSL.using(connection, SQLDialect.MYSQL);
    }


    public static DSLContext create(){
        return create;
    }


}
