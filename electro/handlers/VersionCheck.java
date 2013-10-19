package assets.electrolysm.electro.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import assets.electrolysm.electro.client.ClientProxy;

public class VersionCheck {

	private static String line;
	public static boolean checkDone;
	public static String chatMessage;
	public static String version;

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
					line = "[Electrolysm]" + inputLine;
				}
		 	   in.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			if(line != null)
			{
				if(line.contains(Referance.MOD_REF.VERSION)){
					version = "CURRENT";
				}
				if(!(line.contains(Referance.MOD_REF.VERSION))){
					version = "OUTDATED";
				}
				if(version == ("CURRENT")){
					chatMessage = "";
				}	
				if(version == ("OUTDATED")){
					chatMessage = "The lastest version of Electrolysm is now available";
				}
			}

			System.out.println("[Electrolysm]" + version);
			System.out.println("[Electrolysm]Ended Version Check");
			checkDone = true;
	}
}
