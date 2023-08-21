package Logger;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {

    public static final Logger log = LogManager.getLogger(Log.class);


    /**
     * method to display errors in log.
     * @param className name of class in which error occurred.
     * @param methodName name of method in which error occurred.
     * @param exception stack trace of exception
     */
    public static void logError (String className,String methodName,String exception) {
        log.setLevel((Level) Level.INFO);
        log.info("ClassName :"+className);
        log.info("MethodName :"+methodName );
        log.info("Exception :" +exception);
        log.info("-----------------------------------------------------------------------------------");
    }

    /**
     * method to display information in logs
     * @param message message to be displayed
     */
    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);}

    public static void error(String message) {
        log.error(message);}

    public static void fatal(String message) {
        log.fatal(message);}

    public static void debug(String message) {
        log.debug(message);}
}
