package mods.electrolysm.electro.data;

import java.io.InputStream;
import java.net.URL;

public class VersionData {

	
	//Version
	public static final String REMOTE_VERSION_XML_FILE = "https://raw.github.com/Clarky158/Electrolysm/master/version";
	public static final String currentVersion = "0.2.0";
	//End
	public static String outdatedVersionMessage = "This version of Electrolyms is outdated, please update by going to our Wiki page." + VersionHelper.remoteVersionRepoStream;
	public static int versionCheck = 0;
}
