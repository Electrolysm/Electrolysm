package api;

import java.util.logging.Level;

import electro.handlers.Referance;
import org.apache.logging.log4j.Logger;
import cpw.mods.fml.common.FMLLog;

public class LoggerHandler 
{
	private static Logger elLogger;/* = new Logger();*/
	
	static
	{
		//elLogger.marker.setParent(FMLLog.getLogger());
	}
	
    public static void log(Level logLevel, Object object)
    {
       // elLogger.log(logLevel, (String)object);
    }

    public static void severe(Object object)
    {
        log(Level.SEVERE, object);
    }

    public static void debug(Object object)
    {
        log(Level.INFO, String.format("[DEBUG] %s", String.valueOf(object)));
    }

    public static void warning(Object object)
    {
        log(Level.WARNING, object);
    }

    public static void info(Object object)
    {
        log(Level.INFO, object);
    }

    public static void config(Object object)
    {
        log(Level.CONFIG, object);
    }

    public static void fine(Object object)
    {
        log(Level.FINE, object);
    }

    public static void finer(Object object)
    {
        log(Level.FINER, object);
    }

    public static void finest(Object object)
    {
        log(Level.FINEST, object);
    }
}

