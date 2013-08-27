package mods.Electrolysm.electro.basic.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.EnumSet;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionHandler implements ITickHandler{
	
	private static String chatMessage;
	private static String version;
	private boolean help;

	public static void check(){
		System.out.println("Starting Version Chech")
		
		URL url = null;
		String inputLine = "";
		
		try {
		    url = new URL("https://raw.github.com/Clarky158/Electrolysm/master/version.xml");
		} catch (MalformedURLException e) {
		    e.printStackTrace();
		}
		BufferedReader in;
		try {
		    URLConnection con = url.openConnection();
		    con.setReadTimeout( 1000 ); //1 second
		    in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    while ((inputLine = in.readLine()) != null) {
		        System.out.println(inputLine);
		    }
		    in.close();

		} catch (IOException e) {
		    e.printStackTrace();
		}
		if(inputLine == data.currentVersion){
			version = "CURRENT";
		}
		if(!(inputLine == data.currentVersion)){
			version = "OLD";
		}
		if(version.equals("CURRENT")){
			chatMessage = "";
		}
		if(version.equals("OLD")){
			chatMessage = "Electrolysm Mod is outdated please update.";
		}
		
		System.out.println(version);
		System.out.println("Ended Version Check")
	}

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
		if(help){	
			if(FMLClientHandler.instance().getClient().inGameHasFocus){
					FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(chatMessage);
					help = true;
				}	
			}
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
