package mods.Electrolysm.electro.basic.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionHandler implements ITickHandler{
	
	private static String version;
	/*
	public static void checkVersion() throws IOException
	{
		int times = 0;
		
            URL remoteVersionURL = new URL("https://raw.github.com/Clarky158/Electrolysm/master/version.xml");
            InputStream remoteVersionRepoStream = remoteVersionURL.openStream();
            
          //  version = remoteVersionRepoStreams;
			System.out.println(version);
			}	
*/
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
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
