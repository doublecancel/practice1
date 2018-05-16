package utils;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

    public static DSLContext create(){
        return Holder.INSTANCE.getContext();
    }

    public enum Holder {
        INSTANCE;
        DSLContext context;

        Holder() {
            Connection connection = getConnection();
            context = DSL.using(connection, SQLDialect.MYSQL);
        }

        public DSLContext getContext() {
            return context;
        }

        private static Connection getConnection(){
            Connection connection = null;
            try{
                InputStream in = ConnectionUtils.class.getResourceAsStream("/jdbc.properties");
                Properties p = new Properties();
                p.load(in);
                String url = p.getProperty("jdbc.url");
                String username = p.getProperty("jdbc.username");
                String password = p.getProperty("jdbc.password");
                Class.forName(p.getProperty("jdbc.driverClassName"));
                connection = DriverManager.getConnection(url, username, password);
            }catch (SQLException | IOException | ClassNotFoundException e){}

            return connection;

        }
    }




}
