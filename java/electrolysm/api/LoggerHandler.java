package electrolysm.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class LoggerHandler 
{
	private static Logger elLogger = LogManager.getLogger("Electrolysm");

    public static void log(Level logLevel, Object object)
    {
        elLogger.log(logLevel, "[Electrolysm]" + object);
    }

    public static void severe(Object object)
    {
        log(Level.FATAL, object);
    }

    public static void debug(Object object)
    {
        log(Level.INFO, String.format("[DEBUG] %s", String.valueOf(object)));
    }

    public static void warning(Object object)
    {
        log(Level.WARN, object);
    }

    public static void info(Object object)
    {
        log(Level.INFO, object);
    }

    public static void fine(Object object)
    {
        log(Level.ALL, object);
    }
}

