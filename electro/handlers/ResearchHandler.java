package assets.electrolysm.electro.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.Configuration;

public class ResearchHandler {

    private static ResearchHandler instance = new ResearchHandler();

    // The (publicly available) remote Research number authority file
    private static final String REMOTE_Research_XML_FILE = "https://raw.github.com/pahimar/Equivalent-Exchange-3/master/Research.xml";

    public static Properties remoteResearchProperties = new Properties();

    // All possible results of the remote Research number check
    public static final byte UNINITIALIZED = 0;
    public static final byte CURRENT = 1;
    public static final byte OUTDATED = 2;
    public static final byte ERROR = 3;
    public static final byte FINAL_ERROR = 4;
    public static final byte MC_Research_NOT_FOUND = 5;

    // Var to hold the result of the remote Research check, initially set to uninitialized
    private static byte result = UNINITIALIZED;
    public static String remoteResearch = null;
    public static String remoteUpdateLocation;

    
    /***
     * Checks the Research of the currently running instance of the mod against
     * the remote Research authority, and sets the result of the check
     * appropriately
     */
    
    public static void getOnlineResearch() 
    {
        InputStream remoteResearchRepoStream = null;
        result = UNINITIALIZED;

        try 
        {
            URL remoteResearchURL = new URL(REMOTE_Research_XML_FILE);
            remoteResearchRepoStream = remoteResearchURL.openStream();
            remoteResearchProperties.loadFromXML(remoteResearchRepoStream);
		}
        catch(IOException e) 
		{
			e.printStackTrace();
		}
    }
}
