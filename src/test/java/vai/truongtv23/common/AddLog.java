package vai.truongtv23.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddLog {
    //Initialize Log4j instance
    private static final Logger AddLog =  LogManager.getLogger(AddLog.class);

    //Info Level Logs
    public static void info (String message) {
        AddLog.info(message);
    }
    public static void info (Object object) {
        AddLog.info(object);
    }

    //Warn Level Logs
    public static void warn (String message) {
        AddLog.warn(message);
    }
    public static void warn (Object object) {
        AddLog.warn(object);
    }

    //Error Level Logs
    public static void error (String message) {
        AddLog.error(message);
    }
    public static void error (Object object) {
        AddLog.error(object);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        AddLog.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        AddLog.debug(message);
    }
    public static void debug (Object object) {
        AddLog.debug(object);
    }
}