package mods.electrolysm.electro.data;

import java.io.InputStream;
import java.net.URL;
import java.util.EnumSet;
import java.util.Properties;
import java.util.logging.Level;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class VersionHelper implements ITickHandler {

    private static VersionHelper instance = new VersionHelper();

    // The (publicly available) remote version number authority file
	public static final String REMOTE_VERSION_XML_FILE = "https://raw.github.com/Clarky158/Electrolysm/master/version.xml";

    public static Properties remoteVersionProperties = new Properties();

    // All possible results of the remote version number check
    public static final byte UNINITIALIZED = 0;
    public static final byte CURRENT = 1;
    public static final byte OUTDATED = 2;
    public static final byte ERROR = 3;
    public static final byte FINAL_ERROR = 4;
    public static final byte MC_VERSION_NOT_FOUND = 5;

    // Var to hold the result of the remote version check, initially set to uninitialized
    public static byte result = 10;
    public static InputStream remoteVersion;
    public static String remoteUpdateLocation = null;
    public static InputStream remoteVersionRepoStream;


	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

        
        try{
            URL remoteVersionURL = new URL(REMOTE_VERSION_XML_FILE);
            remoteVersionRepoStream = remoteVersionURL.openStream();
          
                    if (remoteVersionURL.equals(VersionData.currentVersion)) {
                        result = CURRENT;
                    }
                    else {
                        result = OUTDATED;
                    }
        }
   
            catch (Exception ex) {
            }
    }
		
	
	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}
}
