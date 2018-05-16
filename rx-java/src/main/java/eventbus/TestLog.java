package eventbus;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/8/23.
 */
public class TestLog {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("a");

        logger.info("info");

        logger.warning("warn");

        logger.log(Level.SEVERE, "severe");

    }
}
