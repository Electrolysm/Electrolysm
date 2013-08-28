package assets.electrolysm.electro.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class VersionCheck {
	private static String chatMessage;
	private static String version;
	private boolean help;

	public static void check(){
		System.out.println("[Electrolysm]Starting Version Check");

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
		        System.out.println("[Electrolysm]" + inputLine);
		    }
		    in.close();

		} catch (IOException e) {
		    e.printStackTrace();
		}
		if(inputLine == Referance.MOD_REF.VERSION){
			version = "CURRENT";
		}
		if(!(inputLine == Referance.MOD_REF.VERSION)){
			version = "OUTDATED";
		}
		if(version == ("CURRENT")){
			chatMessage = "";
		}	
		if(version == ("OUTDATED")){
			chatMessage = "Electrolysm Mod is outdated please update.";
		}

		System.out.println("[Electrolysm]" + version);
		System.out.println("[Electrolysm]Ended Version Check");
	}
}
