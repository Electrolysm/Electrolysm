package assets.electrolysm.electro;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class configHandler {

	public static void init(File file){
    	Configuration config = new Configuration(file);   

        config.load();
        
		
        config.save();
	}
}
