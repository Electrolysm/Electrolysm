package mods.Electrolysm.electro.basic.handlers;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class CongigHandler {

	public static void init(File file){
		Configuration config = new Configuration(file);
		IDHandler id = new IDHandler();
		
		config.load();
		

		

		
		config.save();
	}
}
